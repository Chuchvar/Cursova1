package Simolator;

public class Pistol extends Firearm{

    public Pistol() {
        super(450, 0.12,10);
    }
    public double shot(double zr,double z,double vz, double vxy){
        double h = getM();
        vxy -= h;
        vz -= 2 / vxy + h * vz / vxy;
        z += vz / (vxy * 5);
        return z;
    }


}
