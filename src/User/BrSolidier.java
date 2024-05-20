package User;

import Simolator.Soldier;

public class BrSolidier extends Soldier {
    public BrSolidier(int x, int y, int ip) {
        //Firearm a;
        super(x,y,ip,new AK47());
    }
}
