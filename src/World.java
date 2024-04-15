import java.util.ArrayList;

public class World {

    Map terra;
    int time;
    ArrayList fruits = new ArrayList<>();
    ArrayList fruits2 = new ArrayList<>();


    public World(int n,int x) { // конструктор, який генериє світ  в залежності від даної інформації
        this.terra = new Map(n,n);
        for (int i=0;i<x/2;i++) {
            Soldier a = new Soldier(1+i,1);
            terra.getspan(1+i,1,"Solider",1+i);
            fruits.add(a);
            Soldier a2 = new Soldier(n-1,n-1-i);
            terra.getspan(n-1,n-1-i,"Solider",1+i);
            fruits2.add(a2);

        }
        terra.setGetf(n);
        this.time = 0;

    }
}
