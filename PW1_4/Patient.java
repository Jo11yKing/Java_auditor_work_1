class Patient implements Runnable {
    private final Clinic clinic;

    public Patient(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public void run() {
        try {
            clinic.patientArrives();
            clinic.therapistExaminesPatient();
            clinic.mriExaminesPatient();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}