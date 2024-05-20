package Simolator;

import java.util.ArrayList;

public class Team {
    ArrayList<Soldier> team = new ArrayList<>();
    ArrayList<CoordinatesMap> targ = new ArrayList<>();
    int n=0;
    public void setTeam(Soldier a) {// додавння в лист солдата
        team.add(a);
        n++;
    }

    public Soldier get(int i) {// пошук солдата по списку
        return team.get(i);
    }
    public void targ(CoordinatesMap coordinates){
        targ.add(coordinates);
    }
    public void targ1(int ip) {
        if (!targ.isEmpty()) {
            CoordinatesMap lastElement = targ.remove(targ.size() - 1);
            //System.out.println("Останній елемент: " + lastElement);
            team.get(ip).getCoordinatesMap().angle(lastElement);
        }
    }
    public  ArrayList<Soldier> get(){

        return team;
    }
}
