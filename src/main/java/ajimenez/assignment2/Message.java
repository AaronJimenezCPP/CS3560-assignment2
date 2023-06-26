/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

import java.util.UUID;

/**
 *
 * @author notwj
 */

// For user messages
// Always associated with a user. Given a random ID
public class Message {
    private final String authorId;
    private final String messageId;
    private String content;
    
    public Message(String authorId, String content) {
        this.messageId = UUID.randomUUID().toString();
        this.authorId = authorId;
        updateContent(content);
    }
    
    public String getAuthorId() {
        return this.authorId;
    }
    
    public String getMessageId() {
        return this.messageId;
    }
    
    final public void updateContent(String newContent) {
        this.content = newContent;
    }
    
    public String getContent() {
        return this.content;
    }
}
