/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import java.util.Scanner;

/**
 *
 * @author mkarousou
 */
public class ContactView {
    
   private ContactController controller;
   
   public ContactView(){
       this.controller = new ContactController();
   }
   
   public void mainLoop(){
        while(true) {
            System.out.println("Menu");
            System.out.println("1. View all contacts");
            System.out.println("2. Add new contact");
            System.out.println("3. Search contact by name");
            System.out.println("4. Search contact by phone");
            System.out.println("5. Modify contact by name");
            System.out.println("6. Delete contact by name");
            System.out.println("7. Exit");

            Scanner inScn = new Scanner(System.in);
            String input = inScn.nextLine();
            if(input.equals("1")){
                this.showContacts();
            }
            else if(input.equals("2")){
                this.processCreation();
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
       
   }
   
   public void processCreation(){
       
   }
   
   public void processSearchByName(){
       
   }
   
   public void processSearchByPhone(){
       
   }
   
   public void processModification(){
       
   }
   public void processDelete(){
       
   }
   
   public void processExit(){
       //TODO
   }
}
