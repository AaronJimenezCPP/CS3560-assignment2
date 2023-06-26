/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajimenez.assignment2;

/**
 *
 * @author notwj
 */
public class Driver {
    private static final DataStore data = MemoryDataStore.getInstance();
    
    public static void main(String[] args) {
        buildDummyData();
        setLookAndFeel();
        openAdminControlPanel();
    }
    
    private static void openAdminControlPanel() {
        AdminControlPanel window = new AdminControlPanel(data);
        window.setVisible(true);
    }
    
    // Set up some dummy data for easier testing
    private static void buildDummyData() {
        UserGroup root = (UserGroup)data.getRoot();
        
        User john = new User("john", "John Smith", data);
        User jane = new User("jane", "Jane Doe", data);
        User fred = new User("fred", "Fred Brown", data);
        
        User aaron = new User("ajimenez", "Aaron Jimenez", data);
        User yusun = new User("yusun", "Professor Yu Sun", data);
        
        root.addUserEntity(john);
        root.addUserEntity(jane);
        root.addUserEntity(fred);
        
        UserGroup admins = new UserGroup("admin users", "Admins", data);
        root.addUserEntity(admins);
        
        admins.addUserEntity(aaron);
        admins.addUserEntity(yusun);
        
        aaron.addFollowing(john.getId());
        aaron.addFollowing(jane.getId());
        aaron.addFollowing(fred.getId());
        aaron.addFollowing(yusun.getId());
        
        yusun.addFollowing(aaron.getId());
        
        john.addFollowing(jane.getId());
        jane.addFollowing(john.getId());
        
        fred.addFollowing(john.getId());
        fred.addFollowing(jane.getId());
        
        john.sendMessage("Hello, world! It's a beautiful day.");
        john.sendMessage("I had a great day with jane yesterday.");
        
        jane.sendMessage("First message! This platform will take some getting used to...");
        
        aaron.sendMessage("New update released!");
        
        fred.sendMessage("pls follow me");
    }
    
    // Use the nimbus style
    private static void setLookAndFeel() {
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
            java.util.logging.Logger.getLogger(AdminControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
}
