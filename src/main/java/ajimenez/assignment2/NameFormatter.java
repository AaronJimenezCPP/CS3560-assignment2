/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

/**
 *
 * @author notwj
 */

// Properly formats names according to set rules
// Implements the visitor pattern
public class NameFormatter implements UserEntityVisitor {
    @Override
    // Replace spaces with underscores
    public void visit(UserGroup user) {
        String newId = user.getId();
        newId = newId.replace(" ", "_");
        user.setId(newId);
    }

    @Override
    // Remove all non alphanumeric 
    public void visit(User user) {
        String newId = user.getId();
        newId = newId.replaceAll("[^a-zA-Z0-9_]", "");
        user.setId(newId);
    }
}
