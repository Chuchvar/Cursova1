public class Soldier {
    private int x;
    private int y;
    private Xp live;

    public Soldier(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void step(int rad){
        y+=Math.cos(rad/2);
        x+=Math.sin(rad);
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
