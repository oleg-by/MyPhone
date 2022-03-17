public class Caller {
    private String name;
    private long callerID;

    public Caller(String alex, long phoneNumber) {
    }

    public Caller(String name, int callerID) {
        this.name = name;
        this.callerID = callerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCallerID(long callerID) {
        this.callerID = callerID;
    }

    public String getName() {
        return name;
    }

    public long getCallerID() {
        return callerID;
    }
}
