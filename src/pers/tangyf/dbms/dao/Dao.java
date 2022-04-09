package pers.tangyf.dbms.dao;

import java.sql.*;
import java.util.*;

public class Dao {
    private static Connection conn = null;
    private Dao() {

        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=GradeDB;"
                        + "user=sa;"
                        + "password=just4Momizi;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;";

        try {
            conn = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ResultSet executeQuery(String sql) {
        try {
            if (conn == null) new Dao();
            return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
        }
    }

    private static int executeUpdate(String sql) {
        try {
            if (conn == null) new Dao();
            return conn.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        } finally {
        }
    }

    public static boolean checkLogin(String user, String pwd) {
        String userCheckSQL = "select * from admin where username='" + user + "' and pwd='" + pwd + "'";
        System.out.println(userCheckSQL);
        ResultSet rs = executeQuery(userCheckSQL);
        boolean flag = false;
        try {
            if (rs == null) flag = false;
            else {
                System.out.println(rs.getRow());
                rs.last();
                flag = rs.getRow() >= 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
            return flag;
        }
    }

    public static List selectCourseInfo() {
        List list = new ArrayList();
        String sql = "select * from Courses";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
//                Course Courseinfo = new Course();
//                Courseinfo.setCourseID(rs.getInt("CourseID"));
//                Courseinfo.setcname(rs.getString("cname"));
//                Courseinfo.setAuthorList(rs.getString("AuthorList"));
//                Courseinfo.setCourseDate(rs.getDate("Coursedate"));
//                list.get(Courseinfo);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }

    public static int InsertCourse(String cname, int credit, int cid) {
        int i = 0;
        try {
            String sql =
                    "insert into Courses(cid,cname,authorlist) values('" + cid + "','" + cname + "','" + credit + "')";
            System.out.println(sql);
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }

    public static int UpdateCourse(int cid, String cname, int credit) {
        int i = 0;
        try {
            String sql = "update Courses set ='" + cname + "',credit='" + credit + "' where cid='" + cid + "'";
            System.out.println(sql);
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }

    public static void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

    public static Connection getDao() {
        if (conn == null) new Dao();
        return conn;
    }

}
