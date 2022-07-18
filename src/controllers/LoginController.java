package controllers;

//region Imports
import config.ConfigFile;
import views.LoginView;
import models.Usuario;
import org.hibernate.Session;
import util.AlertDialog;
import util.DataBase;
import util.Hibernate;

import javax.persistence.Query;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
//endregion

public class LoginController implements ActionListener, ItemListener {

    //region Var
    private LoginView loginView;
    private ConfigFile configFile;
    private DataBase dataBase;
    private boolean accepted;
    //endregion

    //region Builder
    public LoginController(LoginView login){
        init(login);
        addListeners();
    }
    //endregion

    //region Init
    private void init(LoginView login){
        loginView = login;
        dataBase = new DataBase();
        configFile = new ConfigFile();
        accepted = false;
        configFile.createConfigFile();
        loadConfig();
    }
    //endregion

    //region Private Methods

    private void addListeners() {
        loginView.getBtnNewAccept().addActionListener(this);
        loginView.getComboBoxLanguage().addItemListener(this);
    }

    //region gets
    private ArrayList<Usuario> getUsers() {
        Session session = Hibernate.getCurrentSession();
        Query query = session.createQuery("FROM Usuario ");
        ArrayList<Usuario> userList= (ArrayList<Usuario>)query.getResultList();
        session.close();
        return userList;
    }
    private String getRememberMe(){
        if(loginView.getCheckboxRememberMe().isSelected()){
            return "true";
        }else{
            return  "false";
        }
    }

    private String getLanguage(){
        if(loginView.getComboBoxLanguage().getSelectedIndex() == 0){
            return "es_ES";
        }else{
            return "en_EN";
        }
    }

    private String getUser(){
        return loginView.getTextFieldUser().getText();
    }
    //endregion

    private void validateAccount() {
        checkAccounts();
        acceptAccount();
    }

    private void checkAccounts(){
        dataBase.connect();
        for (Usuario usuario : getUsers()) {
            if (loginView.getTextFieldUser().getText().equals(usuario.getUsuario()) &&
                    loginView.getTextFieldPassword().getText().equals(usuario.getPassword())) {
                accepted = true;
                configFile.updateConfigFile(getRememberMe(), getUser(),getLanguage());
            }
        }
        dataBase.disconnect();
    }

    private void acceptAccount(){
        if (!accepted) {
            AlertDialog.messageDialog("Usuario Inválido");

        } else if (accepted) {
            AlertDialog.messageDialog("Usuario Aceptado");
        }
    }

    //region loads
    private void loadConfig() {
        loadRememberUser();
        loadLanguage();
    }

    private void loadRememberUser() {
        if(configFile.getValue("remember").equalsIgnoreCase("true")){
            loginView.getTextFieldUser().setText(configFile.getValue("lastUser"));
            loginView.getCheckboxRememberMe().setSelected(true);
        }else{
            loginView.getCheckboxRememberMe().setSelected(false);
        }
    }

    private void loadLanguage(){
        if(configFile.getValue("language").equalsIgnoreCase("es_ES")){
            loginView.getComboBoxLanguage().setSelectedIndex(0);
        }else if(configFile.getValue("language").equalsIgnoreCase("en_EN")) {
            loginView.getComboBoxLanguage().setSelectedIndex(1);
        }
    }
    //endregion

    //endregion

    //region Public Methods
    @Override
    public void actionPerformed(ActionEvent e) {
        validateAccount();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            configFile.updateConfigFile(getRememberMe(), getUser(),getLanguage());
        }
    }
    //endregion
}
