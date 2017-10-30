package ThreadDemo;

/**
 * Класс, демонстируещий использование
 * методов класса Thread
 * в главном потоке программы
 */

public class CurrentTheradDemo {
    public static  void main(String[] args){
        // переменная therad ссылается на главный поток программы
        Thread thread = Thread.currentThread();
        // вывод сведений о главном потоке
        System.out.println("Текущий поток "+ thread);
        System.out.println("Имя потока "+thread.getName());
        System.out.println("Приоретет "+thread.getPriority());
        System.out.println("Группа потока "+thread.getThreadGroup());
        System.out.println("Индификатор потока "+thread.getId());
        System.out.println("Главный поток "+thread.getState());
        thread.setName("Главный поток");
        thread.setPriority(10);
        System.out.println("Теперь текущий поток "+ thread);
        //вывод цифр с задержкойна 1 секунду
        for (int i =5;i>0;i--){
            System.out.println(i);
            try {
                thread.sleep(1000 );
            }catch (InterruptedException e){
                System.out.println("Поток завершен");
            }
        }
    }
}
