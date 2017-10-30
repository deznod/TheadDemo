package hellothread;

/**
 * Создание подкласса Thread
 *
 * Класс Thread сам реализует интерфейс Runnable
 * хотя его метод run() ничего не делает
 * Подкласс класса Thread может
 * обеспечить собственную реализацию метода run()
 */
public class HelloThread  extends Thread {
    public void run() {
        try {

            while (true) {
                Thread.sleep(3000);
                System.out.println("Hello from a thread");
            }
        } catch (InterruptedException e) {
            System.out.println("Поток завершен");
        }
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
        try {

            while (true) {
                Thread.sleep(6000);

                System.out.println("Hello from main thread");
            }
        } catch (InterruptedException e) {

        }
    }
}
