import java.util.Random;

public class Zoo {
    public static void main(String[] args) {
        // args[99]; // invalid, not a statement
        // System.out.println(args[99]); // out of bound
        // System.out.println(args[0]);
        
        // for (String arg: args) {
        //     System.out.println(arg);
        // }
        Random r = new Random();
        System.out.println(r.nextInt(10)); // random number between 0 and 9
    }
}