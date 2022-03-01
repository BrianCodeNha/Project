import java.io.*;
import java.util.Scanner;

public class Algorithm {
    private final File file = new File("C:/Users/LENOVO/IdeaProjects/CSD201_AS1_FX14288/out/INPUT.txt");
    private final File output1 = new File("C:/Users/LENOVO/IdeaProjects/CSD201_AS1_FX14288/out/OUTPUT1.txt");
    private final File output2 = new File("C:/Users/LENOVO/IdeaProjects/CSD201_AS1_FX14288/out/OUTPUT2.txt");
    private final File output3 = new File("C:/Users/LENOVO/IdeaProjects/CSD201_AS1_FX14288/out/OUTPUT3.txt");
    private final File output4 = new File("C:/Users/LENOVO/IdeaProjects/CSD201_AS1_FX14288/out/OUTPUT4.txt");
    private final File output5 = new File("C:/Users/LENOVO/IdeaProjects/CSD201_AS1_FX14288/out/OUTPUT5.txt");

    public File getOutput1() {
        return output1;
    }

    public File getOutput2() {
        return output2;
    }

    public File getOutput3() {
        return output3;
    }

    public File getOutput4() {
        return output4;
    }

    public File getOutput5() {
        return output5;
    }

    private int n;
    private String[] a = new String[n];

    public String[] getA() {
        return a;
    }

    public void setN(int n) {
        this.n = n;
    }

    public File getFile() {
        return file;
    }


// 1. nhap data
    public void nhapData(){

        {
            try {

                Scanner input = new Scanner(System.in);

                System.out.print("Nhập n (n là length của chuỗi số thực): ");
                setN(input.nextInt());
                input.nextLine();

                System.out.print("Nhập chuỗi số thực bất kỳ: ");
                String stringArr = input.nextLine();

                FileWriter output = new FileWriter(getFile());
                output.write(stringArr);
                output.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // hien thi data

    public String[] displayContent(){
        String fileContent ="";

        try {
            Scanner scanFile = new Scanner(getFile());
            while (scanFile.hasNextLine()){
                fileContent = fileContent.concat(scanFile.nextLine());
            }
            a = fileContent.split(" ");
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }

    // lấy String[] array a

    public String[] getArr () {
        Scanner reader = null;
        try {
            reader = new Scanner(getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String content = "";

        while (reader.hasNextLine()){
            content = content.concat(reader.nextLine());
        }
        String[] a = content.split(" ");
        return a;
    }

    // chuyen array String to array int

    public double[] doublesArray (String[] a){
        double[] b = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = Double.parseDouble(a[i]);

        }
        return b;
    }

    // 3. bubble sort - output1
    public void bubbleSort (String[] a){
        double[] b = doublesArray (a);
        String result = "";

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length - i - 1; j++) {
                 if(b[j]>b[j + 1]){
                     double temp = b[j];
                     b[j] = b[j + 1];
                     b[j + 1] = temp;
                 }

            }
            for (int j = 0; j < b.length; j++) {
                result += b[j] + " ";
            }
            result += "\n";
        }
        System.out.println(result);
        output(getOutput1(), result);
    }

  // 4. selectionSort - output2

    public void selectionSort (String[] a){
        double[] b = doublesArray (a);
        String result = "";

        for (int i = 0; i < b.length; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if(b[i] > b[j]){
                    double temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                 }
            }

            for (int j = 0; j < b.length; j++) {
                result += b[j] + " ";
            }
            result += "\n";
        }
        System.out.println(result);
        output(getOutput2(), result);
    }

    // 5. inserttionSort - output3

    public double[] insertionSort (String[] a) {
        double[] b = doublesArray(a);
        String result = "";

        for (int i = 1; i < b.length; i++) {
            int j = i - 1;
            double current = b[i];


            while (j>= 0 && b[j] > current){
                b[j+1] = b[j];
                j--;
            }
            b[j+1] = current;

            for (int k = 0; k < b.length; k++) {
                result += b[k] + " ";
            }
            result += "\n";
        }
        System.out.print(result);
        System.out.println("Độ phức tạp về thời gian chạy của thuật toán: " + Math.pow(b.length,2));
        System.out.println("Nhận xét:");
        System.out.println("- Dữ liệu sắp xếp theo thứ tự ngược lại (trường hợp xấu): " + Math.pow(b.length,2));
        System.out.println("- Dữ liệu đã được sắp xếp (trường hợp tốt nhất): " + b.length);
        System.out.println("- Dữ liệu có xáo trộn ngẫu nhiên (trường hợp trung bình): " + Math.pow(b.length,2));
        output(getOutput3(), result);
        return b;
    }

    public void searchI (String[] a) {
        double[] b = doublesArray(a);
        Scanner sc = new Scanner(System.in);
        System.out.print("Hãy nhập giá trị cần tìm: ");
        double value = sc.nextDouble();
        String result = "";

        for (int i = 0; i < b.length; i++) {
            if(b[i] > value){
                result += i + " ";
            }
        }
        System.out.println(result);
        System.out.println("Độ phức tạp về thời gian chạy của thuật toán: " + b.length);
        System.out.println("Nhận xét: vì phải search toàn bộ mảng và mảng chưa được sắp xếp nên độ khó luôn là: O(n)");
        System.out.println("- Dữ liệu sắp xếp theo thứ tự ngược lại (trường hợp trung bình): " + b.length);
        System.out.println("- Dữ liệu đã được sắp xếp (trường hợp trung bình): " + b.length);
        System.out.println("- Dữ liệu có xáo trộn ngẫu nhiên (trường hợp trung bình): " + b.length);
        output(getOutput4(), result);
    }

    public void searchB (String[] a) {
        double[] b = doublesArray(a);
        for (int i = 1; i < b.length; i++) {
            int j = i - 1;
            double current = b[i];
            while (j>= 0 && b[j] > current){
                b[j+1] = b[j];
                j--;
            }
            b[j+1] = current;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Hãy nhập giá trị cần tìm: ");
        double value = sc.nextDouble();
        String result = "";

        int l = 0;
        int r = b.length  -1;
        while (l <= r){
            int m = l + (r - l)/2;
            if (b[m] == value){
                result += m;break;
            } else if ( b[m] < value){
                l = m + 1;
            } else  {
                r = m -1;
            }

        }
        System.out.println(result);
        System.out.println("Độ phức tạp về thời gian chạy của thuật toán: " + Math.log(b.length));
        System.out.println("Nhận xét: best case sẽ là vị trí m đầu tiên --> O(1)");
        System.out.println("- Dữ liệu sắp xếp theo thứ tự ngược lại (trường hợp trung bình): " + Math.log(b.length));
        System.out.println("- Dữ liệu đã được sắp xếp (trường hợp trung bình): " + Math.log(b.length));
        System.out.println("- Dữ liệu có xáo trộn ngẫu nhiên: không thể trả về kết quả chính xác với mọi trường hợp");
        output(getOutput5(), result);
    }

    public void output (File file, String s){
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


