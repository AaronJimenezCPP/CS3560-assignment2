/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author notwj
 */

// A concrete implementation of DataStore
// This version has no persistence and stores everything in RAM
// Uses the singleton design pattern
public class MemoryDataStore implements DataStore {
    private final UserEntity root;
    private final Map<String, Message> messages = new HashMap();
    private final Map<String, UserEntity> users = new HashMap(); 
    
    // Singleton design
    private static final MemoryDataStore instance = new MemoryDataStore();
    public static MemoryDataStore getInstance() {
        return MemoryDataStore.instance;
    }
    
    private MemoryDataStore() {
        this.root = new UserGroup("root", instance);
        addUser(root);
    }
    
    @Override
    public UserEntity getRoot() {
        return root;
    }

    @Override
    public Map<String, Message> getMessages() {
        return new HashMap(this.messages);
    }

    @Override
    public Map<String, UserEntity> getUsers() {
        return new HashMap(this.users);
    }

    @Override
    public Message getMessage(String messageId) {
        return this.messages.get(messageId);
    }

    @Override
    public UserEntity getUser(String userId) {
        return this.users.get(userId);
    }

    @Override
    public void addUser(UserEntity user) {
        user.accept(new NameFormatter());
        if (users.containsKey(user.getId())) {
            System.out.println("User with id " + user.getId() + " already exist. Creating random ID.");
            user.setId(UUID.randomUUID().toString());
        }
        users.put(user.getId(), user);
    }

    @Override
    public void addMessage(Message message) {
        messages.put(message.getMessageId(), message);
    }
}
