
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockView extends JFrame {

    /* -----------------Private Member variables --------------------- */
    private static final long serialVersionUID = 1L;
    private static int ROWS_IN_GRID = 2;
    private static int COLS_IN_GRID = 1;
    private static int BUTTON_ROWS = 1;
    private static int BUTTON_COLS = 2;
    private final SimpleClock clock;
    private JLabel face;

    /**
     * Constructor. Takes a SimpleClock as an argument and builds a graphical
     * interface using that clock the model. The Tick button increments the
     * clock by 1 second, while the Reset button sets the clock back to midnight
     * (12:00:00AM). *
     *
     * @param clock
     *            - the clock instance used to store the time for the view
     */
    public ClockView(final SimpleClock clock) {
        super("SimpleClock Demo");
        this.clock = clock;
        this.face = new JLabel("<html><span style='font-size:20px'>"
                + this.clock + "</span></html>");

        this.setLayout(new GridLayout(ROWS_IN_GRID, COLS_IN_GRID));
        this.add(this.face);

        JPanel buttonPanel = new JPanel(
                new GridLayout(BUTTON_ROWS, BUTTON_COLS));
        JButton tickButton = new JButton("Tick");
        tickButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                clock.tick();
                ClockView.this.face.setText(
                        "<html><span style='font-size:20px'>" + clock
                                + "</span></html>");

            }

        });
        buttonPanel.add(tickButton);

        JButton resetButton = new JButton("reset");
        resetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clock.set(12, 0, 0, true);
                ClockView.this.face.setText(
                        "<html><span style='font-size:20px'>" + clock
                                + "</span></html>");
            }

        });
        buttonPanel.add(resetButton);

        this.add(buttonPanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ClockView v = new ClockView(new SimpleClock());
    }

}
