public class Queen {
    private static int n;
    private static int sl = 0;

    public static void main(String[] args) {
        n = 6;
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }

        queenSet(board, 0);

    }

    public static boolean isOk(int[][] b, int row, int col) {
        // check cung cot
        for (int i = 0; i < row; i++) {
            if (b[i][col] == 1) {
                return false;
            }
        }
        // check duong cheo ben trai
        int i = row;
        int j = col;
         while (i>=0 && j>=0){
                if (b[i][j] == 1) {
                    return false;
                }
            i--;
            j--;
        }

        // check duong cheo ben phai
        i = row; j = col;
        while (i>=0 && j < n){
            if (b[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public static void printResult(int[][] b) {
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               // System.out.print(b[i][j] + "  ");
                if (b[i][j] == 1) {
                   result += j + 1 + " ";
                }
            }
         //   System.out.println();
        }
        sl++;
     //   System.out.println();
        System.out.println("Solution " + sl + ": " + result);
      //  System.out.println();

    }

    public static boolean queenSet(int[][] b, int row) {
        if (row == n) {   // khi rowIndex = n --> da dat thanh cong n quan queen, vi rowIndex bat dau tu 0;
            printResult(b); // in ket qua nghiem ra
            return true;
        }

        for (int i = 0; i < n; i++) { // dat hau bat dau o row 0, va cho chay gia tri colIndex tu 0 den n;
            if (isOk(b,row,i)) {  // neu bat ky vi tri nao thoa dk isOk, se set vi tri = 1
                b[row][i] = 1;
                queenSet(b, row + 1); // sau khi dat thanh cong thi goi ham queenSet hang tiep theo va bat dau vong lap cho hang thu 2 (vong lap cho hang 0 chua chay het, tam dung)
                b[row][i] = 0; // sau khi set ket qua thanh cong ham queenSet tai row+1 se tra ve kq true/false sau do se loai bo so mot va tiep tuc vong lap tai cac o con lai sau do de tim o de tiep tuc dat, neu tim dc o thoa dk isOk se dung vong lap va tiep tuc goi ham queenSet tai row + 1 va tiep qua trinh, neu thanh cong dat dc con hau n tren row n -1 thi se in ket qua, neu khong se tra ket qua false (ham queenSet tai row + 1 va set lai gia tri 0 va tiep tuc return false, tiep tuc qua trinh cho den khi het cac nghiem
            }
        }
        return false;
    }
}
