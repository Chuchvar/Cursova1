import java.util.Arrays;

public class Map {
    private int ger[][];
    private int ger2[][];
    private int get3[][];
    private String map[][];
    public Map(int x,int y){
        map=new String[x][];
        for (int r=0;r<x;r++){
            map[r]=new String[y];
            System.out.println(Arrays.toString(map[r]));
        }
    }
    public Map(){
        System.out.println("Ніхуя");
    }
    private void  spawn(int x,int y,String object) {
        map[x-1][y-1]=object;
        System.out.println(Arrays.deepToString(map));
    }
    public void getspan(int j,int t,String objectget){
        spawn(j,t,objectget);
    }
    public int[][] getGer() {
        return ger;
    }

    public void setGer(int[][] ger) {
        this.ger = ger;
    }

    public int[][] getGer2() {
        return ger2;
    }

    public void setGer2(int[][] ger2) {
        this.ger2 = ger2;
    }

    public int[][] getGet3() {
        return get3;
    }

    public void setGet3(int[][] get3) {
        this.get3 = get3;
    }
}
