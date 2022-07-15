package controllers;

import config.ConfigFile;
import gui.LoginView;
import models.Usuario;
import org.hibernate.Session;
import util.AlertDialog;
import util.Hibernate;

import javax.persistence.Query;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginController implements ActionListener {

    LoginView loginView;
    ConfigFile configFile;

    public LoginController(LoginView login){

        loginView = login;
        addActionListener(this);
        configFile = new ConfigFile();
        configFile.createConfigFile();
        loadConfig();
    }

    private void addActionListener(ActionListener actionListener) {
        loginView.getBtnNewButton().addActionListener(actionListener);
    }

    private void validateAccount() {
        boolean accepted = false;
        Hibernate.buildSessionFactoryUser();

        for (Usuario usuario : getUsuario()) {

            if (loginView.getUsuarioTextField().getText().equals(usuario.getUsuario()) &&
                    loginView.getPasswordTextField().getText().equals(usuario.getPassword())) {
                accepted = true;
                configFile.updateConfigFile(rememberMe(), getUser());
            }
            Hibernate.closeSessionFactory();
        }
        if (!accepted) {
            AlertDialog.messageDialog("Usuario Inválido");

        } else if (accepted) {
            AlertDialog.messageDialog("Usuario Aceptado");
        }
    }

    private ArrayList<Usuario> getUsuario() {
        Session sesion = Hibernate.getCurrentSession();
        Query query = sesion.createQuery("FROM Usuario ");
        ArrayList<Usuario> userList= (ArrayList<Usuario>)query.getResultList();
        sesion.close();
        return userList;
    }

    private void loadConfig() {
        loadRememberUser();
    }

    private void loadRememberUser() {
        if(configFile.getValue("remember").equalsIgnoreCase("true")){
            loginView.getUsuarioTextField().setText(configFile.getValue("lastUser"));
            loginView.getChckbxRememberMe().setSelected(true);
        }else{
            loginView.getChckbxRememberMe().setSelected(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validateAccount();
    }

    private String rememberMe(){

        if(loginView.getChckbxRememberMe().isSelected()){
            return "true";
        }else{
            return  "false";
        }
    }

    private String getUser(){
        return loginView.getUsuarioTextField().getText();
    }
}
