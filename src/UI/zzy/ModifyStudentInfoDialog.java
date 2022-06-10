/*
 * Created by JFormDesigner on Sun Apr 24 21:52:56 CST 2022
 */

package UI.zzy;

import javax.swing.event.*;
import DAO.zyx.Student;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

import static Utils.zzy.CommonData.*;

/**
 * @author 1
 */
public class ModifyStudentInfoDialog extends JDialog {
    public ModifyStudentInfoDialog(Window owner,int key) {
        super(owner);
        initComponents();
        studentpasswordField.setEchoChar('*');
        if(key==1){
            backToMainHome.setText("返回登录界面");
            label9.setText("注册用户界面");
            variableButton.setText("注册用户");
            findButton.setEnabled(false);
            tips.setText("请至少填入您的账户名和密码，还有本科院校和本科院校类型以及您的籍贯！");
        } else if (key == 2) {
            if(getOwner()==mainFrameForAdmin){
                label9.setText("删除用户界面");
                variableButton.setText("删除用户");
                tips.setText("请输入用户名进行删除");
                backToMainHome.setText("返回主界面");
            }
            else if (getOwner()==mainFrameForStudent) {
                label9.setText("删除用户界面");
                variableButton.setText("删除用户");
                tips.setText("请输入用户名进行删除");
                backToMainHome.setText("返回主界面");
            }



        } else if (key ==3) {

            studentNameTextField.setText(student.getStudentName());
            studentNameTextField.setEditable(false);
            label9.setText("修改用户界面");
            variableButton.setText("修改用户");
            tips.setText("请填入用户名！");
            backToMainHome.setText("返回主界面");
        }
    }


    private void showPasswordRadioButtonStateChanged(ChangeEvent e) {
        if(showPasswordRadioButton.isSelected()){
            studentpasswordField.setEchoChar('\0'); // 显示原生密码
        }
        else{
            studentpasswordField.setEchoChar('*');//密码信息用*遮盖
        }
    }

    private void accountTextFieldFocusGained(FocusEvent e) {

            studentNameTextField.setText("");
            variableButton.setEnabled(true);

    }

    private void backToMainHome(ActionEvent e) {
        if(getOwner()==mainFrameForAdmin){
            this.dispose();
            mainFrameForAdmin.setVisible(true);
            mainFrameForAdmin.setExtendedState(Frame.NORMAL);

        }
        else if (getOwner()==mainFrameForStudent) {
            this.dispose();
            mainFrameForStudent.setVisible(true);
            mainFrameForStudent.setExtendedState(Frame.NORMAL);
        }
        else if (getOwner()==loginFrame) {
            this.dispose();
            loginFrame.setVisible(true);
            loginFrame.setExtendedState(Frame.NORMAL);
        }


    }


