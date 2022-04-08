package pers.tangyf.dbms.view;

import pers.tangyf.dbms.window.LoginFrame;

import javax.swing.*;

public class ManagementStudio extends JFrame {
    private static final JDesktopPane DESKTOP_PANE = new JDesktopPane();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new LoginFrame();//登录窗口
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
