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

    public TreeNode search(int key){
        return search(root, key);
    }

    private TreeNode search (TreeNode root, int key){

        if(root == null || root.getData() == key){
            return root;
        }

        if(key < root.getData()){
            return search(root.getLeft(), key);
        }
        else{
            return search(root.getRight(), key)
        }
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
