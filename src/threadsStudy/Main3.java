package threadsStudy;

public class Main3 {

    public static class Semaphore {
        private int permit;

        public Semaphore(int permit) {
            this.permit = permit;
        }

        public synchronized void take() throws InterruptedException {
            while (permit <= 0) {
                wait();
            }
            permit--;
        }

        public synchronized void release() throws InterruptedException{
            permit ++;
            notify();
        }
    }

    public static class Fio implements Runnable{
        public Semaphore s;
        public String palavra;

        public Fio(Semaphore s, String palavra) {
            this.s = s;
            this.palavra = palavra;
        }

        public void run() {
            System.out.println(palavra+ " Tentando acessar...");
            System.out.println("...");
            try {
                s.take();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

            System.out.println("Palavra: "+palavra);

            try{
                Thread.sleep(3000);
                s.release();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(1);

        Fio Fio1 = new Fio(semaforo, "A");
        Thread Fio1Thread = new Thread(Fio1);

        Fio Fio2 = new Fio(semaforo, "B");
        Thread Fio2Thread = new Thread(Fio2);

        Fio1Thread.start();
        Fio2Thread.start();
    }
}
