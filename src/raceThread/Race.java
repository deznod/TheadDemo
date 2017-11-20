public class Race extends Thread {
    public static final int MAX_COUNT_OF_STEPS = 200;
    public static final int SLEAP_THREAD = 5;
    private String name;
    private int priorityOne;
    private int priorityTwo;


    public Race(String name, int priorityOne, int priorityTwo) {
        this.name = name;
        this.priorityOne = priorityOne;
        this.priorityTwo = priorityTwo;
    }

    public Race() {
        this("Player", 10, 1);
    }

    public void run() {
        Thread thread = Thread.currentThread();
        thread.setPriority(priorityOne);
        for (int i = 0; i < MAX_COUNT_OF_STEPS; i++) {
            try {
                sleep(SLEAP_THREAD);
            } catch (InterruptedException e) {

            }
            System.out.println(name);
            if (i == 80) {
                thread.setPriority(priorityTwo);
            }
        }

    }

}


