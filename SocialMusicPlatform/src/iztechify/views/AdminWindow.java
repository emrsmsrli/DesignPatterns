package iztechify.views;

import javax.swing.*;

public class AdminWindow  extends AbstractWindow {
    public AdminWindow(){
        super("Admin");
        setSize(400, 500);
        setLayout(null);
    }

    @Override
    public void showWindow() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
