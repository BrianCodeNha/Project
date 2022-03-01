import java.util.Scanner;

public class GradeStudent {

    public static void main(String[] args) {

        begin();

        System.out.println("MID-TERM");
        double x = midTerm();
        System.out.println();

        System.out.println("FINAL_TERM");
        double y = finalTerm();
        System.out.println();

        System.out.println("HOMEWORK");
        double z =homework();
        System.out.println();

        report(x, y, z);

    }


    public static void begin () {
        String alert = "This program reads exam/homework scores and reports your overall course grade";
        System.out.println(alert);
        System.out.println();

    }
    public static double wT = 0;

    public static double calScore (){
        Scanner sc = new Scanner(System.in);

        // nhập weight
        System.out.print("Weight (0-100): ");
        double wei = sc.nextDouble();
        while (wei > 100 || wei < 0){
            System.out.print("vui lòng nhập lại weight nằm trong khoảng 0-100: ");
            wei = sc.nextInt();
        }

        wT += wei;
        while (wT > 100){
            wT -= wei;
            System.out.print("Total weight đã vượt quá 100. Vui lòng nhập lại: ");
            wei = sc.nextDouble();
            wT += wei;
        }
        System.out.println("Total weight: " + wT);

        // nhập điểm đã đạt được
        System.out.print("Score earned: ");
        int score = sc.nextInt();

        // nhập điểm được tăng
        System.out.print("Were scores shifted (1=yes, 2=no): ");
        int shifted = sc.nextInt();
        int shiftAmount = 0;
        while (shifted != 1 && shifted != 2){
            System.out.print("vui lòng nhập lại giá trị (1 hoặc 2): ");
            shifted = sc.nextInt();
        }

        if (shifted == 1){
            System.out.print("shiftAmount: ");
            shiftAmount = sc.nextInt();
        }

        // Hiện thị tổng số điểm
        double totalPoint = (double) score + shiftAmount;
        if (totalPoint > 100){
            totalPoint = 100;
        }
        double mdWeightS = (double) Math.round((totalPoint/100.0)* wei *10)/10;
        System.out.println("Total points: " + totalPoint);
        System.out.println("Weighted score: " + mdWeightS);
        return mdWeightS;
    }

    public static double midTerm () {

        return calScore ();
    }

    public static double finalTerm(){
        return calScore ();
    }

    public static double homework(){

        Scanner sc = new Scanner(System.in);
        // nhập weight
        System.out.print("Weight (0-100): ");
        double wei = sc.nextInt();

        while (wei > 100 || wei < 0){
            System.out.print("vui lòng nhập lại weight nằm trong khoảng 0-100: ");
            wei = sc.nextInt();

        }
        wT += wei;
        while (wT > 100 || wT <100){
            wT -= wei;
            System.out.print("Total weight khác 100. Không hợp lệ, Vui lòng nhập lại: ");
            wei = sc.nextDouble();
            wT += wei;
        }
        System.out.println("Total weight: " + wT);

        // score of 3 assignment
        System.out.print("Number of assignments: ");
        double nA = sc.nextDouble();
        System.out.print("Assignment 1 score and max: ");
        int scoreA1 = sc.nextInt();
        int maxA1 = sc.nextInt();
        System.out.print("Assignment 2 score and max: ");
        int scoreA2 = sc.nextInt();
        int maxA2 = sc.nextInt();
        System.out.print("Assignment 3 score and max: ");
        int scoreA3 = sc.nextInt();
        int maxA3 = sc.nextInt();

        // section points
        System.out.print("How many sections did you attend?: ");
        double attend = sc.nextInt();
        if (attend > 6) {
            attend = 6;
        }

        System.out.println("Section points: " + attend*5);
        double sPoint = (double) Math.round((attend*5.0)/30.0*10)/10;

        System.out.println("Total section points: " + sPoint);

        // total & max points
        double tPoints = scoreA1 + scoreA2 + scoreA3 + attend*5;
        double maxPoints = maxA1 + maxA2 + maxA3 + 30;
        if (tPoints > 150 || maxPoints > 150){
            tPoints = 150;
            maxPoints = 150;
        }

        System.out.println("Total points: " + tPoints);
        System.out.println("Max points: " + maxPoints);
        double hmWeightS = (double) Math.round((tPoints/maxPoints)*wei*10)/10;
        System.out.println("Weighted score: " + hmWeightS);
        return hmWeightS;

    }

    public static void report(double a, double b, double c) {
        double total = (double) Math.round((a + b + c)*10)/10;
        double GPA;
        System.out.println("Your Overall percentage: " + total);
        System.out.println("Your total Weight: " + wT);
        if (total >= 85) {
             GPA = 3;
             System.out.println("Your grade will be at least: " + GPA);
             System.out.println("Excellent Student");
        } else if (total >= 75){
             GPA = 3;
             System.out.println("Your grade will be at least: " + GPA);
             System.out.println("Very good Student");
        } else if (total >= 60){
            GPA = 1;
            System.out.println("Your grade will be at least: " + GPA);
            System.out.println("good Student");
        } else {
            GPA = 0;
            System.out.println("Your grade will be at least: " + GPA);
            System.out.println("nice try");
        }
    }
}

