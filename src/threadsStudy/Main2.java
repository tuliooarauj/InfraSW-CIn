package threadsStudy;

public class Main2 {

    public static class FioThread extends Thread {
        private final int startSum;
        private final int endSum;
        private int totalSum;

        public FioThread(int startSum, int endSum) {
            this.startSum = startSum;
            this.endSum = endSum;
            this.totalSum = 0;
        }

        public void run() {
            for(int i = startSum; i < endSum; i++) {
                totalSum += i;
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException e){}
            }
        }

        public int getTotalSum() {
            return totalSum;
        }

        public static void main(String[] args) throws InterruptedException {
//            FioThread Fio0 = new FioThread(0, 3000);

            FioThread Fio1 = new FioThread(0, 1500);
            FioThread Fio2 = new FioThread(1500, 3000);

            long starTime = System.currentTimeMillis();

            Fio1.start();
            Fio2.start();

//            Fio0.start();
//            Fio0.join();

            Fio1.join();
            Fio2.join();
//            System.out.println(Fio0.getTotalSum());

            long endTime = System.currentTimeMillis();

            System.out.println(Fio1.getTotalSum() + Fio2.getTotalSum());
            System.out.println("Time taken: " + (endTime - starTime));
        }


    }
}
