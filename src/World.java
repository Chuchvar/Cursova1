import java.util.ArrayList;

public class World {
    Map tarra;
    int time;
    ArrayList fruits = new ArrayList<>();
    ArrayList fruits2 = new ArrayList<>();

    public World(int n,int x) {
        for (int i=0;i<x;i++) {
            Soldier a = new Soldier();
            fruits.add(a);
            Soldier a2 = new Soldier();
            fruits.add(a2);

        }
        this.tarra = new Map(n,n);
        this.time = 0;
    }
}
