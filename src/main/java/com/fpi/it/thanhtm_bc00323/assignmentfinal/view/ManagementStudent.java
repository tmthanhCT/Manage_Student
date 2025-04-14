package com.fpi.it.thanhtm_bc00323.assignmentfinal.view;

import com.fpi.it.thanhtm_bc00323.assignmentfinal.controller.SortController;
import com.fpi.it.thanhtm_bc00323.assignmentfinal.controller.StudentController;
import com.fpi.it.thanhtm_bc00323.assignmentfinal.model.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;

public class ManagementStudent extends javax.swing.JFrame {

    private StudentController controller = new StudentController();
    private DefaultTableModel model;
    private Map<String, Student> students;

    public ManagementStudent() {
        initComponents();
        initializeComponents();
    }

    private void initializeComponents() {
        students = new HashMap<>();
        model = new DefaultTableModel(new String[]{"ID", "Name", "Course", "Major", "Class", "Average Score", "Rank"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableStudents.setModel(model);

        controller.loadStudentsFromFile();
        controller = new StudentController(students, model);

        cboMajor.removeAllItems();
        cboMajor.addItem("IT");
        cboMajor.addItem("Business");
        cboMajor.addItem("Graphic Design");

        cboCourse.removeAllItems();
        cboCourse.addItem("K8");
        cboCourse.addItem("K7");
        cboCourse.addItem("K6");


        cboMajor.addActionListener(e -> {
            String selectedMajor = (String) cboMajor.getSelectedItem();
            updateSubjectsByMajor(selectedMajor);
        });

        tableStudents.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                displaySelectedStudent();
            }
        });

