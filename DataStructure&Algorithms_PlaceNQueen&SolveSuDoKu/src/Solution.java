class Solution {

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

        solveSudoku(board);
    }
    public static void solveSudoku(char[][] board) {
        if(board==null || board.length==0)
            return;
        solve(board);


    }
    public static boolean solve(char[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='.')
                {
                    for(char k='1';k<='9';k++)
                    {

                        if(isValid(board,i,j,k))
                        {
                            board[i][j]=k;
                            if(solve(board))
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




    }
    private static boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}