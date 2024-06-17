package threadsStudy;
public class Main {

    //Aplicação 1
    public static class Fio1 extends Thread{
        public void run(){
            System.out.println("Fio thread started");
        }
    }

    //Aplicação 2
    public static class Fio2 implements Runnable{
        public void run(){
            System.out.println("Fio1 thread started");
        }
    }

    public static class Pessoa{
        public String nome;

        public Pessoa(String nome){
            this.nome = nome;
        }
    }

    public static class Professor extends Pessoa implements Runnable{

        public Professor(String nome){
            super(nome);
        }

        public void run(){
            for(int i = 0; i < 10; i++){
                System.out.println("Professor: " + nome + " " + (i+1));

                try{
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }



    public static void main(String[] args) throws InterruptedException{
        Fio1 fio1 = new Fio1();
        fio1.start();

        Fio2 fio2 = new Fio2();
        Thread thread1 = new Thread(fio2);

        Professor Fulano = new Professor("Fulano");
        Thread FulanoConta = new Thread(Fulano);

        Professor Beltrano = new Professor("Beltrano");
        Thread BeltranoConta = new Thread(Beltrano);

        FulanoConta.start();
        //FulanoConta.join(); //Garantindo que fulano conte primeiro completamente

        BeltranoConta.start();
    }
}
