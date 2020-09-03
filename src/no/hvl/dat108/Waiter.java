package no.hvl.dat108;

public class Waiter extends Thread {

    private static int waiters;

    private Burger burger = new Burger();


    @Override
    public synchronized void run() {

        waiters++;
        System.out.println(waiters);

        while (true) {

            if (burger.getAmount() < 1) {
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
                burger.takeBurger();
                System.out.println(toString());

                if (burger.getAmount() == 4) { notify(); }
            }
        }

    }

    @Override
    public String toString() {
        return "Waiter"
                + waiters +
                "served burger   " +
                "(" +
                "(burger number)" +
                ") => [" +
                burger.getAmount() +
                "]";
    }

    public String errorMessage() {
        return "### Waiter" + waiters + " is ready to serve, but there is no burger :( ###";
    }
}
