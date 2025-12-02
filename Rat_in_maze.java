public class Rat_in_maze {
    private int row;
    private int col;
    private Path_Of_Rat_in_Maze path;

    public Rat_in_maze(int startrow, int startcol) {
        this.row = startrow;
        this.col = startcol;
        this.path = new Path_Of_Rat_in_Maze();
        path.addPath(row,col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    public void move(int newrow, int newcol) {
        row = newrow;
        col = newcol;
        path.addPath(row,col);
    }
    public Path_Of_Rat_in_Maze getPath() {
        return path;
    }
}
