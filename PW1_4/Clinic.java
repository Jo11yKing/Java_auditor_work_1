import java.util.Random;
import java.util.concurrent.Semaphore;

class Clinic {
    private final Semaphore therapistSemaphore = new Semaphore(1);
    private final Semaphore mriSemaphore = new Semaphore(1);
    private int maxQueueLength = 0;

    public void patientArrives() throws InterruptedException {
        Random random = new Random();
        Thread.sleep(random.nextInt(301) + 300); // Random arrival time
        System.out.println("Пациент пришел. Длина очереди: " + (therapistSemaphore.getQueueLength() + 1));
        maxQueueLength = Math.max(maxQueueLength, therapistSemaphore.getQueueLength() + 1);
    }

    public void therapistExaminesPatient() throws InterruptedException {
        therapistSemaphore.acquire();
        System.out.println("Пациент проходит осмотр у терапевта.");
        Random random = new Random();
        Thread.sleep(random.nextInt(301) + 100); // Random examination time
        mriSemaphore.acquire();
        mriExaminesPatient();
    }

    public void mriExaminesPatient() throws InterruptedException {
        therapistSemaphore.release();
        System.out.println("Пациент проходит обследование на МРТ.");
        Random random = new Random();
        Thread.sleep(random.nextInt(301) + 100); // Random MRI time
        mriSemaphore.release();
    }

    public int getMaxQueueLength() {
        return maxQueueLength;
    }
}