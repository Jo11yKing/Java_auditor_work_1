import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        int numPatients = 20;

        Thread[] patientThreads = new Thread[numPatients];
        for (int i = 0; i < numPatients; i++) {
            patientThreads[i] = new Thread(new Patient(clinic));
            patientThreads[i].start();
        }

        for (Thread t : patientThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Максимальная длина очереди: " + clinic.getMaxQueueLength());
    }
}