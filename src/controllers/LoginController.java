package controllers;

import gui.LoginView;
import models.Usuario;
import org.hibernate.Session;
import util.Hibernate;

import javax.persistence.Query;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class LoginController implements ActionListener {

    LoginView loginView;
    public LoginController(LoginView loginView){
        this.loginView = loginView;
        addActionListener(this);
        createConfigurationFile();
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

    /**
     * ES - Crea el fichero de configuración si no existe.
     *
     * @throws IOException
     */
    public void createConfigurationFile() {

         File save;  save = new File("login.conf");

        if (!save.exists()) {

            try {
                save.createNewFile();
                assignDefaultPropertiesLogin(save);
            } catch (IOException e) {
                //AlertUtil.errorAlert("Error creating configuration file");
            }

            //assignDefaultPropertiesLogin();
        }
    }

    /**
     * ES - Asigna valores por defecto a las propiedades del archivo de configuración.
     */
    private void assignDefaultPropertiesLogin(File save) {
        Properties config = new Properties();
        config.setProperty("remember", "true");
        config.setProperty("lastUser", "default");
        try {

            config.store(new FileWriter(save.getAbsolutePath()),
                    "Login Settings");
        } catch (IOException e) {

            //AlertUtil.errorAlert("Error when assigning default properties");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Funciona");
        validateAccount();
    }
}
