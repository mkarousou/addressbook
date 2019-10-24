/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import java.io.Serializable;

/**
 *
 * @author mkarousou
 */
public class Contact implements Serializable {
    private String name;
    private String phone;
    private String email;
    private String address;
    
    public Contact (String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    
    public String getName (){
        return this.name;
    }  
    
    public String getPhone (){
        return this.phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
    
    public void setName (String name){
        this.name = name;  
    }
    
    public void setPhone (String phone){
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + "\t" + phone + "\t" + email + "\t" + address;
    }
}
