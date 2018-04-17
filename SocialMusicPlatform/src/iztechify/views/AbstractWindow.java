package iztechify.views;

import javax.swing.*;

public class AbstractWindow extends JFrame implements Window {
    public AbstractWindow(String title) {
        JFrame frame = new JFrame(title);
    }
}
