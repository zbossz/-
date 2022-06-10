/*
 * Created by JFormDesigner on Sun Apr 24 21:05:09 CST 2022
 */

package UI.zzy;

import DAO.yx.SchoolList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

import static Utils.zzy.CommonData.*;

/**
 * @author 1
 */
public class ModifySchoolListDialog extends JDialog {
    public ModifySchoolListDialog(Window owner,int key) {
        super(owner);
        initComponents();
        if(key == 1){
            schoolIdtextField.setEditable(false);
            variableButton.setText("增加院校列表");
            findButton.setEnabled(false);
        }
        else if (key==2) {
            schoolIdtextField.setEditable(false);
            variableButton.setText("删除院校列表");
            tips.setText("可输入学校名称，然后通过查找按钮显示全部信息");
            findButton.setEnabled(true);
        }
        else if (key==3) {
            schoolIdtextField.setEditable(false);
            variableButton.setText("修改院校列表");
            tips.setText("可输入学校名称，然后通过查找按钮显示全部信息");
            findButton.setEnabled(true);
        }
    }

    private void variable(ActionEvent e) {
        if(variableButton.getText().equals("增加院校列表")){
            //院校列表除了招生人数之外，其他必须填上
            String[] info1 = new String[6];
            int[] info2 = new int[4];
            SchoolList schoolList = null;
            info1[0] =schoolNametextField.getText();
            info1[1] =schoolLocTextField.getText();
            info1[2] =schoolTypetextField.getText();
            info1[3] =preProfessionalCoursesTextField.getText();
            info1[4] =reProfessionalCoursestextArea.getText();
            info2[0] = recuitNumbertextField.getText().equals("")? 0 : Integer.parseInt(recuitNumbertextField.getText());
            info2[1] = englishTypetextField.getText().equals("")? 0 : Integer.parseInt(englishTypetextField.getText());
            info2[2] = mathTypetextField.getText().equals("")? 0 : Integer.parseInt(mathTypetextField.getText());
            if(schoolListDAO.AddSchoolList(info1,info2)!=null){
                JOptionPane.showMessageDialog(ModifySchoolListDialog.this,"添加学校列表成功！");
            }
            else {
                tips.setText("添加信息失败!");
            }
        }
        else if (variableButton.getText().equals("删除院校列表")) {

            if(!schoolNametextField.getText().equals("")&&!schoolTypetextField.getText().equals("")){
                if(schoolListDAO.DeleteSchoolList(schoolNametextField.getText(),schoolTypetextField.getText())){
                    JOptionPane.showMessageDialog(ModifySchoolListDialog.this,"删除学校列表成功！");
                }
                else {
                    tips.setText("删除学校信息失败！");
                }
            }
            else{
                tips.setText("请填入学校的名称和类型,或者只填入学校名称，然后使用查找键");
            }
        }
        else if (variableButton.getText().equals("修改院校列表")) {
            String[] info1 = new String[6];
            int[] info2 = new int[4];
            SchoolList schoolList = null;
            info1[0] =schoolNametextField.getText();
            info1[1] =schoolLocTextField.getText();
            info1[2] =schoolTypetextField.getText();
            info1[3] =preProfessionalCoursesTextField.getText();
            info1[4] =reProfessionalCoursestextArea.getText();
            info2[0] = recuitNumbertextField.getText().equals("")? 0 : Integer.parseInt(recuitNumbertextField.getText());
            info2[1] = englishTypetextField.getText().equals("")? 0 : Integer.parseInt(englishTypetextField.getText());
            info2[2] = mathTypetextField.getText().equals("")? 0 : Integer.parseInt(mathTypetextField.getText());
            SchoolList schoolList1 = schoolListDAO.ViewselectedSchoolListByName(schoolNametextField.getText());
            if(
                    info1[0].equals(schoolList1.getSchoolName())&&
                    info1[1].equals(schoolList1.getSchoolLoc())&&
                    info1[2].equals(schoolList1.getSchoolType())&&
                    info1[3].equals(schoolList1.getPreProfessionalCourses())&&
                    info1[4].equals(schoolList1.getReProfessionalCourses())&&
                    info2[0]==schoolList1.getRecruitNumber()&&
                    info2[1]==schoolList1.getEnglishType()&&
                    info2[2]==schoolList1.getMathType()
            ){
                JOptionPane.showMessageDialog(mainFrameForStudent,"请修改内容再点击修改，无需修改就返回主界面!！");
            }
            else{
                if(!schoolNametextField.getText().equals("")&&!schoolTypetextField.getText().equals("")){
                    if(schoolListDAO.ModifySchoolList(info1,info2)!=null){
                        JOptionPane.showMessageDialog(ModifySchoolListDialog.this,"修改学校列表成功！");
                    }
                    else {
                        tips.setText("修改学校信息失败！");
                    }
                }
                else{
                    tips.setText("请填入学校的名称和类型,或者只填入学校名称，然后使用查找键");
                }
            }

        }
    }

    private void find(ActionEvent e) {
        SchoolList schoolList = new SchoolList();
        schoolList=schoolListDAO.ViewselectedSchoolListByName(schoolNametextField.getText());
        schoolIdtextField.setText(String.valueOf(schoolList.getSchoolId()));
        schoolNametextField.setText(String.valueOf(schoolList.getSchoolName()));
        schoolLocTextField.setText(String.valueOf(schoolList.getSchoolLoc()));
        schoolTypetextField.setText(String.valueOf(schoolList.getSchoolType()));
        recuitNumbertextField.setText(String.valueOf(schoolList.getRecruitNumber()));
        englishTypetextField.setText(String.valueOf(schoolList.getEnglishType()));
        mathTypetextField.setText(String.valueOf(schoolList.getMathType()));
        politicsTypetextField.setText(String.valueOf(schoolList.getPoliticType()));
        preProfessionalCoursesTextField.setText(String.valueOf(schoolList.getPreProfessionalCourses()));
        reProfessionalCoursestextArea.setText(String.valueOf(schoolList.getReProfessionalCourses()));
        JOptionPane.showMessageDialog(ModifySchoolListDialog.this,"按名称查找学校成功！");

    }

