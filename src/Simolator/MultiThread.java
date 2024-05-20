package Simolator;

public class MultiThread implements Runnable{
    Thread t;
    String name;
    MultiThread(String n) {
        name=n;
        t = new Thread(this, name);
        t.start();
    }

    public void run() {
        World word = new World(Start.setn(), Start.setx(), Start.setx());
        Start.start(word);
    }

}
