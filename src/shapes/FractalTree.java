package shapes;

import main.Main;

import java.awt.*;

public class FractalTree extends Shape {
    private Graphics2D g;
    private int length	  = 300, count;
    private double angle1 = Math.PI / 4,
            angle2 = Math.PI / 4;

    public FractalTree(Main main) {
        super(main, "Fractal Tree");
    }

    public void begin(Graphics g) {
        if(++count > 15)
            count--;
        this.g 	   = (Graphics2D) g;
        int width  = main.getFrame().getWidth();
        int height = main.getFrame().getHeight();

        g.translate(width / 2, height);
        fractal(length, count - 1);
    }

    private void fractal(int length, int count) {
        g.drawLine(0, 0, 0, -length);
        g.translate(0, -length);

        if(count < 1)
            return;

        g.rotate(angle1);
        fractal(length / 3 * 2, count - 1);

        g.translate(0, length / 3 * 2);
        g.rotate(-angle1);

        g.rotate(-angle2);
        fractal(length / 3 * 2, count - 1);

        g.translate(0, length / 3 * 2);
        g.rotate(angle2);
    }
}