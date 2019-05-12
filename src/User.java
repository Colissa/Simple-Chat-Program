import java.util.ArrayList;

// The User object includes a private ArrayList of Channel objects that the User is subscribed to.
public class User {
    private String userName;
    private ArrayList<Channel> myChannels;

    // Constructor
    public User(String userName) {
        this.userName = userName;
        this.myChannels = new ArrayList<>();
    }

    // Users can subscribe and unsubscribe from specific Channels.
    public void subscribeTo(Channel channel) {
        myChannels.add(channel);
    }

    public void unsubscribeFrom(Channel channel) {
        myChannels.remove(channel);
        channel.removeUser(this);
    }

    // Users are able to write Messages to a Channel and the subscribers of that Channel will then receive their Message.
    public void publishMsg(String content, Channel channel) {
        // Takes in a Message and adds it to the Channel
        Message m = new Message(content, this);
        channel.broadcast(m);
    }

    // Users will receive the Message by displaying it to their screen.
    public void receiveMsg(Message message, Channel channel) {
        // Takes in a Message and its Channel and sends it to the network.
        Network.getNetworkSingleton().message(this.userName + " received " + message + "\n");
    }

    // Getters
    public String getUserName() {
        return this.userName;
    }

    public ArrayList<Channel> getMyChannels() {
        return this.myChannels;
    }

    // toString method will display the information about this User on the screen.
    public String toString() {
        return userName + " (subscribed to: " + myChannels + ")";
    }
}


