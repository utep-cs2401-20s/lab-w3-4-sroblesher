import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GOLTester {
    /* "board1", "board2", "board3", "board4" are the boards
     * that need to be tested, respectively, from the instructions PDF
     * "board5" and "board6" are other boards created to test the games */
    int[][] board1 = {{0,0,0,0,0}, {0,0,0,0,0,0}, {0,1,1,1,0}, {0,0,0,0,0}, {0,0,0,0,0}};
    int[][] board2 = {{0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,1,1,1,0}, {0,1,1,1,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}};
    int[][] board3 = {{0,0,0,0,0,0}, {0,1,1,0,0,0}, {0,1,1,0,0,0}, {0,0,0,1,1,0}, {0,0,0,1,1,0}, {0,0,0,0,0,0}};
    int[][] board5 = {{0,0,0,0,0,0}, {0,1,0,0,0,1}, {0,1,0,1,0,1}, {0,1,0,1,0,1}, {0,0,0,1,0,0}, {0,0,0,0,0,0}};
    int[][] board6 = {{0,0,0,0,0,0}, {0,0,1,1,0,0}, {0,1,0,0,1,0}, {0,0,1,0,1,0}, {0,0,0,1,0,0}, {0,0,0,0,0,0}};

    /* First Method
     * changes the current board into the next state
     * oneStep1 to oneStep5 GameOfLife
     * oneStep6 to oneStep10 TorusGameOfLife           */

    @Test
    void oneStep1() {
        //Board #1
        GameOfLife a = new GameOfLife(board1);

        int[][] expect = new int[5][5];
        expect[1][2] = 1;
        expect[2][2] = 1;
        expect[3][2] = 1;

        a.oneStep();
        assertArrayEquals(expect, a.getBoard());
    }

    @Test
    void oneStep2() {
        //Board #2
        GameOfLife a = new GameOfLife(board2);

        int[][] expect = new int[6][6];
        expect[1][3] = 1;
        expect[2][1] = 1;
        expect[2][4] = 1;
        expect[3][1] = 1;
        expect[3][4] = 1;
        expect[4][2] = 1;

        a.oneStep();
        assertArrayEquals(expect, a.getBoard());
    }

    @Test
    void oneStep3() {
        //Board #3
        GameOfLife a = new GameOfLife(board3);

        int[][] expect = new int[6][6];
        expect[1][1] = 1;
        expect[1][2] = 1;
        expect[2][1] = 1;
        expect[3][4] = 1;
        expect[4][3] = 1;
        expect[4][4] = 1;

        a.oneStep();
        assertArrayEquals(expect, a.getBoard());
    }

    @Test
    void oneStep4() {
        //Board #4
        int[][] arr = new int[18][18];
        arr[2][5] = 1;
        arr[3][4] = 1;
        arr[3][5] = 1;
        arr[3][6] = 1;
        arr[4][3] = 1;
        arr[4][5] = 1;
        arr[4][7] = 1;
        arr[5][3] = 1;
        arr[5][5] = 1;
        arr[5][7] = 1;
        arr[6][4] = 1;
        arr[6][5] = 1;
        arr[6][6] = 1;
        arr[7][5] = 1;

        arr[10][5] = 1;
        arr[11][4] = 1;
        arr[11][5] = 1;
        arr[11][6] = 1;
        arr[12][3] = 1;
        arr[12][5] = 1;
        arr[12][7] = 1;
        arr[13][3] = 1;
        arr[13][5] = 1;
        arr[13][7] = 1;
        arr[14][4] = 1;
        arr[14][5] = 1;
        arr[14][6] = 1;
        arr[15][5] = 1;

        GameOfLife a = new GameOfLife(arr);
        int[][] expect = new int[18][18];
        expect[2][4] = 1;
        expect[2][5] = 1;
        expect[2][6] = 1;
        expect[4][3] = 1;
        expect[4][7] = 1;
        expect[5][3] = 1;
        expect[5][7] = 1;
        expect[7][4] = 1;
        expect[7][5] = 1;
        expect[7][6] = 1;
        expect[10][4] = 1;
        expect[10][5] = 1;
        expect[10][6] = 1;
        expect[12][3] = 1;
        expect[12][7] = 1;
        expect[13][3] = 1;
        expect[13][7] = 1;
        expect[15][4] = 1;
        expect[15][5] = 1;
        expect[15][6] = 1;

        a.oneStep();
        assertArrayEquals(expect, a.getBoard());
    }

    @Test
    void oneStep5() {
        //Board #5
        GameOfLife a = new GameOfLife(board5);
        int[][] expect = new int[6][6];
        expect[1][2] = 1;
        expect[1][4] = 1;
        expect[2][0] = 1;
        expect[2][1] = 1;
        expect[2][5] = 1;
        expect[3][3] = 1;
        expect[4][2] = 1;
        expect[4][4] = 1;

        a.oneStep();
        assertArrayEquals(expect, a.getBoard());
    }

    /*TorusGameOfLife Test cases*/

    @Test
    void oneStep6() {
        //Board #1
        TorusGameOfLife a = new TorusGameOfLife(board1);

        int[][] expect = new int[5][5];
        expect[1][2] = 1;
        expect[2][2] = 1;
        expect[3][2] = 1;

        a.oneStep();
        assertArrayEquals(expect, a.getBoard());
    }

    @Test
    void oneStep7() {
        //Board #2
        TorusGameOfLife a = new TorusGameOfLife(board2);

        int[][] expect = new int[6][6];
        expect[1][3] = 1;
        expect[2][1] = 1;
        expect[2][4] = 1;
        expect[3][1] = 1;
        expect[3][4] = 1;
        expect[4][2] = 1;

        a.oneStep();
        assertArrayEquals(expect, a.getBoard());
    }

    @Test
    void oneStep8() {
        //Board #3
        TorusGameOfLife a = new TorusGameOfLife(board3);

        int[][] expect = new int[6][6];
        expect[1][1] = 1;
        expect[1][2] = 1;
        expect[2][1] = 1;
        expect[3][4] = 1;
        expect[4][3] = 1;
        expect[4][4] = 1;

        a.oneStep();
        assertArrayEquals(expect, a.getBoard());
    }

    @Test
    void oneStep9() {
        //Board #6
        TorusGameOfLife a = new TorusGameOfLife(board6);

        a.oneStep();
        assertArrayEquals(board6, a.getBoard());
    }

    @Test
    void oneStep10() {
        //Board #5
        TorusGameOfLife a = new TorusGameOfLife(board5);
        int[][] expect = new int[6][6];
        expect[1][2] = 1;
        expect[1][4] = 1;
        expect[2][1] = 1;
        expect[2][5] = 1;
        expect[3][3] = 1;
        expect[4][2] = 1;
        expect[4][4] = 1;

        a.oneStep();
        assertArrayEquals(expect, a.getBoard());
    }

    /* Second method
     * calculates the number of neighbors alive
     * neighbors1 to neighbors5
     * neighbors6 to neighbors10                */

    @Test
    void neighbors1() {
        //Board #1
        GameOfLife b = new GameOfLife(board1);

        assertEquals(2,b.neighbors(2,2));
    }

    @Test
    void neighbors2() {
        //Board #2
        GameOfLife b = new GameOfLife(board2);

        assertEquals(4,b.neighbors(2,2));
    }

    @Test
    void neighbors3() {
        //Board #3
        GameOfLife b = new GameOfLife(board3);

        assertEquals(4,b.neighbors(2,2));
    }

    @Test
    void neighbors4() {
        //Board #6
        GameOfLife b = new GameOfLife(board6);

        assertEquals(4,b.neighbors(3,3));
    }

    @Test
    void neighbors5() {
        //Board #5
        GameOfLife b = new GameOfLife(board5);

        assertEquals(5,b.neighbors(2,2));
    }

    /*TorusGameOfLife Test cases*/

    @Test
    void neighbors6() {
        //Board #1
        TorusGameOfLife b = new TorusGameOfLife(board1);

        assertEquals(1,b.neighbors(2,1));
    }

    @Test
    void neighbors7() {
        //Board #2
        TorusGameOfLife b = new TorusGameOfLife(board2);

        assertEquals(1,b.neighbors(3,5));
    }

    @Test
    void neighbors8() {
        //Board #3
        TorusGameOfLife b = new TorusGameOfLife(board3);

        assertEquals(4,b.neighbors(2,3));
    }

    @Test
    void neighbors9() {
        //Board #4
        int[][] arr = new int[18][18];
        arr[2][5] = 1;
        arr[3][4] = 1;
        arr[3][5] = 1;
        arr[3][6] = 1;
        arr[4][3] = 1;
        arr[4][5] = 1;
        arr[4][7] = 1;
        arr[5][3] = 1;
        arr[5][5] = 1;
        arr[5][7] = 1;
        arr[6][4] = 1;
        arr[6][5] = 1;
        arr[6][6] = 1;
        arr[7][5] = 1;

        arr[10][5] = 1;
        arr[11][4] = 1;
        arr[11][5] = 1;
        arr[11][6] = 1;
        arr[12][3] = 1;
        arr[12][5] = 1;
        arr[12][7] = 1;
        arr[13][3] = 1;
        arr[13][5] = 1;
        arr[13][7] = 1;
        arr[14][4] = 1;
        arr[14][5] = 1;
        arr[14][6] = 1;
        arr[15][5] = 1;

        TorusGameOfLife b = new TorusGameOfLife(arr);

        assertEquals(4,b.neighbors(6,6));
    }

    @Test
    void neighbors10() {
        //Board #5
        TorusGameOfLife b = new TorusGameOfLife(board5);

        assertEquals(6,b.neighbors(2,0));
    }

    /* Third Method
     * uses oneStep n times to get the current state of the board
     * evolution1 to evolution5 GameOfLife
     * evolution6 to evolution10 TorusGameOfLife                        */

    @Test
    void evolution1() {
        //Board #1
        GameOfLife c = new GameOfLife(board1);
        int[][] expect = new int[5][5];
        expect[1][2] = 1;
        expect[2][2] = 1;
        expect[3][2] = 1;

        c.evolution(7);
        assertArrayEquals(expect, c.getBoard());
    }

    @Test
    void evolution2() {
        //Board #2
        GameOfLife c = new GameOfLife(board2);

        int[][] expect = new int[6][6];
        expect[1][3] = 1;
        expect[2][1] = 1;
        expect[2][4] = 1;
        expect[3][1] = 1;
        expect[3][4] = 1;
        expect[4][2] = 1;

        c.evolution(5);
        assertArrayEquals(expect, c.getBoard());
    }

    @Test
    void evolution3() {
        //Board #3
        GameOfLife c = new GameOfLife(board3);

        c.evolution(10);
        //The board stays the same
        assertArrayEquals(board3, c.getBoard());
    }

    @Test
    void evolution4() {
        //Board #4
        int[][] arr = new int[18][18];
        arr[2][5] = 1;
        arr[3][4] = 1;
        arr[3][5] = 1;
        arr[3][6] = 1;
        arr[4][3] = 1;
        arr[4][5] = 1;
        arr[4][7] = 1;
        arr[5][3] = 1;
        arr[5][5] = 1;
        arr[5][7] = 1;
        arr[6][4] = 1;
        arr[6][5] = 1;
        arr[6][6] = 1;
        arr[7][5] = 1;

        arr[10][5] = 1;
        arr[11][4] = 1;
        arr[11][5] = 1;
        arr[11][6] = 1;
        arr[12][3] = 1;
        arr[12][5] = 1;
        arr[12][7] = 1;
        arr[13][3] = 1;
        arr[13][5] = 1;
        arr[13][7] = 1;
        arr[14][4] = 1;
        arr[14][5] = 1;
        arr[14][6] = 1;
        arr[15][5] = 1;

        GameOfLife c = new GameOfLife(arr);

        int[][] expect = new int[18][18];
        expect[1][5] = 1;
        expect[2][5] = 1;
        expect[4][5] = 1;
        expect[5][4] = 1;
        expect[5][6] = 1;
        expect[7][4] = 1;
        expect[7][5] = 1;
        expect[7][6] = 1;
        expect[10][4] = 1;
        expect[10][5] = 1;
        expect[10][6] = 1;
        expect[12][4] = 1;
        expect[12][6] = 1;
        expect[13][5] = 1;
        expect[15][5] = 1;
        expect[16][5] = 1;

        c.evolution(7);
        assertArrayEquals(expect, c.getBoard());
    }

    @Test
    void evolution5() {
        //Board #5
        GameOfLife c = new GameOfLife(board5);

        int[][] expect = new int[6][6];
        expect[1][1] = 1;
        expect[2][1] = 1;
        expect[2][2] = 1;
        expect[2][3] = 1;
        expect[2][4] = 1;
        expect[3][1] = 1;
        expect[3][2] = 1;
        expect[3][3] = 1;
        expect[3][4] = 1;
        expect[4][3] = 1;

        c.evolution(2);
        assertArrayEquals(expect, c.getBoard());
    }

    /*TorusGameOfLife Test cases*/

    @Test
    void evolution6() {
        //Board #1
        TorusGameOfLife c = new TorusGameOfLife(board1);

        int[][] expect = new int[5][5];
        expect[1][2] = 1;
        expect[2][2] = 1;
        expect[3][2] = 1;

        c.evolution(7);
        assertArrayEquals(expect, c.getBoard());
    }

    @Test
    void evolution7() {
        //Board #2
        TorusGameOfLife c = new TorusGameOfLife(board2);

        int[][] expect = new int[6][6];
        expect[1][3] = 1;
        expect[2][1] = 1;
        expect[2][4] = 1;
        expect[3][1] = 1;
        expect[3][4] = 1;
        expect[4][2] = 1;

        c.evolution(5);
        assertArrayEquals(expect, c.getBoard());
    }

    @Test
    void evolution8() {
        //Board #3
        TorusGameOfLife c = new TorusGameOfLife(board3);

        c.evolution(10);
        //The board stays the same
        assertArrayEquals(board3, c.getBoard());
    }

    @Test
    void evolution9() {
        //Board #4
        int[][] arr = new int[18][18];
        arr[2][5] = 1;
        arr[3][4] = 1;
        arr[3][5] = 1;
        arr[3][6] = 1;
        arr[4][3] = 1;
        arr[4][5] = 1;
        arr[4][7] = 1;
        arr[5][3] = 1;
        arr[5][5] = 1;
        arr[5][7] = 1;
        arr[6][4] = 1;
        arr[6][5] = 1;
        arr[6][6] = 1;
        arr[7][5] = 1;

        arr[10][5] = 1;
        arr[11][4] = 1;
        arr[11][5] = 1;
        arr[11][6] = 1;
        arr[12][3] = 1;
        arr[12][5] = 1;
        arr[12][7] = 1;
        arr[13][3] = 1;
        arr[13][5] = 1;
        arr[13][7] = 1;
        arr[14][4] = 1;
        arr[14][5] = 1;
        arr[14][6] = 1;
        arr[15][5] = 1;


        TorusGameOfLife c = new TorusGameOfLife(arr);

        int[][] expect = new int[18][18];
        expect[1][5] = 1;
        expect[2][5] = 1;
        expect[4][5] = 1;
        expect[5][4] = 1;
        expect[5][6] = 1;
        expect[7][4] = 1;
        expect[7][5] = 1;
        expect[7][6] = 1;
        expect[10][4] = 1;
        expect[10][5] = 1;
        expect[10][6] = 1;
        expect[12][4] = 1;
        expect[12][6] = 1;
        expect[13][5] = 1;
        expect[15][5] = 1;
        expect[16][5] = 1;

        c.evolution(7);
        assertArrayEquals(expect, c.getBoard());
    }

    @Test
    void evolution10() {
        //Board #5
        TorusGameOfLife c = new TorusGameOfLife(board5);

        int[][] expect = new int[6][6];
        expect[1][2] = 1;
        expect[1][4] = 1;
        expect[2][1] = 1;
        expect[2][5] = 1;
        expect[3][3] = 1;
        expect[4][2] = 1;
        expect[4][4] = 1;

        c.evolution(1);
        assertArrayEquals(expect, c.getBoard());
    }
}