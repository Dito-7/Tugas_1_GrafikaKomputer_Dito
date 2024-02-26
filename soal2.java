import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class soal2 extends Frame implements ActionListener {
    private int sunX; // x-coordinate of the sun
    private int sunY; // y-coordinate of the sun
    private int planetRadius = 20;
    private int orbitRadius = 150;
    private int angle = 0;
    private Timer timer;

    soal2() {
        addWindowListener(new MyFinishWindow());
        timer = new Timer(50, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        angle++;
        repaint();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        // Get the width and height of the window
        int width = getWidth();
        int height = getHeight();

        // Calculate the center of the window
        sunX = width / 2;
        sunY = height / 2;

        // Draw the sun
        g2d.setColor(Color.BLACK);
        g2d.fillOval(sunX - 20, sunY - 20, 60, 60);

        // Calculate planet's position
        double planetX = sunX + orbitRadius * Math.cos(Math.toRadians(angle));
        double planetY = sunY + orbitRadius * Math.sin(Math.toRadians(angle));

        // Draw the planet
        g2d.setColor(Color.BLUE);
        g2d.fillOval((int) (planetX - planetRadius), (int) (planetY - planetRadius), 2 * planetRadius,
                2 * planetRadius);
    }

    public static void main(String[] argv) {
        soal2 f = new soal2();
        f.setTitle("orbit system");
        f.setSize(500, 500);
        f.setVisible(true);
    }
}
