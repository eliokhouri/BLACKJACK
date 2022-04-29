import java.util.concurrent.TimeUnit;


public class Print {
    
    public static void twoDots() throws InterruptedException {
        System.out.println();
        System.out.println();
        for (int i=0; i<2; i++){
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            System.out.println();
        }
        System.out.println();
    }
    
    
    public static void smartPlayer() throws InterruptedException {
        System.out.println();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Smart player...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println();
        System.out.print("Looks like you are calling it early.");
    }


}