    private void variable(ActionEvent e) {

        if (variableButton.getText().equals("注册用户")){

            if(!studentNameTextField.getText().equals("")&&!new String(studentpasswordField.getPassword()).equals("")&&
            !schoolField.getText().equals("")&&!schoolLevelField.getText().equals("")&&!homeField.getText().equals("")){
                String[] info = new String[10];
                info[0]= studentNameTextField.getText();
                info[1]= new String(studentpasswordField.getPassword());
                info[2]= schoolField.getText();
                info[3]= schoolLevelField.getText();
                info[4]= homeField.getText();
                info[5]= dreamSchoolLevelField.getText().equals("")?null:dreamSchoolLevelField.getText();
                info[6]= dreamSchoolPlaceField.getText().equals("")?null:dreamSchoolPlaceField.getText();
                info[7]= dreamSchoolNameField.getText().equals("")?null:dreamSchoolNameField.getText();
                //在注册的时候 我们需要检查这个用户有没有 被注册过 如果被注册过，那么我们就不能够注册，我们的注册用户名必须是唯一的。
                if(studentDAO.ViewSelectedStudentByName(studentNameTextField.getText())==null){
                    if(studentDAO.AddStudent(info) != null){
                        JOptionPane.showMessageDialog(ModifyStudentInfoDialog.this,"注册成功！");
                        ModifyStudentInfoDialog.this.dispose();
                        mainFrameForStudent.dispose();
                        loginFrame.setVisible(true);
                        loginFrame.setExtendedState(Frame.NORMAL);//这个窗口显示到面板
                    }
                    else{
                        tips.setText("注册学生用户失败!");
                    }
                }
                else{
                    tips.setText("用户名已经存在!");
                }
            }
            else{
                tips.setText("请至少填入您的账户名和密码，还有本科院校和本科院校类型以及您的籍贯！");
            }
        }
        else if(variableButton.getText().equals("删除用户")){
            if(getOwner()==mainFrameForAdmin){
                if(!studentNameTextField.getText().equals("")){
                    if(studentDAO.DeleteStudent(studentNameTextField.getText())){
                        JOptionPane.showMessageDialog(ModifyStudentInfoDialog.this,"删除当前用户成功!！");
                        ModifyStudentInfoDialog.this.dispose();
                        mainFrameForAdmin.setVisible(true);
                        mainFrameForAdmin.setExtendedState(Frame.NORMAL);
                    }
                    else {
                        tips.setText("删除用户失败，请填入当前登录账户的用户名!");
                    }
                }
                else {
                    tips.setText("请填入用户名！");
                }
            }
            else if (getOwner()==mainFrameForStudent) {
                if(!studentNameTextField.getText().equals("")){
                    if(studentDAO.DeleteStudent(studentNameTextField.getText())&&student.getStudentName().equals(studentNameTextField.getText())){
                        JOptionPane.showMessageDialog(ModifyStudentInfoDialog.this,"删除当前用户成功!！");
                        ModifyStudentInfoDialog.this.dispose();
                        mainFrameForStudent.dispose();
                        LoginFrame loginFrame = new LoginFrame();
                        loginFrame.setVisible(true);
                    }
                    else {
                        tips.setText("删除用户失败，请填入当前登录账户的用户名!");
                    }
                }
                else {
                    tips.setText("请填入用户名！");
                }
            }

        }
        else if(variableButton.getText().equals("修改用户")){
            String originalPassword = student.getStudentPassword();
            //学生姓名不能为空。
            if(!studentNameTextField.getText().equals("")){
                String[] info = new String[10];
                info[0]= studentNameTextField.getText();
                info[1]= new String(studentpasswordField.getPassword());
                info[2]= schoolField.getText();
                info[3]= schoolLevelField.getText();
                info[4]= homeField.getText();
                info[5]= dreamSchoolLevelField.getText().equals("")?null:dreamSchoolLevelField.getText();
                info[6]= dreamSchoolPlaceField.getText().equals("")?null:dreamSchoolPlaceField.getText();
                info[7]= dreamSchoolNameField.getText().equals("")?null:dreamSchoolNameField.getText();
                System.out.println(student.getStudentName());
                System.out.println(studentNameTextField.getText());
                //确保有内容被修改了
                if(!studentNameTextField.getText().equals(student.getStudentName())){
                    System.out.println(studentNameTextField.getText());
                    System.out.println(student.getStudentName());
                    JOptionPane.showMessageDialog(mainFrameForStudent,"请输入当前用户名称!！");
                }
                else if(studentNameTextField.getText().equals(student.getStudentName())){
                    if(info[0].equals(studentDAO.ViewSelectedStudentByName(studentNameTextField.getText()).getStudentName())&&
                            info[1].equals(new String(studentDAO.ViewSelectedStudentByName(studentNameTextField.getText()).getStudentPassword()))&&
                            info[2].equals(studentDAO.ViewSelectedStudentByName(studentNameTextField.getText()).getSchoolName())&&
                            info[3].equals(studentDAO.ViewSelectedStudentByName(studentNameTextField.getText()).getSchoolType())&&
                            info[4].equals(studentDAO.ViewSelectedStudentByName(studentNameTextField.getText()).getCameFrom())&&
                            info[5].equals(studentDAO.ViewSelectedStudentByName(studentNameTextField.getText()).getDreamSchoolType())&&
                            info[6].equals(studentDAO.ViewSelectedStudentByName(studentNameTextField.getText()).getDreamSchoolLoc())&&
                            info[7].equals(studentDAO.ViewSelectedStudentByName(studentNameTextField.getText()).getDreamSchoolName())
                    ){
                        JOptionPane.showMessageDialog(mainFrameForStudent,"请修改内容再点击修改，无需修改就返回主界面!！");
                    }
                    else {

                        if(student.getStudentName().equals(studentNameTextField.getText())&&studentDAO.ModifyStudent(info)!=null){
                            JOptionPane.showMessageDialog(mainFrameForStudent,"修改当前用户成功!！");
                            if(!(userAccount.equals(student.getStudentPassword()))){
                                ModifyStudentInfoDialog.this.dispose();
                                mainFrameForStudent.dispose();
                                loginFrame.setVisible(true);
                                loginFrame.loginPrompt.setText("");
                            }
                            else {
                                ModifyStudentInfoDialog.this.dispose();
                            }

                        }
                        else {
                            tips.setText("修改用户失败，请填入当前登录账户的用户名!");
                        }
                    }
                }
                else {
                    tips.setText("请填入用户名！");
                }
            }
            tips.setText("请输入用户名和密码");
        }
    }

