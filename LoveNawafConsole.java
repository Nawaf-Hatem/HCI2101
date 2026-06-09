// File: LoveNawafConsole.java
// ترميز: UTF-8
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoveNawafConsole {
    // ألوان ANSI (قد لا تعمل في بعض بيئات Windows القديمة)
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String MAG = "\u001B[35m";
    static final String BOLD = "\u001B[1m";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean heartsOn = true;
        String name = "نواف";
        while (true) {
            clearScreen();
            if (heartsOn) {
                System.out.println(centerLine(RED + BOLD + "❤  أحبك " + name + "  ❤" + RESET));
                System.out.println(centerLine(MAG + "♡ ♥ ❤ ♡ ♥ ❤ ♡" + RESET));
            } else {
                System.out.println(centerLine(BOLD + "أحبك " + name + RESET));
            }
            System.out.println();
            System.out.println("اضغط Enter للتبديل، اكتب q ثم Enter للخروج...");
            String line = br.readLine();
            if (line != null && line.trim().equalsIgnoreCase("q")) break;
            heartsOn = !heartsOn;
        }
        clearScreen();
        System.out.println("باي ❤");
    }

    static void clearScreen() {
        // محاولة مسح الشاشة عبر ANSI
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static String centerLine(String s) {
        int width = 60;
        int pad = Math.max(0, (width - stripAnsi(s).length()) / 2);
        return " ".repeat(pad) + s;
    }

    static int stripAnsiLength(String s) {
        return stripAnsi(s).length();
    }

    static String stripAnsi(String s) {
        return s.replaceAll("\u001B\\[[;\\d]*m", "");
    }
}