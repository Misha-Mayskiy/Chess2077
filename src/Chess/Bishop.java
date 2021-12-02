package Chess;

public class Bishop extends ChessFigure {

    public Bishop(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2657' : '\u265d');
    }

    @Override
    public boolean canMove(int[] xy) {
        return ((Math.abs(xy[0] - xy[2])) == (Math.abs(xy[1] - xy[3])));
    }
}
