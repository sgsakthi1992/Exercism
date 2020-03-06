import java.util.Objects;

public class QueenAttackCalculator {

    Queen blackQueen;
    Queen whiteQueen;

    public QueenAttackCalculator(Queen blackQueen, Queen whiteQueen) {
        if (blackQueen == null || whiteQueen == null)
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        if (blackQueen.equals(whiteQueen))
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        this.blackQueen = blackQueen;
        this.whiteQueen = whiteQueen;
    }

    public boolean canQueensAttackOneAnother() {
        return blackQueen.getRow() == whiteQueen.getRow()
                || blackQueen.getColumn() == whiteQueen.getColumn()
                || Math.abs(blackQueen.getRow() - whiteQueen.getRow())
                == Math.abs(blackQueen.getColumn() - whiteQueen.getColumn());
    }
}

class Queen {

    private final int row;
    private final int column;

    public Queen(int row, int column) {
        validate(row, "row");
        validate(column, "column");
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    private void validate(int value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException("Queen position must have positive " + name + ".");
        }
        if (value > 7) {
            throw new IllegalArgumentException("Queen position must have " + name + " <= 7.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queen queen = (Queen) o;
        return row == queen.row &&
                column == queen.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
