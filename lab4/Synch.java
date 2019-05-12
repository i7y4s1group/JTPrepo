import java.util.*;
import java.util.concurrent.Semaphore;

public class Synch {
    public static Semaphore semaphore = new Semaphore(3);

    public Random rand = new Random();
    public Magazyn magazyn = new Magazyn();
}
