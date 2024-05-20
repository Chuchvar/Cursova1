package Simolator;

import java.util.Arrays;
public class Map {
    private int ipMAP[][];//матриця ip обєктів, для взаємоді об'єктів між собою
    private double dipMAP[][];//матриця яка вказує глибину(висота) клітинки
    private int dirtMAP[][];//матриця відцотку двердоти грунту
    private int hitbox[][];// допоміжний масив для кординації в пространстві(для пулю)
    private String minMap[][];//основна матриця на якій знаходять об'єкти
    private int hightMaP[][];//матриця шуму

    public Map(int x,int y){//створяння пустих матриця
        hitbox=new int[x][];
        ipMAP =new int[x][];
        dipMAP =new double[x][];
        dirtMAP =new int[x][];
        minMap =new String[x][];
        hightMaP =new int[x][];
        for (int r=0;r<x;r++){
            hitbox[r]=new int[y];
            ipMAP[r]=new int[y];
            dipMAP[r]=new double[y];
            dirtMAP[r]=new int[y];
            minMap[r]=new String[y];
            hightMaP[r]=new int[y];
        }
        for (int r=0;r<x;r++){
            for (int r2=0;r2<y;r2++){
                minMap[r][r2]="null";
            }
        }
        generatePerlinNoise(x,y);

        for (int r=0;r<x;r++) {//грнаниці карти по x
            hitbox[r][0]=100;
            ipMAP[r][0]=100;
            dipMAP[r][0]=100;
            dirtMAP[r][0]=100;
            minMap[r][0]="end";
            hitbox[r][y-1]=100;
            ipMAP[r][y-1]=100;
            dipMAP[r][y-1]=100;
            dirtMAP[r][y-1]=100;
            minMap[r][y-1]="end";
        }
        for (int r=0;r<y;r++) {//границі карти по y
            hitbox[0][r]=100;
            ipMAP[0][r]=100;
            dipMAP[0][r]=100;
            dirtMAP[0][r]=100;
            minMap[0][r]="end";
            hitbox[y-1][r]=100;
            ipMAP[y-1][r]=100;
            dipMAP[y-1][r]=100;
            dirtMAP[y-1][r]=100;
            minMap[y-1][r]="end";
        }
    }
    public Map(){//пуста карта
        System.out.println("*і*уя");
    }
    private void  spawn(int x,int y,String object,int object_int) { // розміщує об'єк солдат на карті
        minMap[x][y]=object;
        ipMAP[x][y]=object_int;

    }
    public void getspan(int x,int y,String objectget,int object_int){
        spawn(x,y,objectget,object_int);
    }
    private void spamTree(int forest){ // генерація на матриці дерев
        for (int i = 0; i< minMap.length; i++){
            for (int j = 0; j< minMap[i].length; j++){
                int random=(int)(Math.random()*forest);
                if (random==1 && minMap[i][j]=="null"){
                    minMap[i][j]="Tree";
                    ipMAP[i][j]=-1;

                }
            }
        }

    }
    private  void creatdirt(){// створення земляної матриці
        int x = (int) (Math.random()* dirtMAP.length);
        int y =(int)(Math.random()* dirtMAP.length);
        dirtMAP[x][y]=80;
    }
    public void getcreatdirt(){
        creatdirt();
    }
    public void shopmap1(int h){
        System.out.println("вивід:");
        for (int r = 0; r < h; r++) {
            for (int r2 = 0; r2 < h; r2++) {
                System.out.print(ipMAP[r2][r]);
            }
            System.out.println();
        }
    }
    public void dirmap(int h){
        System.out.println("вивід:");
        for (int r = 0; r < h; r++) {
            for (int r2 = 0; r2 < h; r2++) {
                System.out.print(dipMAP[r2][r]);
            }
            System.out.println();
        }
    }
    public void shopmap2(int h){
        getcreatdirt();
        for (int r = 0; r < h; r++) {
            System.out.println(Arrays.toString(dipMAP[r]));
        }
    }
    public void shopmap3(int h){
        getcreatdirt();
        for (int r = 0; r < h; r++) {
            System.out.println(Arrays.toString(dirtMAP[r]));
        }
    }
    public void getmapf(int h) { // показ матриці
        for (int r = 0; r < h; r++) {
            System.out.println(Arrays.toString(minMap[r]));
        }
    }
    public void setmap1(int x,int y,int i,String a){//перезапис місце знаходження солдата
        ipMAP[x][y]=i;
        minMap[x][y]=a;
    }
    public void setmap1(int x,int y,int i){// перезапис по ip
        ipMAP[x][y]=i;
    }
    public void setmap0(int x,int y){//видалення содата з карти
        ipMAP[x][y]=0;
        minMap[x][y]="null";
    }
    public void generatePerlinNoise(int width, int height) {
        FastNoiseLite perlin = new FastNoiseLite();
        perlin.SetSeed(1234);
        perlin.SetFrequency(0.1f);
        perlin.SetNoiseType(FastNoiseLite.NoiseType.Perlin);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double noiseValue = perlin.GetNoise(x, y);
                dipMAP[x][y] = (noiseValue * 10); // Використовуйте шум для заповнення вашої матриці
            }
        }
    }
    public String setmap(int x,int y){
        return minMap[x][y];
    }
    public int setmap1(int x,int y){
        return ipMAP[x][y];
    }
    public double setmap2(CoordinatesMap a){
        return dipMAP[a.getCoordinatesXint()][a.getCoordinatesYint()];
    }
    public int setmap3(int x,int y){
        return dirtMAP[x][y];
    }
    public int sethitnox(int x,int y){
        return hitbox[x][y];
    }
    public  void showHitBox(int x,int y){
        System.out.println(hitbox[x][y]);
    }
    public void showmap(int x,int y){
        System.out.println(minMap[x][y]);
    }
    public void showmap1(int x,int y){
        System.out.println(ipMAP[x][y]);
    }
    public void showmap2(int x,int y){
        System.out.println(dipMAP[x][y]);
    }
    public void showmap3(int x,int y){
        System.out.println(dirtMAP[x][y]);
    }
    public void getspamTree(int size){
        spamTree(size);
    }
    public int[][] getmap3() {
        return dirtMAP;
    }

    public void setmap3(int[][] map3) {
        this.dirtMAP = map3;
    }

    public double[][] getmap2() {
        return dipMAP;
    }

    public void setmap2(double [][] map2) {
        this.dipMAP = map2;
    }

    public int[][] getmap1() {
        return ipMAP;
    }

    public void setmap1(int[][] map1) {
        this.ipMAP = map1;
    }
    public String[][] getmap() {
        return minMap;
    }

    public void setmap(int[][] map1) {
        this.minMap = minMap;
    }
}
