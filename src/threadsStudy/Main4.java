package threadsStudy;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main4 {

    public static class ContaBanco{
        private int numConta;
        private int valorConta;

        private final Lock lock = new ReentrantLock();

        public ContaBanco(int numConta, int valorConta){
            this.numConta = numConta;
            this.valorConta = valorConta;
        }

        public void addToConta(int valor) throws InterruptedException{
            System.out.println("Tentando acessar ("+ valor +")...");
            lock.lock();

            try {
                valorConta += valor;
                System.out.println("Added! - " + valor);
            }
            finally {
                Thread.sleep(3000);
                lock.unlock();
            }
        }
    }

    public static class Deposito implements Runnable{
        private ContaBanco conta;
        private int valor;

        public Deposito(ContaBanco conta, int valor){
            this.conta = conta;
            this.valor = valor;
        }

        public void run(){
            try{
                conta.addToConta(valor);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ContaBanco conta = new ContaBanco(1,0);

        System.out.println(conta.numConta);

        Deposito Deposito1 = new Deposito(conta,150);
        Deposito Deposito2 = new Deposito(conta,5);

        Thread t1 = new Thread(Deposito1);
        Thread t2 = new Thread(Deposito2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Saldo da conta: "+ conta.valorConta);
    }
}
