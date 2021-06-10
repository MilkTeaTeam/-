/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package student;

import csdemo.DBCon;
import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class PnlStuDetail extends javax.swing.JPanel {
    String stuId;
    Vector<Vector> data;
    /**
     * Creates new form PnlStuDetail
     */
    public PnlStuDetail() {
        initComponents();
    }
    public PnlStuDetail(String stuId) {
        initComponents();
        this.stuId=stuId;
        txtStuId.setText(stuId);
        //根据学号查询该学生的详细信息并显示
        data=DBCon.queryData("Select * from Student where stuId='"+stuId+"'");
        Vector line =(Vector)data.get(0);
        txtStuName.setText(line.get(1).toString());
        if(line.get(2).toString().equals("男")){
            radMan.setSelected(true);
        }else{
            radWoman.setSelected(true);
        }
        txtBirth.setText(line.get(3).toString());
        //学号不可以修改的，禁用
        txtStuId.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrpSex = new javax.swing.ButtonGroup();
        lblStuId = new javax.swing.JLabel();
        txtStuId = new javax.swing.JTextField();
        lblStuName = new javax.swing.JLabel();
        txtStuName = new javax.swing.JTextField();
        lblSex = new javax.swing.JLabel();
        radMan = new javax.swing.JRadioButton();
        radWoman = new javax.swing.JRadioButton();
        lblBirth = new javax.swing.JLabel();
        txtBirth = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        lblStuId.setText("学号");

        lblStuName.setText("姓名");

        lblSex.setText("性别");

        btngrpSex.add(radMan);
        radMan.setText("男");

        btngrpSex.add(radWoman);
        radWoman.setText("女");

        lblBirth.setText("生日");

        btnSave.setText("修改");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("取消");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStuName)
                                .addGap(18, 18, 18)
                                .addComponent(txtStuName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSex)
                                .addGap(18, 18, 18)
                                .addComponent(radMan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radWoman))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStuId)
                                .addGap(18, 18, 18)
                                .addComponent(txtStuId, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBirth)
                                .addGap(18, 18, 18)
                                .addComponent(txtBirth))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStuId)
                    .addComponent(txtStuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStuName)
                    .addComponent(txtStuName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSex)
                    .addComponent(radMan)
                    .addComponent(radWoman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBirth))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        //获取用户输入的数据(修改后的数据)
        String stuName=txtStuName.getText();
        String birth=txtBirth.getText();
        String sex="";
        
        if(radMan.isSelected()){
            sex="男";
        }else if(radWoman.isSelected()){
            sex="女";
        }
        
        String sql="update Student set stuName='"+stuName+"',sex='"+sex
                +"',birth='"+birth+"' where stuId='"+stuId+"'";
        if(DBCon.updateData(sql)){
            JOptionPane.showMessageDialog(null, "修改数据成功","系统信息",JOptionPane.INFORMATION_MESSAGE);
            returnStuQuery();
            
        }else{
            JOptionPane.showMessageDialog(null, "修改数据失败","系统信息",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        returnStuQuery();
    }//GEN-LAST:event_btnCancelActionPerformed
    
    void returnStuQuery(){
        //--3 清空面板父类容器(内容面板)的所有组件
        JPanel pnl=(JPanel)this.getParent();
        pnl.removeAll();
        //--4 加载PnlStuQuery面板（学生详细信息面板）
        PnlStuQuery pnlStuQuery=new PnlStuQuery();
        //--5 设置当前内容面板的布局为边框式布局
        pnl.setLayout(new BorderLayout());
        //--6 加载学生详细信息的面板
        pnl.add(pnlStuQuery,BorderLayout.CENTER);
        //--7 刷新窗口
        pnl.getParent().validate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup btngrpSex;
    private javax.swing.JLabel lblBirth;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblStuId;
    private javax.swing.JLabel lblStuName;
    private javax.swing.JRadioButton radMan;
    private javax.swing.JRadioButton radWoman;
    private javax.swing.JTextField txtBirth;
    private javax.swing.JTextField txtStuId;
    private javax.swing.JTextField txtStuName;
    // End of variables declaration//GEN-END:variables
}