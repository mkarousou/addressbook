package addressbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author mkarousou
 */

//Controller class. Implements all major functionality
public class ContactController {
    
    private ArrayList<Contact> contactList;
    
    public ContactController () throws IOException, ClassNotFoundException{
        this.contactList = new ArrayList<Contact>();
        
        //load contact list from file
        FileInputStream fis = new FileInputStream("contacts.addr");
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.contactList = (ArrayList)ois.readObject();
        ois.close();
        fis.close();
    }
    
    public ArrayList<Contact> getContactList(){
        return this.contactList;
    }
    
    //creates new contact and adds it to contactlist
    public void createNewContact (String name, String phone, String email, String address){
        Contact newcont = new Contact (name, phone, email, address);
        this.contactList.add(newcont);    
    }
    
    //returns null object if contact not found
    public Contact searchContactsbyName(String name){
        for (int i = 0; i < contactList.size(); i++){
            Contact cnt = contactList.get(i);
            
            if (name.equals(cnt.getName())){
                return cnt;
            }
        }
        return null;
    }
    
    //returns null object if contact not found
    public Contact searchContactbyPhone(String phone){
        for (int i = 0; i < contactList.size(); i++){
            Contact cnt = contactList.get(i);
            
            if(phone.equals(cnt.getPhone())){
                return cnt;
            }
        }
        return null;
    }
    
    //finds contact
    public void modifyContactsbyName(String name, String newName, String phone, String email, String address){
        for (int i = 0; i < contactList.size(); i++){
            Contact cnt = contactList.get(i);
            
            //if contact found, modify
            if (name.equals(cnt.getName())){
                cnt.setName(newName);
                cnt.setPhone(phone);
                cnt.setEmail(email);
                cnt.setAddress(address);   
                break;
            }
        }    
    } 
    
    //finds contact and removes it from contactlist
    public void deleteContactbyName(String name){
        for (int i = 0; i < contactList.size(); i++){
            Contact cnt = contactList.get(i);
            
            if (name.equals(cnt.getName())){
                contactList.remove(i);
            }
        }
    }
    
    //opens file and saves contactlist
    public boolean saveAndExit(){
        try{
            FileOutputStream fos = new FileOutputStream("contacts.addr");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(this.contactList);
            oos.close();
            fos.close();
            return true;
        }catch(IOException ioe){
            return false;
        }
    }
}