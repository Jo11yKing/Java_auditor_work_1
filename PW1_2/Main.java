import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> listOfNumbers = new CopyOnWriteArrayList<>();

        // Создание и запуск потоков для чтения и записи
        Thread readerThread = new Thread(new Reader(listOfNumbers));
        Thread writerThread = new Thread(new Writer(listOfNumbers));

        readerThread.start();
        writerThread.start();
    }
}
