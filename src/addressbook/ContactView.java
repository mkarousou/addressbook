package addressbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mkarousou
 */

//View class. Implements user input and output functionality
public class ContactView {
    
    private ContactController controller;
    private Scanner inScanner;
   
    
    //if contact file cannot open, leaves fields null
    public ContactView(){
        try
        {
            this.controller = new ContactController();
            this.inScanner = new Scanner(System.in);
        }catch(IOException ioe){
            System.out.println("***Could not retrieve contacts!***");
            return;
        }catch(ClassNotFoundException c){
            System.out.println("***Could not retrieve contacts!***");
            return;
        }
    }   
    
    //main loop of application
    public void mainLoop(){
        //if controller is null (contact file could not be loaded), the application returns
        if(this.controller == null)
            return;
        while(true) {
            System.out.println("Menu");
            System.out.println("1. View all contacts");
            System.out.println("2. Add new contact");
            System.out.println("3. Search contact by name");
            System.out.println("4. Search contact by phone");
            System.out.println("5. Modify contact by name");
            System.out.println("6. Delete contact by name");
            System.out.println("7. Exit");

            String input = this.inScanner.nextLine();
            if(input.equals("1")){
                this.showContacts();
            }
            else if(input.equals("2")){
                this.processCreation(false);
            }
            else if(input.equals("3")){
                this.processSearchByName();
            }
            else if(input.equals("4")){
                this.processSearchByPhone();
            }
            else if(input.equals("5")){
                this.processModification();
            }
            else if(input.equals("6")){
                this.processDelete();
            }
            else if(input.equals("7")){
                this.processExit();
                break;
            }
            else{
                System.out.println("Wrong input!! Must be between 1 and 7!");
            }
        }
    }
   
    public void showContacts(){
        ArrayList<Contact> contacts = this.controller.getContactList();
        System.out.println();
        System.out.println("Full Name\t\tPhone\t\tEmail\t\t\tAddress");
        System.out.println("------------------------------------------------------------------------------------");
        for(Contact ct: contacts)
        {
            System.out.println(ct.toString());
        }
        System.out.println();
    }
    
    //if modify is true, it modifies an existing contact. If not, it creates a new one
    public void processCreation(Boolean modify){
        System.out.println();
        String oldName = "";
        if(modify)
        {
            System.out.println("Please enter name of contact to modify");
            oldName = this.inScanner.nextLine();
        }
        System.out.println("Please enter full name");
        String name = this.inScanner.nextLine();
        System.out.println("Please enter phone number");
        String phone = this.inScanner.nextLine();
        String email = "";
        while(true)
        {
            System.out.println("Please enter email address");
            email = this.inScanner.nextLine();
            if(email.indexOf("@")>0)
                break;
            else
                System.out.println("***Ivalid email address!***");
        }
        System.out.println("Please enter street address");
        String address = this.inScanner.nextLine();
        
        if(modify)
            this.controller.modifyContactsbyName(oldName, name, phone, email, address);
        else
            this.controller.createNewContact(name, phone, email, address);
        
        System.out.println("Transaction successful");
        System.out.println();
    }
   
    public void processSearchByName(){
        System.out.println();
        System.out.println("Please enter name to search");
        String name = this.inScanner.nextLine();
        Contact foundCont = this.controller.searchContactsbyName(name);
        if(foundCont != null)
        {
            System.out.println("Full Name\t\tPhone\t\tEmail\t\t\tAddress");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println(foundCont.toString());
        }
        else
            System.out.println("***Contact not found!***");
        System.out.println();
    }
   
    public void processSearchByPhone(){
        System.out.println();
        System.out.println("Please enter phone number to search");
        String phone = this.inScanner.nextLine();
        Contact foundCont = this.controller.searchContactbyPhone(phone);
        if(foundCont != null)
        {
            System.out.println("Full Name\t\tPhone\t\tEmail\t\t\tAddress");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println(foundCont.toString());
        }
        else
            System.out.println("***Contact not found!***");
        System.out.println();
    }

    //calls process creation with modify = true
    public void processModification(){
        this.processCreation(true);
    }
    
    public void processDelete(){
        System.out.println();
        System.out.println("Please enter name of contact to delete");
        String name = this.inScanner.nextLine();
        this.controller.deleteContactbyName(name);
        System.out.println("Transaction successful");
        System.out.println();
    }

    public void processExit(){
        System.out.println();
        System.out.println("Saving contacts...");
        if(this.controller.saveAndExit())
        {
            System.out.println("Transaction successful");
            System.out.println("Closing...");
        }
        else
            System.out.println("***Could not save contacts!***");
        System.out.println();
    }
}