package MultiThreads;

/** synchronized - нужно, чтобы синхронизировать запись в одну переменную,
 * с которой работают два и более потока
 * Только один поток в один момент времени получает доступ к выполнению тела метода
 * -
 * У каждого объекта есть сущность в виде монитора и каждый монитор может принадлежать только одному потоку
 * Эту особенность можно использовать, чтобы один поток в один момент времени что-то исполнял
 *-
 * Когда метод объекта помечается synchronized, синхронизация на this - на мониторе выбранного объекта */
public class SynchronizingThreads {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        SynchronizingThreads synchronizingThreads = new SynchronizingThreads();
        synchronizingThreads.doSomething();
    }

//    private synchronized void increment(){
//        counter++;
//    }

    private void increment(){
        // synchronized block - может исполняться только одним потоком
        // синхронизация на текущем объекте
        synchronized (this) {
            counter++;
        }
    }

    public void doSomething() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
                increment();
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
                // Три такта:
                // Считывание переменной
                // Увеличение переменной
                // Ее запись
                // counter++;
                increment();
        });

        // Два потока пишут в одну переменную и часть инструкций может теряться
        // (ядро работает со старым значением)
        thread1.start();
        thread2.start();

        // Ожидание, пока потоки не завершатся
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}
