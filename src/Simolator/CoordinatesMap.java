package Simolator;

public class CoordinatesMap {//клас координат
    double coordinatesX;
    double coordinatesY;

    public CoordinatesMap(double coordinatesX, double coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
    }
    void step(double rad){//крок з певним напрямком
        coordinatesY +=(Math.sin(rad))/10;
        coordinatesX +=(Math.cos(rad))/10;
    }
    void step(double rad,int k){//крок з певним напрямком і певної довжини
        coordinatesY +=(Math.sin(rad))/k;
        coordinatesX +=(Math.cos(rad))/k;
    }
    void stepStraight(double view,Xp live,int k){//крок в перед з певним напрямком і певної довжини
        coordinatesY +=(Math.sin(view)/k)*live.getArms();
        coordinatesX +=(Math.cos(view)/k)*live.getArms();
    }
    void stepStraightReturn(int xt,int yt,double view,Xp live) {//видштохування від інших об'єків через обмеження симуляції
        if (xt != (int) coordinatesX) {
            coordinatesX -=live.getArms()* Math.cos(view) / 6;
        }
        if (yt != (int) coordinatesY) {
            coordinatesY -=live.getArms()* Math.sin(view) / 6;
        }
    }


    public void setXY(double x,double y){
        this.coordinatesX = x;
        this.coordinatesY = y;
    }
    public double getCorditSoldOnMapY(double view,double radius) {//упрощкний хідбокс по Y (підчас руху прямо)
        if (Math.sin(view) >= 0) {
            return coordinatesY + (Math.sin(view) / 5)+ radius;
        } else {
            return coordinatesY + (Math.sin(view) / 5)- radius;
        }
    }
    public double getCorditSoldOnMapX(double view,double radius) {//упрощкний хідбокс по Y (підчас руху прямо)
        if (Math.cos(view) >= 0) {
            return coordinatesX + (Math.sin(view) / 5)+ radius;
        } else {
            return coordinatesX + (Math.sin(view) / 5)- radius;
        }
    }
    public CoordinatesMap getCoordinates(){//вертає копію класу
        return new CoordinatesMap(coordinatesX,coordinatesY);
    }
    public double distance(double x,double y) {//виаховує відстань до точки
        return Math.sqrt(Math.pow(coordinatesX - x, 2) + Math.pow(coordinatesY - y, 2));
    }
    public double distance(CoordinatesMap c) {//виаховує відстань до точки
        return Math.sqrt(Math.pow(coordinatesX - c.getCoordinatesX(), 2) + Math.pow(coordinatesY - c.getCoordinatesY(), 2));
    }
    public double angle(double x,double y) {//виаховує кут до точки
        double a=Math.abs(x-coordinatesX)/distance(x, y);
        return Math.acos(a);
    }
    public double angle(CoordinatesMap s) {//виаховує кут до точки
        double x=s.getCoordinatesX();
        double a=Math.abs(x-coordinatesX)/distance(x, s.getCoordinatesY());
        return Math.acos(a);
    }
    public double getCoordinatesX() {
        return coordinatesX;
    }

    public double getCoordinatesY() {
        return coordinatesY;
    }
    public int getCoordinatesXint() {
        return (int)coordinatesX;
    }

    public int getCoordinatesYint() {
        return (int)coordinatesY;
    }
}
