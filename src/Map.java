import java.util.Arrays;

public class Map {

    private int map1[][];//матриця ip обєктів, для взаємоді об'єктів між собою
    private int map2[][];//матриця яка вказує глибину(висота) клітинки
    private int map3[][];//матриця відцотку двердоти грунту
    private String map[][];//основна матриця на якій знаходять об'єкти
    public Map(int x,int y){//створяння пустих матриця
        map1=new int[x][];
        map2=new int[x][];
        map3=new int[x][];
        map=new String[x][];
        for (int r=0;r<x;r++){
            map1[r]=new int[y];
            map2[r]=new int[y];
            map3[r]=new int[y];
            map[r]=new String[y];
            System.out.println(Arrays.toString(map[r]));
        }
    }
    public Map(){
        System.out.println("Ніхуя");
    }
    private void  spawn(int x,int y,String object,int object_int) { // розміщує об'єк солдат на матриці
        map[x-1][y-1]=object;
        map1[x-1][y-1]=object_int;

    }
    public void getspan(int j,int t,String objectget,int object_int){
        spawn(j,t,objectget,object_int);
    }
    private void spamTree(int forest){
        for (int i =0;i<map.length;i++){
            for (int j=0;i<map[i].length;j++){
                int random=(int)(Math.random()*forest);
                if (random==1){
                    map[i][j]="Tree";
                }
            }
        }

    }
    public void getmapf(int h) {
        for (int r = 0; r < h; r++) {
            System.out.println(Arrays.toString(map[r]));
        }
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
