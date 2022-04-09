package pers.tangyf.dbms.util;

import javax.swing.*;
import java.net.URL;

public class CreatedIcon {
    public static ImageIcon get(String ImageName){
        URL IconUrl = CreatedIcon.class.getResource("/img/"+ImageName);
        ImageIcon icon=new ImageIcon(IconUrl);
        return icon;
    }
}
