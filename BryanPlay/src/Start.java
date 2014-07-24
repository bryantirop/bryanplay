package bryanplay;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author kim
 */
public class Start extends javax.swing.JFrame {

    private JFileChooser filechooser;
    private javax.swing.filechooser.FileNameExtensionFilter filter;
    private MediaPlayer mediaplayer;
    private java.io.FileFilter filefilter;
    
    
    public Start() {
        initComponents();
        
        filechooser = new JFileChooser();
        filter = new javax.swing.filechooser.FileNameExtensionFilter("Music and Video", "mp3", "flv","mp4","wav","ogg","3gp","vob","mkv");
        
        filefilter = new java.io.FileFilter() {
            private final javax.swing.filechooser.FileNameExtensionFilter filter2 = filter;
            
            @Override
            public boolean accept(File file)
                {
                    return filter2.accept(file);
                }
            
        };
        
        this.mediaplayer = new MediaPlayer(this.canvas1);
        
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jMenuItem5 = new javax.swing.JMenuItem();
        playBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        pauseBtn = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        Volumebar = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        canvas2 = new java.awt.Canvas();
        jPanel1 = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        jCheckBox1 = new javax.swing.JCheckBox();
        nextBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openFile = new javax.swing.JMenuItem();
        openFolder = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();

        jButton2.setText("jButton2");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BryanPlay");
        setMinimumSize(new java.awt.Dimension(1000, 500));

        playBtn.setText("Play");
        playBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });

        stopBtn.setText("Stop");

        pauseBtn.setText("Pause");
        pauseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseBtnActionPerformed(evt);
            }
        });

        jSlider1.setMaximum(20000);
        jSlider1.setPaintLabels(true);
        jSlider1.setValue(0);

        jCheckBox2.setText("Repeat Current");

        jCheckBox3.setText("Loop");

        jLabel1.setText("Volume");

        Volumebar.setMaximum(150);
        Volumebar.setToolTipText("Adjust Volume");
        Volumebar.setValue(80);
        Volumebar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VolumebarStateChanged(evt);
            }
        });

        jLabel2.setText("0:00");

        durationLabel.setText("45:36");

        canvas1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCheckBox1.setText("Mute");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Back");

        jMenu1.setText("Media");

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFile.setText("Open File...");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        jMenu1.add(openFile);

        openFolder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        openFolder.setText("Open Folder...");
        openFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFolderActionPerformed(evt);
            }
        });
        jMenu1.add(openFolder);
        jMenu1.add(jSeparator1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Quit");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("View");

        jMenuItem3.setText("Playlist");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem6.setText("Help Contents");
        jMenu3.add(jMenuItem6);
        jMenu3.add(jSeparator2);

        jMenuItem7.setText("About BryanPlay");
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(durationLabel))
                            .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pauseBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextBtn)
                        .addGap(65, 65, 65)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Volumebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(durationLabel)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Volumebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(playBtn)
                                    .addComponent(stopBtn)
                                    .addComponent(pauseBtn)
                                    .addComponent(jCheckBox3)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(backBtn)
                                    .addComponent(nextBtn))))))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBtnActionPerformed
         final MediaPlayer mp = this.mediaplayer;
         
         new PlayThread(mp,this,PlayerSelect.BEGIN,null,null);
    }//GEN-LAST:event_playBtnActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        filechooser.setMultiSelectionEnabled(true);
        filechooser.setFileFilter(filter);
        
        int c = filechooser.showOpenDialog(this);
        if(c == JFileChooser.APPROVE_OPTION)
        {
            java.io.File files[] = filechooser.getSelectedFiles();
            for(java.io.File file:files)
            {
                this.mediaplayer.addFile(file.toString());
            }
            
            if(this.mediaplayer.playlist.isEmpty())
            {
                final MediaPlayer mp = this.mediaplayer;
                PlayThread pt = new PlayThread(mp,this,PlayerSelect.BEGIN,null,null);
            }
        }
        
    }//GEN-LAST:event_openFileActionPerformed

    private void VolumebarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_VolumebarStateChanged
        int value = Volumebar.getValue();
        this.mediaplayer.setVolume(value);
    }//GEN-LAST:event_VolumebarStateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        this.mediaplayer.mute();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void openFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFolderActionPerformed
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int c = filechooser.showOpenDialog(this);
        if(c == JFileChooser.APPROVE_OPTION)
        {
            java.io.File dir = filechooser.getSelectedFile();
            java.io.File files[] = dir.listFiles(filefilter);
            for(java.io.File f:files)
            {
                this.mediaplayer.addFile(f.toString());
            }
            
            if(this.mediaplayer.playlist.isEmpty())
            {
                final MediaPlayer mp = this.mediaplayer;
                PlayThread pt = new PlayThread(mp,this,PlayerSelect.BEGIN,null,null);
               
            }
            
            
        }
    }//GEN-LAST:event_openFolderActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        
    }//GEN-LAST:event_nextBtnActionPerformed

    private void pauseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pauseBtnActionPerformed

       
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Start().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider Volumebar;
    private javax.swing.JButton backBtn;
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas2;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton nextBtn;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem openFolder;
    private javax.swing.JButton pauseBtn;
    private javax.swing.JButton playBtn;
    private javax.swing.JButton stopBtn;
    // End of variables declaration//GEN-END:variables
}