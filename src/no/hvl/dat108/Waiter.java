package no.hvl.dat108;

public class Waiter extends Thread {

    private static int waiters;

    private Burger burger;

    public Waiter(Burger burger) {
        this.burger = burger;
    }

    @Override
    public void run() {

        waiters++;

        while (true) {

            System.out.println("um");

            synchronized (burger) {
                while (burger.getAmount() > 0) {

                    try {
                        Thread.sleep((burger.randomNumber()) * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    burger.takeBurger();
                    System.out.println(toString());
//                    burger.notifyAll();
                }

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

    public String problem() {
        return "### Waiter" + waiters + " is ready to serve, but there is no burger :( ###";
    }
}
