import java.util.Scanner;

class Node {
    int value;
    Node left;
    Node right;
    
    public Node(int value) {
        this.value = value;
    }
}

class BinarySearch {
    Node root = null;
    
    public void add(int value) {
        Node newNode = new Node(value);
        
        if (root == null) {
            root = newNode;
        } else {
            root = addNode(root, newNode);
        }
    }
    
    private Node addNode(Node node, Node newNode) {
        if (node == null)
            return newNode;
        
        if (node.value > newNode.value)
            node.left = addNode(node.left, newNode);
        else
            node.right = addNode(node.right, newNode);

        return node;
    }
    
    //후위순회 Postorder : Left -> Right -> Root
    public void postOrder(Node node) {
	    if (node != null) {
		    if (node.left != null) postOrder(node.left);
		    if (node.right != null) postOrder(node.right);
		    System.out.println(node.value);
	    }
    }
}

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        BinarySearch bs = new BinarySearch();
        while (sc.hasNext()) {
            int number = sc.nextInt();
            bs.add(number);
        }
        
        bs.postOrder(bs.root);
    }
}