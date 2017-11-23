package raceThread;

public class Run {
    public static void main(String[] args) {
        Race PlayerOne = new Race("Дудка",1,10);
        Race PlayerTwo = new Race("Трубник",10,1);
        PlayerOne.start();
        PlayerTwo.start();
    }
}
