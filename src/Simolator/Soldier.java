package Simolator;

public class Soldier {
    private Xp live;
    private CoordinatesMap coordinatesMap;
    private double view;//кут погляду
    private double radius =0.2;// розмір персонажа по x
    private double target =0; // опознання ворога
    private double height =1.7;//висота солдата
    private int ip; // особистий номер на карті
    private boolean goal =false; //захоплення цілі
    private Firearm pistol; //зброя
    private boolean end =false;

    public Soldier(int x, int corditSoldOnMapY, int ip) {//  конструкто солдата з базовою зброєю
        view =0;
        this.ip=ip;
        live=new Xp();
        coordinatesMap =new CoordinatesMap(x,corditSoldOnMapY);
        pistol=new Pistol();
    }
    public Soldier(int x, int corditSoldOnMapY, int ip, Firearm a) {// солодат з певним видом зброї
        coordinatesMap =new CoordinatesMap(x,corditSoldOnMapY);
        view =0;
        this.ip=ip;
        live=new Xp();
        pistol=a;
    }
    public boolean ammunition() {
        return pistol.ammunition();
    }
    public void recharge(){
        pistol.recharge();
    }
    public void setr() {//перевести погляд в низ
        view =Math.PI/2;
    }
    public void sets() {//повернитися на право
        view =0;
    }
    public void sets(Double pi) {
        view =pi;
    }
    void death() {// дачик попанадання
        live.death();
    }
    void step(double rad){//крок з певним напрямком
        coordinatesMap.step(rad);
    }
    void stepStraight(){//крок в перед
        coordinatesMap.stepStraight(view,live,10);
    }
    void stepStraightReturn(int xt,int yt) {//видштохування від інших об'єків через обмеження симуляції
        coordinatesMap.stepStraightReturn(xt,yt,view,live);
    }
    void stepStraightReturn() {//видштохування від інших об'єків
        coordinatesMap.stepStraight(view,live,-18);

    }

    public double getCorditSoldOnMapX() {//упрощкний хідбокс по Х (підчас руху прямо)
        return coordinatesMap.getCorditSoldOnMapX(view,radius);
    }

    public double getCorditSoldOnMapY() {//упрощкний хідбокс по Y (підчас руху прямо)
        return coordinatesMap.getCorditSoldOnMapY(view,radius);
    }
    public double getX(double r) {//упрощкний хідбокс по Х (підчас руху в напрямку r)
        return coordinatesMap.getCorditSoldOnMapX(r,radius);
    }

    public double getY(double r) {//упрощкний хідбокс по Y (підчас руху в напрямку r)
        return coordinatesMap.getCorditSoldOnMapY(r,radius);
    }
    public void changeTARGET(){//фіксація цілі, міння цілі
        goal =!goal;
    }
    public void end(){//фіксація цілі, міння цілі
        end =!end;
    }
    public boolean getLiveArms() {//боєздатність
        if (live.getLegs()==0){
            return false;
        }
        return true;
    }

    public double getx() {
        return coordinatesMap.getCoordinatesX();
    }

    public double gety() {
        return coordinatesMap.getCoordinatesY();
    }
    public void setXY(double x,double y){
        coordinatesMap.setXY(x,y);
    }
    public double getHeight() {
        return height;
    }
    public double getView() {
        return view;
    }

    public void setView(double view) {
        this.view = view;
    }

    public void setTarget(double target) {
        this.target = target;
    }
    public double getTarget() {
        return target;
    }
    public boolean getlive() {
        return live.isLive();
    }
    public boolean isGoal() {
        return goal;
    }

    public Firearm getPistol() {
        return pistol;
    }
    public double getPistolM() {
        return pistol.getM();
    }
    public double getPistolV() {
        return pistol.getV();
    }
    public int getIp() {
        return ip;
    }

    public CoordinatesMap getCoordinatesMap() {
        return coordinatesMap;
    }

    public boolean isEnd() {
        return end;
    }
}
