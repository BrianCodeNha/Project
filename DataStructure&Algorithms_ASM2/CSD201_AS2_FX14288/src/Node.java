public class Node {
    // Node để quản lý thông tin và hành  của vi mỗi node trong danh sách
    Product data;
    Node nextNode;

    public Product getData() {
        return data;
    }

    public void setData(Product data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node(Product data) {
        this.data = data;
    }

    public String toString () {
        return getData().toString();
    }
}
