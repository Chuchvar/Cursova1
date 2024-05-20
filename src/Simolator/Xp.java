package Simolator;

public class Xp {
    private boolean live;// життя солдата
    private double rana;// поранення солдата
    private double krow;//об'єм крові
    private int legs;//ноги
    private int arms;//руки

    public Xp() {
        this.rana = 0;
        this.krow = 1;
        this.legs = 2;
        this.arms = 2;
        live=true;
    }

    public void death(){//перевірка смерті
        kine4();
        rana++;
        krow-=0.2;
        if ((Math.random()*rana>1)||(krow<=0)){
            live=false;
        }
    }
    public void kine4(){//перевірка попадані по кінечності
        int random=(int)(Math.random()*3);
        if (random==0){
            arms--;
        } else if (random==1){
            legs--;
        } else if (random == 2) {
            live=false;
        }
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getArms() {
        return arms;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }

    public double getKrow() {
        return krow;
    }

    public void setKrow(double krow) {
        this.krow = krow;
    }

    public boolean isLive() {
        return live;
    }


    public void setLive(boolean live) {
        this.live = live;
    }

    public double getRana() {
        return rana;
    }

    public void setRana(double rana) {
        this.rana = rana;
    }
}
