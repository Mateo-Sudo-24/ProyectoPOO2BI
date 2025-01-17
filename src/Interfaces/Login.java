package Interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public JPanel panelLogin;
    private JButton ingresarButtonLogin;
    private JTextField TFLPassword;
    private JTextField TFLUsuario;

    public Login(JPanel frame) {
        ingresarButtonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new MenuPrincipal(frame).PanelPrincipal );
                frame.validate();
                frame.repaint();
            }
        });
    }
}
