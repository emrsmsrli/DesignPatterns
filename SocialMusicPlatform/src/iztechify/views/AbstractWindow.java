package iztechify.views;

import javax.swing.*;
import java.util.Observer;

public abstract class AbstractWindow extends JFrame implements Window, Observer {
    public AbstractWindow(String title) {
        super(title);
    }
}
