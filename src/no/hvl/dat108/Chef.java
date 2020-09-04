package no.hvl.dat108;

public class Chef extends Thread {

    private int chefs = 0;
    private Burger burger = new Burger();


    @Override
    public void run() {

        chefs++;
        System.out.println(chefs);

        while (true) {

            synchronized (burger) {
                while (burger.getAmount() < 5) {

                    try {
                        Thread.sleep((burger.randomNumber()) * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    burger.makeBurger();
                    System.out.println(toString());
                    burger.notifyAll();
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
