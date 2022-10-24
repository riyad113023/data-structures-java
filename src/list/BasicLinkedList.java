package list;

import org.w3c.dom.Node;

public class BasicLinkedList<X> {

    private Node first;
    private Node last;

    private int nodeCount;


    public BasicLinkedList(){
        first= null;
        last=null;
        nodeCount =0;
    }

    public int size(){
        return nodeCount;
    }

    public void add (X item){

        if(first == null){
            first = new Node(item);
            last = first;
        }
        else{
            Node newLastNode =new Node(item);
            last.setNextNode(newLastNode);
            last = newLastNode;
        }
        nodeCount++;
    }

    public void insert(X item, int position){
        if(size() < position){
            throw new IllegalArgumentException("The linked list is smaller than the position mentioned");
        }

        Node currentNode = first;

        for(int i = 1; i < position && currentNode != null; i++){
            currentNode = currentNode.getNextNode();
        }

        Node newNode = new Node(item);

        Node nextNode = currentNode.getNextNode();

        currentNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        nodeCount++;
    }


    public  X removeAt(int position){
        if(first == null){
            throw new IllegalArgumentException("Can not remove from empty linked list");
        }

        Node currentNode = first;
        Node preNode = first;


        for(int i=0; i<position && currentNode !=null; i++){
            preNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        X nodeItem = currentNode.getNodeItem();
        preNode.setNextNode(currentNode.getNextNode());

        nodeCount--;

        return nodeItem;
    }

    public X remove(){
        if(first == null){
            throw new IllegalStateException("The linked list is empty");
        }

        X nodeItem = first.getNodeItem();

        first = first.getNextNode();
        nodeCount--;
        return nodeItem;
    }


    public X get(int position){
        if(size() < position){
            throw  new IllegalArgumentException("the position specified is greater than size of the linked list");
        }

        Node currentNode = first;

        for(int i=1; i<size() && currentNode != null; i++){
            if(i==position){
                return currentNode.getNodeItem();
            }
            currentNode = currentNode.getNextNode();
        }

        return null;
    }


    public int find(X item){
        if (first == null) {
            throw new IllegalStateException("The list is empty");
        }

        Node currentNode = first;

        for(int i=1; i < size(); i++ ){
            if(currentNode.getNodeItem().equals(item)){
                return i;
            }
            currentNode= currentNode.getNextNode();
        }

        return -1;
    }


    public String toString(){

        StringBuffer stringBuffer = new StringBuffer();

        Node curNode = first;

        while (curNode!=null){
            stringBuffer.append(curNode.nodeItem);
            curNode= curNode.getNextNode();

            if (curNode != null) {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }
    private class Node{
        private Node nextNode;
        private X nodeItem;

        public Node(X nodeItem) {
            this.nextNode = null;
            this.nodeItem = nodeItem;
        }

        public void setNextNode(Node nextNode){
            this.nextNode = nextNode;
        }

        public Node getNextNode(){
            return nextNode;
        }

        public X getNodeItem(){
            return nodeItem;
        }


    }
}