        updateSubjectsByMajor(cboMajor.getSelectedItem().toString());
        tableStudents.repaint();

    }

    private void updateSubjectsByMajor(String major) {
        if (major == null) {
            return;
        }

        lbSubject1.setText("");
        lbSubject2.setText("");
        lbSubject3.setText("");
        txtGrade.setText("");
        txtGrade1.setText("");
        txtGrade2.setText("");

        switch (major) {
            case "IT" -> {
                lbSubject1.setText("Java");
                lbSubject2.setText("Database");
                lbSubject3.setText("Networking");
            }
            case "Business" -> {
                lbSubject1.setText("Marketing");
                lbSubject2.setText("Finance");
                lbSubject3.setText("Management");
            }
            case "Graphic Design" -> {
                lbSubject1.setText("Photoshop");
                lbSubject2.setText("Illustrator");
                lbSubject3.setText("3D Modeling");
            }
            default ->
                System.out.println("Unknown major: " + major);
        }
    }

    private void displaySelectedStudent() {
        int selectedRow = tableStudents.getSelectedRow();
        if (selectedRow >= 0) {
            String id = model.getValueAt(selectedRow, 0).toString();
            Student student = students.get(id);

            if (student != null) {
                txtIDStudent.setText(student.getId());
                txtName.setText(student.getName());
                cboCourse.setSelectedItem(student.getCourse());
                txtClass.setText(student.getClassName());
                cboMajor.setSelectedItem(student.getMajor());

                txtGrade.setText(String.valueOf(student.getSubjectScore(lbSubject1.getText())));
                txtGrade1.setText(String.valueOf(student.getSubjectScore(lbSubject2.getText())));
                txtGrade2.setText(String.valueOf(student.getSubjectScore(lbSubject3.getText())));
            }
        }
    }

    private void clearFields() {
        txtIDStudent.setText("");
        txtName.setText("");
        cboCourse.setSelectedIndex(0);
        txtClass.setText("");
        txtGrade.setText("");
        txtGrade1.setText("");
        txtGrade2.setText("");

        controller.loadTableData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbSubject1 = new javax.swing.JLabel();
        txtIDStudent = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtClass = new javax.swing.JTextField();
        txtGrade = new javax.swing.JTextField();
        cboMajor = new javax.swing.JComboBox<>();
        btnEdit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStudents = new javax.swing.JTable();
        lbSubject2 = new javax.swing.JLabel();
        lbSubject3 = new javax.swing.JLabel();
        txtGrade1 = new javax.swing.JTextField();
        txtGrade2 = new javax.swing.JTextField();
        cboSortBy = new javax.swing.JComboBox<>();
        cboCourse = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("MANAGEMENT STUDENT");
        jLabel1.setToolTipText("jLabel1\n");
        jLabel1.setFocusable(false);
        jLabel1.setName(""); // NOI18N

        jLabel2.setText("ID Student");

        jLabel3.setText("Name");

        jLabel4.setText("Major");

        jLabel5.setText("Course");

        jLabel6.setText("Class");

        lbSubject1.setText("Java");
        lbSubject1.setToolTipText("");

        txtIDStudent.setName("txtIDStudent"); // NOI18N

        txtName.setName("txtName"); // NOI18N

        txtClass.setName("txtClass"); // NOI18N

        txtGrade.setName("txtGrade"); // NOI18N

        cboMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "Business", "Graphic Design" }));
        cboMajor.setName("cboMajor"); // NOI18N

        btnEdit.setText("Edit");
        btnEdit.setName("bntEdit"); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel8.setText("Search: ");

        txtSearch.setName("txtSearch"); // NOI18N

        btnSearch.setText("Search");
        btnSearch.setName("btnSearch"); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.setName("bntAdd"); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.setName("btnClear"); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tableStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Course", "Major", "Class", "Subjects", "Average score", "Rank"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableStudents.setName(""); // NOI18N
        jScrollPane1.setViewportView(tableStudents);

        lbSubject2.setText("Database");
        lbSubject2.setToolTipText("");

        lbSubject3.setText("Networking");
        lbSubject3.setToolTipText("");

        txtGrade1.setName("txtGrade"); // NOI18N

        txtGrade2.setName("txtGrade"); // NOI18N

        cboSortBy.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cboSortBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending name", "Descending name", "Average score ascending", "Average score descending" }));
        cboSortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSortByActionPerformed(evt);
            }
        });

        cboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K6", "K7", "K8", " " }));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDStudent)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(txtClass, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(cboMajor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnSave)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(42, 42, 42)
                                .addComponent(btnEdit)
                                .addGap(30, 30, 30)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnClear)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbSubject3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtGrade2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbSubject1)
                                        .addComponent(lbSubject2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtGrade1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtGrade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(cboSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(441, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDStudent)
                            .addComponent(btnAdd)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEdit)
                        .addComponent(btnDelete)
                        .addComponent(btnClear)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSubject1)
                            .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSubject2)
                        .addComponent(cboCourse))
                    .addComponent(txtGrade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSubject3)
                        .addComponent(txtGrade2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                    .addComponent(cboMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(btnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                            .addComponent(txtClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        txtIDStudent.getAccessibleContext().setAccessibleName("txtIDStudent");
        cboMajor.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String id = txtIDStudent.getText().trim();
            String name = txtName.getText().trim();
            String course = cboCourse.getSelectedItem().toString();
            String major = cboMajor.getSelectedItem().toString();
            String className = txtClass.getText().trim();

            double grade1 = Double.parseDouble(txtGrade.getText().trim());
            double grade2 = Double.parseDouble(txtGrade1.getText().trim());
            double grade3 = Double.parseDouble(txtGrade2.getText().trim());

            controller.addStudent(id, name, course, major, className,
                    lbSubject1.getText(), grade1, lbSubject2.getText(), grade2, lbSubject3.getText(), grade3);
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid grades for all subjects");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tableStudents.getSelectedRow();
        if (selectedRow >= 0) {
            String id = tableStudents.getValueAt(selectedRow, 0).toString();
            controller.deleteStudent(id);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to delete");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int selectedRow = tableStudents.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                String id = tableStudents.getValueAt(selectedRow, 0).toString();
                String name = txtName.getText().trim();
                String course = cboCourse.getSelectedItem().toString();
                String major = cboMajor.getSelectedItem().toString();
                String className = txtClass.getText().trim();

                double grade1 = Double.parseDouble(txtGrade.getText().trim());
                double grade2 = Double.parseDouble(txtGrade1.getText().trim());
                double grade3 = Double.parseDouble(txtGrade2.getText().trim());

                controller.editStudent(id, name, course, major, className,
                        lbSubject1.getText(), grade1, lbSubject2.getText(), grade2, lbSubject3.getText(), grade3);
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid grade format");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to edit");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void cboSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSortByActionPerformed
        SortController.sortStudents((String) cboSortBy.getSelectedItem(), students, model);
    }//GEN-LAST:event_cboSortByActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = txtSearch.getText().trim().toLowerCase();
        controller.searchStudents(keyword);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        controller.saveStudentsToFile();
    }//GEN-LAST:event_btnSaveActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ManagementStudent().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboCourse;
    private javax.swing.JComboBox<String> cboMajor;
    private javax.swing.JComboBox<String> cboSortBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSubject1;
    private javax.swing.JLabel lbSubject2;
    private javax.swing.JLabel lbSubject3;
    private javax.swing.JTable tableStudents;
    private javax.swing.JTextField txtClass;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextField txtGrade1;
    private javax.swing.JTextField txtGrade2;
    private javax.swing.JTextField txtIDStudent;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
