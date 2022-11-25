package com.company.resume.panel;

import com.company.resume.config.Config;
import com.company.resume.frame.AddEmpHistoryFrame;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.main.Context;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import javax.swing.JFrame;

public class EmploymentHistoryPanel extends javax.swing.JPanel {

    private EmploymentHistoryDaoInter empHistoryDao = Context.instanceEmploymentHistoryDao();
    private List<EmploymentHistory> empHistories;
    private EmploymentHistory empHistory;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private int index = 0;

    public EmploymentHistoryPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHistory = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        txtHeader = new javax.swing.JTextField();
        txtBeginDate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtEndDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaJobDesc = new javax.swing.JTextArea();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setText("/");

        txtAreaJobDesc.setColumns(20);
        txtAreaJobDesc.setRows(5);
        jScrollPane1.setViewportView(txtAreaJobDesc);

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHistoryLayout = new javax.swing.GroupLayout(pnlHistory);
        pnlHistory.setLayout(pnlHistoryLayout);
        pnlHistoryLayout.setHorizontalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistoryLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHistoryLayout.createSequentialGroup()
                        .addComponent(btnPrevious)
                        .addGap(36, 36, 36)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(pnlHistoryLayout.createSequentialGroup()
                        .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlHistoryLayout.createSequentialGroup()
                                .addComponent(txtBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(127, Short.MAX_VALUE))))
        );
        pnlHistoryLayout.setVerticalGroup(
            pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHistoryLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(pnlHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(btnDelete))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 1, Short.MAX_VALUE)
                    .addComponent(pnlHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fillUserComponents() {
        empHistories = empHistoryDao.getEmploymentHistoryByUserId(Config.loggedInUser.getId());
        empHistory = empHistories.get(index);
        String header = empHistory.getHeader();
        Date beginDate = empHistory.getBeginDate();
        Date endDate = empHistory.getEndDate();
        String jobDesc = empHistory.getJobDescription();

        txtHeader.setText(header);
        txtBeginDate.setText(sdf.format(beginDate));
        if (endDate == null) {
            txtEndDate.setText("-");
        } else {
            txtEndDate.setText(sdf.format(endDate));
        }
        txtAreaJobDesc.setText(jobDesc);
    }

    public void fillAndSwitchEmpHistory() {
        empHistories = empHistoryDao.getEmploymentHistoryByUserId(Config.loggedInUser.getId());
        if (index < empHistories.size() && index >= 0) {
            btnNext.setEnabled(true);
            btnPrevious.setEnabled(true);
            fillUserComponents();
        }
        if ((index - 1) < 0) {
            btnPrevious.setEnabled(false);
        }
        if ((index + 1) >= empHistories.size()) {
            btnNext.setEnabled(false);
        }
    }

    public void updateEmpHistory() {
        try {
            String header = txtHeader.getText();
            String beginDateStr = txtBeginDate.getText();
            String endDateStr = txtEndDate.getText();
            String jobDesc = txtAreaJobDesc.getText();
            Date beginDate = new Date(sdf.parse(beginDateStr).getTime());
            Date endDate;
            if (endDateStr.equals("-") || endDateStr.trim().equals("")) {
                endDate = null;
            } else {
                endDate = new Date(sdf.parse(endDateStr).getTime());
            }

            empHistory.setHeader(header);
            empHistory.setBeginDate(beginDate);
            empHistory.setEndDate(endDate);
            empHistory.setJobDescription(jobDesc);

            empHistoryDao.updateEmploymentHistory(empHistory);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddEmpHistoryFrame f = new AddEmpHistoryFrame("Add Employment History");
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        index++;
        fillAndSwitchEmpHistory();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        index--;
        fillAndSwitchEmpHistory();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        empHistoryDao.removeEmploymentHistory(empHistory.getId());
        fillAndSwitchEmpHistory();
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlHistory;
    private javax.swing.JTextArea txtAreaJobDesc;
    private javax.swing.JTextField txtBeginDate;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextField txtHeader;
    // End of variables declaration//GEN-END:variables
}
