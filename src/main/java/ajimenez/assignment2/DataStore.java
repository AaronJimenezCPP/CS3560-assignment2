/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

import java.util.Map;

/**
 *
 * @author notwj
 */

// All data access in this application uses this interface
// Allows for differnt kinds of data storage implementations
public interface DataStore {
    public UserEntity getRoot();
    public Map<String, Message> getMessages();
    public Map<String, UserEntity> getUsers();
    public Message getMessage(String messageId);
    public UserEntity getUser(String userId);
    public void addUser(UserEntity user);
    public void addMessage(Message message);
}
