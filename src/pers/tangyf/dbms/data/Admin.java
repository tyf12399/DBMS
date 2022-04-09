package pers.tangyf.dbms.data;

public class Admin {
    private int AID = -1;
    private String username = "";
    private String password = "";
    public Admin() {}
    public Admin(String name, String pwd, int id) {
        username = name;
        password = pwd;
        AID = id;}
    public void setUsername(String name) {
        username = name;}
    public String getUsername() {
        return username;}
    public void setPassword(String pwd) {
        password = pwd;}
    public String getPassword() {
        return password;}
    public int getAID(){
        return AID;}
}
