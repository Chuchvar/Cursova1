package Simolator;

public abstract class Firearm {
    private double v;
    private double m;

    private final double ammunitionMax;
    private double ammunition;

    public Firearm(double v, double m,int ammunition) {
        this.v = v;
        this.m = m;
        this.ammunitionMax=ammunition;
        this.ammunition=ammunition;
    }
    public double shot(double zr,double z,double vz,double vxy){
        double h = m;
        vxy -= h;
        vz -= 2 / vxy + h * vz / vxy;
        z += vz / (vxy * 5);
        return z;
    }
    public void recharge(){
        ammunition=ammunitionMax;
    }
    public void shotammunition(){
        ammunition--;
    }
    public boolean ammunition() {
        return ammunition > 0;
    }
    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }


}