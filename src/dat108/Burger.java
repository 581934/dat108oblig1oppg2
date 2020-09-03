package dat108;

import java.util.Random;

public class Burger {

    private static int amount = 0;

    public int randomNumber() {

        return new Random().nextInt(5) + 2;
    }

    public synchronized void makeBurger(){amount++;}

    public synchronized void takeBurger(){amount--;}

    public synchronized int getAmount() {return amount;}
}
