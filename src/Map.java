import java.util.Arrays;

public class Map {
    private int map1[][];
    private int map2[][];
    private int map3[][];
    private String map[][];
    public Map(int x,int y){
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
    private void  spawn(int x,int y,String object,int object_int) {
        map[x-1][y-1]=object;
        map1[x-1][y-1]=object_int;

    }
    public void getspan(int j,int t,String objectget,int object_int){
        spawn(j,t,objectget,object_int);
    }
    public int[][] getmap3() {
        return map3;
    }

    public void setmap3(int[][] map2) {
        this.map3 = map2;
    }

    public int[][] getmap2() {
        return map2;
    }

    public void setGer2(int[][] map2) {
        this.map2 = map2;
    }

    public int[][] getmap1() {
        return map1;
    }

    public void setGet3(int[][] map1) {
        this.map1 = map1;
    }
    public void setGetf(int h) {
        for (int r = 0; r < h; r++) {
            System.out.println(Arrays.toString(map[r]));
        }
    }

}
