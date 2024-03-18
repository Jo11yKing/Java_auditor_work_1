import java.util.Random;
class Citizen implements Runnable {
    private final int category;
    private final MFCWindow[] windows;
    public static int[] totalCitizensByCategory = new int[3]; // Число всех клиентов по категориям
    public static int[] angryCitizensByCategory = new int[3]; // Число злых клиентов по категориям

    public Citizen(int category, MFCWindow[] windows) {
        this.category = category;
        this.windows = windows;
        totalCitizensByCategory[category - 1]++;
    }

    @Override
    public void run() {
        Random random = new Random();
        int windowIndex = category - 1;
        MFCWindow window = windows[windowIndex];
        if (!window.isBusy()) {
            window.fully();
            System.out.println("Citizen of category " + category + " served at window " + (windowIndex + 1));
        } else {
            angryCitizensByCategory[category - 1]++;
            System.out.println("Citizen of category " + category + " left angrily from window " + (windowIndex + 1));
        }
        window.empty();
    }

    public static double getAngryPercentage(int category) {
        double angryPercentage = (double) angryCitizensByCategory[category - 1] / totalCitizensByCategory[category - 1] * 100;
        return angryPercentage;
    }
}