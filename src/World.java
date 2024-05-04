import java.util.ArrayList;
public class World {
    Map terra;
    int time;
    ArrayList team1 = new ArrayList<Soldier>();//команда 1
    ArrayList team2 = new ArrayList<Soldier>();//команда// 2
    int x;
    int y;
    int n;


    public World(int n,int x,int y) { // конструктор, який генериє світ  в залежності від даної інформації
        this.terra = new Map(x,y);

        for (int i=0;i<n/2;i++) {
            Soldier a = new Soldier(2+i,5);
            terra.getspan(2+i,5,"Solider",1+i);
            team1.add(a);
            Soldier a2 = new Soldier(n,n+i);
            terra.getspan(n+2,n+i,"Solider",1+i);
            team2.add(a2);
        }
        terra.getspamTree(33);
        //terra.shopmap1(x);
        this.time = 0;
        this.x=x;
        this.y=y;
    }
    public void moment() {
        for (int i=0;i<3;i++) {
            for (int ii = 0; ii < 50; ii++) {
                movementV2(i);
            }
        }
        terra.shopmap1(x);
    }
    public void movement(int ip){
        Soldier a = (Soldier) team1.get(ip);
        double yt=a.getY();
        double xt=a.getX();
        if(terra.setmap1((int)xt,(int)yt)==0) {
            terra.setmap1((int)a.getx(),(int)a.gety(),0);
            a.stepStraight();
            terra.setmap1((int)a.getx(),(int)a.gety(),ip+1);
            //System.out.println("xt="+xt);
        } else if (terra.setmap1((int) xt, (int) yt) == ip+1) {
            a.stepStraight();
            //System.out.println("xtts="+xt);
        }

    }
    public void movementV2(int ip){
        Soldier a = (Soldier) team1.get(ip);
        int yt=(int)a.gety();
        int xt=(int)a.getx();
        terra.setmap1((int)a.getx(),(int)a.gety(),0);
        a.stepStraight();

        //movementV3(a.getx(),a.gety());
        if(terra.setmap1((int)a.getx(),(int)a.gety())!=0) {
            a.stepStraightReturn(xt,yt);
            //System.out.println("xt="+xt);
        }
        terra.setmap1((int)a.getx(),(int)a.gety(),ip+1);
    }
    public void movementV2(double x,double y,double x2,double y2) {
        int x1 = (int) (x + x2);
        int y1 = (int) (y + y2);
        String a1 = terra.setmap(x1, y1);
        if (a1 != "null") {
            if (a1 != "Tree") {

            } else if (a1 != "Solider") {

            }
        }
    }
    public void movementV3(double x,double y){
        movementV2(x,y,-0.5,-0.5);
        movementV2(x,y,0.5,-0.5);
        movementV2(x,y,-0.5,0.5);
        movementV2(x,y,0.5,0.5);
    }
}