import javax.swing.*;
import java.awt.*;
import java.util.Random;

class DrawPanel extends JPanel {

    private int drawMode;
    private int x1;
    Tree derevo = new Tree();

    Color blue = new Color(0xFF00E3);
    Color black = new Color(0x000000);

    public void setX(int x1) {
        this.x1 = x1;
    }

    public DrawPanel(){
        setLayout(null);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.black));
        drawMode = 0;
    }

    public void setDrawMode(int x){
        drawMode = x;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        switch (drawMode) {
            case 1:
                derevo.insert(x1);
                derevo.paint(g);
                break;
            case 2:
                derevo.paint(g);
                derevo.find(g, x1,blue,black);
                break;
            case 3:
                derevo.remove(x1);
                derevo.paint(g);
                break;
            case 4:
                Random rnd = new Random();
                for (int i = 0; i < x1; i++) {
                    derevo.insert(rnd.nextInt(89)+10);
                }
                derevo.paint(g);
                break;
            case 5:
                derevo.clearTree();
                break;
        }
    }
}
