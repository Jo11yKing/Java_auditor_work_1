import java.util.concurrent.CopyOnWriteArrayList;

class Reader implements Runnable {
    private final CopyOnWriteArrayList<Integer> listOfNumbers;

    public Reader(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000); // Задержка чтения
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Reading from list: " + listOfNumbers);
        }
    }
}