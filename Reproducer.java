import java.util.concurrent.locks.LockSupport;

public class Reproducer {
    public static void main(String args[]) throws Exception {
        long pid = ProcessHandle.current().pid();
        System.out.println("PID.. " + pid);
        while (true) {
            if (args.length >0 && args[0].equals("blind")) {
                blindSpot();
            } else {
                helper();
            }
        }
    }

    private static void blindSpot() throws InterruptedException {
        Thread.sleep(50);
        LockSupport.parkNanos(50000);
        System.out.println("Running... ");
    }

    /** Do busy work.*/
    private static void helper(){
        String ret ="";
        for (int i=0; i< 2000000; i++){
            if (i%71==0){
                ret = ret + String.valueOf(helper0(String.valueOf(i)));
            }
        }
        System.out.println("Running... "+ String.valueOf(ret.length()));
    }

    private static int helper0(String s){
        return s.toLowerCase().getBytes().length;
    }
}