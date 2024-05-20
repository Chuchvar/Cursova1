package Simolator;
import javax.swing.*;
import java.awt.*;
public class GamePanel extends JPanel {
    private World world;

    public GamePanel(World world) {
        this.world = world;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Малюйте ваші об'єкти тут
        for (Soldier soldier : world.team1.get()) {
            if (soldier.getlive()) {
                g.setColor(Color.BLUE);
                g.fillRect((int)soldier.getCorditSoldOnMapX()*4, (int)soldier.getCorditSoldOnMapY()*4, 6, 6);
            }
        }
        for (Soldier soldier : world.team2.get()) {
            if (soldier.getlive()) {
                g.setColor(Color.RED);
                g.fillRect((int)soldier.getCorditSoldOnMapX()*4, (int)soldier.getCorditSoldOnMapY()*4, 6, 6);
            }
        }
        for (int a=0;a<world.sizeMaponX;a++) {
            for (int a2=0;a2<world.sizeMaponX;a2++) {
                if (world.terra.setmap1(a,a2)==-1) {
                    g.setColor(Color.BLACK);
                    g.fillRect(a*4, a2*4, 6, 6);
                }
            }
        }
    }
}
