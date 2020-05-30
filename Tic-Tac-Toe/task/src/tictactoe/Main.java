package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String s = scanner.nextLine();
        char[] c = s.toCharArray();
        System.out.println("---------");
        System.out.println("| " + c[0] + " " + c[1] + " " + c[2] + " |");
        System.out.println("| " + c[3] + " " + c[4] + " " + c[5] + " |");
        System.out.println("| " + c[6] + " " + c[7] + " " + c[8] + " |");
        System.out.println("---------");
    }
}
