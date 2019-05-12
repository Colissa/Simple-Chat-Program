// To test the Chat System
public class Main {
    public static void main(String[] args){
        // Creates a ChatManager object which manages a "global" list of Channels.
        ChatManager cm = ChatManager.getChannelManagerSingleton();

        // Creates Channels and names them.
        Channel sportsChannel = new Channel("Sports");
        Channel techChannel = new Channel("Technology");
        Channel financeChannel = new Channel("Finance");
        Channel foodChannel = new Channel("Delicious!");

        // Adds the Channels to the ChatManager ArrayList.
        cm.addGlobalChannel(sportsChannel);
        cm.addGlobalChannel(techChannel);
        cm.addGlobalChannel(financeChannel);
        cm.addGlobalChannel(foodChannel);

        System.out.println("All channels: " + cm.getAllChannels());

        System.out.println();

        System.out.println("Users are being created");
        System.out.println();

        // Creates Users and names them.
        Admin theAdmin = new Admin("Colissa");
        User sportsFanatic = new User("Sports Fanatic");
        User foodie = new User("Foodie");
        User techie = new User("Techie");
        User moneyGrubber = new User("Money Grubber");

        System.out.println("Admin is subscribing Users to Channels");
        System.out.println();

        // Admin subscribes User1 to all three Channels.
        theAdmin.subscribeUserTo(sportsFanatic, sportsChannel);
        theAdmin.subscribeUserTo(sportsFanatic, techChannel);
        theAdmin.subscribeUserTo(sportsFanatic, foodChannel);

        // Admin subscribes User2 to two Channels.
        theAdmin.subscribeUserTo(foodie, techChannel);
        theAdmin.subscribeUserTo(foodie, foodChannel);

        // Admin subscribes User1 to all three Channels.
        theAdmin.subscribeUserTo(techie, sportsChannel);
        theAdmin.subscribeUserTo(techie, techChannel);

        // Admin subscribes User4 to all three Channels.
        theAdmin.subscribeUserTo(moneyGrubber, foodChannel);
        theAdmin.subscribeUserTo(moneyGrubber, techChannel);
        theAdmin.subscribeUserTo(moneyGrubber, sportsChannel);

        System.out.println("Printing Users' subscription to screen:");
        //Printing the Users' subscriptions
        System.out.println(sportsFanatic);
        System.out.println(foodie);
        System.out.println(techie);
        System.out.println(moneyGrubber);
        System.out.println();

        System.out.println("Testing sending a Message to a Channel:");
        // Publishing a Message to the sportsChannel.
        sportsFanatic.publishMsg("Hello, I am a huge sports fan!", sportsChannel);
        System.out.println();

        System.out.println("Users have unsubscribed from different Channels.");
        //User4 unsubscribes from the c1 Channel.
        moneyGrubber.unsubscribeFrom(sportsChannel);
        techie.unsubscribeFrom(sportsChannel);
        foodie.unsubscribeFrom(techChannel);
        sportsFanatic.unsubscribeFrom(techChannel);
        System.out.println();

        System.out.println("Printing Users' subscription to screen after they have unsubscribed:");
        //Printing the Users' subscriptions
        System.out.println(sportsFanatic);
        System.out.println(foodie);
        System.out.println(techie);
        System.out.println(moneyGrubber);
        System.out.println();

        System.out.println("Testing sending a Message to a Channel:");
        //Publishing a Message to the techChannel.
        techie.publishMsg("I enjoy learning about the latest technology!", techChannel);
        System.out.println();

        System.out.println("Testing sending a Message to a Channel:");
        //Publishing a Message to the foodChannel.
        foodie.publishMsg("I love cooking!", foodChannel);
        System.out.println();

        System.out.println("Testing sending a Message to a Channel with no subscribers:");
        //Publishing a Message to the financeChannel.
        foodie.publishMsg("I hate Wall Street", financeChannel);
        System.out.println();


    }
}
