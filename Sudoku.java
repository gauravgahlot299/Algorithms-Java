public class Sudoku {
    public static void main(String args[]) {
        int[][] board = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
        System.out.println(solver(board));
        for (int p = 0; p < 9; p++) {
            System.out.println();
            for (int q = 0; q < 9; q++) {
                System.out.print(board[p][q]);
            }
        }

    }

    static int solver(int[][] board) {
        int sol = -1;
        int i = -1;
        int j = -1;
        for (int p = 0; p < 9; p++) {
            boolean flag = true;
            for (int q = 0; q < 9; q++) {
                if (board[p][q] == 0) {
                    i = p;
                    j = q;
                    flag=false;
                    break;
                }
            }
            if(flag==false) break;
        }
        if (i == -1 && j == -1) return 1;
        for (int k = 1; k <= 9; k++) {
            boolean flag = true;
            for (int l = 0; l < 9; l++) {
                if (board[i][l] == k) {
                    flag = false;
                    break;
                }
            }
            if (flag == false) continue;
            for (int l = 0; l < 9; l++) {
                if (board[l][j] == k) {
                    flag = false;
                    break;
                }
            }
            if (flag == false) continue;
            int istart = (i/3)*3;
            int jstart = (j/3)*3;
            for (int l = istart; l < istart + 3; l++) {
                boolean innerFlag = true;
                for (int m = jstart; m < jstart + 3; m++) {
                    if (l < 9 && m < 9) {
                        if (board[l][m] == k) {
                            flag = false;
                            innerFlag = false;
                            break;
                        }
                    }
                }
                if (innerFlag == false) break;
            }
            if (flag == false) continue;
            board[i][j] = k;
            sol = solver(board);
            if (sol == -1) {
                board[i][j] = 0;
                continue;
            }
        }
        return sol;
    }
}
