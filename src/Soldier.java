public class Soldier {
    private double x;//координати по х
    private double y;//координати по y
    private Xp live;
    private double r;//кут погляду
    public Soldier(int x, int y) {
        this.x = x;
        this.y = y;
        r=0;
    }

    void step(double rad){//крок

        y+=(Math.cos(rad/2))/10;
        x+=(Math.sin(rad))/10;
    }
    void stepStraight(){//крок
        y+=Math.cos(r/2)/5;
        x+=Math.sin(r)/5;
    }
    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }
}
