import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class soal4 extends Frame implements ActionListener {
    private int sunX; // x-coordinate of the sun
    private int sunY; // y-coordinate of the sun
    private int planetRadius = 20;
    private int orbitRadius = 150;
    private int angle = 0;
    private Timer timer;
    private Point closestPointToSun; // Titik paling dekat dengan matahari di planet

    soal4() {
        addWindowListener(new MyFinishWindow());
        timer = new Timer(50, this); // 50 milliseconds delay between updates
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        angle++; // Increment angle for animation
        updateClosestPoint(); // Update the closest point to the sun on the planet
        repaint(); // Trigger repaint to update the animation
    }

    // Method to update the position of the closest point to the sun on the planet
    private void updateClosestPoint() {
        // Calculate the position of the closest point to the sun on the planet
        double closestX = sunX + orbitRadius * Math.cos(Math.toRadians(angle - 120)); // Menggeser sudut sebesar 120
                                                                                      // derajat (1/3 orbit)
        double closestY = sunY + orbitRadius * Math.sin(Math.toRadians(angle - 120));
        closestPointToSun = new Point((int) closestX, (int) closestY);
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

        // Draw the closest point to the sun on the planet
        g2d.setColor(Color.RED);
        g2d.fillOval((int) (closestPointToSun.x - 3), (int) (closestPointToSun.y - 3), 6, 6);
    }

    public static void main(String[] argv) {
        soal4 f = new soal4();
        f.setTitle("orbit system with pluto");
        f.setSize(500, 500);
        f.setVisible(true);
    }
}
