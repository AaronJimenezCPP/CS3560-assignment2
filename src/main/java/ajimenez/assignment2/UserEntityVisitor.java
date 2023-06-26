/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

/**
 *
 * @author notwj
 */
public interface UserEntityVisitor {
    void visit (UserGroup user);
    void visit (User user);
}
