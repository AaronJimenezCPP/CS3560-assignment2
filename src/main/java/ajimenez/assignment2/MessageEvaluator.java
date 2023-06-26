/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

/**
 *
 * @author notwj
 */

// Used to evaluate message sentiment
public class MessageEvaluator {
    public static String[] keywords = {
        "good",
        "great",
        "awesome",
        "love",
        "wonderful",
        "excellent",
        "amazing",
        "fond",
        "outstanding",
        "talented",
        "enjoy",
        "satisfying",
        "tasty",
        "yum",
        "beautiful"
    };
    
    public static boolean isPositive(String msg) {
        for (String keyword : keywords) {
            if (msg.contains(keyword)) {
                return true;
            }
        }
        
        return false;
    }
}
