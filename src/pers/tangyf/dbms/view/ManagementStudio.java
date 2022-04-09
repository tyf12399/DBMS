package pers.tangyf.dbms.view;

import pers.tangyf.dbms.util.CreatedIcon;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ManagementStudio extends JFrame {
    private static final JDesktopPane DESKTOP_PANE = new JDesktopPane();

    public ManagementStudio() {
        super();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        setLocationByPlatform(true);
        setSize(800, 600);
        setTitle("重庆大学图书馆管理系统");
        JMenuBar menuBar = createMenu(); // 调用创建菜单栏的方法
        setJMenuBar(menuBar);
        JToolBar toolBar = createToolBar(); // 调用创建工具栏的方法
        getContentPane().add(toolBar, BorderLayout.NORTH);
        final JLabel label = new JLabel();
        label.setBounds(0, 0, 0, 0);
        label.setIcon(null); // 窗体背景
        DESKTOP_PANE.addComponentListener(new ComponentAdapter() {
            public void componentResized(final ComponentEvent e) {
                Dimension size = e.getComponent().getSize();
                label.setSize(e.getComponent().getSize());
                ImageIcon icon=CreatedIcon.get("backImg.jpg");//添加菜单栏图标
                label.setIcon(icon);
            }
        });
        DESKTOP_PANE.add(label, Integer.MIN_VALUE);
        getContentPane().add(DESKTOP_PANE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new LoginFrame();//登录窗口
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void addIFame(JInternalFrame iframe) { // 添加子窗体的方法
        DESKTOP_PANE.add(iframe);
    }

    private JToolBar createToolBar() { // 创建工具栏的方法
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        BevelBorder border = new BevelBorder(BevelBorder.RAISED);
        toolBar.setBorder(border);
//
        JButton CourseAddButton = new JButton();
        ImageIcon icon = CreatedIcon.get("CourseAddtb.jpg");//添加菜单栏图标
        CourseAddButton.setIcon(icon);
        CourseAddButton.setHideActionText(true);
//        CourseAddButton.addActionListener(MenuAction.getCourseAddAction());
        toolBar.add(CourseAddButton);
////在工具栏中添加图书修改与删除图标
        JButton CourseModiAndDelButton = new JButton();
        ImageIcon Coursemodiicon = CreatedIcon.get("CourseModiAndDeltb.jpg");//创建图标方法
        CourseModiAndDelButton.setIcon(Coursemodiicon);
        CourseModiAndDelButton.setHideActionText(true);
        toolBar.add(CourseModiAndDelButton);
//        CourseModiAndDelButton.addActionListener(MenuAction.getCourseModiAction());

        JButton CourseTypeAddButton = new JButton();
        ImageIcon CourseTypeAddicon = CreatedIcon.get("CourseTypeAddtb.jpg");//创建图标方法
        CourseTypeAddButton.setIcon(CourseTypeAddicon);
        CourseTypeAddButton.setHideActionText(true);
        toolBar.add(CourseTypeAddButton);
        JButton CourseBorrowButton = new JButton();
        ImageIcon CourseBorrowicon = CreatedIcon.get("CourseBorrowtb.jpg");//创建图标方法
        CourseBorrowButton.setIcon(CourseBorrowicon);
        CourseBorrowButton.setHideActionText(true);
        toolBar.add(CourseBorrowButton);
//
        JButton CourseOrderButton = new JButton();
        ImageIcon CourseOrdericon = CreatedIcon.get("CourseOrdertb.jpg");//创建图标方法
        CourseOrderButton.setIcon(CourseOrdericon);
        CourseOrderButton.setHideActionText(true);
        toolBar.add(CourseOrderButton);
//
        JButton CourseCheckButton = new JButton();
        ImageIcon CourseCheckicon = CreatedIcon.get("newCourseChecktb.jpg");//创建图标方法
        CourseCheckButton.setIcon(CourseCheckicon);
        CourseCheckButton.setHideActionText(true);
        toolBar.add(CourseCheckButton);
//
        JButton readerAddButton = new JButton();
        ImageIcon readerAddicon = CreatedIcon.get("readerAddtb.jpg");//创建图标方法
        readerAddButton.setIcon(readerAddicon);
        readerAddButton.setHideActionText(true);
        toolBar.add(readerAddButton);

        JButton readerModiAndDelButton = new JButton();
        ImageIcon readerModiAndDelicon = CreatedIcon.get("readerModiAndDeltb.jpg");//创建图标方法
        readerModiAndDelButton.setIcon(readerModiAndDelicon);
        readerModiAndDelButton.setHideActionText(true);
        toolBar.add(readerModiAndDelButton);

        JButton ExitButton = new JButton();
        ImageIcon Exiticon = CreatedIcon.get("exittb.jpg");//创建图标方法
        ExitButton.setIcon(Exiticon);
        ExitButton.setHideActionText(true);
        toolBar.add(ExitButton);
        return toolBar;
    }

    private JMenuBar createMenu() { // 创建菜单栏的方法
        JMenuBar menuBar = new JMenuBar();

        JMenu CourseOrderMenu = new JMenu(); // 初始化新书订购管理菜单
        CourseOrderMenu.setIcon(CreatedIcon.get("xsdgcd.jpg"));
        CourseOrderMenu.addActionListener(new TempListener());

        JMenu baseMenu = new JMenu();// 初始化基础数据维护菜单
        baseMenu.setIcon(CreatedIcon.get("jcsjcd.jpg"));
        {
            JMenu readerManagerMItem = new JMenu("读者信息管理");
            readerManagerMItem.addActionListener(new TempListener());

            JMenu CourseTypeManageMItem = new JMenu("图书类别管理");
            CourseTypeManageMItem.addActionListener(new TempListener());

            JMenu menu = new JMenu("图书信息管理");
            menu.addActionListener(new TempListener());

            baseMenu.add(readerManagerMItem);
            baseMenu.add(CourseTypeManageMItem);
            baseMenu.add(menu);
            baseMenu.addSeparator();
            baseMenu.addActionListener(new TempListener());
        }
        JMenu borrowManageMenu = new JMenu(); // 借阅管理
        borrowManageMenu.setIcon(CreatedIcon.get("jyglcd.jpg"));
        borrowManageMenu.addActionListener(new TempListener()); // 借阅

        JMenu sysManageMenu = new JMenu(); // 系统维护
        sysManageMenu.setIcon(CreatedIcon.get("jcwhcd.jpg"));
        JMenu userManageMItem = new JMenu("用户管理"); // 用户管理
        userManageMItem.addActionListener(new TempListener());
        sysManageMenu.addActionListener(new TempListener());
        sysManageMenu.add(userManageMItem);

        menuBar.add(baseMenu); // 添加基础数据维护菜单到菜单栏
        menuBar.add(CourseOrderMenu); // 添加新书订购管理菜单到菜单栏
        menuBar.add(borrowManageMenu); // 添加借阅管理菜单到菜单栏
        menuBar.add(sysManageMenu); // 添加系统维护菜单到菜单栏
        return menuBar;
    }

    private class TempListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
// TODO Auto-generated method stub
        }
    }
}


