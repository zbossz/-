/*
 * Created by JFormDesigner on Wed Apr 20 10:02:06 CST 2022
 */

package UI.zzy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.event.*;

import DAO.zyx.StudentDAO;
import com.jgoodies.forms.factories.*;

import static Utils.zzy.CommonData.*;

/**
 * @author 1
 */
public class LoginFrame extends JFrame {
    public LoginFrame() {
        initComponents();
        loginButton.setEnabled(false);
    }

    public void loginButtonMouseClicked(MouseEvent e) {
        userAccount = AccountTextField.getText();
        userPassword = new String(passwordField.getPassword());

        if(userAccount.length()==0||userPassword.length()==0)
            loginPrompt.setText("用户名或密码不能为空！");
        else{
            loginPrompt.setText("正在登录！");
            student = studentDAO.FindSelectedStudent(userAccount,userPassword);
            admin = adminDAO.FindSelectedAdmin(userAccount,userPassword);
        }
        if(student != null){
            mainFrameForStudent.setVisible(true);
            this.setVisible(false);
        }
        else if(admin!=null){
            mainFrameForAdmin.setVisible(true);
            this.setVisible(false);
        }
        else {
            loginPrompt.setText("用户名或密码不正确！！");
            loginButton.setEnabled(false);//按钮设置不可用
        }
    }

    private void register(ActionEvent e) {
        ModifyStudentInfoDialog modifyStudentInfoDialog = new ModifyStudentInfoDialog(loginFrame,1);
        modifyStudentInfoDialog.setVisible(true);
    }

    private void agreeMentStateChanged(ChangeEvent e) {
        // TODO add your code here
        if(agreeMent.isSelected()){
            loginButton.setEnabled(true);
            registerButton.setEnabled(true);
        }
        else if(!agreeMent.isSelected()){
            loginButton.setEnabled(false);
            registerButton.setEnabled(false);
        }
    }

