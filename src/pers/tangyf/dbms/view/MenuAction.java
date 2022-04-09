package pers.tangyf.dbms.view;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MenuAction {
        private static Map<String, JInternalFrame> frames=new HashMap<String, JInternalFrame>(); // 子窗体集合
//        public static CourseModiAction Course_MODIFY; // 图书信息修改窗体动作
//        public static CourseAddAction Course_ADD; // 图书信息添加窗体动作

        //图书修改与删除
//        private static class CourseModiAction implements ActionListener {
//
//            public void actionPerformed(ActionEvent e) {
//                if (!frames.containsKey("图书修改")||frames.get("图书修改").isClosed()) {
//                    CourseModiAndDelFrame frame=new CourseModiAndDelFrame();
//                    frames.put("图书修改", frame);
//                    ManagementStudio.addIFame(frames.get("图书修改"));
//                }
//            }
//        }

//        public static ActionListener getCourseModiAction(){
//            if(Course_MODIFY==null){
//                Course_MODIFY=new CourseModiAction();
//            }
//            return Course_MODIFY;
//
//        }
//    private static class CourseAddAction implements ActionListener {// 图书信息添加－－－已经实现，请参照
//        public void actionPerformed(ActionEvent e) {
//            if (!frames.containsKey("图书信息添加")||frames.get("图书信息添加").isClosed()) {
//                CourseAddFrame frame = new CourseAddFrame();
//                frames.put("图书信息添加", frame);
//                ManagementStudio.addIFame(frames.get("图书信息添加"));
//            }
//        }
//    }

//    public static ActionListener getCourseAddAction(){
//        if(Course_ADD==null){
//            Course_ADD=new CourseAddAction();
//        }
//        return Course_ADD;
//    }

    private MenuAction() {
        super();
    }
}
