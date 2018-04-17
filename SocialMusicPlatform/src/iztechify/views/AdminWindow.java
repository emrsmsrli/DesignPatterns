package iztechify.views;

import javax.swing.*;

public class AdminWindow  extends AbstractWindow {
    public AdminWindow(){
        super("Admin Profile");
        JFrame admin = new JFrame("Admin Profile");
        admin.setSize(400, 500);
        admin.setLayout(null);
        admin.setVisible(true);
    }
}
