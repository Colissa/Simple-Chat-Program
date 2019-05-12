import java.util.ArrayList;

// The ChatManager class is a singleton object that manages a "global" list of Channels.
public class ChatManager {
    private ArrayList<Channel> globalChannels;
    private Network myNetwork;

    // Constructor is private to ensure that the same ChatManager is used
    // to manage the channels globally.
    private ChatManager() {
        this.globalChannels = new ArrayList<>();
        this.myNetwork = Network.getNetworkSingleton();
    }

    public void addGlobalChannel(Channel channel) {
        globalChannels.add(channel);
    }
    public ArrayList<Channel> getAllChannels() { return this.globalChannels;}

    ////////////////////////////////////////////
    //// Singleton
    ////////////////////////////////////////////

    // Private static singleton.
    private static ChatManager myChatManagerSingleton;

    // The public getter method checks to see if the ChatManager has already
    // been instantiated before returning the singleton instance.
    public static ChatManager getChannelManagerSingleton() {
        if (myChatManagerSingleton == null) {
            myChatManagerSingleton = new ChatManager();
        }
        return myChatManagerSingleton;
    }
}
