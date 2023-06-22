/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author User
 */
public class User {
      private String userID; 
      private String email;
      private String password;
      private String name;
      private String position;
      
    public User(String userID, String email, String password, String name, String position){
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.name = name;
        this.position = position;
}

    public User() {
    }
    
    public String getName() {
        return name;
    }   
    
    public String getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPosition() {
        return position;
    }
    
    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", email=" + email + ", password=" + password + ", name=" + name + ", position=" + position + '}';
    }
}
