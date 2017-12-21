package MultiThreadedReading;

import java.io.*;


/**
 * Данный класс содержит реализацию задачи "Многопоточное считывание данных из файлов".
 *
 * @author Dubinin. 15it18.
 */

public class MultiThreadReading extends Thread {

    private static final long TIME = System.currentTimeMillis();

    private volatile static BufferedWriter bufferedWriter;//для записи в файл

    private String addres;//для передачи в поток адреса файла для считываение

    public MultiThreadReading(String addres) {
        this.addres = addres;
    }

    @Override
    public void run() {

        String string;

        try (BufferedReader br = new BufferedReader(new FileReader(addres))) {

            while ((string = br.readLine()) != null) {

                write(string);

            }
        } catch (IOException e) {

            e.printStackTrace();

        }

        System.out.println((System.currentTimeMillis()-TIME));
    }


    /**
     * Данный класс записывает в файл строку.
     *
     * @param string строка записываемая в файл.
     * @throws IOException InputOutputException
     */
    private static synchronized void write(String string) throws IOException {

        bufferedWriter.write(string + "\n");

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        bufferedWriter = new BufferedWriter(new FileWriter(new File("F:\\TheadDemo\\src\\MultiThreadedReading\\combo.txt")));

        MultiThreadReading throughStreams = new MultiThreadReading("F:\\TheadDemo\\src\\MultiThreadedReading\\Procces.txt");
        MultiThreadReading throughStreams_1 = new MultiThreadReading("F:\\TheadDemo\\src\\MultiThreadedReading\\Thread.txt");

        throughStreams.start();
        throughStreams_1.start();

        if (throughStreams.isAlive())
            throughStreams.join();

        if (throughStreams_1.isAlive())
            throughStreams_1.join();

        bufferedWriter.close();
    }
}