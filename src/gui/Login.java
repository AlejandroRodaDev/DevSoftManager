package gui;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Login extends JFrame{
    private JPanel contentPane;
    private JTextField usuarioTextField;
    private JPasswordField passwordTextField;

    public Login() {
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
        usuarioTextField.setBounds(102, 83, 210, 20);
        usuarioTextField.setFont(new Font("Consolas", Font.PLAIN, 11));
        panel_1.add(usuarioTextField);
        usuarioTextField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Usuario");
        lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
        lblNewLabel.setBounds(10, 86, 82, 14);
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Contraseña");
        lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(10, 126, 82, 14);
        panel_1.add(lblNewLabel_1);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(102, 123, 210, 20);
        panel_1.add(passwordTextField);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Recordar");
        chckbxNewCheckBox.setFont(new Font("Consolas", Font.PLAIN, 11));
        chckbxNewCheckBox.setBackground(new Color(220, 220, 220));
        chckbxNewCheckBox.setBounds(196, 175, 116, 23);
        panel_1.add(chckbxNewCheckBox);

        JLabel lblNewLabel_2 = new JLabel("Desarrollado por @Devinci404");
        lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 11));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_2.setBounds(10, 236, 302, 14);
        panel_1.add(lblNewLabel_2);

        JLabel lblContraseñaIncorrecta = new JLabel("");
        lblContraseñaIncorrecta.setFont(new Font("Consolas", Font.PLAIN, 11));
        lblContraseñaIncorrecta.setBounds(102, 154, 210, 14);
        panel_1.add(lblContraseñaIncorrecta);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Español", "English"}));
        comboBox.setBounds(230, 11, 82, 22);
        panel_1.add(comboBox);
    }
}
