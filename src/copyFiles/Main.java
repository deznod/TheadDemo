package copyFiles;

/**
 * Класс для задачи копирование файлов
 * @author Dubinin. 15it18
 */
public class Main {
    private static final String ADRESS = "F:\\TheadDemo\\src\\copyFiles\\Files.txt";

    public static void main(String[] args) throws InterruptedException {

        CopyFiles copyFiles = new CopyFiles(ADRESS, "F:\\TheadDemo\\src\\copyFiles\\Files(copy).txt");
        CopyFiles copyFiles1 = new CopyFiles(ADRESS, "F:\\TheadDemo\\src\\copyFiles\\Files(copy2).txt");

        run(copyFiles);
        joinThread(copyFiles);

        System.out.println("Задание первое - " + copyFiles.getTimeRun());

        copyFiles = new CopyFiles(ADRESS, "F:\\TheadDemo\\src\\copyFiles\\Files(copy).txt");

        run(copyFiles);
        joinThread(copyFiles);

        run(copyFiles1);
        joinThread(copyFiles1);

        System.out.println("Задание второе - " + (copyFiles.getTimeRun() + copyFiles1.getTimeRun()));

        copyFiles = new CopyFiles(ADRESS, "F:\\TheadDemo\\src\\copyFiles\\Files(copy).txt");
        copyFiles1 = new CopyFiles(ADRESS, "F:\\TheadDemo\\src\\copyFiles\\Files(copy2).txt");

        run(copyFiles, copyFiles1);
        joinThread(copyFiles, copyFiles1);

        System.out.print("Задание третье: ");
        System.out.print(copyFiles.getTimeRun());
        System.out.print(","+copyFiles1.getTimeRun());


    }

    /**
     * Метод запускает 2 потока.
     *
     * @param copyFiles  1 поток
     * @param copyFiles1 2 поток
     */
    private static void run(CopyFiles copyFiles, CopyFiles copyFiles1) {
        copyFiles.start();
        copyFiles1.start();

    }

    /**
     * Метод запускает один поток
     *
     * @param copyFiles поток
     */
    private static void run(CopyFiles copyFiles) {
        copyFiles.start();
    }

    /**
     * Метод вызывает метод join() для потоков, который ждет пока выполниться поток.
     *
     * @param copyFiles  1 поток
     * @param copyFiles1 2 поток
     * @throws InterruptedException исключение.
     */
    private static void joinThread(CopyFiles copyFiles, CopyFiles copyFiles1) throws InterruptedException {
        copyFiles.join();
        copyFiles1.join();
    }

    /**
     * метод вызывает метод join() для потока, который ждет пока поток выпониться.
     *
     * @param copyFiles поток.
     * @throws InterruptedException исключение.
     */
    private static void joinThread(CopyFiles copyFiles) throws InterruptedException {
        copyFiles.join();
    }
}

