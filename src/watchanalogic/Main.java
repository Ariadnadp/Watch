package watchanalogic;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        new Main().execute();
    }

    // Constructor
    public Main() {
        initComponents();
        Watch watch = new Watch();
        WatchDisplay watchDisplay = new WatchDisplay();
        WatchPresenter watchPresenter = new WatchPresenter(watch,watchDisplay);
        add(watchDisplay);
    }

    // Method execute
    private void execute() {
        setVisible(true);
    }

    private void initComponents() {
        setTitle("Watch");
        setSize(478,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
