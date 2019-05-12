import java.util.ArrayList;

// The Channel class has an ArrayList of Messages, which represents its chat history.
// It will also have an ArrayList of subscribed Users.
// Publish-Subscribe design pattern:
// The Users can publish Messages, which then gets broadcasted to all the subscribed Users for this Channel.
public class Channel {
    private String name;
    private ArrayList<User> myUsers;
    private ArrayList<Message> chatHistory;

    // Constructor
    public Channel(String name) {
        this.name = name;
        this.myUsers = new ArrayList<>();
        this.chatHistory = new ArrayList<>();
    }

    // Allows this Channel to broadcast a Message to its subscribers but not to the author of the Message.
    public void broadcast(Message message) {
        for (User u : myUsers) {
            if (!u.equals(message.getMyAuthor())) {
                u.receiveMsg(message, this);
            }
        }
        chatHistory.add(message);
    }

    // Getters
    public ArrayList<Message> getHistory() {
        return chatHistory;
    }
    public ArrayList<User> getMyUsers() {
        return myUsers;
    }
    public String getName() {
        return name;
    }

    // Adds a User to this Channel's myUsers ArrayList.
    public void addUser(User user) {
        myUsers.add(user);
    }

    // Removes a User from this Channel's myUsers ArrayList.
    public void removeUser(User user) {
        myUsers.remove(user);
    }

    // toString method will display the information about this Channel onto the screen.
    public String toString() {
        return "Channel: " + name;
    }
}
