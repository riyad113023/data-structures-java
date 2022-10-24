package hash;

public class HashTableTestApp {
    BasicHashTable<String, String> app= new BasicHashTable<String, String>(12);


    public static void main(String[] args) {
        HashTableTestApp testApp = new HashTableTestApp();
        testApp.putElementsToHashTable();
        testApp.getElementTest();
        testApp.deleteElementsToHashTable();
        testApp.getElementTest();

    }

    public void putElementsToHashTable(){
        app.put("8mm","8 mm Socket");
        app.put("10mm","10 mm Socket");
        app.put("12mm","12 mm Socket");
        app.put("14mm","14 mm Socket");
        app.put("16mm","16 mm Socket");
    }


    public void deleteElementsToHashTable(){
        app.delete("8mm");
        app.delete("10mm");
    }

    public void getElementTest(){
        String value = app.get("8mm");
        if(value!=null){
            System.out.println(" the 8mm key found");
        }
        else{
            System.out.println(" the 8mm key not found!!");
        }
    }

}
