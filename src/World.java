import java.util.ArrayList;
public class World {
    Map terra;
    int time;
    ArrayList team1 = new ArrayList<>();//команда 1
    ArrayList team2 = new ArrayList<>();//команда// 2
    int x;
    int y;
    int n;


    public World(int n,int x,int y) { // конструктор, який генериє світ  в залежності від даної інформації
        this.terra = new Map(x,y);

        for (int i=0;i<n/2;i++) {
            Soldier a = new Soldier(2+i,5);
            terra.getspan(2+i,5,"Solider",1+i);
            team1.add(a);
            Soldier a2 = new Soldier(n,n-i);
            terra.getspan(n+2,n+i,"Solider",1+i);
            team2.add(a2);
        }
        terra.getspamTree(33);
        terra.shopmap1(x);
        this.time = 0;
        this.x=x;
        this.y=y;
    }
    public void moment() {
        for (int i=0;i<40;i++) {
                movement(2);
        }
        terra.shopmap1(x);
    }
    public void movement(int ip){
        Soldier a=((Soldier) team1.get(ip));
        double yt=a.getY();
        double xt=a.getX();
        if(terra.setmap1((int)xt,(int)yt)==0) {
            terra.setmap1((int)a.getx(),(int)a.gety(),0);
            a.stepStraight();
            terra.setmap1((int)a.getx(),(int)a.gety(),ip+1);
            team1.set(ip,a);
            System.out.println("xt="+xt);
        } else if (terra.setmap1((int) xt, (int) yt) == ip+1) {
            a.stepStraight();
            System.out.println("xtts="+xt);
            team1.set(ip,a);
        }else{

        }

    }
}