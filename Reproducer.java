public class Reproducer {
    public static void main(String args[]) throws Exception {
        long pid = ProcessHandle.current().pid();
        System.out.println("PID.. " + pid);
        while (true) {
            Thread.sleep(3000);
            System.out.println("Running...");
        }
    }
}