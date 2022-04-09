package pers.tangyf.dbms.data;

public class Course {
    private int CID = -1;
    private String CName = "";
    private int Credit = -1;
    public Course() {}
    public Course(String name, int credit_p, int id) {
        CName = name;
        SGender = gender;
        CID = id;}
    public void setCName(String name) {
        CName = name;}
    public String getCName() {
        return CName;}
    public void setSGender(String gender) {
        SGender = gender;}
    public String getSGender() {
        return SGender;}
    public int getCID(){
        return CID;}
}
}
