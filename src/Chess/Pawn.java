package Chess;

public class Pawn extends ChessFigure {

    public Pawn(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2659' : '\u265f');
    }

    @Override
    public boolean canMove(int[] xy) {
        if (this.colorIsWhite) {
            return (((xy[1] == xy[3]) && (xy[0] + 1) == xy[2]) ||
                    ((xy[0] == 6) && (xy[1] == xy[3]) && (xy[0] == (xy[2] + 2))) ||
                    ((xy[0] == (xy[2] + 1)) && (Math.abs(xy[1] - xy[3]) == 1)));
        }
        else {
            return (((xy[1] == xy[3]) && (xy[0] == (xy[2] - 1))) ||
                    ((xy[0] == 1) && (xy[1] == xy[3]) && (xy[0] == (xy[2] - 2))) ||
                    ((xy[0] == (xy[2] - 1)) && (Math.abs(xy[1] - xy[3]) == 1)));
        }
    }
}
