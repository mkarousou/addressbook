package addressbook;

/**
 *
 * @author mkarousou
 */
public class AddressBook {
    
    public static void main(String[] args) {
        //create a new view object to interact with the controller
        ContactView view = new ContactView();
        //start interface main loop
        view.mainLoop();
    }
    
}
