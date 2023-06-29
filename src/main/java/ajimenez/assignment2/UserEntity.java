/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;

/**
 *
 * @author notwj
 */

// Class for users and user groups
// Follows the composite design pattern
public abstract class UserEntity {
    private String id;
    private UserEntity parent;
    private String displayName;
    private final long creationTime = System.currentTimeMillis();
    private long lastUpdateTime  = creationTime;
    
    protected DataStore data;
    
    public UserEntity(String id, DataStore data) {
        this.id = id;
        this.displayName = id;
        this.data = data;
    }
    
    public UserEntity(String id, UserEntity parent, DataStore data) {
        this.id = id;
        this.parent = parent;
        this.displayName = id;
        this.data = data;
    }
    
    public UserEntity(String id, String displayName, DataStore data) {
        this.id = id;
        this.displayName = displayName;
        this.data = data;
    }
    
    public UserEntity(String id, UserEntity parent, String displayName, DataStore data) {
        this.id = id;
        this.parent = parent;
        this.displayName = displayName;
        this.data = data;
    }
    
    public String getId() {
        return this.id;
    }
    
    public final void setId(String newId) {
        this.id = newId;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public void setDisplayName(String newDisplayName) {
        this.displayName = newDisplayName;
        this.updateLastUpdateTime();
    } 
    
    protected UserEntity getParent() {
        return this.parent;
    }
    
    protected void setParent(UserGroup newParent) {
        this.parent = newParent;
    }
    
    public List<UserEntity> getChildren() {
        return new ArrayList();
    }
    
    public long getCreationTime() {
        return this.creationTime;
    }
    
    public void updateLastUpdateTime() {
        this.lastUpdateTime = System.currentTimeMillis();
    }
    
    public long getLastUpdateTime() {
        return this.lastUpdateTime;
    }
    
    public abstract void accept(UserEntityVisitor visitor);
    
    public abstract Icon getIcon(boolean expanded);
    
    public abstract void addUserEntity(UserEntity newUserEntity);
    
    public abstract UserEntityStatistics getStatistics();
}
