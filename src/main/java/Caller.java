package main.java;

public class Caller {
    private String name;
    private long callerID;

    public Caller() {
    }

    public Caller(String name, long callerID) throws CallerIDException {
        if(callerID <= 0 && callerID > 999999999) {
            throw new CallerIDException("The caller ID is incorrect.");
        } else {
            this.name = name;
            this.callerID = callerID;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCallerID(long callerID) throws CallerIDException {
        if(callerID <= 0 && callerID > 999999999) {
            throw new CallerIDException("The caller ID is incorrect.");
        } else {
            this.callerID = callerID;
        }
    }

    public String getName() {
        return name;
    }

    public long getCallerID() {
        return callerID;
    }
}
