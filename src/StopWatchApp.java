import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Cody on 1/31/2017.
 */
public class StopWatchApp extends JFrame {

    //List all the GUI Object References
    private final String applicationTitle = "Stop Watch Application";
    private JLabel title;
    private JTextField hrsField;
    private JTextField minField;
    private JTextField secField;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private int hr;
    private int min;
    private int sec;
    private boolean isWatchTicking = false;

    private StopWatch stopwatch;

    public static void main(String[] args) {
        StopWatchApp stopwatchApp = new StopWatchApp();
        stopwatchApp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        centreWindow(stopwatchApp);
        stopwatchApp.setVisible(true);
    }

    public StopWatchApp() {
        this.setTitle(applicationTitle);
        this.setSize(800, 320);
        initializeGUI();
        setTime();
    }

    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    private void initializeGUI() {
        JPanel content = (JPanel)this.getContentPane();
        content.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2,2,2,2);
        c.gridx = 0;
        c.gridy = 0;
        title = new JLabel("Stop Watch", SwingConstants.CENTER);
        content.add(title, c);
        addWindowListener(new ConfirmOnClose());
        c.gridx = 0;
        c.gridy = 1;
        content.add(createDisplayPanel(), c);
        c.gridx = 0;
        c.gridy = 2;
        content.add(createButtonsPanel(), c);
    }


    class ConfirmOnClose extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            int confirm = JOptionPane.showConfirmDialog(e.getWindow(), "Are you sure you want to exit?");
            if(confirm == 0) {
                e.getWindow().dispose();
                System.exit(0);
            }
        }
    }
}
