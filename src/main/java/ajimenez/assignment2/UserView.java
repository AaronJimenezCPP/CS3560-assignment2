/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ajimenez.assignment2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author notwj
 */
public class UserView extends javax.swing.JFrame {
    private User user;
    private DataStore data;
    
    /**
     * Creates new form UserView
     */
    public UserView() {
        initComponents();
        System.err.println("Please run from Driver.java.");
    }
    
    public UserView(User user, DataStore data) {
        initComponents();
        this.data = data;
        this.user = user;
        
        updateHomePage();
        initMessageSubscriptions();
        onCloseSetup();
    }
    
    // Unsubscribe observers on close
    public final void onCloseSetup() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                unsubscribeAll();
            }
        });
    }
    
    // Update home page with user's information
    public final void updateHomePage() {
        // User stats
        Username.setText(user.getDisplayName() + " (" + user.getId() + ")");
        Followers.setText("<html><b>Followers: </b>" + user.getFollowers().size());
        Following.setText("<html><b>Following: </b>" + user.getFollowing().size());
        Messages.setText("<html><b>Messages: </b>" + user.getMessages().size());
        
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, h:mm:ss a");
        CreationTime.setText("<html><b>Creation Time: </b>" + sdf.format(new Date(user.getCreationTime())));
        LastUpdate.setText("<html><b>Last Update: </b>" + sdf.format(new Date(user.getLastUpdateTime())));
        
        // Following list
        List<String> followingListData = new ArrayList();
        for (String following : user.getFollowing()) {
            User thisUser = (User)data.getUser(following);
            followingListData.add(thisUser.getDisplayName() + " (" + thisUser.getId() + ")");
        }
        FollowingList.setListData(followingListData.toArray(String[]::new));
        
        // Home feed
        List<String> homefeedData = new ArrayList();
        for (String messageId : user.getFeed()) {
            Message message = data.getMessage(messageId);
            User messageUser = (User)data.getUser(message.getAuthorId());
            homefeedData.add("<html><b>" + messageUser.getDisplayName() + " (" + messageUser.getId() + ")</b>: " + message.getContent());
        }
        HomeFeed.setListData(homefeedData.toArray(String[]::new));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Username = new javax.swing.JLabel();
        Followers = new javax.swing.JLabel();
        Following = new javax.swing.JLabel();
        Messages = new javax.swing.JLabel();
        FollowUserId = new javax.swing.JTextField();
        FollowUserIdButton = new javax.swing.JButton();
        HomeFeedScrollPane = new javax.swing.JScrollPane();
        HomeFeed = new javax.swing.JList<>();
        HomeFeedLabel = new javax.swing.JLabel();
        FollowingLabel = new javax.swing.JLabel();
        FollowingListScrollPane = new javax.swing.JScrollPane();
        FollowingList = new javax.swing.JList<>();
        MessageScrollPane = new javax.swing.JScrollPane();
        Message = new javax.swing.JTextArea();
        SendMessageButton = new javax.swing.JButton();
        MessageLabel = new javax.swing.JLabel();
        LastUpdate = new javax.swing.JLabel();
        CreationTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Username.setText("Username (User ID)");

        Followers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Followers.setText("<html><b>Followers:</b> 10");
        Followers.setToolTipText("");

        Following.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Following.setText("<html><b>Following:</b> 20");

        Messages.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Messages.setText("<html><b>Messages:</b> 5");

        FollowUserIdButton.setText("➕ Follow User");
        FollowUserIdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FollowUserIdButtonActionPerformed(evt);
            }
        });

        HomeFeed.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        HomeFeed.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        HomeFeedScrollPane.setViewportView(HomeFeed);

        HomeFeedLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HomeFeedLabel.setText("Home Feed");
        HomeFeedLabel.setToolTipText("");

        FollowingLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FollowingLabel.setText("Following");
        FollowingLabel.setToolTipText("");

        FollowingList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        FollowingList.setFixedCellWidth(178);
        FollowingListScrollPane.setViewportView(FollowingList);

        Message.setColumns(20);
        Message.setRows(5);
        MessageScrollPane.setViewportView(Message);

        SendMessageButton.setText("Send");
        SendMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendMessageButtonActionPerformed(evt);
            }
        });

        MessageLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MessageLabel.setText("Send Message");
        MessageLabel.setToolTipText("");

        LastUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LastUpdate.setText("<html><b>Last Update:</b> 10");
        LastUpdate.setToolTipText("");

        CreationTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CreationTime.setText("<html><b>Creation Time:</b> 10");
        CreationTime.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SendMessageButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MessageScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MessageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(FollowUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FollowUserIdButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HomeFeedScrollPane)
                                    .addComponent(HomeFeedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FollowingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(FollowingListScrollPane)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(Followers, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Following, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Messages, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(CreationTime, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LastUpdate))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Followers, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Following, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Messages, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreationTime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FollowUserIdButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FollowUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HomeFeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FollowingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HomeFeedScrollPane)
                    .addComponent(FollowingListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(MessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MessageScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SendMessageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Send a message as user. Will add to followers' home feeds
    private void SendMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendMessageButtonActionPerformed
        user.sendMessage(new Message(
                user.getId(),
                Message.getText()
        ));
        
        Message.setText("");
    }//GEN-LAST:event_SendMessageButtonActionPerformed

    // Subscribe to live updates on home feed
    public void subscribeToUserMessages(String userId) {
        MessageObserver.addObserver(userId, this);
    }
    
    public void unsubscribeToUserMessages(String userId) {
        MessageObserver.removeObserver(userId, this);
    }
    
    // Add self and following to live updates on home feed
    public final void initMessageSubscriptions() {
        subscribeToUserMessages(user.getId());
        for (String userId : user.getFollowing()) {
            subscribeToUserMessages(userId);
        }
    }
    
    // Unsubscribe everything
    public void unsubscribeAll() {
        unsubscribeToUserMessages(user.getId());
        for (String userId : user.getFollowing()) {
            unsubscribeToUserMessages(userId);
        }
    }
    
    // Called from observer update. Followed user or self sent message
    public void messageUpdate(Message message) {
        updateHomePage();
    }
    
    // Follow the user with the id provided in the input field
    private void FollowUserIdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FollowUserIdButtonActionPerformed
        String userIdToAdd = FollowUserId.getText();
        UserEntity userToAdd = data.getUser(userIdToAdd);
        if (userToAdd != null && "User".equals(userToAdd.getClass().getSimpleName())) {
            user.addFollowing(userToAdd.getId());
            updateHomePage();
        }
        
        subscribeToUserMessages(userIdToAdd);
        FollowUserId.setText("");
    }//GEN-LAST:event_FollowUserIdButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CreationTime;
    private javax.swing.JTextField FollowUserId;
    private javax.swing.JButton FollowUserIdButton;
    private javax.swing.JLabel Followers;
    private javax.swing.JLabel Following;
    private javax.swing.JLabel FollowingLabel;
    private javax.swing.JList<String> FollowingList;
    private javax.swing.JScrollPane FollowingListScrollPane;
    private javax.swing.JList<String> HomeFeed;
    private javax.swing.JLabel HomeFeedLabel;
    private javax.swing.JScrollPane HomeFeedScrollPane;
    private javax.swing.JLabel LastUpdate;
    private javax.swing.JTextArea Message;
    private javax.swing.JLabel MessageLabel;
    private javax.swing.JScrollPane MessageScrollPane;
    private javax.swing.JLabel Messages;
    private javax.swing.JButton SendMessageButton;
    private javax.swing.JLabel Username;
    // End of variables declaration//GEN-END:variables
}
