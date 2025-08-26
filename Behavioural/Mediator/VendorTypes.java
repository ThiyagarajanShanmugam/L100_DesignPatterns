package Behavioural.Mediator;

// Photographer vendor
class Photographer extends Vendor {
    public Photographer() {
        super("Photographer");
    }
    
    @Override
    public void receiveUpdate(String event, String senderType) {
        if (event.contains("ceremony starting")) {
            System.out.println(name + ": Getting ready to capture ceremony!");
        } else if (event.contains("cake cutting")) {
            System.out.println(name + ": Moving to cake table for photos!");
        }
    }
    
    @Override
    public String getType() { return "Photographer"; }
}

// DJ vendor
class DJ extends Vendor {
    public DJ() {
        super("DJ");
    }
    
    @Override
    public void receiveUpdate(String event, String senderType) {
        if (event.contains("ceremony starting")) {
            System.out.println(name + ": Playing wedding march!");
        } else if (event.contains("ready for party")) {
            System.out.println(name + ": Starting reception music!");
        }
    }
    
    @Override
    public String getType() { return "DJ"; }
}

// Caterer vendor
class Caterer extends Vendor {
    public Caterer() {
        super("Caterer");
    }
    
    @Override
    public void receiveUpdate(String event, String senderType) {
        if (event.contains("ceremony starting")) {
            System.out.println( name + ": Preparing reception dinner!");
        } else if (event.contains("ready for cake")) {
            System.out.println(name + ": Bringing out the wedding cake!");
        }
    }
    
    @Override
    public String getType() { return "Caterer"; }
}
