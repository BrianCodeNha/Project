import java.io.*;
import java.util.Scanner;

public class MyList {
    // chứa thông tin và hành vi cơ bản của một danh sách móc nối
    Node head;
    Node tail;
    // 1. thêm sản phẩm vào phía cuối chuỗi
    public void addNodeAtEnd (Product data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        }

        this.tail.setNextNode(newNode);
        this.tail = newNode;
    }

    public void addNodeAtHead(Product data) {
        Node newNode = new Node(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    // in kết quả ra String
    public String toString () {
        String result = "ID |  Title   | Quantity | price" + "\n" + "--------------------------------" + "\n";
        Node current = this.head;
        while (current != null) {
            result += current.toString() + "\n";
            current = current.getNextNode();
        }
        return result;
    }

    // 2. đọc data từ file và in ra
    public void readSaveAndDisplay(File file) {
        String results = "";
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String lineOfText = reader.nextLine();
                if (lineOfText.startsWith("ID") || lineOfText.startsWith("-")) { // loại hàng title đầu tiên
                    continue;
                }
                results += lineOfText + "\n";
            }
            String[] a = results.split("\n"); // chia nho String trong file data theo hàng
            for (int j = 0; j < a.length; j++) {
                String[] b = a[j].split("  |  "); // chia nhỏ từng thành phần trong hàng qua dấu |
                Product demo = new Product(b[0],b[2],Integer.parseInt(b[4]),Double.parseDouble(b[6])); // chuyển data dạng chuỗi sang số thực và int
                addNodeAtEnd(demo);
            }
            reader.close();
            System.out.println(toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. nhập data và save vào list sản phẩm
    public String inputAndSave() {
        // Nhập data đầu vào
        Scanner sc = new Scanner(System.in);
        System.out.print("ID: ");
        String id = sc.next();
        System.out.print("Tên SP: ");
        String tenSP = sc.next();
        System.out.print("Số Lượng: ");
        int soLg = sc.nextInt();
        System.out.print("Đơn giá: ");
        double donGia = sc.nextDouble();
        Product bb = new Product(id,tenSP,soLg,donGia);
        addNodeAtEnd(bb);
        String result = "Đã thêm thành công SP: " + id;
        System.out.println(result);
        return result;

    }

    // 4. save vào file data
    public String saveToFile(File file) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(toString());
            writer.close();
            System.out.println("successfully saved!");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "successfully saved!";
    }

    // 5. tìm sản phẩm theo id
    public String searchProductID() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Bạn muốn tìm theo ID: ");
        String id = sc.next();
        Node current = this.head;

        while (current != null) { // duyệt các phần tử trong list để cho ra kết quả theo id
            if (current.getData().getMaSP().equals(id)) {
                return "RESULT: " + "\n" + current.toString();
            }
            current = current.getNextNode();
        }
        return "-1";
    }

    // 6. remove san pham
    public String removeSP() {
        // nhập id sản phẩm
        Scanner sc = new Scanner(System.in);
        System.out.print("Bạn muốn xoá ID: ");
        String id = sc.next();
        Node current = this.head;
        Node currentNext = current.getNextNode();

        while (currentNext != null) {
            // truong hop id xoa trung voi head
            if (this.head.getData().getMaSP().equals(id)) {
                this.head = currentNext;
                System.out.println("Đã xoá thành công ID: " + id);
                return "Đã xoá thành công ID: " + id;
            }
            // truong hop o giua va cuoi chuoi
            if (currentNext.getData().getMaSP().equals(id)) {
                current.setNextNode(currentNext.getNextNode());
                System.out.println("Đã xoá thành công ID: " + id);
                return "Đã xoá thành công ID: " + id;
            }
            current = current.getNextNode();
            currentNext = current.getNextNode();
        }
        System.out.println("Không tìm thấy ID: " + id);
        return "Không tìm thấy ID: " + id;

    }

    public int length() {
        int length = 0;
        Node current = this.head;

        while (current != null) {
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    // 7. sắp xếp thứ tự sản phẩm có đệ quy

    void QuickSort(MyList l) {
        Node tag, p;
        if (l.head == l.tail) {
            return;
        }
        MyList l1 = new MyList();
        MyList l2 = new MyList();
        tag = l.head;
        l.head = l.head.nextNode; // cap nhat lai l.head
        tag.nextNode = null; // co lap tag
        while (l.head != null) {
            p = l.head;
            l.head = l.head.nextNode;
            p.nextNode = null;
            if (p.getData().getMaSP().compareTo(tag.getData().getMaSP()) <= 0) {
                l1.addNodeAtHead(p.getData());
            } else {
                l2.addNodeAtHead(p.getData());
            }
        }
        QuickSort(l1);// gọi đệ quy sắp xếp
        QuickSort(l2);
        if (l1.head != null) {
            l.head = l1.head; // lấy head của l1 gán cho head của l
            l1.tail.nextNode = tag;
        } else { // l1 rỗng
            l.head = tag;
        }
        tag.nextNode = l2.head;
        if (l2.head != null) {
            l.tail = l2.tail;
        } else {
            l.tail = tag;
        }

    }
//    public void sortedList() {
//        Node i = this.head;
//        while (i != null) {
//            Node j = i.getNextNode();
//            while (j != null) {
//                if (i.getData().getMaSP().compareTo(j.getData().getMaSP()) > 0) {
//                    Product temp = i.data;
//                    i.setData(j.getData());
//                    j.setData(temp);
//                }
//                j = j.getNextNode();
//
//            }
//            i = i.getNextNode();
//
//
//        }
//        System.out.println(toString());
//    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    // chuyen so luong thanh dang binary
    public String convertFirstToBinary(int sL) {
        String result = "";
        if (sL == 0) {
            return result;
        }
        while (sL != 0){
            result += sL%2;
            sL = sL/2;
        }
        convertFirstToBinary(sL); // result = 1
        System.out.print("Binary: " + result);

        return "Binary: " + result;
    }
}
