import Chess.Chessboard;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static Chessboard chessBoard;
    private static boolean isRunned;

    static {
        chessBoard = new Chessboard();
        isRunned = true;
    }

    //главный класс (запускает всё)
    public static void main(String[] args) {
        showField();
        while (isRunned) {
            int[] coor = prepareCoordinate(inputData());
            if (coor != null) {
                if (chessBoard.canMove(coor))
                    chessBoard.move(coor);
            } else {
                showError();
                continue;
            }
            showField();
        }
    }

    //    ошибка если вдруг что-то не так
    static private void showError() {
        System.err.println("Что-то пошло не так! Повторите ваши действия.");
    }

    //    показывает поле
    static private void showField() {
        System.out.println(chessBoard);
    }

    /**
     * Ввод данных о ходе
     *
     * @return строка с координатами
     */
    private static String inputData() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toLowerCase(Locale.ROOT);
    }

    //    конвертация в массивные xy доски
    private static int[] prepareCoordinate(String input) {
        if (input.equalsIgnoreCase("выход")) {
            isRunned = false;
            System.out.println("Спасибо за игру!");
            return null;
        }
        char[] data = input.toCharArray();
        int[] coor = {4, 1, 4, 3};
        if (data.length != 4) return null;
        else {
            int count = 0;
            if (data[0] >= 'a' && data[0] <= 'h') {
                coor[0] = data[0] - 'a';
                count++;
            }
            if (data[2] >= 'a' && data[2] <= 'h') {
                coor[2] = data[2] - 'a';
                count++;
            }
            if (data[1] >= '1' && data[1] <= '8') {
                coor[1] = data[1] - '1';
                count++;
            }
            if (data[3] >= '1' && data[3] <= '8') {
                coor[3] = data[3] - '1';
                count++;
            }
            if (count != 4)
                return null;
        }
        return coor;
    }
}