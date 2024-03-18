class MyRunnable implements Runnable {

    // Переопределение метода run()
    @Override
    public void run() {
        // Вывод ID потока
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }
}