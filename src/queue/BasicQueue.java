package queue;

public class BasicQueue<X> {

    private X[] data;
    private int front;
    private int end;

    public BasicQueue(){
        data = (X[])new Object[1000];
        front = -1;
        end =-1;
    }


    public int size(){
        if(front ==-1 && end == -1){
            return 0;
        }
        else{
            return end - front +1;
        }
    }

    public void enQueue (X item){
        if((end+1) % data.length == front){
            throw new IllegalStateException("Queue is full");
        }
        else if ( size()==0 ) {
            front++;
            end++;
            data[end] = item;
        }
        else {
            end++;
            data[end] = item;
        }
    }

    public X deQueue (){
        X item = null;
        if(size() ==0) {

        }
        else if(end == front){
            item = data[front];
            data[front] =null;
            front = -1;
            end = -1;
        }
        else{
            item = data[front];
            data[front] = null;
            front++;
        }
        return item;
    }


    public boolean contains(X item){
        boolean found = false;
        if(size()==0){
            return found;
        }

        for(int i=front; i < end; i++){
            if(data[i].equals(item)){
                found = true;
                break;
            }
        }

        return found;
    }

    public X access(int position){
        if(size()==0 || position > size()){
            throw new IllegalArgumentException("no data found on specified position");
        }

        int trueIndex =0;

        for(int i= front; i< end; i++){
            if(trueIndex == position){
                return data[i];
            }
            trueIndex++;
        }
        throw new IllegalArgumentException("no data found on specified position");
    }


}
