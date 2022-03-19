public interface Messenger {
    default void sendMessage(String message, Caller caller){
        System.out.println("The message (" + message + ") has been sent to subscriber " + caller.getName() + " at number " + caller.getCallerID() + ".");
    }
    default String getMessage(Caller caller){
        return "You have received a message from " + caller.getName();
    }
}
