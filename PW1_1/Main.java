public class Main {
    public static void main(String[] args) {
        // Создание и запуск трех потоков
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        Thread thread3 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}