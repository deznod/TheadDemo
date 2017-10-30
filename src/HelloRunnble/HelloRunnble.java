package HelloRunnble;

/**
 * Реализация интерфейса Runnable
 * Интерфейс Runnable определяет один метод run,
 * предназначен для размещения кода, исполняемого в потоке.
 * Runnable-объект пересылается в конструктор Thread
 * и с помощью метода start() поток запускется.
 */
public class HelloRunnble implements Runnable {
    public void run(){
        System.out.println("Hello from a thread!");
        while (true){
            System.out.println("1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String  args[])  {
        (new Thread(new HelloRunnble())).start();
        System.out.println("Hello from main thread");


    }
}
