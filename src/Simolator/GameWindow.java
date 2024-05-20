package Simolator;

import javax.swing.*;
import java.awt.*;

    public class GameWindow extends JFrame {
        private GamePanel panel;

        public GameWindow(World world) {
            setTitle("Battle Simulation");
            setSize(1200, 1600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel = new GamePanel(world);
            add(panel);
            setVisible(true);
        }

        public void refresh() {
            panel.repaint();
        }
    }
