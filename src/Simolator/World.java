package Simolator;

public class World {
    Map terra;
    int time;//час
    Team team1 = new Team();//команда 1
    Team team2 = new Team();//комда 2
    int sizeMaponX;//розмір карти по х
    int sizaMaponY;//розмір карти по y
    int kickSold;//кількість солдат
    public World(int kickSold, int sizeMaponX, int sizaMaponY) { // конструктор, який генериє світ  в залежності від даної інформації
        this.terra = new Map(sizeMaponX, sizaMaponY);
        this.kickSold = kickSold;
        for (int i = 0; i < kickSold; ) {
            i++;
            terra.getspan(sizeMaponX -5, i+2, "Solider", i);
            Soldier a = new Soldier(sizeMaponX -5, 2+i, i);
            a.sets(Math.PI);
            team1.setTeam(a);
            i++;
            terra.getspan(  2, i+2 , "Solider", i);
            Soldier a2 = new Soldier(2, i +2, i);
            team2.setTeam(a2);
        }
        terra.getspamTree(100);
        //terra.shopmap1(x);
        this.time = 0;
        this.sizeMaponX = sizeMaponX;
        this.sizaMaponY = sizaMaponY;
        //terra.dirmap(sizeMaponX);
    }

    public void moment(int i) {//крок прямо (3 метра)
        Soldier a;
        if(i%2==1) {
            a = team1.get((i-1)/2);
        }else{
            a = team2.get(i/2-1);
        }
        for (int ii = 0; ii < 30; ii++) {
            movementV2(i);
            if (ii%10==0) {
                a.sets();
            }
        }
    }

    public void movement(int ip) {
        Soldier a = team1.get(ip);
        double yt = a.getCorditSoldOnMapY();
        double xt = a.getCorditSoldOnMapX();
        if (terra.setmap1((int) xt, (int) yt) == 0) {
            terra.setmap1((int) a.getx(), (int) a.gety(), 0);
            a.stepStraight();
            terra.setmap1((int) a.getx(), (int) a.gety(), ip * 2 + 1);
            //System.out.println("xt="+xt);
        } else if (terra.setmap1((int) xt, (int) yt) == ip * 2 + 1) {
            a.stepStraight();
            //System.out.println("xtts="+xt);
        }

    }//просто версія опрацювання хітбоксів

    public void movementV2(int ip) {
        Soldier a;
        if(ip%2==1) {
            a = team1.get((ip-1)/2);
        }else{
            a = team2.get(ip/2-1);
        }
        int yt = (int) a.gety();
        int xt = (int) a.getx();
        terra.setmap1((int) a.getx(), (int) a.gety(), 0,"null");

        a.stepStraight();
        if (terra.setmap((int) a.getx(), (int) a.gety()) != "null") {
            if(terra.setmap((int) a.getx(), (int) a.gety()) == "end"){
                a.end();
            }
            a.stepStraightReturn(xt, yt);
            a.setr();
            //System.out.println((int)a.getx());
        }
        while (movementV3(a.getCoordinatesMap())) {
            a.stepStraightReturn();
            //System.out.println(ip);
        }
        terra.setmap1((int) a.getx(), (int) a.gety(), ip,"Solider");
    }//складна версія опрацювання хітбоксів

