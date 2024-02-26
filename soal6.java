import java.awt.*;
import java.awt.geom.*;

public class soal6 extends Frame {

    // Constructor
    public soal6() {
        // Enable the closing of the window.
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        // Use antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // The lines should have a thickness of 3.0 instead of 1.0.
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        // Definition and drawing of the curves that define the letters.

        // Letter D
        int xd1 = 50;
        int yd1 = 50;

        int xd2 = 50;
        int yd2 = 450;

        int xd3 = 400;
        int yd3 = 250;

        int xd4 = 50;
        int yd4 = 450;

        int xd5 = 50;
        int yd5 = 250;
        QuadCurve2D.Double d1 = new QuadCurve2D.Double(xd1, yd1, xd3, yd3, xd2, yd2);
        g2d.draw(d1);
        QuadCurve2D.Double d2 = new QuadCurve2D.Double(xd1, yd1, xd5, yd5, xd4, yd4);
        g2d.draw(d2);

        // Letter A
        int xa1 = 300, ya1 = 400;
        int xa2 = 350, ya2 = 100;
        int xa3 = 400, ya3 = 400;

        g2d.drawLine(xa1, ya1, xa2, ya2);
        g2d.drawLine(xa2, ya2, xa3, ya3);

        // Letter N
        int xn1 = 550, yn1 = 400;
        int xn2 = 550, yn2 = 100;
        int xn3 = 650, yn3 = 400;
        int xn4 = 650, yn4 = 100;
        g2d.drawLine(xn1, yn1, xn2, yn2);
        g2d.drawLine(xn2, yn2, xn3, yn3);
        g2d.drawLine(xn3, yn3, xn4, yn4);
    }

    public static void main(String[] argv) {
        soal6 f = new soal6();
        f.setTitle("Letters: D, A, N");

        f.setSize(700, 500);
        f.setVisible(true);
    }
}
