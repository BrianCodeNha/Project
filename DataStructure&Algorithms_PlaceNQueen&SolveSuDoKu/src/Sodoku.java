import java.util.ArrayList;

class Sudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'.','.','6','.','8','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','3'},
                {'1','.','.','.','.','7','2','4','.'},
                {'4','.','.','.','.','2','1','5','.'},
                {'.','.','.','.','.','.','9','.','.'},
                {'.','2','.','7','.','.','.','.','.'},
                {'.','.','.','.','.','5','.','.','9'},
                {'.','.','1','6','.','.','5','3','.'},
                {'3','.','.','.','.','.','.','.','7'}
        };

        setSudoku(board);
        printResult(board);
    }
    public static void printResult(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                 System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }


    public static boolean setSudoku (char[][] board) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='.')
                {
                    for(char k='1';k<='9';k++)
                    {

                        if(isOk(board,i,j,k))
                        {
                            board[i][j]=k;
                            if(setSudoku(board))
                                return true;
                            else
                                board[i][j]='.';
                        }

                    }
                    return false;

                }
            }
        }
        return true;
////        if (col == 9) {
////            System.out.println();
////            System.out.println("FINAL RESULT OF SUDOKU: ");
////            printResult(board);
////            System.exit(0);
////        }
////
////        if (row == 9) {
////            row = 0;
////            setSudoku(board, row, col + 1);
////            return;
////        }
//        for (int i = row; i < 9; i++) {
//            if(board[i][col] == '.') {
//                for (char j = '1'; j <= '9' ; j++) {
//                    if (isOk(board, i, col, j)) {
//                        board[i][col] = j;
//                        setSudoku(board, i + 1, col);          // false
//                        board[i][col] = '.'; //back track tai vi tri hang i
//                        }
//
//                }
//                return;
//            }
//            if (i == 8 && board[i][col] != '.') {
//                row = 0;
//                setSudoku(board, row, col + 1);
//                return;
//            }
//        }
//        return;
    }

    public static boolean isOk(char[][] board, int row, int col, char j) {
        //kiem tra hang doc, o hien tai trong va != cac o da co
        ArrayList<Character> d = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.') {
                d.add(board[i][col]);
            }
        }
        for (int i = 0; i < d.size(); i++) {
            if (d.get(i) == j) {
                return false;
            }
        }

        // kiem tra hang ngang
        ArrayList<Character> n = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.') {
                n.add(board[row][i]);
            }
        }
        for (int i = 0; i < n.size(); i++) {
            if (n.get(i) == j) {
                return false;
            }
        }

        // kiem tra o 3/3
        // day 1 o 3-3
        if (row < 3 && col < 3) {
            ArrayList<Character> v = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    if (board[i][k] != '.') {
                        v.add(board[i][k]);
                    }
                }
            }

            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) == j) {
                    return false;
                }
            }
        }
        // day 1 o 6-3
        if (row >= 3 && row < 6 && col <3) {
            ArrayList<Character> v = new ArrayList<>();
            for (int i = 3; i < 6; i++) {
                for (int k = 0; k < 3; k++) {
                    if (board[i][k] != '.') {
                        v.add(board[i][k]);
                    }
                }
            }

            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) == j) {
                    return false;
                }
            }
        }
        // day 1 o 9-3
        if (row >= 6 && row < 9 && col < 3) {
            ArrayList<Character> v = new ArrayList<>();
            for (int i = 6; i < 9; i++) {
                for (int k = 0; k < 3; k++) {
                    if (board[i][k] != '.') {
                        v.add(board[i][k]);
                    }
                }
            }

            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) == j) {
                    return false;
                }
            }
        }

        // day 2 o 3-6
        if (row < 3 && col >= 3 && col < 6 ) {
            ArrayList<Character> v = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                for (int k = 3; k < 6; k++) {
                    if (board[i][k] != '.') {
                        v.add(board[i][k]);
                    }
                }
            }

            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) == j) {
                    return false;
                }
            }
        }
        // day 2 o 6-6
        if (row >= 3 && row < 6 && col >= 3 && col < 6) {
            ArrayList<Character> v = new ArrayList<>();
            for (int i = 3; i < 6; i++) {
                for (int k = 3; k < 6; k++) {
                    if (board[i][k] != '.') {
                        v.add(board[i][k]);
                    }
                }
            }

            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) == j) {
                    return false;
                }
            }
        }
        // day 2 o 9-6
        if (row >= 6 && row < 9 && col >= 3 && col <6) {
            ArrayList<Character> v = new ArrayList<>();
            for (int i = 6; i < 9; i++) {
                for (int k = 3; k < 6; k++) {
                    if (board[i][k] != '.') {
                        v.add(board[i][k]);
                    }
                }
            }

            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) == j) {
                    return false;
                }
            }
        }

        // day 3 o 3-9
        if (row < 3 && col >= 6 && col <9) {
            ArrayList<Character> v = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                for (int k = 6; k < 9; k++) {
                    if (board[i][k] != '.') {
                        v.add(board[i][k]);
                    }
                }
            }

            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) == j) {
                    return false;
                }
            }
        }
        // day 3 o 6-9
        if (row >= 3 && row < 6 && col >= 6 && col <9) {
            ArrayList<Character> v = new ArrayList<>();
            for (int i = 3; i < 6; i++) {
                for (int k = 6; k < 9; k++) {
                    if (board[i][k] != '.') {
                        v.add(board[i][k]);
                    }
                }
            }

            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) == j) {
                    return false;
                }
            }
        }
        // day 3 o 9-9
        if (row >= 6 && row < 9 && col >= 6 && col <9) {
            ArrayList<Character> v = new ArrayList<>();
            for (int i = 6; i < 9; i++) {
                for (int k = 6; k < 9; k++) {
                    if (board[i][k] != '.') {
                        v.add(board[i][k]);
                    }
                }
            }

            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) == j) {
                    return false;
                }
            }
        }
        return true;
    }



}