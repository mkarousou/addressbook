/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import java.util.ArrayList;

/**
 *
 * @author mkarousou
 */
public class ContactController {
    
    private ArrayList<Contact> contactList;
    
    public ContactController (){
        this.contactList = new ArrayList<Contact>();
        Contact contact1 = new Contact ("Maria Karousou", "6995846785", "mkarousou@gmail.com", "Klemanso 16");
        this.contactList.add(contact1);
        Contact contact2 = new Contact ("Giorgos Tsatiris", "6989846385", "gtsatiris@gmail.com", "Neorion 20");
        this.contactList.add(contact2);
        Contact contact3 = new Contact ("Eleni Spyrou", "6973388761", "elenspyr@gmail.com", "Karatza 4");
        this.contactList.add(contact3);
        Contact contact4 = new Contact ("Dimitris Papadopoulos", "6932908702", "dimpapado@gmail.com", "Moutsopoulou 6");
        this.contactList.add(contact4);
    }
    
    public ArrayList<Contact> getContactList(){
        return this.contactList;
    }
    
    public void createNewContact (String name, String phone, String email, String address){
        Contact newcont = new Contact (name, phone, email, address);
        this.contactList.add(newcont);    
    }
    
    public Contact searchContactsbyName(String name){
        for (int i = 0; i < contactList.size(); i++){
            Contact cnt = contactList.get(i);
            
            if (name.equals(cnt.getName())){
                return cnt;
            }
        }
        return null;
    }
    
    public Contact searchContactbyPhone(String phone){
        for (int i = 0; i < contactList.size(); i++){
            Contact cnt = contactList.get(i);
            
            if(phone.equals(cnt.getPhone())){
                return cnt;
            }
        }
        return null;
    }
    
    public void modifyContactsbyName(String name, String newName, String phone, String email, String address){
        for (int i = 0; i < contactList.size(); i++){
            Contact cnt = contactList.get(i);
            
            if (name.equals(cnt.getName())){
                cnt.setName(newName);
                cnt.setPhone(phone);
                cnt.setEmail(email);
                cnt.setAddress(address);   
                break;
            }
        }    
    } 
    
    public void deleteContactbyName(String name){
        for (int i = 0; i < contactList.size(); i++){
            Contact cnt = contactList.get(i);
            
            if (name.equals(cnt.getName())){
                contactList.remove(i);
            }
        }
    }
    
    public boolean saveAndExit(){
        //TODO
        return true;
    }
}