/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.UIManager;

/**
 *
 * @author notwj
 */

// For user group (folders)
public class UserGroup extends UserEntity {
    private final List<UserEntity> children = new ArrayList();
    
    public UserGroup(String id, DataStore data) {
        super(id, data);
    }
    
    public UserGroup(String id, UserEntity parent, DataStore data) {
        super(id, parent, data);
    }
    
    public UserGroup(String id, String displayName, DataStore data) {
        super(id, displayName, data);
    }
    
    public UserGroup(String id, UserEntity parent, String displayName, DataStore data) {
        super(id, parent, displayName, data);
    }
   
    @Override
    public void addUserEntity(UserEntity newUserEntity) {
        this.children.add(newUserEntity);
        newUserEntity.setParent(this);
        MemoryDataStore.getInstance().addUser(newUserEntity);
    }
    
    @Override
    public List<UserEntity> getChildren() {
        return this.children;
    }
    
    @Override
    public Icon getIcon(boolean expanded) {
        if (expanded) {
            return UIManager.getIcon("Tree.openIcon");
        }
        else {
            return UIManager.getIcon("Tree.closedIcon");
        }
    }
    
    @Override
    // Fill statistics for AdminControlPanel. Many fields left blank for groups
    public UserEntityStatistics getStatistics() {
        UserEntityStatistics stats = new UserEntityStatistics();
        stats.setType(this.getClass().getSimpleName());
        stats.setDisplayName(this.getDisplayName());
        stats.setId(this.getId());
        return stats;
    }
    
    @Override
    public void accept(UserEntityVisitor visitor) {
        visitor.visit(this);
    }
}
