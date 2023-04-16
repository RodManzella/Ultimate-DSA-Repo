package bst1;

public class BinarySearchTree {
    
    private TreeNode root;

    public void insert(int value){
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode root, int value){
        
        if(root == null){
            root = new TreeNode(value);
            return root;
        }

        if(value < root.getData()){
            root.setLeft(insert(root.getLeft(), value));
        }
        else{
            root.setRight(insert(root.getRight(), value));
        }

        return root;
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(TreeNode root){

        if(root == null){
            return;
        }
        inOrder(root.getLeft());
        System.out.println(root.getData());
        inOrder(root.getRight());
    }
}
