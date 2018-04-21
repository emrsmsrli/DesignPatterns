package iztechify.views;

import iztechify.models.Music;
import iztechify.controllers.AdminController;

import javax.swing.*;
import java.util.Observable;

public class AdminWindow  extends AbstractWindow {
    private AdminController adminController;
    private Music music;

    public AdminWindow(AdminController adminController, Music music){
        super("Admin");
        this.adminController = adminController;
        this.music = music;
        setSize(400, 500);
        setLayout(null);
    }

    @Override
    public void showWindow() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
