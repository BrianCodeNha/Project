import java.util.Scanner;

public class main_sort {
    public static String yn = "";

    public static void main(String[] args) {
        menu();

    }

    public static void menu (){
        System.out.println("+-------------------Menu------------------+");
        System.out.println("|      1.Input                            |");
        System.out.println("|      2.Output                           |");
        System.out.println("|      3.Bubble sort                      |");
        System.out.println("|      4.Selection sort                   |");
        System.out.println("|      5.Insertion sort                   |");
        System.out.println("|      6.Search > value                   |");
        System.out.println("|      7.Search = value                   |");
        System.out.println("|      0.Exit                             |");
        System.out.println("+-----------------------------------------+");
        System.out.print("Vui lòng nhập lựa chọn của bạn: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        while (choice > 7 || choice < 0){
            System.out.print("Lựa chọn của bạn không hợp lệ, vui lòng chọn lại: ");
            choice = sc.nextInt();
        }
        Algorithm a  = new Algorithm();
        switch (choice){
            case 1:
                System.out.println("Nhập data");
                a.nhapData();
                System.out.println();
                break;
            case 2:
                System.out.println("display data");
                a.displayContent();
                System.out.println();
                break;
            case 3:
                System.out.println("bubblesort");
                a.bubbleSort(a.getArr());
                System.out.println();
                break;
            case 4:
                System.out.println("selectionSort");
                a.selectionSort(a.getArr());
                System.out.println();
                break;
            case 5:
                System.out.println("insertionSort");
                double[] ca = a.insertionSort(a.getArr());
                System.out.println();
                break;
            case 6:
                System.out.println("SearchI");
                a.searchI(a.getArr());
                System.out.println();
                break;
            case 7:
                System.out.println("SearchB");
                a.searchB(a.getArr());
                System.out.println();
                break;
            case 0:
                System.out.println("Cảm ơn bạn! Tạm biệt.");
                yn = "no";
                System.out.println();
                break;
        }

       if (yn != "no"){
           menu();
       }

    }
}
