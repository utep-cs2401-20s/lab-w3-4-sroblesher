public class GameOfLife {
    //ATTRIBUTES
    int size;
    int[][] board;
    int[][] previous;

    //CONSTRUCTORS
    public GameOfLife(){}

    public GameOfLife(int size){
        this.size = size;
        previous = new int[size][size];
        board = new int[size][size];
    }

    public GameOfLife(int[][] newBoard) {
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

    //GETTERS AND SETTERS
    public void setSize(int size){ this.size = size; }

    //public void setBoard(int[][] newBoard){ previous = newBoard; }

    public int[][] getBoard() { return board; } //Return current state of the board

    //Updates the board into next state
    public void oneStep(){
        for (int i = 0; i < size; i++) {
            for (int j =  0; j < size; j++) {
                if (alive(i,j)) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }

        /* Copy all elements from the new "board" to the previous board.
        *  This for future "oneStep" method calls*/
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                previous[i][j] = board[i][j];
            }
        }
    }

    //Checks whether or not the cell should be alive in the next state of the board
    public boolean alive(int i, int j) {
        int cellsAlive = neighbors(i,j);
        int aliveOrDead = previous[i][j];

        if (aliveOrDead == 1) { //If cell is alive
            if (cellsAlive < 2) return false;   //If fewer than two alive neighbors
            if (cellsAlive < 4) return true;   //If two or three alive neighbors
        }
        else {  //If cell is dead
            if (cellsAlive == 3) return true;   //If exactly three alive neighbors
        }

        return false;
    }

    //Counts how many alive neighbors the cell has
    public int neighbors(int i, int j) {
        int cellsAlive = 0;

        if ((i-1) >= 0 && (j-1) >= 0) if (previous[i-1][j-1] == 1) cellsAlive++;
        if ((j-1) >= 0) if (previous[i][j-1] == 1) cellsAlive++;
        if ((i+1) < size && (j-1) >= 0) if (previous[i+1][j-1] == 1) cellsAlive++;
        if ((i-1) >= 0) if (previous[i-1][j] == 1) cellsAlive++;
        if ((i+1) < size) if (previous[i+1][j] == 1) cellsAlive++;
        if ((i-1) >= 0 && (j+1) < size) if (previous[i-1][j+1] == 1) cellsAlive++;
        if ((j+1) < size) if (previous[i][j+1] == 1) cellsAlive++;
        if ((i+1) < size && (j+1) < size) if (previous[i+1][j+1] == 1) cellsAlive++;

        return cellsAlive;
    }

    //After n onStep changes in the board
    public void evolution(int n){
        if (n < 1) printArray();

        while (n != 0){
            oneStep();
            n--;
        }
    }

    //Prints the array of the current board
    public void printArray() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

}
