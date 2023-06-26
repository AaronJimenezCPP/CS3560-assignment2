/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author notwj
 */

// Uses observer pattern
// Makes it so that open user view home feeds are live updated
public class MessageObserver {
    public static Map<String, Set<UserView>> userViews = new HashMap();
    
    // Allows multiple observers to watch a single specific user id
    public static void addObserver(String followingId, UserView userView) {
        if (!userViews.containsKey(followingId)) {
            userViews.put(followingId, new HashSet());
        }
        
        userViews.get(followingId).add(userView);
    }
    
    public static void removeObserver(String followingId, UserView userView) {
        userViews.get(followingId).remove(userView);
    }
    
    // Update all observers listening to this message author id
    public static void update(Message message) {
        if (!userViews.containsKey(message.getAuthorId())) return;
        for (UserView userView : userViews.get(message.getAuthorId())) {
            userView.messageUpdate(message);
        }
    }
}
