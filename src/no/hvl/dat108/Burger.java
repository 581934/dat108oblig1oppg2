package no.hvl.dat108;

import java.util.Random;

public class Burger {

    private static int amount = 0;

    public int randomNumber() {

        return new Random().nextInt(5) + 2;
    }

    public void makeBurger(){amount++;}

    public void takeBurger(){amount--;}

    public synchronized int getAmount() {return amount;}
}
