package tictactoe;

import java.util.Scanner;

public class Main {

    static char[] field;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter cells: ");
        String s = scanner.nextLine();
        field = s.toCharArray();
        printField(field);

//        System.out.println(getTextState());

        int positionOnField = enterXY();
        doMove(positionOnField, 'X');
        printField(field);
    }

    private static String getTextState() {

        return isNotFinish() ? "Game not finished" :
                isDraw() ? "Draw" :
                        isWinsX() ? "X wins" :
                                isWinsO() ? "O wins" :
                                        isImpossible() ? "Impossible" : "Impossible";

    }

    private static void printField(char[] field) {
        System.out.println("---------");
        System.out.println("| " + field[0] + " " + field[1] + " " + field[2] + " |");
        System.out.println("| " + field[3] + " " + field[4] + " " + field[5] + " |");
        System.out.println("| " + field[6] + " " + field[7] + " " + field[8] + " |");
        System.out.println("---------");
    }

    private static void doMove(int positionOnField, char c) {
        field[positionOnField] = c;
    }

    private static int enterXY() {
        int x;
        int y;
        int positionOnField = 0;
        boolean invalidCoordinates = true;
        while (invalidCoordinates) {
            System.out.print("Enter the coordinates: ");

            try {
                x = scanner.nextInt();
                y = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                invalidCoordinates = true;
                continue;
            }

            positionOnField = getPositionOnFieldFromCoordinates(x, y);
            if (positionOnField == -1) {
                System.out.println("Coordinates should be from 1 to 3!");
                invalidCoordinates = true;
                continue;
            }

            switch (field[positionOnField]) {
                case 'X':
                case 'O':
                    System.out.println("This cell is occupied! Choose another one!");
                    invalidCoordinates = true;
                    continue;
            }
            invalidCoordinates = false;
        }
        return positionOnField;
    }

    private static int getPositionOnFieldFromCoordinates(int x, int y) {
        switch (x) {
            case 1:
                switch (y) {
                    case 1:
                        return 6;
                    case 2:
                        return 3;
                    case 3:
                        return 0;
                    default:
                        return -1;
                }
            case 2:
                switch (y) {
                    case 1:
                        return 7;
                    case 2:
                        return 4;
                    case 3:
                        return 1;
                    default:
                        return -1;
                }
            case 3:
                switch (y) {
                    case 1:
                        return 8;
                    case 2:
                        return 5;
                    case 3:
                        return 2;
                    default:
                        return -1;
                }
            default:
                return -1;
        }
    }

    /**
     * "Game not finished"
     */
    private static boolean isNotFinish() {
        return count('_') > 0 &&
                !isWinsX() &&
                !isWinsO() &&
                !isImpossible();
    }

    /**
     * "Draw"
     */
    private static boolean isDraw() {
        return count('_') == 0 &&
                !isWinsX() &&
                !isWinsO() &&
                !isImpossible();
    }

    /**
     * "X wins"
     */
    private static boolean isWinsX() {
        return !isImpossible() && isWin('X');
    }

    /**
     * "O wins"
     */
    private static boolean isWinsO() {
        return !isImpossible() && isWin('O');
    }

    /**
     * "Impossible"
     */
    private static boolean isImpossible() {
        int x = count('X');
        int o = count('O');

        if (isWin('X') && isWin('O')) {
            return true;
        } else {
            return x >= o ?
                    x - o > 1 :
                    o - x > 1;
        }
    }

    private static boolean isWin(char c) {
        return (field[0] == c && field[1] == c && field[2] == c) ||
                (field[3] == c && field[4] == c && field[5] == c) ||
                (field[6] == c && field[7] == c && field[8] == c) ||
                (field[0] == c && field[3] == c && field[6] == c) ||
                (field[1] == c && field[4] == c && field[7] == c) ||
                (field[2] == c && field[5] == c && field[8] == c) ||
                (field[0] == c && field[4] == c && field[8] == c) ||
                (field[2] == c && field[4] == c && field[6] == c);
    }

    private static int count(char c) {
        int counter = 0;
        for (char c1 : field) {
            if (c == c1) {
                counter++;
            }
        }
        return counter;
    }

}
