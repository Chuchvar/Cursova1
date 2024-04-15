import java.util.ArrayList;

public class World {
    Map tarra;
    int time;
    ArrayList fruits = new ArrayList<>();

    public World(int n,int x) {
        for (int i=0;i<x;i++) {
            Soldier a = new Soldier();
            fruits.add(a);
        }this.tarra = new Map(n,n);
        this.time = 0;
    }
}
