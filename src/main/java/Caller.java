package main.java;

public class Caller {
    private String name;
    private long callerID;

    public Caller() {
    }

    public Caller(String name, long callerID) throws CallerIDException {
        if(callerID <= 0) {
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
        if(callerID <= 0) {
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

    @Override
    public String toString() {
        return "Caller{" +
                "name='" + name + '\'' +
                ", callerID=" + callerID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Caller caller = (Caller) o;

        if (getCallerID() != caller.getCallerID()) return false;
        return getName().equals(caller.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + (int) (getCallerID() ^ (getCallerID() >>> 32));
        return result;
    }
}
