public class Soldier {
    private int x;//координати по х
    private int y;//координати по y
    private Xp live;
    private int r;//кут погляду

    public Soldier(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void step(int rad){//крок

        y+=Math.cos(rad/2);
        x+=Math.sin(rad);
    }
    void stepStraight(){//крок
        y+=2*Math.cos(r/2);
        x+=2*Math.sin(r);
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
