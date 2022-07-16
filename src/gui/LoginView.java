package gui;

import controllers.LoginController;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LoginView extends JFrame{
    private JPanel contentPane;
    private JTextField usuarioTextField;
    private JTextField passwordTextField;

    private JCheckBox chckbxRememberMe;

    private JButton btnNewButton;

    private LoginController loginController;

    private JComboBox comboBox;

    public JTextField getUsuarioTextField() {
        return usuarioTextField;
    }


    public JTextField getPasswordTextField() {
        return passwordTextField;
    }


    public JButton getBtnNewButton() {
        return btnNewButton;
    }

    public JCheckBox getChckbxRememberMe() {
        return chckbxRememberMe;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public LoginView() {

        setTitle("Login");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(new Color(105, 105, 105));
        panel.setBounds(0, 0, 113, 261);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblImage = new JLabel("");
        lblImage.setIcon(new ImageIcon("C:\\Users\\aleja\\Downloads\\security.png"));
        lblImage.setBounds(10, 11, 93, 79);
        panel.add(lblImage);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new CompoundBorder());
        panel_1.setBackground(new Color(220, 220, 220));
        panel_1.setBounds(112, 0, 322, 261);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        usuarioTextField = new JTextField();
        usuarioTextField.setBounds(10, 83, 302, 20);
        panel_1.add(usuarioTextField);
        usuarioTextField.setColumns(10);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(10, 145, 302, 20);
        panel_1.add(passwordTextField);

        chckbxRememberMe = new JCheckBox("Recordar");
        chckbxRememberMe.setFont(new Font("Consolas", Font.PLAIN, 11));
        chckbxRememberMe.setBackground(new Color(220, 220, 220));
        chckbxRememberMe.setBounds(10, 172, 116, 23);
        panel_1.add(chckbxRememberMe);

        JLabel lblNewLabel_2 = new JLabel("Desarrollado por @Devinci404");
        lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 11));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_2.setBounds(10, 236, 302, 14);
        panel_1.add(lblNewLabel_2);

        JLabel lblContraseñaIncorrecta = new JLabel("");
        lblContraseñaIncorrecta.setFont(new Font("Consolas", Font.PLAIN, 11));
        lblContraseñaIncorrecta.setBounds(102, 120, 210, 14);
        panel_1.add(lblContraseñaIncorrecta);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Español", "English"}));
        comboBox.setBounds(230, 11, 82, 22);
        panel_1.add(comboBox);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 11));
        btnNewButton.setBounds(223, 170, 89, 23);
        btnNewButton.setActionCommand("Login");
        panel_1.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("Contraseña");
        lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
        lblNewLabel.setBounds(10, 120, 116, 14);
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Usuario");
        lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(10, 58, 116, 14);
        panel_1.add(lblNewLabel_1);
        loginController = new LoginController(this);
    }
}
