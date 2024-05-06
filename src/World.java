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

        for (int i=0;i<n;) {
            Soldier a = new Soldier(2+i,5);
            terra.getspan(2+i,5,"Solider",++i);
            team1.add(a);
            Soldier a2 = new Soldier(n,n+i);
            terra.getspan(n+2,n+i,"Solider",++i);
            team2.add(a2);
        }
        terra.getspamTree(33);
        //terra.shopmap1(x);
        this.time = 0;
        this.x=x;
        this.y=y;
    }
    public void moment() {
        long t = System.currentTimeMillis();
        for (int i=499;i>0;i--) {
            for (int ii = 0; ii < 20000; ii++) {
                movementV2(i);
            }
        }
        System.out.println(System.currentTimeMillis()-t);
        for (int i=499;i>0;i--) {
            ((Soldier) team1.get(i)).setR(1);
        }

        long t2 = System.currentTimeMillis();
        for (int i=499;i>0;i--) {
            for (int ii = 0; ii < 20000; ii++) {
                movementV2(i);
            }
        }

        System.out.println(System.currentTimeMillis()-t2);
        //terra.shopmap1(x);
    }
    public void movement(int ip){
        Soldier a = (Soldier) team1.get(ip);
        double yt=a.getY();
        double xt=a.getX();
        if(terra.setmap1((int)xt,(int)yt)==0) {
            terra.setmap1((int)a.getx(),(int)a.gety(),0);
            a.stepStraight();
            terra.setmap1((int)a.getx(),(int)a.gety(),ip*2+1);
            //System.out.println("xt="+xt);
        } else if (terra.setmap1((int) xt, (int) yt) == ip*2+1) {
            a.stepStraight();
            //System.out.println("xtts="+xt);
        }

    }//просто версія опрацювання хітбоксів
    public void movementV2(int ip){
        Soldier a = (Soldier) team1.get(ip);
        int yt=(int)a.gety();
        int xt=(int)a.getx();
        terra.setmap1((int)a.getx(),(int)a.gety(),0);
        a.stepStraight();
        if(terra.setmap1((int)a.getx(),(int)a.gety())!=0) {
            a.stepStraightReturn(xt,yt);
            //System.out.println((int)a.getx());
        }
        while(movementV3(a.getx(),a.gety())){
            a.stepStraightReturn();
            //System.out.println(ip);
        }
        terra.setmap1((int)a.getx(),(int)a.gety(),ip*2+1);
    }//склаждна версія опрацювання хітбоксів
    public boolean collision(double x, double y, double x2, double y2) {
        int x1 = (int) (x + x2);
        int y1 = (int) (y + y2);
        String a1 = terra.setmap(x1, y1);
        if (a1 != "null") {
            if (a1 != "Tree") {

            } else if (a1 == "Solider") {
                int a2=terra.setmap1(x1, y1);
                Soldier a = (Soldier) team1.get(a2);
                double xx=a.getx();
                double yy=a.gety();
                double d=Math.sqrt(Math.pow(xx-x,2)+Math.pow(yy-y,2));
                if(d<0.4){
                    return true;
                }
            }
        }
        return false;
    }//
    public void shot(double xx,double yy,double z) {
        double x = xx;
        double y = yy;
        double zz=z;
        double a=-0.1;
        double ss=1.1;
        int i=0;
        while (zz> terra.setmap2((int)xx, (int)yy)){
            movementV3shot(xx, yy);
            ss*=1.007;
            a+=0.000002*ss;
            zz-=a;
            System.out.println(zz+" "+i);
            i++;;
        }
    }
    public boolean collisionshot(double x,double y,double x2,double y2) {
        int x1 = (int) (x + x2);
        int y1 = (int) (y + y2);
        String a1 = terra.setmap(x1, y1);
        if (a1 != "null") {
            if (a1 != "Tree") {

            } else if (a1 == "Solider") {
                int a2=terra.setmap1(x1, y1);
                Soldier a = (Soldier) team1.get(a2);
                double xx=a.getx();
                double yy=a.gety();
                double d=Math.sqrt(Math.pow(xx-x,2)+Math.pow(yy-y,2));
                if(d<0.4){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean movementV3(double x,double y){
        boolean a1= collision(x,y,-0.5,-0.5);
        boolean a2= collision(x,y,0.5,-0.5);
        boolean a3= collision(x,y,-0.5,0.5);
        boolean a4= collision(x,y,0.5,0.5);
        return a1|a2|a3|a4;
    }
    public void movementV3shot(double x,double y){
        collisionshot(x,y,-0.5,-0.5);
        collisionshot(x,y,0.5,-0.5);
        collisionshot(x,y,-0.5,0.5);
        collisionshot(x,y,0.5,0.5);
    }

}