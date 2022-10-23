package stack;

public class BasicStack<X> {
    private X [] data;
    private int stackPointer;

    public BasicStack(){
        data = (X[]) new Object[1000];
    }

    public void push(X newItem){
        data[stackPointer++] = newItem;
    }

    public X pop(){
        if(stackPointer == 0){
            throw new IllegalStateException("There is no item in the stack");
        }
        return data[--stackPointer];
    }

    public boolean contains (X item){
        boolean found = false;

        for(int i=0; i < stackPointer; i++){
            if(data[i].equals(item)){
                found = true;
                break;
            }
        }
        return found;
    }


    public X access (X item){
        while (stackPointer > 0){
            X poppedItem = pop();
            if(item.equals(poppedItem)){
                return poppedItem;
            }
        }

        throw new IllegalArgumentException("Could not find the item on the stack "+ item);
    }

    public int size(){
        return stackPointer;
    }


}
