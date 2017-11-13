package raceThread;



public class RaceThread extends Thread {
    public static final int MAX_COUNT_OF_STEPS=200;
    public static final int SLEAP_THREAD=5;
    private int i;
    @Override
    public void run() {
        for (i=0; i<=MAX_COUNT_OF_STEPS;i++){
            try {
                sleep(SLEAP_THREAD);
                System.out.println("raceThread = "+ i);
            }catch (InterruptedException e){

            }
        }
    }

    public static void main(String[] args) {
        RaceThread race =new RaceThread();
        race.start();
        Thread thread = new Thread(currentThread());
        for (int i=0;i<=MAX_COUNT_OF_STEPS;i++){
            try {

                sleep(SLEAP_THREAD);
                System.out.println("mainThread = "+ i);
            }catch (InterruptedException e){

            }
        }if (race.i%5 == 0){
            thread.setPriority(MAX_PRIORITY);
            race.setPriority(MIN_PRIORITY);
        }if (race.i%10 == 0){
            race.setPriority(MIN_PRIORITY);
            thread.setPriority(MAX_PRIORITY);
        }
    }
}
