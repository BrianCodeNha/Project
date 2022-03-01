import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyStack {
    // chứa thông tin và các hành vi cơ bản của stack
    Node top;

    public void push(Product a){
        Node newNode = new Node(a);
        newNode.setNextNode(this.top);
        this.top = newNode;
    }

    public Product pop() {
        Product a = this.top.getData();
        this.top = this.top.getNextNode();
        return a;
    }

    public int length() {
        Node current = this.top;
        int length = 0;
        while (current != null) {
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    public boolean isEmpty() {
        if (length() != 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        String result = "ID |  Title   | Quantity | price" + "\n" + "--------------------------------" + "\n";;
        Node current = this.top;

        while (current != null) {
            result += current.toString() + "\n";
            current = current.getNextNode();
        }
        return result;
    }

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
                push(demo);
            }
            reader.close();
            System.out.println(toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
