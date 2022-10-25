package tree;

import org.w3c.dom.Node;

public class BasicBinaryTree<X extends Comparable<X>> {

    private Node root;

    private int size;

    public BasicBinaryTree(){
        this.root = null;
    }

    public int size(){
        return size;
    }

    public void add (X item){
        Node node=   new Node(item);

        if (this.root == null) {
            this.root = node;
            this.size++;
        }
        else {
            insert(this.root,node);
        }
    }

    public boolean contains(X item){
         Node node =   get(item);
         if(node == null){
             return false;
         }
         else {
             return true;
         }
    }

    public Node get(X item){
        Node currentNode = this.root;

        while (currentNode!= null){
            int val = item.compareTo(currentNode.getItem());

            if(val == 0){
                return currentNode;
            } else if (val<0) {

                currentNode = currentNode.getLeft();
            }
            else {
                currentNode = currentNode.getRight();
            }
        }
        return  null;
    }

    public void insert(Node parent , Node child){
        if(child.getItem().compareTo(parent.getItem()) <0){
            if(parent.getLeft() == null){
                parent.setLeft(child);
                child.setParent(parent);
                size++;
            }
            else
            {
                insert(parent.getLeft(), child);
            }

        }
        else if(child.getItem().compareTo(parent.getItem()) >0){
            if(parent.getRight() == null){
                parent.setRight(child);
                child.setParent(parent);
                size++;
            }
            else{
                insert(parent.getRight(), child);
            }
        }
    }


    public boolean delete(X item){
        boolean deleted = false;
        Node node = get(item);
        if(node == null){
            return false;
        }
        else if(node.getLeft() == null && node.getRight() == null){
            unlink(node, null);
            deleted = true;
        }
        else if(node.getLeft() == null && node.getRight() != null){
            unlink(node, node.getRight());
            deleted = true;
        }
        else if(node.getRight()== null && node.getLeft()!= null){
            unlink(node, node.getLeft());
            deleted = true;
        }
        else{
            Node child = node.getLeft();
            while(child.getRight() !=null && child.getLeft() != null){
                child = child.getRight();
            }

            child.getParent().setRight(null);

            child.setRight(node.getRight());
            child.setLeft(node.getLeft());

            unlink(node, child);
            deleted  = true;
        }

        return false;
    }

    public void unlink(Node currentNode, Node newNode){
        if(currentNode == this.root){

            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root = newNode;
            this.size--;
        }
        else if(currentNode.getParent().getRight() == currentNode){
            currentNode.getParent().setParent(newNode);
            this.size--;
        }
        else {
            currentNode.getParent().setLeft(newNode);
            this.size--;
        }
    }


    private class Node{
        private Node left;
        private Node right;
        private Node parent;
        private X item;

        public Node(X item){
            this.item= item;
            this.left = null;
            this.right = null;
            this.parent = null;

        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getItem() {
            return item;
        }

        public void setItem(X item) {
            this.item = item;
        }
    }

}
