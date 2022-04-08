package pers.tangyf.dbms.window;

import pers.tangyf.dbms.dao.Dao;
import pers.tangyf.dbms.data.Admin;
import pers.tangyf.dbms.util.CreatedIcon;
import pers.tangyf.dbms.view.ManagementStudio;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LoginFrame extends JFrame {
    private class ResetAction implements ActionListener {//重置动作

        public void actionPerformed(final ActionEvent e) {
            username.setText("");
            password.setText("");
        }
    }

    class LoginAction implements ActionListener {//登录动作

        public void actionPerformed(final ActionEvent e) {
            if (Dao.checkLogin(username.getText(), password.getPassword())) {
                ManagementStudio frame = new ManagementStudio();
                frame.setVisible(true);
                LoginFrame.this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "密码错误或用户不存在");
                username.setText("");
                password.setText("");
            }
        }
    }

    private final JPasswordField password;
    private final JTextField username;
    private final JButton login;
    private final JButton reset;
    private static Admin admin;

    public LoginFrame() {
        super();
        final BorderLayout borderLayout = new BorderLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        borderLayout.setVgap(10);
        getContentPane().setLayout(borderLayout);
        setTitle("成绩管理系统登录");
        setBounds(100, 100, 385, 194);
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(0, 0, 0, 0));
        getContentPane().add(panel);
        final JPanel panel_2 = new JPanel();
        final GridLayout gridLayout = new GridLayout(0, 2);
        gridLayout.setHgap(5);
        gridLayout.setVgap(20);
        panel_2.setLayout(gridLayout);
        panel.add(panel_2);
        final JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(0, 0));
        label.setMinimumSize(new Dimension(0, 0));
        panel_2.add(label);
        label.setText("用  户  名：");
        username = new JTextField(15);
        username.setPreferredSize(new Dimension(0, 0));
        panel_2.add(username);
        final JLabel label_1 = new JLabel();
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_2.add(label_1);
        label_1.setText("密      码：");
        password = new JPasswordField(15);
        password.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    login.doClick();
                }
            }
        });
        panel_2.add(password);
        final JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.SOUTH);
        login = new JButton();
        login.addActionListener(new LoginAction());
        login.setText("登录");
        panel_1.add(login);
        reset = new JButton();
        reset.addActionListener(new ResetAction());
        reset.setText("重置");
        panel_1.add(reset);
        final JLabel tupianLabel = new JLabel();
        ImageIcon loginIcon = CreatedIcon.add("logo.png");
        tupianLabel.setIcon(loginIcon);
        tupianLabel.setOpaque(true);
        tupianLabel.setBackground(Color.GREEN);
        tupianLabel.setPreferredSize(new Dimension(260, 60));
        panel.add(tupianLabel, BorderLayout.NORTH);
        setVisible(true);
        setResizable(false);
    }
}
