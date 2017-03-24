/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cprassoc.solr.auth.forms;

import com.cprassoc.solr.auth.Frameable;
import com.cprassoc.solr.auth.SolrAuthActionController;
import com.cprassoc.solr.auth.forms.resources.Resources;
import com.cprassoc.solr.auth.model.HistoryVersion;
import com.cprassoc.solr.auth.model.SavedVersion;
import com.cprassoc.solr.auth.ui.SolrAuthMainWindow;
import com.cprassoc.solr.auth.util.Log;
import com.cprassoc.solr.auth.util.Utils;
import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author kevin
 */
public class HistoryViewerDialog extends BaseDialog {
    
    private HistoryVersion versions = null;
    private HashMap<String, String> treeHash = null;
    private Frameable frame = null;
    private String selectedKey = "";
    /**
     * Creates new form HistoryViewer
     */
    public HistoryViewerDialog(Frameable parent, boolean modal, HistoryVersion versions) {
        super(parent.getFrame(), modal);
        this.versions = versions;
        this.frame = parent;
        initComponents();
    }
    
    private DefaultMutableTreeNode getRootNode() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("Saved Versions");
        treeHash = new HashMap<>();
        if (versions != null) {
            Iterator<String> iter = versions.getHistory().keySet().iterator();
            SavedVersion v;
            String key;
            while (iter.hasNext()) {
                key = iter.next();
                v = versions.getHistory().get(key);
                DefaultMutableTreeNode cnode = new DefaultMutableTreeNode(v.getTitle());
                
                node.add(cnode);
                treeHash.put(v.getTitle(), key);
            }
            
        }
        
      
        return node;
    }
    
    private void setCellRenderer(){
          DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(Resources.getNamedResourceIcon(Resources.Resource.XC_security_icon_small));
        renderer.setForeground(Color.white);
        renderer.setTextSelectionColor(Color.yellow);
        renderer.setTextNonSelectionColor(Color.white);
        this.versionTree.setCellRenderer(renderer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        versionTree = new JTree(getRootNode());
        setCellRenderer();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        rolesPane = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        userPane = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        permissionPane = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        descPanel = new javax.swing.JTextPane();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Version History");

        jButton1.setText("Load");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doLoadSelectedAction(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doCancelAction(evt);
            }
        });

        versionTree.setBackground(new java.awt.Color(0, 51, 102));
        versionTree.setForeground(new java.awt.Color(255, 255, 255));
        versionTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                doTreeNodeSelectedAction(evt);
            }
        });
        jScrollPane1.setViewportView(versionTree);

        jScrollPane2.setViewportView(jScrollPane1);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Users:");

        rolesPane.setEditable(false);
        rolesPane.setBackground(new java.awt.Color(0, 51, 102));
        rolesPane.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(rolesPane);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Permissions:");

        userPane.setEditable(false);
        userPane.setBackground(new java.awt.Color(0, 51, 102));
        userPane.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(userPane);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Roles");

        permissionPane.setEditable(false);
        permissionPane.setBackground(new java.awt.Color(0, 51, 102));
        permissionPane.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(permissionPane);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Description:");

        descPanel.setEditable(false);
        descPanel.setBackground(new java.awt.Color(0, 51, 102));
        descPanel.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane6.setViewportView(descPanel);

        jButton3.setText("Push to Solr");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doPushToSolrAction(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane4)
                                            .addComponent(jScrollPane5)
                                            .addComponent(jScrollPane3)
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))))
                                .addGap(49, 49, 49))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doTreeNodeSelectedAction(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_doTreeNodeSelectedAction
        // Log.log(getClass(), "Node selected: "+evt.toString());
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) versionTree.getLastSelectedPathComponent();
        
        if (node == null) //Nothing is selected.     
        {
            return;
        }
        
        if (node.isLeaf()) {
            Object nodeInfo = node.getUserObject();
            String key = treeHash.get((String) nodeInfo);
            SavedVersion version = versions.getHistory().get(key);
            Log.log("Selected Version: " + version.getTitle());
            this.userPane.setText(Utils.mapKeysToString(version.getSeucrityJson().getAuthentication().getCredentials()));
            this.permissionPane.setText(Utils.mapKeysToString(version.getSeucrityJson().getAuthorization().getPermissions().get(0)));
            this.rolesPane.setText(Utils.mapValuesToString(version.getSeucrityJson().getAuthorization().getUserRoles()));
            this.descPanel.setText(version.getDescription());
            this.selectedKey = key;
        }        
    }//GEN-LAST:event_doTreeNodeSelectedAction

    private void doCancelAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doCancelAction
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_doCancelAction

    private void doLoadSelectedAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doLoadSelectedAction
        
        frame.fireAction(SolrAuthActionController.SolrManagerAction.load_a_version, null, selectedKey);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_doLoadSelectedAction

    private void doPushToSolrAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doPushToSolrAction
          frame.fireAction(SolrAuthActionController.SolrManagerAction.push_a_version, null, selectedKey);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_doPushToSolrAction

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
            java.util.logging.Logger.getLogger(HistoryViewerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryViewerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryViewerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryViewerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HistoryViewerDialog dialog = new HistoryViewerDialog(new SolrAuthMainWindow(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane descPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane permissionPane;
    private javax.swing.JTextPane rolesPane;
    private javax.swing.JTextPane userPane;
    private javax.swing.JTree versionTree;
    // End of variables declaration//GEN-END:variables
}
