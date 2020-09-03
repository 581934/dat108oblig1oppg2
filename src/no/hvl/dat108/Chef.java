package no.hvl.dat108;

public class Chef extends Thread {

    private int chefs = 0;
    private Burger burger = new Burger();


    @Override
    public synchronized void run() {

        chefs++;
        System.out.println(chefs);

        while (true) {

            if (burger.getAmount() > 4) {
                try {
                    System.out.println(errorMessage());
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep((burger.randomNumber()) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                burger.makeBurger();
                System.out.println(toString());

                if (burger.getAmount() == 1) { notify(); }
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

    private String errorMessage() {
        return "### Chef" + chefs + " is ready to make burger, but there isn't enough space :( ###";
    }
}
