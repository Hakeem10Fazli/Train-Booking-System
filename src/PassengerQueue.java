import java.util.Random;

public class PassengerQueue  {



    private Trainstation trainStation;
    private Passenger[] queueArray ;//new Passenger[21] ;
    private int first;
    private int last;
    private int maxStayInQueue;
    private int maxLength;

    // constructor PassengerQueue
    public PassengerQueue() {
        this.queueArray = new Passenger[21];
    }

    public Passenger[] getQueueArray() {
        return queueArray;
    }

    public void setQueueArray(Passenger[] queueArray) {
        this.queueArray = queueArray;
    }

    // Getters and Setters for PassengerQueue

    public void add(Passenger data){
        if (!isFull()) {
            queueArray[last] = data;
            last= (last +=1)%21;
            maxLength++;
        }else {
            System.out.println("Queue is full");
        }
    }

    public Passenger remove(){

        Passenger passenger = queueArray[first];
        if (!isEmpty()) {
            first = (first +1)%21;
            maxLength--;
        }else{
            System.out.println("Queue is empty");
        }
        return passenger;
    }


    public void display(){

        for (Passenger passenger:this.queueArray) {
            if (passenger == null) {
                break;
            }else {
                System.out.println(passenger.getSeat() + " - " + passenger.getName() + " -  " );
            }
        }

    }

    public boolean isEmpty() {
        return getMaxLength() == 0;
    }

    public boolean isFull() {
        return getMaxLength()  == 21;
    }

    public int getMaxStayInQueue() {
        return maxStayInQueue;
    }

    public void setMaxStayInQueue(int maxStayInQueue) {
        this.maxStayInQueue = maxStayInQueue;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }


}
