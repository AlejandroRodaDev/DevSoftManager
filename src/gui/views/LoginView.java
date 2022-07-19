package gui.views;

//region Imports
import gui.controllers.LoginController;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
//endregion

public class LoginView extends JFrame{

    //region Variables
    private JPanel contentPane;
    private JTextField textFieldUser;
    private JTextField textFieldPassword;
    private JCheckBox checkboxRememberMe;
    private JButton btnNewAccept;
    private JComboBox comboBoxLanguage;
    private JLabel lblRegister;
    //endregion

    //region Getters
    public JTextField getTextFieldUser() {
        return textFieldUser;
    }

    public JTextField getTextFieldPassword() {
        return textFieldPassword;
    }

    public JButton getBtnNewAccept() {
        return btnNewAccept;
    }

    public JCheckBox getCheckboxRememberMe() {
        return checkboxRememberMe;
    }

    public JComboBox getComboBoxLanguage() {
        return comboBoxLanguage;
    }

    public JLabel getLblRegister() {
        return lblRegister;
    }

    //endregion

    //region Constructor
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

        lblRegister = new JLabel("Registarse");
        lblRegister.setForeground(Color.WHITE);
        lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegister.setFont(new Font("Consolas", Font.PLAIN, 11));
        lblRegister.setBounds(10, 236, 93, 14);
        panel.add(lblRegister);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new CompoundBorder());
        panel_1.setBackground(new Color(220, 220, 220));
        panel_1.setBounds(112, 0, 322, 261);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        textFieldUser = new JTextField();
        textFieldUser.setBounds(10, 83, 302, 20);
        panel_1.add(textFieldUser);
        textFieldUser.setColumns(10);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(10, 145, 302, 20);
        panel_1.add(textFieldPassword);

        checkboxRememberMe = new JCheckBox("Recordar");
        checkboxRememberMe.setFont(new Font("Consolas", Font.PLAIN, 11));
        checkboxRememberMe.setBackground(new Color(220, 220, 220));
        checkboxRememberMe.setBounds(10, 172, 116, 23);
        panel_1.add(checkboxRememberMe);

        JLabel lblNewLabel_2 = new JLabel("Desarrollado por @Devinci404");
        lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 11));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_2.setBounds(10, 236, 302, 14);
        panel_1.add(lblNewLabel_2);

        comboBoxLanguage = new JComboBox();
        comboBoxLanguage.setFont(new Font("Consolas", Font.PLAIN, 11));
        comboBoxLanguage.setModel(new DefaultComboBoxModel(new String[] {"Español", "English"}));
        comboBoxLanguage.setBounds(230, 11, 82, 22);
        panel_1.add(comboBoxLanguage);

        btnNewAccept = new JButton("Login");
        btnNewAccept.setFont(new Font("Consolas", Font.PLAIN, 11));
        btnNewAccept.setBounds(223, 170, 89, 23);
        btnNewAccept.setActionCommand("Login");
        panel_1.add(btnNewAccept);

        JLabel lblNewLabel = new JLabel("Contraseña");
        lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
        lblNewLabel.setBounds(10, 120, 116, 14);
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Usuario");
        lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(10, 58, 116, 14);
        panel_1.add(lblNewLabel_1);

        LoginController loginController = new LoginController(this);
    }
    //endregion
}