    private void find(ActionEvent e) {
        if(!studentNameTextField.getText().equals("")){
            Student student = studentDAO.ViewSelectedStudentByName(studentNameTextField.getText());
            studentNameTextField.setText(student.getStudentName());
            studentpasswordField.setText(student.getStudentPassword());
            schoolField.setText(student.getSchoolName());
            schoolLevelField.setText(student.getSchoolType());
            homeField.setText(student.getCameFrom());
            dreamSchoolLevelField.setText(student.getDreamSchoolType());
            dreamSchoolPlaceField.setText(student.getDreamSchoolLoc());
            dreamSchoolNameField.setText(student.getDreamSchoolName());
            JOptionPane.showMessageDialog(ModifyStudentInfoDialog.this,"按名称查找学生成功！");
        }
        else{
            tips.setText("请输入学生用户名!");
        }
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
        label9 = new JLabel();
        studentNameTextField = new JTextField();
        schoolField = new JTextField();
        schoolLevelField = new JTextField();
        homeField = new JTextField();
        dreamSchoolLevelField = new JTextField();
        dreamSchoolPlaceField = new JTextField();
        dreamSchoolNameField = new JTextField();
        studentpasswordField = new JPasswordField();
        showPasswordRadioButton = new JRadioButton();
        backToMainHome = new JButton();
        variableButton = new JButton();
        tips = new JLabel();
        dreamschoolNamelabel = new JLabel();
        passwordlabel = new JLabel();
        schoollabel = new JLabel();
        schoolLevellabel = new JLabel();
        homelabel = new JLabel();
        dreamschoolTypelabel = new JLabel();
        acoountlabel = new JLabel();
        dreamschoolLoclabel = new JLabel();
        findButton = new JButton();

        //======== this ========
        setTitle("\u7528\u6237\u6ce8\u518c\u754c\u9762");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("\u7528\u6237\u540d");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label2 ----
                label2.setText("\u5bc6\u7801");
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label3 ----
                label3.setText("\u672c\u79d1\u9662\u6821");
                label3.setHorizontalAlignment(SwingConstants.CENTER);
                label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label4 ----
                label4.setText("\u672c\u79d1\u9662\u6821\u7ea7\u522b");
                label4.setHorizontalAlignment(SwingConstants.CENTER);
                label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label5 ----
                label5.setText("\u7c4d\u8d2f");
                label5.setHorizontalAlignment(SwingConstants.CENTER);
                label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label6 ----
                label6.setText("\u5fd7\u613f\u5b66\u6821\u7c7b\u578b");
                label6.setHorizontalAlignment(SwingConstants.CENTER);
                label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label7 ----
                label7.setText("\u5fd7\u613f\u5b66\u6821\u5730\u5740");
                label7.setHorizontalAlignment(SwingConstants.CENTER);
                label7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label8 ----
                label8.setText("\u5fd7\u613f\u5b66\u6821\u540d\u79f0");
                label8.setHorizontalAlignment(SwingConstants.CENTER);
                label8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label9 ----
                label9.setText("\u6b22\u8fce\u8fdb\u5165\u6ce8\u518c\u754c\u9762");
                label9.setHorizontalAlignment(SwingConstants.CENTER);
                label9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));

                //---- studentNameTextField ----
                studentNameTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- schoolField ----
                schoolField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- schoolLevelField ----
                schoolLevelField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- homeField ----
                homeField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- dreamSchoolLevelField ----
                dreamSchoolLevelField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- dreamSchoolPlaceField ----
                dreamSchoolPlaceField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- dreamSchoolNameField ----
                dreamSchoolNameField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- studentpasswordField ----
                studentpasswordField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));

                //---- showPasswordRadioButton ----
                showPasswordRadioButton.setText("\u663e\u793a\u5bc6\u7801");
                showPasswordRadioButton.addChangeListener(e -> showPasswordRadioButtonStateChanged(e));

                //---- backToMainHome ----
                backToMainHome.setText("\u8fd4\u56de\u767b\u5f55\u754c\u9762");
                backToMainHome.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                backToMainHome.addActionListener(e -> backToMainHome(e));

                //---- variableButton ----
                variableButton.setText("\u6ce8\u518c");
                variableButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                variableButton.addActionListener(e -> variable(e));

                //---- tips ----
                tips.setHorizontalAlignment(SwingConstants.CENTER);
                tips.setForeground(Color.red);

                //---- findButton ----
                findButton.setText("\u67e5\u627e");
                findButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                findButton.addActionListener(e -> find(e));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(backToMainHome)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(findButton)
                            .addGap(69, 69, 69)
                            .addComponent(variableButton, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                            .addGap(129, 129, 129))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(0, 20, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(schoollabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordlabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addComponent(schoolLevellabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addComponent(homelabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addComponent(dreamschoolTypelabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addComponent(acoountlabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addComponent(dreamschoolNamelabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addComponent(dreamschoolLoclabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(label4, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(label5, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(label7, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(label8, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createParallelGroup()
                                                    .addGroup(contentPanelLayout.createParallelGroup()
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                            .addGroup(contentPanelLayout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(dreamSchoolNameField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(dreamSchoolPlaceField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                            .addGap(18, 18, 18)
                                                            .addComponent(dreamSchoolLevelField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(homeField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(schoolLevelField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(schoolField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addComponent(studentpasswordField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(showPasswordRadioButton)))))))
                            .addGap(69, 69, 69))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(20, Short.MAX_VALUE)
                            .addComponent(tips, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(26, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(label9)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(16, 16, 16)
                                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(14, 14, 14)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(passwordlabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addGap(1, 1, 1)
                                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(studentpasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(showPasswordRadioButton)))
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                            .addGap(12, 12, 12)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(schoolField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(schoollabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(schoolLevelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(schoolLevellabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                            .addGap(12, 12, 12)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(homeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(homelabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                            .addGap(12, 12, 12)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(dreamSchoolLevelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dreamschoolTypelabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(acoountlabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(12, 12, 12)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(dreamSchoolPlaceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dreamschoolLoclabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                            .addGap(8, 8, 8)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(dreamSchoolNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(dreamschoolNamelabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(tips, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(backToMainHome)
                                .addComponent(variableButton)
                                .addComponent(findButton))
                            .addContainerGap(30, Short.MAX_VALUE))
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
    private JLabel label9;
    private JTextField studentNameTextField;
    private JTextField schoolField;
    private JTextField schoolLevelField;
    private JTextField homeField;
    private JTextField dreamSchoolLevelField;
    private JTextField dreamSchoolPlaceField;
    private JTextField dreamSchoolNameField;
    private JPasswordField studentpasswordField;
    private JRadioButton showPasswordRadioButton;
    private JButton backToMainHome;
    private JButton variableButton;
    private JLabel tips;
    private JLabel dreamschoolNamelabel;
    private JLabel passwordlabel;
    private JLabel schoollabel;
    private JLabel schoolLevellabel;
    private JLabel homelabel;
    private JLabel dreamschoolTypelabel;
    private JLabel acoountlabel;
    private JLabel dreamschoolLoclabel;
    private JButton findButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        ModifyStudentInfoDialog modifyStudentInfoDialog = new ModifyStudentInfoDialog(loginFrame,1);
        modifyStudentInfoDialog.setVisible(true);

    }
}
