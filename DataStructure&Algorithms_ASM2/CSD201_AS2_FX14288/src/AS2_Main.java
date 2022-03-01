import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AS2_Main {
    // là lớp để tạo menu và thực hiện thực hiện các chức năng  trong lớp ProductEngine của bài toán
    static String yn = "";

    public static void main(String[] args) {

        controller();
    }

    // đưa ra option trên giao diện
    public static void controller() {
        File data = new File("C:/Users/LENOVO/IdeaProjects/CSD201_AS2_FX14288/src/data.txt");
        File outPut = new File("C:/Users/LENOVO/IdeaProjects/CSD201_AS2_FX14288/src/console_output.txt");
        MyList List = new MyList();
        MyStack newStack = new MyStack();
        MyQueue newQueue = new MyQueue();
        while (!yn.equals("no")) {
            System.out.println("Choose one of this options:\n" +
                    "            Product list:\n" +
                    "            1. Load data from file and display\n" +
                    "            2. Input & add to the end.\n" +
                    "            3. Display data\n" +
                    "            4. Save product list to file.\n" +
                    "            5. Search by ID\n" +
                    "            6. Delete by ID\n" +
                    "            7. Sort by ID.\n" +
                    "            8. Convert to Binary\n" +
                    "            9. Load to stack and display\n" +
                    "            10. Load to queue and display.\n" +
                    "            0. Exit");

            System.out.print("Your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    List.readSaveAndDisplay(data);
                    saveToOutPut(List.toString());
                    break;
                case 2:
                    saveToOutPut(List.inputAndSave());
                    break;
                case 3:
                    System.out.println(List.toString());
                    saveToOutPut(List.toString());
                    break;
                case 4:
                    saveToOutPut(List.saveToFile(data));
                    break;
                case 5:
                    saveToOutPut(List.searchProductID());
                    break;
                case 6:
                    saveToOutPut(List.removeSP());
                    break;
                case 7:
//                    List.sortedList();
                    List.QuickSort(List);
                    saveToOutPut(List.toString());
                    break;
                case 8:
                    int slg = List.getHead().getData().getSoLuong();
                    saveToOutPut(List.convertFirstToBinary(slg));
                    break;
                case 9:
                    newStack.stackReadSaveAndDisplay(data);
                    saveToOutPut(newStack.toString());
                    break;
                case 10:
                    newQueue.stackReadSaveAndDisplay(data);
                    saveToOutPut(newQueue.toString());
                    break;
                case 0:
                    yn = "no";
                    break;
            }
        }
    }

    // lưu thông tin vào output.txt
    public static void saveToOutPut(String data) {
        try {
            File outPut = new File("C:/Users/LENOVO/IdeaProjects/CSD201_AS2_FX14288/src/console_output.txt");
            FileWriter writer = new FileWriter(outPut,true);
            writer.write(data + "\n");
            System.out.println();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}