
import java.util.Scanner;
public class LuckyNumber {

    public static void main(String[] args) {


        while (Game.yn.equals("")|| Game.yn.equals("y")){
            play ();
        }
        if (!Game.yn.equals("y") ){
            report();

        }
    }

    public class Game {
        public static int gameCount = 0;
        public static int mRoundCount = 100;
        public static int tRoundCount = 0;
        public static String yn = "";
    }

     public static void play (){
         // bắt đầu trò chơi
         Game.gameCount++;
         int roundCount = 0;

         //chọn một số ngẫu nhiên từ 1 - 100
         double luckyNumber = Math.random()*100; luckyNumber = Math.floor(luckyNumber);

         // nhập số dự đoán từ user
         System.out.println("Xin vui lòng nhập số may mắn của bạn trong khoảng từ 1-100");
         Scanner input = new Scanner(System.in);
         int yluckyNumber = input.nextInt();

         // lượt dự đoán tăng lên
         roundCount ++;

         // so sánh và đưa ra gợi ý cho người chơi đoán.
         while (yluckyNumber != luckyNumber) {

             // dự đoán lớn hơn
             if (yluckyNumber > luckyNumber) {
                 System.out.println("số may mắn nhỏ hơn số dự đoán của bạn.");
                 System.out.println("Hãy nhập lại dự đoán của bạn");
                 yluckyNumber = input.nextInt();
                 roundCount++;

             }

             // dự đoán nhỏ hơn
             else if (yluckyNumber < luckyNumber) {
                 System.out.println("số may mắn lớn hơn số dự đoán của bạn.");
                 System.out.println("Hãy nhập lại dự đoán của bạn");
                 yluckyNumber = input.nextInt();
                 roundCount++;
             }
         }

         // Khi có kết quả chính xác, hỏi người chơi có muốn tiếp tục?
         if (yluckyNumber == luckyNumber) {

             // thông báo kết quả
             System.out.println("Chúc mừng!! bạn đã đoán đúng con số may mắn sau " + roundCount + " lần dự đoán.");

             // tính toán tổng số lần dự đoán và ghi nhận best game
             Game.tRoundCount += roundCount;

             if (roundCount < Game.mRoundCount) { Game.mRoundCount = roundCount;}

             System.out.println("Bạn có muốn tiếp tục chơi?");
             Game.yn = input.next().toLowerCase().substring(0,1);

         }
    }
    public static void report (){
        System.out.println("Tổng số lần chơi: "+ Game.gameCount);
        System.out.println("Tổng số lần dự đoáng: "+ Game.tRoundCount);
        System.out.println("Số lần dự đoán trung bình mỗi lượt chơi: "+ Game.tRoundCount/Game.gameCount);
        System.out.println("Số lượt dự đoán thấp nhất: "+ Game.mRoundCount);
    }
}
