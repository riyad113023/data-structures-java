package queue;

import java.util.Objects;

public class QueueTestApp {
    BasicQueue<Gad2Chair> gad2Lift = new BasicQueue<Gad2Chair>();


    private void loadLift(){
        Gad2Chair gad2Chair1 = new Gad2Chair("Riyad", "Nusrat");
        Gad2Chair gad2Chair2 = new Gad2Chair("Milton", "Shimu");

        gad2Lift.enQueue(gad2Chair1);
        gad2Lift.enQueue(gad2Chair2);
    }

    private void unloadLift(){
        Gad2Chair gad2Chair = gad2Lift.deQueue();
        System.out.println(gad2Chair.listChairRiders());

        Gad2Chair gad2Chair2 = gad2Lift.deQueue();
        System.out.println(gad2Chair2.listChairRiders());
    }

    private boolean contains(Gad2Chair gad2Chair){
        return gad2Lift.contains(gad2Chair);
    }

    private int liftSize(){
        return gad2Lift.size();
    }

    public static void main(String[] args) {

        QueueTestApp app = new QueueTestApp();
        app.loadLift();

        System.out.println("current size :" + app.liftSize());

        System.out.println("Lift contains Riyad Nusrat ::");
        System.out.println(app.contains(new Gad2Chair("Riyad","Nusrat") ));

        app.unloadLift();

        System.out.println("Lift contains Riyad Nusrat ::");
        System.out.println(app.contains(new Gad2Chair("Riyad","Nusrat") ));
    }
}


class Gad2Chair{

    private String seat1Name;
    private String seat2Name;

    public Gad2Chair(String seat1Name, String seat2Name) {
        this.seat1Name = seat1Name;
        this.seat2Name = seat2Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gad2Chair gad2Chair = (Gad2Chair) o;
        return Objects.equals(seat1Name, gad2Chair.seat1Name) && Objects.equals(seat2Name, gad2Chair.seat2Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seat1Name, seat2Name);
    }

    public String listChairRiders(){
        return this.seat1Name + ", " +this.seat2Name;
    }

}
