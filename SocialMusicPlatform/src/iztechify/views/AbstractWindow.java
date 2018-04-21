package iztechify.views;

import javax.swing.*;

public abstract class AbstractWindow extends JFrame implements Window {
    public AbstractWindow(String title) {
        super(title);
    }
}
