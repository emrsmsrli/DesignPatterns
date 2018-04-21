package iztechify.views;

import iztechify.controllers.Controller;
import iztechify.models.music.Music;

import javax.swing.*;
import java.util.Observable;

public class AdminWindow  extends AbstractWindow {
    private Controller adminController;
    private Music music;

    public AdminWindow(Controller adminController, Music music){
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
