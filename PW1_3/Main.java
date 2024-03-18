import java.util.Random;
public class Main {
    public static void main(String[] args) {
        MFCWindow[] windows = new MFCWindow[3];
        for (int i = 0; i < 3; i++) {
            windows[i] = new MFCWindow();
        }

        int totalCitizens = 1000; // Общее количество граждан

        for (int i = 0; i < totalCitizens; i++) {
            int category = new Random().nextInt(3) + 1;
            Thread citizenThread = new Thread(new Citizen(category, windows));
            citizenThread.start();
        }

        for (int i = 0; i < 3; i++) {
            double angryPercentage = Citizen.getAngryPercentage(i + 1);
            System.out.println("Category " + (i + 1) + ": Served = " + Citizen.totalCitizensByCategory[i] +
                    ", Angry = " + Citizen.angryCitizensByCategory[i] + ", Angry Percentage = " + angryPercentage + "%");
        }
    }
}