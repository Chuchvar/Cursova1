public class Map {
    private int ger[][];
    private int ger2[][];
    private int get3[][];

    public Map(int x,int y){
<<<<<<< HEAD
=======
        int map[][]=new int[x][];
        for (int r=0;r<x;r++){
            map[r]=new int[y];
        }
        System.out.println(map);
>>>>>>> fd0157b0843d2cf555513cdfd737ad2dc7254679
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
