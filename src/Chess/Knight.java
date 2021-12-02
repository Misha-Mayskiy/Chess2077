package Chess;

public class Knight extends ChessFigure {

    public Knight(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2658' : '\u265e');
    }

    @Override
    public boolean canMove(int[] xy) {
        return ((Math.abs(xy[0] - xy[2]) == 1 && Math.abs(xy[1] - xy[3]) == 2) ||
                (Math.abs(xy[0] - xy[2]) == 2 && Math.abs(xy[1] - xy[3]) == 1));
    }
}
