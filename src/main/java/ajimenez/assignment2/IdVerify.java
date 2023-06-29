/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

/**
 *
 * @author notwj
 */
public class IdVerify {
    public static boolean isValid(String id, DataStore data) {
        if (id.matches("\\s")) return false;
        else if (data.getUser(id) != null) return false;
        else return true;
    }
    
    public static boolean isAllValid(DataStore data) {
        for (UserEntity user : data.getUsers().values()) {
            if (!isValid(user.getId(), data)) return false;
        }
        
        return true;
    }
}
