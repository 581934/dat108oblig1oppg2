package no.hvl.dat108;

public class main {

    public static void main(String[] args) {

        Thread chef = new Chef();
        Thread waiter = new Waiter();

        chef.start();
        chef.start();
        chef.start();


        waiter.start();
        waiter.start();

    }
}
