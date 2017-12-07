package copyFiles;

public class Main {
    private  static final String ADRESS="/home/juja/IdeaProjects/TheadDemo/src/copyFiles/Files";
    public static void main(String[] args) throws InterruptedException {
      CopyFiles copyFiles =new CopyFiles(ADRESS, "/home/juja/IdeaProjects/TheadDemo/src/copyFiles/Files(copy).txt");
      CopyFiles copyFiles1 =new CopyFiles(ADRESS, "/home/juja/IdeaProjects/TheadDemo/src/copyFiles/Files(copy2).txt");
        long time= System.currentTimeMillis();
      copyFiles.start();
      copyFiles.join();
      copyFiles1.start();
      copyFiles1.join();
        System.out.println(System.currentTimeMillis()- time);
    }
}
