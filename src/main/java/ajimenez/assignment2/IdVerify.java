/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author notwj
 */

// Used to verify that all user id's are valid
public class IdVerify {
    public static boolean isAllValid(DataStore data) {
        Set<String> seenIds = new HashSet(); 
        for (UserEntity user : data.getUsers().values()) {
            if (seenIds.contains(user.getId())) return false;
            seenIds.add(user.getId());
            
            if (user.getId().matches("\\s")) return false;
        }
        
        return true;
    }
}
