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
            for (int i = 0; i <200 ; i++) {



                Thread.sleep(3000);
                System.out.println("Hello from a thread");
            }
        } catch (InterruptedException e) {
            System.out.println("Поток завершен");
        }
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
        (new HelloThread()).start();
    }
}
