package pers.tangyf.dbms.util;

import javax.swing.*;
import java.net.URL;

public class CreatedIcon {
    public static ImageIcon add(String ImageName){
        URL IconUrl = CreatedIcon.class.getResource("/pers/tangyf/dbms/img/"+ImageName);
        ImageIcon icon=new ImageIcon(IconUrl);
        return icon;
    }
}
