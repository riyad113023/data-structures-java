package list;

public class TrainLinkedListApp {



    BasicLinkedList<TrainCar> train = new BasicLinkedList<TrainCar>();


    private void buildInitialTrain(){
        TrainCar trainCar1 = new TrainCar(CarType.BOXCAR,"Amazon Packages");
        TrainCar trainCar2 = new TrainCar(CarType.FLATBED,"Farm Machinery");
        TrainCar trainCar3 = new TrainCar(CarType.HOPPER,"Coal");
        TrainCar trainCar4 = new TrainCar(CarType.HOPPER,"Grain");

        train.add(trainCar1);
        train.add(trainCar2);
        train.add(trainCar3);
        train.add(trainCar4);
    }

    private int getTrainSize(){
        return train.size();
    }


    private void removeAndInsertCar(){
        train.remove();

        System.out.println("The current size of train after remove "+ train.size());
        System.out.println("Current train data after remove"+ train.toString());

        train.insert(new TrainCar(CarType.BOXCAR,"Farm Fence "), 1);

        System.out.println("The current size of train after insert "+ train.size());
        System.out.println("Current train data after insert"+ train.toString());
    }

    public static void main(String[] args) {

        TrainLinkedListApp app = new TrainLinkedListApp();
        app.buildInitialTrain();

        System.out.println("The current size of train is "+ app.getTrainSize());
        System.out.println("Current train "+ app.train.toString());

        app.removeAndInsertCar();

    }


    class TrainCar{
        private CarType carType;
        private String contents;

        public TrainCar(CarType carType, String contents) {
            this.carType = carType;
            this.contents = contents;
        }

        @Override
        public String toString() {
            return "TrainCar{" +
                    "carType=" + carType +
                    ", contents='" + contents + '\'' +
                    '}';
        }
    }

    enum CarType{
        BOXCAR,TANKER,FLATBED,HOPPER
    }
}