    private void backToMainFrame(ActionEvent e) {
        ModifySchoolListDialog.this.dispose();
        mainFrameForAdmin.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        variableButton = new JButton();
        schoolNametextField = new JTextField();
        recuitNumbertextField = new JTextField();
        englishTypetextField = new JTextField();
        mathTypetextField = new JTextField();
        politicsTypetextField = new JTextField();
        preProfessionalCoursesTextField = new JTextField();
        backToMainFramebutton = new JButton();
        label9 = new JLabel();
        schoolIdtextField = new JTextField();
        tips = new JLabel();
        scrollPane1 = new JScrollPane();
        reProfessionalCoursestextArea = new JTextArea();
        schoolLocTextField = new JTextField();
        label11 = new JLabel();
        schoolTypetextField = new JTextField();
        findButton = new JButton();

        //======== this ========
        setTitle("\u4fee\u6539\u5b66\u6821\u5217\u8868");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("\u5b66\u6821\u540d\u79f0");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label2 ----
                label2.setText("\u5b66\u6821\u5730\u5740");
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label3 ----
                label3.setText("\u62db\u751f\u4eba\u6570");
                label3.setHorizontalAlignment(SwingConstants.CENTER);
                label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label4 ----
                label4.setText("\u82f1\u8bed\u8003\u8bd5\u7c7b\u522b");
                label4.setHorizontalAlignment(SwingConstants.CENTER);
                label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label5 ----
                label5.setText("\u6570\u5b66\u8003\u8bd5\u7c7b\u522b");
                label5.setHorizontalAlignment(SwingConstants.CENTER);
                label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label6 ----
                label6.setText("\u653f\u6cbb\u8003\u8bd5\u7c7b\u522b");
                label6.setHorizontalAlignment(SwingConstants.CENTER);
                label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label7 ----
                label7.setText("\u521d\u8bd5\u4e13\u4e1a\u8bfe");
                label7.setHorizontalAlignment(SwingConstants.CENTER);
                label7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label8 ----
                label8.setText("\u590d\u8bd5\u4e13\u4e1a\u8bfe");
                label8.setHorizontalAlignment(SwingConstants.CENTER);
                label8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- variableButton ----
                variableButton.setText("\u4fee\u6539\u4fe1\u606f");
                variableButton.addActionListener(e -> variable(e));

                //---- backToMainFramebutton ----
                backToMainFramebutton.setText("\u8fd4\u56de\u4e3b\u83dc\u5355");
                backToMainFramebutton.addActionListener(e -> backToMainFrame(e));

                //---- label9 ----
                label9.setText("\u5b66\u6821ID");
                label9.setHorizontalAlignment(SwingConstants.CENTER);
                label9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- tips ----
                tips.setForeground(Color.red);
                tips.setHorizontalAlignment(SwingConstants.CENTER);

                //======== scrollPane1 ========
                {

                    //---- reProfessionalCoursestextArea ----
                    reProfessionalCoursestextArea.setRows(3);
                    scrollPane1.setViewportView(reProfessionalCoursestextArea);
                }

                //---- label11 ----
                label11.setText("\u5b66\u6821\u7c7b\u522b");
                label11.setHorizontalAlignment(SwingConstants.CENTER);
                label11.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- findButton ----
                findButton.setText("\u67e5\u627e");
                findButton.addActionListener(e -> find(e));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addComponent(backToMainFramebutton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                            .addComponent(findButton)
                            .addGap(74, 74, 74)
                            .addComponent(variableButton)
                            .addGap(150, 150, 150))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(144, 144, 144)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(label9, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                            .addGap(39, 39, 39)
                                            .addComponent(schoolIdtextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
                                            .addGap(39, 39, 39)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(schoolLocTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(schoolNametextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(schoolTypetextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(recuitNumbertextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(englishTypetextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(mathTypetextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(politicsTypetextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(preProfessionalCoursesTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(146, 146, 146)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label6)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(97, 97, 97)
                                    .addComponent(tips, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(115, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addComponent(schoolIdtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(6, 6, 6)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addComponent(schoolNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addComponent(schoolLocTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label11, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addComponent(schoolTypetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addComponent(recuitNumbertextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(englishTypetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(mathTypetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(politicsTypetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(preProfessionalCoursesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tips, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(backToMainFramebutton)
                                .addComponent(variableButton)
                                .addComponent(findButton))
                            .addGap(26, 26, 26))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JButton variableButton;
    private JTextField schoolNametextField;
    private JTextField recuitNumbertextField;
    private JTextField englishTypetextField;
    private JTextField mathTypetextField;
    private JTextField politicsTypetextField;
    private JTextField preProfessionalCoursesTextField;
    private JButton backToMainFramebutton;
    private JLabel label9;
    private JTextField schoolIdtextField;
    private JLabel tips;
    private JScrollPane scrollPane1;
    private JTextArea reProfessionalCoursestextArea;
    private JTextField schoolLocTextField;
    private JLabel label11;
    private JTextField schoolTypetextField;
    private JButton findButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        ModifySchoolListDialog modifySchoolListDialog = new ModifySchoolListDialog(mainFrameForAdmin,1);
        modifySchoolListDialog.setVisible(true);
    }
}
