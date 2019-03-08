/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

/**
 *
 * @author ciano
 */
public class Manager {
    //Declare properties
    private String username;
    private String password;
    
    //Getters and setters
    public void setUsername(String username){
        if(this.username == ""){
            this.username = username;
        }
    }
        
    public String getUsername(){
        return username;
    }
    
    public void setPassword(String password){
        if(this.password == ""){
            this.password = password;
        }
    }
    
    public String getPassword(){
        return password;
    }
    
    public Manager(){
        this.username = "";
        this.password = "";
    }
    
    public Manager(String username, String password){
        this.username = username;
        this.password = password;
    }
}
