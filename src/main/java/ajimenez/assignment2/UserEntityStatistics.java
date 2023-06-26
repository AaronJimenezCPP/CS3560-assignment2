/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

/**
 *
 * @author notwj
 */
public class UserEntityStatistics {
    private String type = "-";
    private String id = "-";
    private String displayName = "-";
    private int followers = -1;
    private int following = -1;
    private int messages = -1;
    private double positivePercentage = -1;
    
    public UserEntityStatistics() {
        
    }
    
    public void setType(String newType) {
        this.type = newType;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setId(String newId) {
        this.id = newId;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setDisplayName(String newDisplayName) {
        this.displayName = newDisplayName;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public void setFollowers(int newFollowers) {
        this.followers = newFollowers;
    }
    
    public int getFollowers() {
        return this.followers;
    }
    
    public void setFollowing(int newFollowing) {
        this.following = newFollowing;
    }
    
    public int getFollowing() {
        return this.following;
    }
    
    public void setMessages(int newMessages) {
        this.messages = newMessages;
    }
    
    public int getMessages() {
        return this.messages;
    }
    
    public void setPositivePercentage(double newPositivePercentage) {
        this.positivePercentage = newPositivePercentage;
    }
    
    public double getPositivePercentage() {
        return this.positivePercentage;
    }
}
