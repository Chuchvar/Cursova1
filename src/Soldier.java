public class Soldier {
    private double x;//координати по х
    private double y;//координати по y
    private Xp live;
    private double r;//кут погляду
    private double xx=0.2;
    private double yy=0.2;
    public Soldier(int x, int y) {
        this.x = x;
        this.y = y;
        r=0;
    }

    void step(double rad){//крок

        y+=(Math.sin(rad))/10;
        x+=(Math.cos(rad))/10;
    }
    void stepStraight(){//крок
        y+=Math.sin(r)/5;
        x+=Math.cos(r)/5;
    }
    public double getX() {
        if (Math.sin(r) >= 0) {
            return x + Math.cos(r) / 5+xx;
        } else {
            return x + Math.cos(r) / 5-xx;
        }
    }

    public double getY() {
        if (Math.sin(r) >= 0) {
            return y + (Math.sin(r) / 5)+yy;
        } else {
            return y + (Math.sin(r) / 5)-yy;
        }
    }
    public double getX(double r) {
        if (Math.sin(r) >= 0) {
            return x + Math.cos(r) / 10+xx;
        } else {
            return x + Math.cos(r) / 10-xx;
        }
    }

    public double getY(double r) {
        if (Math.sin(r) >= 0) {
            return y + Math.sin(r) / 10+yy;
        } else {
            return y + Math.sin(r) / 10-yy;
        }
    }

    public double getx() {
        return x;
    }

    public double gety() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }
}
