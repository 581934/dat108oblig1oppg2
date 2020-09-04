package no.hvl.dat108;

public class main {

    public static void main(String[] args) {

        Burger b = new Burger();

        Thread chef = new Chef(b);
        Thread waiter = new Waiter(b);

        chef.start();
//        chef.start();
//        chef.start();


        waiter.start();
//        waiter.start();


    }
}
