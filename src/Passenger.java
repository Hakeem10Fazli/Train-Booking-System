
public class Passenger {

    private String name;
    private int secondsInQueue ;
    private String seat;

    public Passenger() {

        this.seat = seat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String s, String name) {

        this.name = name+"= "+seat;
    }

    public int getSecondsInQueue() {

        return secondsInQueue;
    }

    public void setSecondsInQueue(int secondsInQueue) {

        this.secondsInQueue = secondsInQueue;
    }

    public String getSeat() {

        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

}