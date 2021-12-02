package Chess;

import java.util.Random;

public class Chessboard {

    private ChessFigure[][] chessBoard;
    private boolean isWhitesMove;
    //прошлые наработки
//    public Chessboard() {
//        buildChessboard();
//        run = true;
//    }
//    public Boolean getRun() {
//        return this.run;
//    }

    //create chess figures and who first turn(Black or White)
    public Chessboard() {
        // шахматная доска 8x8
        // строки [0] и [1] белые
        // строки [6] и [7] черные
        this.chessBoard = new ChessFigure[8][8];
        for (int i = 0; i < chessBoard.length; i++) {
            chessBoard[1][i] = new Pawn(true);
            chessBoard[6][i] = new Pawn(false);
        }
        chessBoard[0][0] = new Rook(true);
        chessBoard[0][7] = new Rook(true);
        chessBoard[0][1] = new Knight(true);
        chessBoard[0][6] = new Knight(true);
        chessBoard[0][2] = new Bishop(true);
        chessBoard[0][5] = new Bishop(true);
        chessBoard[7][0] = new Rook(false);
        chessBoard[7][7] = new Rook(false);
        chessBoard[7][1] = new Knight(false);
        chessBoard[7][6] = new Knight(false);
        chessBoard[7][2] = new Bishop(false);
        chessBoard[7][5] = new Bishop(false);
        chessBoard[0][3] = new King(true);
        chessBoard[7][3] = new King(false);
        chessBoard[0][4] = new Queen(true);
        chessBoard[7][4] = new Queen(false);
        Random rand = new Random();
        isWhitesMove = rand.nextBoolean();
    }

    //create field
    @Override
    public String toString() {
        System.out.println("\ta\tb\tc\td\te\tf\tg\th");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chessBoard.length; i++) {
            result.append(8 - i).append("|");
            for (ChessFigure cf : chessBoard[7 - i])
                result.append(cf != null ? cf : " ");
            result.append("\n");
        }
        //показывает you how you must input turn
        System.out.println("|―――――――――――――――――――――――|\n" +
                "| Введите ход в виде: 'a1a1' (без ')    ");
        //whites turn
        if (isWhitesMove) {
            System.out.println("|―――――――――――――――――――――――|\n" +
                    "| Ход Белых:");
        }
        //blacks turn
        else {
            System.out.println("|―――――――――――――――――――――――|\n" +
                    "| Ход Черных:");
        }
        return result.toString();
    }

    private boolean moveValid(int[] xy) {
        //check where your turn
        if (xy[0] < 0 || xy[0] > 7 || xy[1] < 0 || xy[1] > 7 || xy[2] < 0
                || xy[2] > 7 || xy[3] < 0 || xy[3] > 7) {
            System.err.println("Ход находится вне доски!");
            return false;
        }
        //check if you выбрал пустую клетку
        if (chessBoard[xy[0]][xy[1]] == null) {
            System.err.println("Клетка пуста!");
            return false;
        }
        //check who do turn
        if ((chessBoard[xy[0]][xy[1]].colorIsWhite && !isWhitesMove)
                || (!chessBoard[xy[0]][xy[1]].colorIsWhite && isWhitesMove)) {
            System.err.println("Сейчас ходит другой цвет!");
            return false;
        }
        //check can move figure
        if (!chessBoard[xy[2]][xy[3]].canMove(xy)) {
            System.err.println("Эта фигура так не двигается!");
            return false;
        }
        //friendly fire OFF
        if (chessBoard[xy[0]][xy[1]].colorIsWhite
                && chessBoard[xy[2]][xy[3]].colorIsWhite) {
            System.err.println("Белые не могут ходить на белых!");
            return false;
        }
        //friendly fire OFF
        if (!chessBoard[xy[0]][xy[1]].colorIsWhite
                && !chessBoard[xy[2]][xy[3]].colorIsWhite) {
            System.err.println("Черные не могут ходить на черных!");
            return false;
        }
        //congregations! your turn прошел check time!
        return true;
    }

//    past наработки
//            if (move.equalsIgnoreCase("выход")) {
//                run = false;
//                System.out.println("Спасибо за игру!");
//                return;
//            }
//            String[] elem = move.split(" ");

    //check is can move figure
    public boolean canMove(int[] xy) {
        if (!moveValid(xy))
            return false;
        else return chessBoard[xy[1]][xy[0]].canMove(xy);
    }

    //past наработки
    //        if (moveValid()) {
    //            chessBoard[xy[2]][xy[3]] = chessBoard[xy[0]][xy[1]];
    //            chessBoard[xy[0]][xy[1]] = null;
    //            isWhitesMove = !isWhitesMove;
    //        }

    public void move(int[] xy) {
        chessBoard[xy[3]][xy[2]] = chessBoard[xy[1]][xy[0]];
        chessBoard[xy[1]][xy[0]] = null;
    }
}

/**
 *  plans на будущее:
 * 1.шах и мат
 * 2.рокировка
 * 3.
*/
