import java.text.*;
import java.util.*;

// The Message object has a timestamp, author, and the Message content.
public class Message {
    private String theMessage;
    private long timeStamp;
    private User myAuthor;

    // Constructor will take theMessage and myAuthor parameters and injects the values to this.
    // The timestamp is obtained from the system at the time of Message creation.
    public Message(String theMessage, User myAuthor) {
        this.theMessage = theMessage;
        this.timeStamp = System.currentTimeMillis();
        this.myAuthor = myAuthor;
    }

    // Getters
    public String getTheMessage() {
        return theMessage;
    }
    public long getTimeStamp() {
        return timeStamp;
    }
    public User getMyAuthor() {
        return myAuthor;
    }

    // The timestamp will be formatted by using the SimpleDateFormat utility class.
    private static String formatTimeStamp(long ts) {
        SimpleDateFormat sdf = new SimpleDateFormat("[MMM dd, yyyy HH:mm]");
        Date resultDate = new Date(ts);
        return sdf.format(resultDate);
    }

    // toString method will display the information about this Message onto the screen.
    public String toString() {
        return "\"" + theMessage + "\" from --" + myAuthor.getUserName() + " on " + formatTimeStamp(timeStamp);
    }
}
