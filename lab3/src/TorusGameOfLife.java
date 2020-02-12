public class TorusGameOfLife extends GameOfLife{

    // CONSTRUCTORS
    public TorusGameOfLife(){}

    public TorusGameOfLife(int size){
        this.size = size;
        previous = new int[size][size];
        board = new int[size][size];
    }

    public TorusGameOfLife(int[][] newBoard){
        size = newBoard.length;
        previous = new int[size][size];
        board = new int[size][size];

        /* Copy all elements from the board, passed as a parameter,
         *  to the actual and previous board arrays  */
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard.length; j++) {
                previous[i][j] = newBoard[i][j];
                board[i][j] = newBoard[i][j];
            }
        }
    }

    //Only method different from GameOfLife
    @Override
    public int neighbors(int i, int j){
        int cellsAlive = 0;

        if (previous[(i-1+size)%size][(j-1+size)%size] == 1) cellsAlive++;
        if (previous[i%size][(j-1+size)%size] == 1) cellsAlive++;
        if (previous[(i+1)%size][(j-1+size)%size] == 1) cellsAlive++;
        if (previous[(i-1+size)%size][j%size] == 1) cellsAlive++;
        if (previous[(i+1)%size][j%size] == 1) cellsAlive++;
        if (previous[(i-1+size)%size][(j+1)%size] == 1) cellsAlive++;
        if (previous[i%size][(j+1)%size] == 1) cellsAlive++;
        if (previous[(i+1)%size][(j+1)%size] == 1) cellsAlive++;

        return cellsAlive;
    }
}
