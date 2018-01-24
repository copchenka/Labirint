package lab;

public class Field {

    private Cell[][] cells;
    private int rows;
    private int columns;
    public boolean FlagS = false;
    boolean FlagF = false;
    Point start;
    Point finish;

    Field(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        cells = new Cell[rows][columns];
    }

    public enum Cell {//обозначение элементов на поле
        Start, Finish, Barrier
    }

    public void putStart(int a, int b) {
        //выбор клетки как старта,если уже есть,то старый удаляется
        //и записывается новый
        if (FlagS == false) {
            FlagS = true;
            cells[a][b] = Cell.Start;
            start = new Point(a, b);
        } else {
            Delete(start.getX(), start.getY());
            cells[a][b] = Cell.Start;
            start = new Point(a, b);
        }
    }

    public void putFinish(int a, int b) {
        if (FlagF == false) {
            FlagF = true;
            cells[a][b] = Cell.Finish;
            finish = new Point(a, b);
        } else {
            Delete(finish.getX(), finish.getY());
            cells[a][b] = Cell.Finish;
            finish = new Point(a, b);
        }
    }

    public void putBarrier(int a, int b) {
        if (cells[a][b] != Cell.Finish && cells[a][b] != Cell.Start) {
            cells[a][b] = Cell.Barrier;
        }
    }

    public boolean isBar(Point point) {
        if (cells[point.getX()][point.getY()] == Cell.Barrier) {
            return true;
        } else {
            return false;
        }
    }

    public Point getStart() {
        return start;
    }

    public Point getFinish() {
        return finish;
    }

    private void Delete(int a, int b) {
        cells[a][b] = null;
    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

    public Cell[][] getBoard() {
        return cells;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
