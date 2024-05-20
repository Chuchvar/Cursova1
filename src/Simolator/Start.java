package Simolator;

import java.util.Scanner;

public class Start {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static int numberSoleder, sizeMap; //розмір карти і кількість бойців
    int numberFight;//кількість боїв
    public void starts(){//ввід даних
        String s1 = "«resque»";
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть кількість солдат: ");
        if(sc.hasNextInt()){
            numberSoleder =sc.nextInt();
        }else{
            System.out.println("Ви вели не інтове значеня");
        }
        System.out.println("Введіть розмір карти:");
        if(sc.hasNextInt()){
            sizeMap =sc.nextInt();
        }else{
            System.out.println("Ви вели не інтове значеня");
        }
        System.out.println("Введіть кількість потоків:");
        if(sc.hasNextInt()){
            numberFight =sc.nextInt();
        }else{
            System.out.println("Ви вели не інтове значеня");
        }
        for (int i = 1; i< numberFight; i++) {
            new MultiThread(s1);
        }
        try {
            World word = new World(numberSoleder, sizeMap, sizeMap);
            start(word);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано»");
        }
        System.out.println("«Головний потік завершено»");
    }
    static public void start(World w) {
        GameWindow window = new GameWindow(w);
        for (int i = 0; i < 300; i++) {
            int k = numberSoleder + 1;
            while (k-- > 1) {
                Soldier a;
                if (k % 2 == 1) {
                    a = w.team1.get((k - 1) / 2);
                } else {
                    a = w.team2.get(k / 2 - 1);
                }
                if (a.getlive()) {
                    if (!a.ammunition()) {
                        a.recharge();
                    } else if (a.isGoal()) {
                        if (a.getLiveArms()) {
                            w.shot(a.getCoordinatesMap(), w.terra.setmap2(a.getCoordinatesMap()) + a.getHeight(), a.getTarget(), 0.002, a.getPistol());
                            a.changeTARGET();
                        }
                    } else {
                        w.view(a);
                        if (!a.isGoal()) {
                            if (k % 2 == 0) {
                                if (a.isEnd()) {
                                    w.team2.targ1(k / 2 - 1);
                                }
                                w.moment(k);
                            }
                        }
                    }
                }
            }
            // Оновлюйте графіку на кожному кроці
            window.refresh();
            try {
                Thread.sleep(200); // Пауза між кадрами для видимого оновлення
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int k = numberSoleder + 1;
        int i = 0;
        int i2 = 0;
        int i5 = 0;
        int i7 = 0;
        int i6 = 0;
        while (k-- > 1) {
            Soldier a;
            if (k % 2 == 0) {
                a = w.team2.get(k / 2 - 1);
            } else {
                a = w.team1.get((k - 1) / 2);
            }
            if (a.getlive()) {
                i++;
                if (k % 2 == 0) {
                    i5++;
                } else {
                    i6++;
                }
            } else {
                i2++;
            }
        }
        System.out.println("Вижили" + " " + ANSI_GREEN + i + ANSI_RESET);
        System.out.println("Не вижило" + " " + ANSI_RED + i2 + ANSI_RESET);
        if (i5 > i6) {
            System.out.println("Команда" + ANSI_BLUE + " 2 " + ANSI_RESET + "перемогла і має виживших" + " " + ANSI_GREEN + i5 + ANSI_RESET);
        } else {
            System.out.println("Команда" + ANSI_YELLOW + " 1 " + ANSI_RESET + "перемогла і має виживших" + " " + ANSI_GREEN + i6 + ANSI_RESET);
        }
    }

    static int setx(){
       return sizeMap;
    }
    static int setn(){
        return numberSoleder;
    }

}
