import java.awt.*;
import java.awt.geom.*;

public class soal1 extends Frame {

    soal1() {
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Use of antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // The lines should have a thickness of 3.0 instead of 1.0.
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        GeneralPath gp = new GeneralPath();

        gp.moveTo(60, 80);

        gp.lineTo(200, 80);
        gp.quadTo(220, 80, 220, 100);

        gp.lineTo(220, 150);
        gp.quadTo(220, 170, 200, 170);

        gp.lineTo(60, 170);
        gp.quadTo(40, 170, 40, 150);

        gp.lineTo(40, 100);
        gp.quadTo(40, 80, 60, 80);

        g2d.draw(gp);

        g2d.setStroke(new BasicStroke(1.0f));

        // Draw a coordinate system.
        drawSimpleCoordinateSystem(250, 200, g2d);
    }

    public static void drawSimpleCoordinateSystem(int xmax, int ymax,
            Graphics2D g2d) {
        int xOffset = 30;
        int yOffset = 50;
        int step = 20;
        String s;
        // Remember the actual font.
        Font fo = g2d.getFont();
        // Use a small font.
        g2d.setFont(new Font("sansserif", Font.PLAIN, 9));
        // x-axis.
        g2d.drawLine(xOffset, yOffset, xmax, yOffset);
        // Marks and labels for the x-axis.
        for (int i = xOffset + step; i <= xmax; i = i + step) {
            g2d.drawLine(i, yOffset - 2, i, yOffset + 2);
            g2d.drawString(String.valueOf(i), i - 7, yOffset - 7);
        }

        // y-axis.
        g2d.drawLine(xOffset, yOffset, xOffset, ymax);

        s = "  "; // for indention of numbers < 100
        for (int i = yOffset + step; i <= ymax; i = i + step) {
            g2d.drawLine(xOffset - 2, i, xOffset + 2, i);
            if (i > 99) {
                s = "";
            }
            g2d.drawString(s + String.valueOf(i), xOffset - 25, i + 5);
        }

        // Reset to the original font.
        g2d.setFont(fo);
    }

    public static void main(String[] argv) {
        soal1 f = new soal1();
        f.setTitle("GeneralPath example");
        f.setSize(500, 500);
        f.setVisible(true);
    }
}
