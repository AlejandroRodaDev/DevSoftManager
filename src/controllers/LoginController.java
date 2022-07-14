package controllers;

import config.ConfigFile;
import gui.Login;
import models.Usuario;
import org.hibernate.Session;
import util.Hibernate;

import javax.persistence.Query;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginController implements ActionListener {

    Login loginView;
    ConfigFile configFile;

    public LoginController(Login login){

        loginView = login;
        addActionListener(this);
        configFile = new ConfigFile();
        configFile.createConfigFile();
    }


    private void addActionListener(ActionListener actionListener) {
        loginView.getBtnNewButton().addActionListener(actionListener);
    }


    /**
     * ES - Valida que la cuenta introducida existe en la base de datos.
     */
    private void validateAccount() {
        Hibernate.buildSessionFactoryUser();
        boolean accepted = false;

        for (Usuario usuario : getUsuario()) {

            if (loginView.getUsuarioTextField().getText().equals(usuario.getUsuario()) &&
                    loginView.getPasswordTextField().getText().equals(usuario.getPassword())) {

                //usuarioActual = user;
                accepted = true;
                //updateConfigurationFile();
                //disconnectToUserDatabase();
            }
            Hibernate.closeSessionFactory();
        }

        if (!accepted) {
            //JOptionPane.showMessageDialog(null,
                    //configDictionary.getProperty("userInvalid"));
            JOptionPane.showMessageDialog(null,"Usuario Inválido");

        } else if (accepted) {
            //JOptionPane.showMessageDialog(null,
                    //configDictionary.getProperty("userAccepted"));
            //updateLanguageFile();

            JOptionPane.showMessageDialog(null,"Usuario Aceptado");
            //MainView view = new MainView();
            //Model model = new Model();
            //MainViewController controller = new MainViewController(view, model, rol, usuarioActual);
            //dispose();
        }
    }

    private ArrayList<Usuario> getUsuario() {
        Session sesion = Hibernate.getCurrentSession();
        Query query = sesion.createQuery("FROM Usuario ");
        ArrayList<Usuario> userList= (ArrayList<Usuario>)query.getResultList();
        sesion.close();
        return userList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Funciona");
        validateAccount();
    }
}
