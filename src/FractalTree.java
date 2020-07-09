import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class FractalTree extends JFrame {

    public FractalTree() {
        super("Fractal Tree");
        setBounds(100, 100, 1200, 1000);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void drawTree(Graphics g, int x1, int y1, double angle, int depth, double length, int angleBetweenBranch, double portionOfNextBranch) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth  * length);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth  * length);
        g.drawLine(x1, y1, x2, y2);

        drawTree(g, x2, y2, angle - angleBetweenBranch, depth - 1, length*portionOfNextBranch, angleBetweenBranch, portionOfNextBranch);
        drawTree(g, x2, y2, angle + angleBetweenBranch, depth - 1,length*portionOfNextBranch, angleBetweenBranch, portionOfNextBranch);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        drawTree(g, 600, 800, -90, 10, 10,45, 1);
    }

    public static void main(String[] args) {
        new FractalTree().setVisible(true);
    }
}