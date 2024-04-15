import java.util.ArrayList;

public class World {

    Map terra;
    int time;
    ArrayList fruits = new ArrayList<>();
    ArrayList fruits2 = new ArrayList<>();


    public World(int n,int x) { // конструктор, який генериє світ  в залежності від даної інформації
        for (int i=0;i<x;i++) {
            Soldier a = new Soldier();
            fruits.add(a);
            Soldier a2 = new Soldier();
            fruits2.add(a2);

        }
        this.terra = new Map(n,n);
        this.time = 0;
        terra.getspan(1,1,"Solider");
    }
}
