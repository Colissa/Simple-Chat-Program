// The Network class is a simple "fake println" network, which simulates routing chat Messages through a network.
// To simplify the simulation, the activity is merely printed onto the screen.
public class Network {
    private String networkName;

    // Constructor is private to ensure that the same Network is used.
    private Network(String networkName) {
        this.networkName = networkName;
    }

    // Getter & Setter
    public String getNetworkName() {
        return this.networkName;
    }
    public void setNetworkName(String name) {
        this.networkName = name;
    }

    // toString method will display the information about this Network onto the screen.
    public String toString() {
        return "Network name: " + networkName + ".";
    }

    // Simulates "putting a message on the network" - in this case, it simply
    // prints to the screen.
    public void message(Object o) {
        System.out.println(o);
    }

    ////////////////////////////////////////////
    //// Singleton
    ////////////////////////////////////////////

    // Private static global singleton.
    private static Network myNetworkSingleton;

    // The public getter method checks to see if the Network has already
    // been instantiated before returning the singleton instance.
    public static Network getNetworkSingleton() {
        if (myNetworkSingleton == null) {
            myNetworkSingleton = new Network("Fake Println Network");
        }
        return myNetworkSingleton;
    }
}
