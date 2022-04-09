package pers.tangyf.dbms.data;

public class Student {
        //初始化给一些初始值
        private int SID = -1;
        private String SName = "";
        private String SGender = "";
        public Student() {}
        public Student(String name, String gender, int id) {
            SName = name;
            SGender = gender;
            SID = id;}
        public void setStName(String name) {
            SName = name;}
        public String getSName() {
            return SName;}
        public void setSGender(String gender) {
            SGender = gender;}
        public String getSGender() {
            return SGender;}
        public int getSID(){
            return SID;}
}
