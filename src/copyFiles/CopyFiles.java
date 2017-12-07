package copyFiles;

import java.io.*;
import java.sql.Time;

public class CopyFiles extends Thread {
    private String adresSource;
    private String adresRecipteon;


    CopyFiles(String adresSource, String adresRecipteon) {
        this.adresSource = adresSource;
        this.adresRecipteon = adresRecipteon;
    }


    @Override
    public void run() {
        long time = System.currentTimeMillis();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(adresRecipteon));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(adresSource))) {

            String copyLine;
            while ((copyLine = bufferedReader.readLine()) != null) {
                bufferedWriter.write(copyLine + '\n');
            }
        } catch (IOException e) {

        }
    }
}
