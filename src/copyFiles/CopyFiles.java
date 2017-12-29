package copyFiles;
/**
 * Класс для задачи копирование файлов
 * @author Dubinin. 15it18
 */
import java.io.*;

public class CopyFiles extends Thread {
    private String adresSource;
    private String adresRecipteon;
    private long timeRun;

    CopyFiles(String adresSource, String adresRecipteon) {
        this.adresSource = adresSource;
        this.adresRecipteon = adresRecipteon;
    }
    long getTimeRun(){
        return timeRun;
    }

    @Override
    public void run() {
        long time=System.currentTimeMillis();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(adresRecipteon));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(adresSource))) {
            String copyLine;
            while ((copyLine = bufferedReader.readLine()) != null) {

                bufferedWriter.write(copyLine + '\n');
            }
            timeRun=System.currentTimeMillis()-time;
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
        }
    }
}
