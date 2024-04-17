import java.util.Arrays;

public class Map {
    private int map1[][];//матриця ip обєктів, для взаємоді об'єктів між собою
    private int map2[][];//матриця яка вказує глибину(висота) клітинки
    private int map3[][];//матриця відцотку двердоти грунту
    private int hitbox[][];// допоміжний масив для кординації в пространстві(для пулю)
    private String map[][];//основна матриця на якій знаходять об'єкти
    public Map(int x,int y){//створяння пустих матриця
        hitbox=new int[x][];
        map1=new int[x][];
        map2=new int[x][];
        map3=new int[x][];
        map=new String[x][];
        for (int r=0;r<x;r++){
            hitbox[r]=new int[y];
            map1[r]=new int[y];
            map2[r]=new int[y];
            map3[r]=new int[y];
            map[r]=new String[y];
        }
    }
    public Map(){
        System.out.println("Ніхуя");
    }
    private void  spawn(int x,int y,String object,int object_int) { // розміщує об'єк солдат на матриці
        map[x][y]=object;
        map1[x][y]=object_int;

    }
    public void getspan(int j,int t,String objectget,int object_int){
        spawn(j,t,objectget,object_int);
    }
    private void spamTree(int forest){ // генерація на матриці дерев
        for (int i =0;i<map.length;i++){
            for (int j=0;j<map[i].length;j++){
                int random=(int)(Math.random()*forest);
                if (random==1 && map[i][j]=="null"){
                    map[i][j]="Tree";
                }
            }
        }

    }
    private  void creatdirt(){
        int x = (int) (Math.random()*map3.length);
        int y =(int)(Math.random()*map3.length);
        map3[x][y]=80;
    }
    public void getcreatdirt(){
        creatdirt();
    }
    public void shopmap1(int h){
        System.out.println("вивід:");
        for (int r = 0; r < h; r++) {
            for (int r2 = 0; r2 < h; r2++) {
                System.out.print(map1[r2][r]);
            }
            System.out.println();
        }
    }
    public void shopmap2(int h){
        getcreatdirt();
        for (int r = 0; r < h; r++) {
            System.out.println(Arrays.toString(map2[r]));
        }
    }
    public void shopmap3(int h){
        getcreatdirt();
        for (int r = 0; r < h; r++) {
            System.out.println(Arrays.toString(map3[r]));
        }
    }
    public void getmapf(int h) { // показ матриці
        for (int r = 0; r < h; r++) {
            System.out.println(Arrays.toString(map[r]));
        }
    }
    public String setmap(int x,int y){
        return map[x][y];
    }
    public int setmap1(int x,int y){
        return map1[x][y];
    }
    public void setmap1(int x,int y,int i){
        map1[x][y]=i;
    }
    public int setmap2(int x,int y){
        return map2[x][y];
    }
    public int setmap3(int x,int y){
        return map3[x][y];
    }
    public int sethitnox(int x,int y){
        return hitbox[x][y];
    }
    public  void showHitBox(int x,int y){
        System.out.println(hitbox[x][y]);
    }
    public void showmap(int x,int y){
        System.out.println(map[x][y]);
    }
    public void showmap1(int x,int y){
        System.out.println(map1[x][y]);
    }
    public void showmap2(int x,int y){
        System.out.println(map2[x][y]);
    }
    public void showmap3(int x,int y){
        System.out.println(map3[x][y]);
    }
    public void getspamTree(int size){
        spamTree(size);
    }
    public int[][] getmap3() {
        return map3;
    }

    public void setmap3(int[][] map3) {
        this.map3 = map3;
    }

    public int[][] getmap2() {
        return map2;
    }

    public void setmap2(int[][] map2) {
        this.map2 = map2;
    }

    public int[][] getmap1() {
        return map1;
    }

    public void setmap1(int[][] map1) {
        this.map1 = map1;
    }
    public String[][] getmap() {
        return map;
    }

    public void setmap(int[][] map1) {
        this.map = map;
    }


}
