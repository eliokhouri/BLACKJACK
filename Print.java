import java.util.concurrent.TimeUnit;


public class Print {
    
    public static void fourDots() throws InterruptedException {
        System.out.println();
        System.out.println();
        for (int i=0; i<4; i++){
            TimeUnit.SECONDS.sleep(2);
            System.out.print(".");
        }
        System.out.println();
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

    public static void potOneWin() throws InterruptedException {
        System.out.println();
        System.out.println("It looks like you beat the house! We are going to have to end the night early for you.");
        System.out.println();
        TimeUnit.SECONDS.sleep(5);
    }


    public static void potTwo() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println();
        System.out.println();
        System.out.println("GAME OVER.");
        System.out.println();
    }

    public static void potOneLose() throws InterruptedException {
        System.out.println();
        System.out.println("It looks like you squandered your bankroll! You do not have any more money to gamble with.");
        System.out.println();
        TimeUnit.SECONDS.sleep(5);
    }





}