    public boolean collision(CoordinatesMap c, double x2, double y2) {//перевірка зіткнення
        int x1 = (int) (c.getCoordinatesX() + x2);
        int y1 = (int) (c.getCoordinatesX() + y2);
        String a1 = terra.setmap(x1, y1);
        if (!a1.equals("null")) {
            if (a1.equals("Tree")) {
                double d = c.distance(x1,y1);
                if (d <= 0.3) {
                    return true;
                }
            } else if (a1 == "Solider") {
                int a2 = terra.setmap1(x1, y1);
                if (a2!=0){
                    Soldier a;
                    if (terra.setmap1(x1, y1) % 2 == 1) {
                        a = team1.get((a2 - 1) / 2);
                    } else {
                        a = team2.get(a2 / 2 - 1);
                    }
                    double d =c.distance(a.getCoordinatesMap());;
                    if (d <= 0.4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void shot(CoordinatesMap t, double z, double xr, double zr,Firearm frarm) {//постріл
        double x = t.getCoordinatesX() + (Math.cos(xr));
        double y = t.getCoordinatesY() + (Math.sin(xr));
        CoordinatesMap f=t.getCoordinates();
        double vz = frarm.getV() * (Math.sin(zr));
        double vxy = frarm.getV() * (Math.cos(zr));
        frarm.shotammunition();
        while (z >= terra.setmap2(f)) {
            f.step(xr,5);
            z=frarm.shot(zr,z,vz,vxy);
            if (movementV3shot(f)) {
                //System.out.println("break");
                break;
            }
        }
//        if(z <= terra.setmap2((int) x, (int) y)){
//            System.out.println("промах");
//        }
    }

    public boolean collisionview(CoordinatesMap c, double x2, double y2) {//перевірка чи засікли когось
        int x1 = (int) (c.getCoordinatesX() + x2);
        int y1 = (int) (c.getCoordinatesY() + y2);
        String a1 = terra.setmap(x1, y1);
        if (a1 != "null") {
            if (a1 == "Tree") {

            } else if (a1 == "Solider") {
                Soldier a;
                int a2 = terra.setmap1(x1, y1);
                if (terra.setmap1(x1, y1) % 2 == 1) {
                    a = team1.get((a2 - 1) / 2);
                } else {
                    a = team2.get(a2 / 2 - 1);
                }
                double d = c.distance(a.getCoordinatesMap());
                if (d < 0.21) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean collisionshot(CoordinatesMap c, double x2, double y2) {//перевіка влучаня пулі
        int x1 = (int) (c.getCoordinatesX() + x2);
        int y1 = (int) (c.getCoordinatesY() + y2);
        String a1 = terra.setmap(x1, y1);
        if (a1 != "null") {
            if (a1 == "Tree") {

            } else if (a1 == "Solider") {
                Soldier a;
                int a2 = terra.setmap1(x1, y1);
                if (terra.setmap1(x1, y1) % 2 == 1) {
                    a = team1.get((a2 - 1) / 2);
                } else {
                    a = team2.get(a2 / 2 - 1);
                }
                double d = c.distance(a.getCoordinatesMap());;
                if (d < 0.21) {
                    a.death();
                    if(!a.getlive()) {
                        terra.setmap0(x1, y1);
                    }
                    return true;
                }
            }
        }
        return false;
    }//перевірка попадання

    public boolean movementV3(CoordinatesMap c) {//перевірка хідбоксу під час руху
        boolean a1 = collision(c, -0.5, -0.5);
        boolean a2 = collision(c, 0.5, -0.5);
        boolean a3 = collision(c, -0.5, 0.5);
        boolean a4 = collision(c, 0.5, 0.5);
        return a1 | a2 | a3 | a4;
    }

    public boolean movementV3shot(CoordinatesMap c) {
        boolean a1 = collisionshot(c, -0.5, -0.5);
        boolean a2 = collisionshot(c, 0.5, -0.5);
        boolean a3 = collisionshot(c, -0.5, 0.5);
        boolean a4 = collisionshot(c, 0.5, 0.5);
        return a1 | a2 | a3 | a4;
    }//перевірка попадання

    public boolean movementV3View(CoordinatesMap c) {
        boolean a1 = collisionview(c, -0.5, -0.5);
        boolean a2 = collisionview(c, 0.5, -0.5);
        boolean a3 = collisionview(c, -0.5, 0.5);
        boolean a4 = collisionview(c, 0.5, 0.5);
        return a1 | a2 | a3 | a4;
    }//перевірка погляду

    public boolean view(Soldier a) {//зір
        double y=a.gety();
        double r = a.getView()-1;
        double x=a.getx();
        double z = terra.setmap2(a.getCoordinatesMap()) + a.getHeight();
        double zt;
        for (int i = 0; i < 400; i++) {
            zt = -100;
            r += 0.012;
            y = a.gety()+Math.sin(r)/2;
            x = a.getx()+Math.cos(r)/2;

            for (int t = 0; t < 450; t++) {
                if (zt * t / 20 + z < terra.setmap2(a.getCoordinatesMap())) {
                    zt = (terra.setmap2(a.getCoordinatesMap()) - z) * 20 / t;
                }
                x += Math.cos(r) / 5;
                y += Math.sin(r) / 5;
                String a1 = terra.setmap((int) x, (int) y);
                if (a1 != "null") {

                    if (a1 == "end") {
                        t = 2000;
                    } else if (a1 == "Solider") {
                        if (movementV3View(a.getCoordinatesMap())) {
                            if (terra.setmap1((int) x, (int) y) % 2 != a.getIp() % 2) {
                                a.setTarget(r + Math.random() / 0.01-0.005);
                                a.changeTARGET();
                                if(a.getIp()%2==0){
                                    team2.targ(new CoordinatesMap(x,y));
                                }
                                if(a.getIp()%2==1){
                                    team1.targ(new CoordinatesMap(x,y));
                                }


                                //System.out.println(r + " солдат № " + a.getIp()+ " побачив солдата № " + terra.setmap1((int) x, (int) y));
                                t = 1000;
                                i += 1000;
                            }

                        }
                    }else {
                        t = 1000;
                    }
                }

            }
        }
        //terra.setmap1((int) a.getx(), (int) a.gety(), k);
        return true;
    }//метод для зору
}