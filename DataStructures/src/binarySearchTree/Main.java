package binarySearchTree;

public class Main {
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);

        bst.inOrder();

        if(null != bst.search(3)){
            System.out.println("Found");
        }
        else{
            System.out.println("Not found");
        }
    }
}
