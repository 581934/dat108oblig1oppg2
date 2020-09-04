package no.hvl.dat108;

public class Chef extends Thread {

    private int chefs = 0;
    private Burger burger;

    public Chef(Burger burger) {
        this.burger = burger;
    }

    @Override
    public void run() {

        chefs++;

        while (true) {

            System.out.println("um");

            synchronized (burger) {
                if (burger.getAmount() < 5) {

                    try {
                        Thread.sleep((burger.randomNumber()) * 500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    burger.makeBurger();
                    System.out.println(toString());
//                    burger.notifyAll();
                }

            }
        }
    }

    @Override
    public String toString() {

        return "Chef"
                + chefs +
                " made a burger   " +
                "(" +
                //getAmount() +
                ") => [" +
                burger.getAmount() +
                "]";
    }
}