    private void passwordFieldKeyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){//敲击了回车键
            String userName = AccountTextField.getText();
            String userPassword = new String(passwordField.getPassword());

            if(userName.length()==0||userPassword.length()==0)
                loginPrompt.setText("用户名或密码不能为空！");
            else{
                loginPrompt.setText("正在登录！");
                if(student != null){
                    mainFrameForStudent.setVisible(true);
                    LoginFrame.this.dispose();
                }
                else if(admin!=null){
                    mainFrameForAdmin.setVisible(true);
                    LoginFrame.this.dispose();
                }
                else {
                    loginPrompt.setText("用户名或密码不正确！！");
                    loginButton.setEnabled(false);//按钮设置不可用
                }
                student = StudentDAO.FindSelectedStudent(userName,userPassword);
                admin = adminDAO.FindSelectedAdmin(userName,userPassword);
            }


        }
    }

    public void initComponents() {
        Image image = Toolkit.getDefaultToolkit().getImage("\\zbosszLOGO.jpg");
        if(SystemTray.isSupported()){
            //获取当前平台的系统托盘
            SystemTray tray = SystemTray.getSystemTray();
            //加载一个图片当作托盘图标
            PopupMenu popupMenu = new PopupMenu();

            MenuItem openItem = new MenuItem("打开");
            MenuItem exitItem = new MenuItem("退出");

            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!LoginFrame.this.isShowing()){
                        LoginFrame.this.setVisible(true);
                        LoginFrame.this.setExtendedState(NORMAL);//这个窗口显示到面板
                    }
                }
            });
            exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            popupMenu.add(openItem);
            popupMenu.add(exitItem);
            //创建系统托盘
            TrayIcon trayIcon = new TrayIcon(image,"GraduateSchoolInquirySystem",popupMenu);
            //托盘图标自适应尺寸
            trayIcon.setImageAutoSize(true);

            LoginFrame.this.addWindowListener(new WindowAdapter() {
                @Override
                //这个是窗口最小化事件
                public void windowIconified(WindowEvent e) {
                        try {
                            tray.add(trayIcon);
                        } catch (AWTException ex) {
                            throw new RuntimeException(ex);
                        }
                        loginFrame.setVisible(false);
                }
            });
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getButton()==MouseEvent.BUTTON1) {//button3是右键，button1是左键
                        super.mouseClicked(e);
                        int clickedtimes = e.getClickCount();
                        if (clickedtimes == 1) {
                            LoginFrame.this.setVisible(true);
                            LoginFrame.this.setExtendedState(NORMAL);//这个窗口显示到面板
                        }
                        tray.remove(trayIcon);
                    }
                }
            });
        }

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        loginButton = new JButton();
        registerButton = new JButton();
        AccountTextField = new JTextField();
        passwordField = new JPasswordField();
        agreeMent = new JCheckBox();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = compFactory.createLabel("");
        label5 = new JLabel();
        rememberPasswordcheckBox = new JCheckBox();
        rememberAccountcheckBox = new JCheckBox();
        loginPrompt = new JLabel();

        //======== this ========
        setTitle("\u8003\u7814\u4fe1\u606f\u67e5\u8be2\u7cfb\u7edf");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- loginButton ----
                loginButton.setText("\u767b\u5165");
                loginButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                loginButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        loginButtonMouseClicked(e);
                    }
                });

                //---- registerButton ----
                registerButton.setText("\u6ce8\u518c");
                registerButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                registerButton.addActionListener(e -> register(e));

                //---- AccountTextField ----
                AccountTextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

                //---- passwordField ----
                passwordField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
                passwordField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        passwordFieldKeyReleased(e);
                    }
                });

                //---- agreeMent ----
                agreeMent.setText("\u540c\u610f\u7528\u6237\u534f\u8bae");
                agreeMent.setHorizontalAlignment(SwingConstants.CENTER);
                agreeMent.addChangeListener(e -> agreeMentStateChanged(e));

                //---- label1 ----
                label1.setText("\u8d26\u6237\uff1a");
                label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                label1.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label2 ----
                label2.setText("\u5bc6\u7801\uff1a");
                label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                label2.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label3 ----
                label3.setText("\u6b22\u8fce\u8fdb\u5165\u767b\u5f55\u754c\u9762");
                label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
                label3.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label4 ----
                label4.setHorizontalAlignment(SwingConstants.CENTER);

                //---- rememberPasswordcheckBox ----
                rememberPasswordcheckBox.setText("\u8bb0\u4f4f\u5bc6\u7801");

                //---- rememberAccountcheckBox ----
                rememberAccountcheckBox.setText("\u8bb0\u4f4f\u8d26\u6237");

                //---- loginPrompt ----
                loginPrompt.setHorizontalAlignment(SwingConstants.CENTER);
                loginPrompt.setForeground(Color.red);

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label4, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                            .addGap(88, 88, 88))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(0, 152, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPanelLayout.createParallelGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(passwordField))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(AccountTextField, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(rememberAccountcheckBox)
                                    .addGap(39, 39, 39)
                                    .addComponent(rememberPasswordcheckBox)
                                    .addGap(18, 18, 18)
                                    .addComponent(agreeMent, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)))
                            .addGap(129, 129, 129))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(437, Short.MAX_VALUE))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(183, 183, 183)
                            .addComponent(registerButton)
                            .addGap(109, 109, 109)
                            .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 166, Short.MAX_VALUE))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(198, 198, 198)
                            .addComponent(loginPrompt, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(181, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addComponent(AccountTextField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label5))
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(rememberAccountcheckBox)
                                    .addComponent(rememberPasswordcheckBox)
                                    .addComponent(agreeMent)))
                            .addGap(18, 18, 18)
                            .addComponent(loginPrompt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(registerButton)
                                .addComponent(loginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(47, 47, 47))
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
    private JButton loginButton;
    private JButton registerButton;
    public JTextField AccountTextField;
    public JPasswordField passwordField;
    public JCheckBox agreeMent;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    public JCheckBox rememberPasswordcheckBox;
    public JCheckBox rememberAccountcheckBox;
    public JLabel loginPrompt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        //窗体和对话框设置默认跨平台外观感
        /*JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);*/
        loginFrame.setVisible(true);
    }
}
