class MFCWindow {
    private boolean isBusy = false;

    public synchronized boolean isBusy() {
        return isBusy;
    }

    public synchronized void fully() {
        isBusy = true;
    }

    public synchronized void empty() {
        isBusy = false;
    }
}