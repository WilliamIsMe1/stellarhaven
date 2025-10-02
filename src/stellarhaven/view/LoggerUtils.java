package stellarhaven.view;

import java.io.OutputStream;
import java.io.PrintStream;

public class LoggerUtils   {
    public static void clearScreen() {
        System.out.print("\033[H");
    }
}
