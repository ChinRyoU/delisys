package deliverySystem;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author 20jz0134
 */

public class BoundaryPayments extends javax.swing.JFrame {
    ControldeliverySystem control;
    ControlOrder          controlorder;
    DefaultTableModel model;
    Employee manager;
    /**
     * Creates new form BoundaryPayments
     */
    public BoundaryPayments() {
        initComponents();
        initTableModel();
        ImageIcon icon = new ImageIcon("src/deliverySystem/icon/G06.png"); // アイコンファイルを指定
        setIconImage(icon.getImage());                //フレームにアイコン設定
        setTitle("元気屋");
    }
    public void setControl(ControldeliverySystem control, ControlOrder controlorder){
        this.control      = control;
        this.controlorder = controlorder;
    }
    public void initTableModel(){
        model = (DefaultTableModel)jTablePaymentStatus.getModel();
        DefaultTableCellRenderer leftCellRenderer = new DefaultTableCellRenderer();
        leftCellRenderer.setHorizontalAlignment(JLabel.LEFT);
        DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();
        centerCellRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTablePaymentStatus.getColumnModel().getColumn(1).setCellRenderer(leftCellRenderer);
        jTablePaymentStatus.getColumnModel().getColumn(2).setCellRenderer(leftCellRenderer);
        jTablePaymentStatus.getColumnModel().getColumn(3).setCellRenderer(leftCellRenderer);
        jTablePaymentStatus.getColumnModel().getColumn(4).setCellRenderer(centerCellRenderer);
        
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
        jLabelManager = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldOrderNum = new javax.swing.JTextField();
        jButtonConfirm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePaymentStatus = new javax.swing.JTable();
        jButtonSend = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jButtonNotPayment = new javax.swing.JButton();
        jButtonAll = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonShowAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("MS UI Gothic", 1, 24)); // NOI18N
        jLabel1.setText("入金登録");

        jLabelManager.setText("???さん、こんにちは");

        jLabel3.setText("注文番号");

        jButtonConfirm.setText("確認");
        jButtonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmActionPerformed(evt);
            }
        });

        jTablePaymentStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "注文番号", "請求金額", "注文日時", "入金状況"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTablePaymentStatus);
        if (jTablePaymentStatus.getColumnModel().getColumnCount() > 0) {
            jTablePaymentStatus.getColumnModel().getColumn(3).setCellRenderer(null);
        }

        jButtonSend.setText("送信");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        jButtonBack.setText("戻る");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonNotPayment.setText("未入金");
        jButtonNotPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNotPaymentActionPerformed(evt);
            }
        });

        jButtonAll.setText("すべて");
        jButtonAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAllActionPerformed(evt);
            }
        });

        jButtonCancel.setText("取消");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonShowAll.setText("一覧表示");
        jButtonShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelManager, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAll, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldOrderNum)
                                        .addGap(31, 31, 31)
                                        .addComponent(jButtonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonNotPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonShowAll)))
                                .addGap(18, 18, 18)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelManager)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldOrderNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfirm)
                    .addComponent(jButtonNotPayment)
                    .addComponent(jButtonShowAll))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButtonAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSend)
                    .addComponent(jButtonBack))
                .addGap(29, 29, 29))
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

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        // TODO add your handling code here:
        int send_cnt = 0;
        for(int i = 0; i < model.getRowCount(); i++){
            if((boolean)jTablePaymentStatus.getModel().getValueAt(i, 0) && jTablePaymentStatus.getModel().getValueAt(i, 4).equals("×")){
                Date paymentTime = Date.valueOf(LocalDate.now());
                send_cnt += controlorder.updateorders(paymentTime, manager.getEmployee_no(), (String)jTablePaymentStatus.getModel().getValueAt(i, 1)); 
                jTablePaymentStatus.getModel().setValueAt("〇", i, 4);
            }
        }
        JOptionPane.showMessageDialog(this, send_cnt + "件を更新しました。", "確認",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void jButtonNotPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNotPaymentActionPerformed
        // TODO add your handling code here:
        List<Order> orders = controlorder.getOrderdata();
        
        model.setRowCount(0);
        for(int i = 0; i < orders.size(); i++){
            if(orders.get(i).getEmployeeNo() == null){
                Order order = orders.get(i);
                //int request_price = order.getRequestPrice();
                Timestamp ts = order.getOrderDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                String str = sdf.format(ts);
                Object[] productdata = {false, order.getOrderNum(), order.getRequestPrice(), str,"×"};
                model.addRow(productdata);
            }
        }
       
    }//GEN-LAST:event_jButtonNotPaymentActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        control.closeBoundaryPayments();
    }//GEN-LAST:event_jButtonBackActionPerformed

    public void setManager(Employee manager){
        this.manager = manager;
        jLabelManager.setText(manager.getName() + "さん、こんにちは。");
    }
    
    public void removeMessage(){
        jTextFieldOrderNum.setText("");
        model.setRowCount(0);
    }
    
            
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        control.closeBoundaryPayments();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmActionPerformed
        // TODO add your handling code here:
        if(jTextFieldOrderNum.getText().equals("")){
            model.setRowCount(0);
            //JOptionPane.showMessageDialog(this, "注文番号を入力してください。", "エラー",JOptionPane.ERROR_MESSAGE);
        }
        else{
            try{
                model.setRowCount(0);
                List<Order> orders = controlorder.getOrdernum(jTextFieldOrderNum.getText());
                for(int i = 0; i < orders.size(); i++){
                    Order order = orders.get(i);
                    //int request_price = order.getRequestPrice();
                    Timestamp ts = order.getOrderDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                    String str = sdf.format(ts);
                    String paymentstate = "";
                    if(orders.get(i).getEmployeeNo() == null){
                        paymentstate = "×";
                    }else{
                        paymentstate = "〇";
                    }   
                    Object[] productdata = {false, order.getOrderNum(), order.getRequestPrice(), str, paymentstate};
                    model.addRow(productdata);
                    jTextFieldOrderNum.setText("");
                }
            }           
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "注文番号がありません。", "エラー",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonConfirmActionPerformed

    private void jButtonAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAllActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i < model.getRowCount(); i++){
            model.setValueAt(true, i, 0);
        }
    }//GEN-LAST:event_jButtonAllActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i < model.getRowCount(); i++){
            model.setValueAt(false, i, 0);
        }
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowAllActionPerformed
        // TODO add your handling code here:
        List<Order> orders = controlorder.getOrderAll();
        
        model.setRowCount(0);
        for(int i = 0; i < orders.size(); i++){
            Order order = orders.get(i);
            //int request_price = order.getRequestPrice();
            Timestamp ts = order.getOrderDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            String str = sdf.format(ts);
            String paymentstate = "";
            if(orders.get(i).getEmployeeNo() == null){
                paymentstate = "×";
            }else{
                paymentstate = "〇";
            }   
            Object[] productdata = {false, order.getOrderNum(), order.getRequestPrice(), str, paymentstate};
            model.addRow(productdata);

        }
    }//GEN-LAST:event_jButtonShowAllActionPerformed

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
            java.util.logging.Logger.getLogger(BoundaryPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoundaryPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoundaryPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoundaryPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoundaryPayments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAll;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JButton jButtonNotPayment;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JButton jButtonShowAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelManager;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePaymentStatus;
    private javax.swing.JTextField jTextFieldOrderNum;
    // End of variables declaration//GEN-END:variables
}