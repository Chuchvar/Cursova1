public class Map {
    private int ger[][];
    private int ger2[][];
    private int get3[][];

    public Map(int x,int y){
        int map[][]=new int[x][y];
        for (int i=0;i<=x;i++){
            for (int j=0;j<=y;j++){
                map[i][j]=0;
            }
        }
        System.out.println(map);
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
