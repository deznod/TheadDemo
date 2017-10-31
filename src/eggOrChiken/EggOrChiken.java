package eggOrChiken;

/**
 * Класс EggOrChiken.
 * Даныый класс содержит реализованную задачу "Курица и яйцо"
 * @author Dubinin V.E 15IT18
 */

public class EggOrChiken extends Thread {
    /**
     * Побочный поток
     */
    public void run() {

        for (int i=0;i<100;i++) {
               setPriority(1);
            try {
                Thread.sleep(100);

                System.out.println("Яйцо "+i);
            } catch (InterruptedException e) {

            }
        }
    }

    /**
     * Главный поток
     * @param args
     */
    public static void main(String[] args) {
        EggOrChiken eggOrChiken = new EggOrChiken();
        Thread thread = new Thread(currentThread());
        thread.setPriority(10);
        System.out.println("Спор начат");
        (new EggOrChiken()).start();
        for (int i = 0; i < 100; i++) {
            try {

                Thread.sleep(100);
                System.out.println("курица " + i);
            } catch (InterruptedException e) {

            }
        }
        /**
         * Проверка победителя спора
         */
        if (eggOrChiken.isAlive()){
            try {
                eggOrChiken.join();
            }catch (InterruptedException e){}
            System.out.println("Первым появилось яйцо");
        }else {
            System.out.println("Курица первая");
        }
        System.out.println("спор законен");
    }
}
