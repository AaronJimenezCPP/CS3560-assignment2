/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.UIManager;

/**
 *
 * @author notwj
 */

// Actual user accounts
public class User extends UserEntity {
    private final Set<String> followers = new HashSet();
    private final Set<String> following = new HashSet();
    private final List<String> feed = new ArrayList();
    private final List<String> messages = new ArrayList();
    
    public User(String id, DataStore data) {
        super(id, data);
    }
    
    public User(String id, UserEntity parent, DataStore data) {
        super(id, parent, data);
    }
    
    public User(String id, String displayName, DataStore data) {
        super(id, displayName, data);
    }
    
    public User(String id, UserEntity parent, String displayName, DataStore data) {
        super(id, parent, displayName, data);
    }
    
    @Override
    // Add to parent folder instead
    public void addUserEntity(UserEntity newUserEntity) {
        this.getParent().addUserEntity(newUserEntity);
    }
    
    @Override
    public Icon getIcon(boolean expanded) {
        return UIManager.getIcon("FileView.fileIcon");
    }
    
    @Override
    // Custom fill statistcs for display on AdminControlPanel
    public UserEntityStatistics getStatistics() {
        int positiveCount = 0;
        for (String messageId : this.getMessages()) {
            Message message = data.getMessage(messageId);
            if (MessageEvaluator.isPositive(message.getContent())) {
                positiveCount++;
            }
        }
        
        UserEntityStatistics stats = new UserEntityStatistics();
        stats.setType(this.getClass().getSimpleName());
        stats.setId(this.getId());
        stats.setDisplayName(this.getDisplayName());
        stats.setFollowers(this.followers.size());
        stats.setFollowing(this.following.size());
        stats.setMessages(this.messages.size());
        stats.setPositivePercentage((double)positiveCount / (double)this.getMessages().size());
        return stats;
    }
    
    @Override
    public void accept(UserEntityVisitor visitor) {
        visitor.visit(this);
    }
    
    public Set<String> getFollowers() {
        return new HashSet(this.followers);
    }
    
    // Add to this user's following and following user's followers
    // No "addFollower" necessary
    public void addFollowing(String userId) {
        if (this.following.contains(userId)) {
            System.out.println("Already following.");
        }
        else if (userId.equals(this.getId())) {
            System.out.println("A user cannot follow itself.");
        }
        else if (data.getUser(userId) == null || !data.getUser(userId).getClass().getSimpleName().equals("User")) {
            System.out.println("Not a valid user.");
        }
        else {
            this.following.add(userId);
            ((User)data.getUser(userId)).followers.add(this.getId());
        }
    }
    
    public void removeFollowing(String userId) {
        if (this.following.contains(userId)) {
            this.following.remove(userId);
            ((User)data.getUser(userId)).followers.remove(userId);
        }
        else {
            System.out.println("Not following.");
        }
    }
    
    public Set<String> getFollowing() {
        return new HashSet(this.following);
    }
    
    // Add a message to home feed on User View
    public void addToFeed(String messageId) {
        this.feed.add(messageId);
    }
    
    public List<String> getFeed() {
        return this.feed;
    }
    
    // Send message, add to home feeds, update open subscribed UserViews
    public void sendMessage(Message newMessage) {
        this.messages.add(newMessage.getMessageId());
        data.addMessage(newMessage);
        this.addToFeed(newMessage.getMessageId());
        for (String followerId : this.getFollowers()) {
            User followingUser = (User)data.getUser(followerId);
            followingUser.addToFeed(newMessage.getMessageId());
        }
        
        MessageObserver.update(newMessage);
    }
    
    public void sendMessage(String msgString) {
        Message newMessage = new Message(this.getId(), msgString);
        this.sendMessage(newMessage);
    }
    
    public List<String> getMessages() {
        return this.messages;
    }
}
