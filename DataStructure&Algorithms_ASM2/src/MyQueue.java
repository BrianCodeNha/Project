import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyQueue {
    // chứa thông tin và các hành vi cơ bản của stack
    Node front;
    Node back;

    // đưa thông tin sản phẩm vào
    public void enqueue (Product a){
        Node newNode = new Node(a);
        if (front == null) {
            this.front = newNode;
            this.back = newNode;
        }

        this.back.setNextNode(newNode);
        this.back = newNode;
    }

    // xoá sản phẩm
    public void dequeue() {
        this.front = this.front.getNextNode();
    }

    // chiều dài của queue
    public int length() {
        Node current = this.front;
        int length = 0;
        while (current != null) {
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    // check queue rỗng hay không
    public boolean isEmpty() {
        if (length() != 0) {
            return false;
        }
        return true;
    }

    // in chuỗi ra console
    public String toString() {
        String result = "ID |  Title   | Quantity | price" + "\n" + "--------------------------------" + "\n";;
        Node current = this.front;

        while (current != null) {
            result += current.toString() + "\n";
            current = current.getNextNode();
        }
        return result;
    }


    // Save queue output
    public void stackReadSaveAndDisplay(File file) {
        String results = "";
        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String lineOfText = reader.nextLine();
                if (lineOfText.startsWith("ID") || lineOfText.startsWith("-")) {
                    continue;
                }
                results += lineOfText + "\n";
            }
            String[] a = results.split("\n");
            for (int j = 0; j < a.length; j++) {
                String[] b = a[j].split("  |  ");
                Product demo = new Product(b[0],b[2],Integer.parseInt(b[4]),Double.parseDouble(b[6]));
                enqueue(demo);
            }
            reader.close();
            System.out.println(toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
