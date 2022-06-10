/*
 * Created by JFormDesigner on Wed Apr 27 23:37:36 CST 2022
 */

package UI.zzy;

import UI.yx.MainFrameForAdmin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

import static Utils.zzy.CommonData.*;

/**
 * @author 1
 */
public class ModifyAdminInfoDialog extends JDialog {
    public ModifyAdminInfoDialog(Window owner,int key) {
        super(owner);
        initComponents();
        switch (key){
            case 1:varibleAdminButton.setText("修改管理员信息");adminAccount.setText(admin.getAdminName());adminAccount.setEditable(false);break;
            case 2:varibleAdminButton.setText("增加管理员信息");break;
            case 3:varibleAdminButton.setText("删除管理员信息");break;
        }
    }

    private void varibleAdmin(ActionEvent e) {
        if(varibleAdminButton.getText().equals("修改管理员信息")){
            if(admin==null){
                tips.setText("当前账户不存在!");
            }
            else if(admin!=null&&admin.getAdminName().equals(adminAccount.getText())){
                if(!adminAccount.getText().equals("") && !new String(adminPassword.getPassword()).equals("")){
                    if(!admin.getAdminPassword().equals(new String(adminPassword.getPassword()))){
                        if(adminDAO.ModifyAdminInfo(adminAccount.getText(),new String(adminPassword.getPassword()))){
                            tips.setText("密码修改成功，请重新登录");
                            mainFrameForAdmin.dispose();//销毁主窗口
                            //修改成功之后，会弹出一条信息
                            JOptionPane.showMessageDialog(ModifyAdminInfoDialog.this,"密码修改成功，请重新登录账户！");
                            LoginFrame loginFrame = new LoginFrame();
                            loginFrame.setVisible(true);
                        }
                    }
                    else {
                        tips.setText("密码不能与原始密码相同!");
                    }
                }
                else {
                    tips.setText("账户名或密码不能为空！");
                }
            }
            else if(!admin.getAdminName().equals(adminAccount.getText())){
                tips.setText("账户名输入错误！请输入当前登录用户的账户名!");
            }
        }
        else if (varibleAdminButton.getText().equals("增加管理员信息")) {
            if(!adminAccount.getText().equals("") && !new String(adminPassword.getPassword()).equals("")){
                if(adminDAO.InsertAdminInfo(adminAccount.getText(),new String(adminPassword.getPassword()))){
                    tips.setText("管理员账户注册成功！");
                    JOptionPane.showMessageDialog(ModifyAdminInfoDialog.this,"账户注册成功！");

                }
            }else {
                tips.setText("账户名或密码不能为空！");
            }

        }
        else if (varibleAdminButton.getText().equals("删除管理员信息")) {
            if(!adminAccount.getText().equals("") && !new String(adminPassword.getPassword()).equals("")){
                if(admin==null){
                    tips.setText("当前账户不存在!");
                }
                else if(admin!=null&&admin.getAdminName().equals(adminAccount.getText())){
                    if(adminDAO.DeleteAdminInfo(adminAccount.getText())){
                        tips.setText("账户已经注销!请重新登录");
                        mainFrameForAdmin.dispose();//销毁主窗口
                        //修改成功之后，会弹出一条信息
                        JOptionPane.showMessageDialog(ModifyAdminInfoDialog.this,"账户注销成功，请重新注册账户！");
                        LoginFrame loginFrame = new LoginFrame();
                        loginFrame.setVisible(true);
                    }
                }
                else if(!admin.getAdminName().equals(adminAccount.getText())){
                    tips.setText("账户名输入错误！请输入当前登录用户的账户名!");
                }
            }
            else {
                tips.setText("账户名或密码不能为空！");
            }
        }
    }

    private void backToMainFram(ActionEvent e) {
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        adminAccount = new JTextArea();
        adminPassword = new JPasswordField();
        backToMainFramButton = new JButton();
        varibleAdminButton = new JButton();
        tips = new JLabel();

        //======== this ========
        setTitle("\u7ba1\u7406\u5458\u4fe1\u606f\u5904\u7406\u96c6\u5408");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("\u7ba1\u7406\u5458\u8d26\u6237\uff1a");
                label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- label2 ----
                label2.setText("\u7ba1\u7406\u5458\u5bc6\u7801\uff1a");
                label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //======== scrollPane1 ========
                {

                    //---- adminAccount ----
                    adminAccount.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
                    scrollPane1.setViewportView(adminAccount);
                }

                //---- adminPassword ----
                adminPassword.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));

                //---- backToMainFramButton ----
                backToMainFramButton.setText("\u8fd4\u56de\u4e3b\u83dc\u5355");
                backToMainFramButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                backToMainFramButton.addActionListener(e -> backToMainFram(e));

                //---- varibleAdminButton ----
                varibleAdminButton.setText("\u786e\u8ba4\u4fee\u6539");
                varibleAdminButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                varibleAdminButton.addActionListener(e -> varibleAdmin(e));

                //---- tips ----
                tips.setHorizontalAlignment(SwingConstants.CENTER);
                tips.setForeground(Color.red);

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(tips, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                        .addComponent(backToMainFramButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(adminPassword, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(scrollPane1)
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(varibleAdminButton)))))
                            .addGap(44, 44, 44))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(58, 58, 58)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(adminPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addComponent(tips, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(varibleAdminButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(backToMainFramButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(27, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
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
    private JScrollPane scrollPane1;
    private JTextArea adminAccount;
    private JPasswordField adminPassword;
    private JButton backToMainFramButton;
    private JButton varibleAdminButton;
    private JLabel tips;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        ModifyAdminInfoDialog modifyAdminInfoDialog = new ModifyAdminInfoDialog(mainFrameForAdmin,1);
        modifyAdminInfoDialog.setVisible(true);
    }
}
