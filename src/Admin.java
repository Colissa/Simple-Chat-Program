// Admin extends the User class and is able to add and remove any User from a Channel.
public class Admin extends User {

    // Constructor
    public Admin(String userName) {
        super(userName);
    }

    // Subscribes a User to a Channel.
    public void subscribeUserTo(User user, Channel channel) {
        channel.addUser(user);
        user.subscribeTo(channel);
    }

    // Unsubscribes a User to a Channel.
    public void unsubcribeUserFrom(User user, Channel channel) {
        channel.removeUser(user);
        user.unsubscribeFrom(channel);
    }
}
