/*
 * Created by JFormDesigner on Wed Apr 27 08:14:50 CST 2022
 */

package UI.zzy;

import DAO.zyx.SchoolInfo;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;

import static Utils.zzy.CommonData.mainFrameForAdmin;
import static Utils.zzy.CommonData.schoolInfoDAO;

/**
 * @author 1
 */
public class ModifySchoolInfoDialog extends JDialog {
    public ModifySchoolInfoDialog(Window owner,int key) {
        super(owner);
        initComponents();
        switch (key){
            case 1:
                varribleInfoButton.setText("增加学校信息");
                tips.setText("至少把学校的名称，类型，和全科的撑几天上之后才可以添加。");
//                varribleInfoButton.setEnabled(false);
                findByNameButton.setEnabled(false);
                break;
            case 2:
                varribleInfoButton.setText("删除学校信息");
//                findbutton.setEnabled(false);
                tips.setText("填上删除学校的名称和类型，或者只填删除学校的名称，然后通过搜索按钮找到对应的学校信息，之后再点删除！");
                break;
            case 3:
                varribleInfoButton.setText("修改学校信息");
                schoolTypetextField.setEditable(false);
//                findbutton.setEnabled(false);
                tips.setText("填修改学校的名称，然后通过搜索按钮找到对应的学校信息，之后修改需要修改的信息，最后点击修改！");
                break;
        }
    }

    private void varribleInfo(ActionEvent e) {
        if(varribleInfoButton.getText().equals("增加学校信息")){

            //至少把学校的名称，类型，和全科的撑几天上之后才可以添加。
            if(!schoolNametextField.getText().equals("")&&!allCourseMinTextField.getText().equals("")
            &&!allCourseMeanTextField.getText().equals("")&&!allCourseMaxTextField.getText().equals("")
            &&!schoolTypetextField.getText().equals("")){
                tips.setText("");
                //varribleInfoButton.setEnabled(true);
                BigDecimal[] score = new BigDecimal[20];
                score[0] = BigDecimal.valueOf(allCourseMinTextField.getText().equals("")?0.0:Double.parseDouble(allCourseMinTextField.getText()));
                score[1] = BigDecimal.valueOf(allCourseMeanTextField.getText().equals("")?0.0:Double.parseDouble(allCourseMeanTextField.getText()));
                score[2] = BigDecimal.valueOf(allCourseMaxTextField.getText().equals("")?0.0:Double.parseDouble(allCourseMaxTextField.getText()));
                score[3] = BigDecimal.valueOf(englishMinTextField.getText().equals("")?0.0:Double.parseDouble(englishMinTextField.getText()));
                score[4] = BigDecimal.valueOf(englishMeanTextField.getText().equals("")?0.0:Double.parseDouble(englishMeanTextField.getText()));
                score[5] = BigDecimal.valueOf(englishMaxTextField.getText().equals("")?0.0:Double.parseDouble(englishMaxTextField.getText()));
                score[6] = BigDecimal.valueOf(politicsMinTextField.getText().equals("")?0.0:Double.parseDouble(politicsMinTextField.getText()));
                score[7] = BigDecimal.valueOf(politicsMeanTextField.getText().equals("")?0.0:Double.parseDouble(politicsMeanTextField.getText()));
                score[8] = BigDecimal.valueOf(politicsMaxTextField.getText().equals("")?0.0:Double.parseDouble(politicsMaxTextField.getText()));
                score[9] = BigDecimal.valueOf(firstProfessionalMintextField.getText().equals("")?0.0:Double.parseDouble(firstProfessionalMintextField.getText()));
                score[10] = BigDecimal.valueOf(firstProfessionalMeantextField.getText().equals("")?0.0:Double.parseDouble(firstProfessionalMeantextField.getText()));
                score[11] = BigDecimal.valueOf(firstProfessionalMaxtextField.getText().equals("")?0.0:Double.parseDouble(firstProfessionalMaxtextField.getText()));
                score[12] = BigDecimal.valueOf(secondProfessionalMinTextField.getText().equals("")?0.0:Double.parseDouble(secondProfessionalMinTextField.getText()));
                score[13] = BigDecimal.valueOf(secondProfessionalMeanTextField.getText().equals("")?0.0:Double.parseDouble(secondProfessionalMeanTextField.getText()));
                score[14] = BigDecimal.valueOf(secondProfessionalMaxTextField.getText().equals("")?0.0:Double.parseDouble(secondProfessionalMaxTextField.getText()));

                SchoolInfo schoolInfo = schoolInfoDAO.AddSelectedSchoolInfo(schoolNametextField.getText(),
                        schoolTypetextField.getText(),score, reExamNumberTextField.getText().equals("")?0:Integer.parseInt(reExamNumberTextField.getText()));
                if(schoolInfo != null){
                    JOptionPane.showMessageDialog(ModifySchoolInfoDialog.this,"学校信息添加成功！");
                }
                else{
                    tips.setText("学校信息添加失败");
                }
            }
            else {
                tips.setText("至少把学校的名称，类型，和全科的撑几天上之后才可以添加。");
            }
        }
        else if (varribleInfoButton.getText().equals("删除学校信息")) {
            if(!schoolNametextField.getText().equals("")){
                if(!schoolTypetextField.getText().equals("")){
                    tips.setText("");
                    if(schoolInfoDAO.DeleteSelectedSchoolInfo(schoolNametextField.getText(),schoolTypetextField.getText())){
                        JOptionPane.showMessageDialog(ModifySchoolInfoDialog.this,"删除学校信息成功！");
                    }
                    else {
                        tips.setText("删除学校信息失败!");
                    }
                }
                else {
                    tips.setText("请点击查找按钮，或者写上学校的类型!");
                }
            }
            else {
                tips.setText("至少要写出学校的名称再点击查找按钮，或者是写出学校的名称和学校的类型!");
            }
        }
        else if (varribleInfoButton.getText().equals("修改学校信息")) {
            if(!schoolNametextField.getText().equals("")){
                if(!schoolTypetextField.getText().equals("")){
                    tips.setText("点击查找按钮！");
                    BigDecimal[] score = new BigDecimal[20];
                    score[0] = BigDecimal.valueOf(allCourseMinTextField.getText().equals("")?0.0:Double.parseDouble(allCourseMinTextField.getText()));
                    score[1] = BigDecimal.valueOf(allCourseMeanTextField.getText().equals("")?0.0:Double.parseDouble(allCourseMeanTextField.getText()));
                    score[2] = BigDecimal.valueOf(allCourseMaxTextField.getText().equals("")?0.0:Double.parseDouble(allCourseMaxTextField.getText()));
                    score[3] = BigDecimal.valueOf(englishMinTextField.getText().equals("")?0.0:Double.parseDouble(englishMinTextField.getText()));
                    score[4] = BigDecimal.valueOf(englishMeanTextField.getText().equals("")?0.0:Double.parseDouble(englishMeanTextField.getText()));
                    score[5] = BigDecimal.valueOf(englishMaxTextField.getText().equals("")?0.0:Double.parseDouble(englishMaxTextField.getText()));
                    score[6] = BigDecimal.valueOf(politicsMinTextField.getText().equals("")?0.0:Double.parseDouble(politicsMinTextField.getText()));
                    score[7] = BigDecimal.valueOf(politicsMeanTextField.getText().equals("")?0.0:Double.parseDouble(politicsMeanTextField.getText()));
                    score[8] = BigDecimal.valueOf(politicsMaxTextField.getText().equals("")?0.0:Double.parseDouble(politicsMaxTextField.getText()));
                    score[9] = BigDecimal.valueOf(firstProfessionalMintextField.getText().equals("")?0.0:Double.parseDouble(firstProfessionalMintextField.getText()));
                    score[10] = BigDecimal.valueOf(firstProfessionalMeantextField.getText().equals("")?0.0:Double.parseDouble(firstProfessionalMeantextField.getText()));
                    score[11] = BigDecimal.valueOf(firstProfessionalMaxtextField.getText().equals("")?0.0:Double.parseDouble(firstProfessionalMaxtextField.getText()));
                    score[12] = BigDecimal.valueOf(secondProfessionalMinTextField.getText().equals("")?0.0:Double.parseDouble(secondProfessionalMinTextField.getText()));
                    score[13] = BigDecimal.valueOf(secondProfessionalMeanTextField.getText().equals("")?0.0:Double.parseDouble(secondProfessionalMeanTextField.getText()));
                    score[14] = BigDecimal.valueOf(secondProfessionalMaxTextField.getText().equals("")?0.0:Double.parseDouble(secondProfessionalMaxTextField.getText()));
                    SchoolInfo schoolInfo = schoolInfoDAO.ViewSelectedSchoolInfoByName(schoolNametextField.getText());
                    if(
                            score[0].equals(BigDecimal.valueOf(schoolInfo.getAllCoursesMin()))&&
                            score[1].equals(BigDecimal.valueOf(schoolInfo.getAllCoursesMean()))&&
                            score[2].equals(BigDecimal.valueOf(schoolInfo.getAllCoursesMax()))&&
                            score[3].equals(BigDecimal.valueOf(schoolInfo.getEnglishMin()))&&
                            score[4].equals(BigDecimal.valueOf(schoolInfo.getEnglishMean()))&&
                            score[5].equals(BigDecimal.valueOf(schoolInfo.getEnglishMax()))&&
                            score[6].equals(BigDecimal.valueOf(schoolInfo.getPoliticsMin()))&&
                            score[7].equals(BigDecimal.valueOf(schoolInfo.getPoliticsMean()))&&
                            score[8].equals(BigDecimal.valueOf(schoolInfo.getPoliticsMax()))&&
                            score[9].equals(BigDecimal.valueOf(schoolInfo.getFirstProfessionalMin()))&&
                            score[10].equals(BigDecimal.valueOf(schoolInfo.getFirstProfessionalMean()))&&
                            score[11].equals(BigDecimal.valueOf(schoolInfo.getFirstProfessionalMax()))&&
                            score[12].equals(BigDecimal.valueOf(schoolInfo.getSecondProfessionalMin()))&&
                            score[13].equals(BigDecimal.valueOf(schoolInfo.getSecondProfessionalMean()))&&
                            score[14].equals(BigDecimal.valueOf(schoolInfo.getSecondProfessionalMax()))
                    ){
                        JOptionPane.showMessageDialog(ModifySchoolInfoDialog.this,"请至少修改一项内容，无需修改可以返回主界面！");
                    }
                    else {
                        if(schoolInfoDAO.ModifySelectedSchoolInfo(schoolNametextField.getText(),schoolTypetextField.getText(),score,Integer.parseInt(reExamNumberTextField.getText()))!=null){
                            JOptionPane.showMessageDialog(ModifySchoolInfoDialog.this,"修改学校信息成功！");
                        }
                        else {
                            tips.setText("修改学校信息失败!");
                        }
                    }

                }
                else {
                    tips.setText("请点击查找按钮!");
                }
            }
            else {
                tips.setText("至少要写出学校的名称再点击查找按钮，或者是写出学校的名称和学校的类型再点击查找按钮!");
            }
        }
    }

    /**
     * 这个按钮的功能是从数据库查找学校信息。然后把对应的学校信息填入到表单当中。
     * @param e
     */
    private void findByName(ActionEvent e) {
        SchoolInfo schoolInfo = schoolInfoDAO.ViewSelectedSchoolInfoByName(schoolNametextField.getText());
        schoolTypetextField.setText(schoolInfo.getSchoolType());
        schoolNametextField.setText(schoolInfo.getSchoolName());
        allCourseMinTextField.setText(String.valueOf(schoolInfo.getAllCoursesMin()));
        allCourseMeanTextField.setText(String.valueOf(schoolInfo.getAllCoursesMean()));
        allCourseMaxTextField.setText(String.valueOf(schoolInfo.getAllCoursesMax()));
        englishMinTextField.setText(String.valueOf(schoolInfo.getEnglishMin()));
        englishMeanTextField.setText(String.valueOf(schoolInfo.getEnglishMean()));
        englishMaxTextField.setText(String.valueOf(schoolInfo.getEnglishMax()));
        politicsMinTextField.setText(String.valueOf(schoolInfo.getPoliticsMin()));
        politicsMeanTextField.setText(String.valueOf(schoolInfo.getPoliticsMean()));
        politicsMaxTextField.setText(String.valueOf(schoolInfo.getPoliticsMax()));
        firstProfessionalMintextField.setText(String.valueOf(schoolInfo.getFirstProfessionalMin()));
        firstProfessionalMeantextField.setText(String.valueOf(schoolInfo.getFirstProfessionalMean()));
        firstProfessionalMaxtextField.setText(String.valueOf(schoolInfo.getFirstProfessionalMax()));
        secondProfessionalMinTextField.setText(String.valueOf(schoolInfo.getSecondProfessionalMin()));
        secondProfessionalMeanTextField.setText(String.valueOf(schoolInfo.getSecondProfessionalMean()));
        secondProfessionalMaxTextField.setText(String.valueOf(schoolInfo.getSecondProfessionalMax()));
        reExamNumberTextField.setText(String.valueOf(schoolInfo.getReExamNumber()));
        JOptionPane.showMessageDialog(ModifySchoolInfoDialog.this,"查找学校信息成功！");
    }

    private void backToMainWindow(ActionEvent e) {
        ModifySchoolInfoDialog.this.dispose();
        mainFrameForAdmin.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        contentpanel = new JPanel();
        label89 = new JLabel();
        label90 = new JLabel();
        label91 = new JLabel();
        label92 = new JLabel();
        label93 = new JLabel();
        label94 = new JLabel();
        label95 = new JLabel();
        schoolNametextField = new JTextField();
        allCourseMeanTextField = new JTextField();
        allCourseMaxTextField = new JTextField();
        englishMinTextField = new JTextField();
        englishMeanTextField = new JTextField();
        englishMaxTextField = new JTextField();
        backToMainWindow = new JButton();
        label96 = new JLabel();
        schoolTypetextField = new JTextField();
        varribleInfoButton = new JButton();
        label97 = new JLabel();
        politicsMinTextField = new JTextField();
        label98 = new JLabel();
        textField97 = new JTextField();
        label99 = new JLabel();
        politicsMaxTextField = new JTextField();
        politicsMeanTextField = new JTextField();
        label100 = new JLabel();
        label101 = new JLabel();
        label102 = new JLabel();
        firstProfessionalMintextField = new JTextField();
        firstProfessionalMeantextField = new JTextField();
        firstProfessionalMaxtextField = new JTextField();
        secondProfessionalMinTextField = new JTextField();
        label103 = new JLabel();
        label104 = new JLabel();
        secondProfessionalMeanTextField = new JTextField();
        secondProfessionalMaxTextField = new JTextField();
        label105 = new JLabel();
        label106 = new JLabel();
        reExamNumberTextField = new JTextField();
        tips = new JLabel();
        allCourseMinTextField = new JTextField();
        findByNameButton = new JButton();

        //======== this ========
        setTitle("\u7ba1\u7406\u5b66\u6821\u4fe1\u606f");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== contentpanel ========
                {

                    //---- label89 ----
                    label89.setText("\u5b66\u6821\u540d\u79f0");
                    label89.setHorizontalAlignment(SwingConstants.CENTER);
                    label89.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label90 ----
                    label90.setText("\u5168\u79d1\u6700\u4f4e\u5206");
                    label90.setHorizontalAlignment(SwingConstants.CENTER);
                    label90.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label91 ----
                    label91.setText("\u5168\u79d1\u5e73\u5747\u5206");
                    label91.setHorizontalAlignment(SwingConstants.CENTER);
                    label91.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label92 ----
                    label92.setText("\u5168\u79d1\u6700\u9ad8\u5206");
                    label92.setHorizontalAlignment(SwingConstants.CENTER);
                    label92.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label93 ----
                    label93.setText("\u82f1\u8bed\u6700\u4f4e\u5206");
                    label93.setHorizontalAlignment(SwingConstants.CENTER);
                    label93.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label94 ----
                    label94.setText("\u82f1\u8bed\u5e73\u5747\u5206");
                    label94.setHorizontalAlignment(SwingConstants.CENTER);
                    label94.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label95 ----
                    label95.setText("\u82f1\u8bed\u6700\u9ad8\u5206");
                    label95.setHorizontalAlignment(SwingConstants.CENTER);
                    label95.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- backToMainWindow ----
                    backToMainWindow.setText("\u8fd4\u56de\u4e3b\u754c\u9762");
                    backToMainWindow.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                    backToMainWindow.addActionListener(e -> backToMainWindow(e));

                    //---- label96 ----
                    label96.setText("\u5b66\u6821\u7c7b\u578b");
                    label96.setHorizontalAlignment(SwingConstants.CENTER);
                    label96.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- varribleInfoButton ----
                    varribleInfoButton.setText("\u786e\u8ba4\u4fee\u6539");
                    varribleInfoButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                    varribleInfoButton.addActionListener(e -> varribleInfo(e));

                    //---- label97 ----
                    label97.setText("\u653f\u6cbb\u6700\u4f4e\u5206");
                    label97.setHorizontalAlignment(SwingConstants.CENTER);
                    label97.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label98 ----
                    label98.setText("\u653f\u6cbb\u5e73\u5747\u5206");
                    label98.setHorizontalAlignment(SwingConstants.CENTER);
                    label98.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label99 ----
                    label99.setText("\u653f\u6cbb\u6700\u9ad8\u5206");
                    label99.setHorizontalAlignment(SwingConstants.CENTER);
                    label99.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label100 ----
                    label100.setText("\u4e13\u4e1a\u8bfe1\u6700\u4f4e\u5206");
                    label100.setHorizontalAlignment(SwingConstants.CENTER);
                    label100.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label101 ----
                    label101.setText("\u4e13\u4e1a\u8bfe1\u5e73\u5747\u5206");
                    label101.setHorizontalAlignment(SwingConstants.CENTER);
                    label101.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label102 ----
                    label102.setText("\u4e13\u4e1a\u8bfe1\u6700\u9ad8\u5206");
                    label102.setHorizontalAlignment(SwingConstants.CENTER);
                    label102.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label103 ----
                    label103.setText("\u4e13\u4e1a\u8bfe2\u6700\u4f4e\u5206");
                    label103.setHorizontalAlignment(SwingConstants.CENTER);
                    label103.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label104 ----
                    label104.setText("\u4e13\u4e1a\u8bfe2\u5e73\u5747\u5206");
                    label104.setHorizontalAlignment(SwingConstants.CENTER);
                    label104.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label105 ----
                    label105.setText("\u4e13\u4e1a\u8bfe2\u6700\u9ad8\u5206");
                    label105.setHorizontalAlignment(SwingConstants.CENTER);
                    label105.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- label106 ----
                    label106.setText("\u590d\u8bd5\u4eba\u6570");
                    label106.setHorizontalAlignment(SwingConstants.CENTER);
                    label106.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- tips ----
                    tips.setHorizontalAlignment(SwingConstants.CENTER);
                    tips.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                    tips.setForeground(Color.red);

                    //---- findByNameButton ----
                    findByNameButton.setText("\u6309\u7167\u540d\u79f0\u67e5\u627e");
                    findByNameButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                    findByNameButton.addActionListener(e -> findByName(e));

                    GroupLayout contentpanelLayout = new GroupLayout(contentpanel);
                    contentpanel.setLayout(contentpanelLayout);
                    contentpanelLayout.setHorizontalGroup(
                        contentpanelLayout.createParallelGroup()
                            .addGroup(contentpanelLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(contentpanelLayout.createParallelGroup()
                                    .addGroup(contentpanelLayout.createSequentialGroup()
                                        .addGroup(contentpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(contentpanelLayout.createSequentialGroup()
                                                .addComponent(label96, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(schoolTypetextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label97, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contentpanelLayout.createParallelGroup()
                                                    .addComponent(politicsMinTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textField97, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(contentpanelLayout.createSequentialGroup()
                                                .addComponent(label89, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(schoolNametextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label98, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(politicsMeanTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(contentpanelLayout.createSequentialGroup()
                                                .addComponent(label90, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(allCourseMinTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label99, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(politicsMaxTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(contentpanelLayout.createSequentialGroup()
                                                .addComponent(label91, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(allCourseMeanTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label100, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(firstProfessionalMintextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(contentpanelLayout.createSequentialGroup()
                                                .addComponent(label92, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(allCourseMaxTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label101, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(firstProfessionalMeantextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(contentpanelLayout.createSequentialGroup()
                                                .addComponent(label93, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(englishMinTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label102, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(firstProfessionalMaxtextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(contentpanelLayout.createSequentialGroup()
                                                .addComponent(label94, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(englishMeanTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label103, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(secondProfessionalMinTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(contentpanelLayout.createSequentialGroup()
                                                .addComponent(label95, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(englishMaxTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label104, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(secondProfessionalMeanTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(contentpanelLayout.createSequentialGroup()
                                                .addGroup(contentpanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addGroup(contentpanelLayout.createSequentialGroup()
                                                        .addComponent(findByNameButton)
                                                        .addGap(31, 31, 31))
                                                    .addGroup(contentpanelLayout.createSequentialGroup()
                                                        .addComponent(label106, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(12, 12, 12)
                                                        .addComponent(reExamNumberTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(label105, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                                .addComponent(secondProfessionalMaxTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tips, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addContainerGap(59, Short.MAX_VALUE))
                                    .addGroup(contentpanelLayout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(backToMainWindow)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                                        .addComponent(varribleInfoButton)
                                        .addGap(166, 166, 166))))
                    );
                    contentpanelLayout.setVerticalGroup(
                        contentpanelLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, contentpanelLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(contentpanelLayout.createParallelGroup()
                                    .addComponent(label96, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(schoolTypetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(politicsMinTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField97, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label97, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(contentpanelLayout.createParallelGroup()
                                    .addComponent(label89, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(schoolNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(politicsMeanTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label98, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentpanelLayout.createParallelGroup()
                                    .addGroup(contentpanelLayout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(politicsMaxTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contentpanelLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(contentpanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(allCourseMinTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label90, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label99, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
                                .addGap(13, 13, 13)
                                .addGroup(contentpanelLayout.createParallelGroup()
                                    .addComponent(label91, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(allCourseMeanTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstProfessionalMintextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label100, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(contentpanelLayout.createParallelGroup()
                                    .addComponent(firstProfessionalMeantextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contentpanelLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(contentpanelLayout.createParallelGroup()
                                            .addComponent(label92, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(contentpanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(allCourseMaxTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label101, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))))
                                .addGap(7, 7, 7)
                                .addGroup(contentpanelLayout.createParallelGroup()
                                    .addComponent(firstProfessionalMaxtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contentpanelLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(contentpanelLayout.createParallelGroup()
                                            .addComponent(label93, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(englishMinTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label102, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
                                .addGap(12, 12, 12)
                                .addGroup(contentpanelLayout.createParallelGroup()
                                    .addComponent(label94, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(englishMeanTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(secondProfessionalMinTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label103, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(contentpanelLayout.createParallelGroup()
                                    .addComponent(secondProfessionalMeanTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contentpanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(contentpanelLayout.createParallelGroup()
                                            .addComponent(label95, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(englishMaxTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(label104, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(contentpanelLayout.createParallelGroup()
                                    .addComponent(label106, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reExamNumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contentpanelLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(secondProfessionalMaxTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label105, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(tips, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(contentpanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(backToMainWindow)
                                    .addComponent(findByNameButton)
                                    .addComponent(varribleInfoButton))
                                .addContainerGap(37, Short.MAX_VALUE))
                    );
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(contentpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(contentpanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JPanel contentpanel;
    private JLabel label89;
    private JLabel label90;
    private JLabel label91;
    private JLabel label92;
    private JLabel label93;
    private JLabel label94;
    private JLabel label95;
    private JTextField schoolNametextField;
    private JTextField allCourseMeanTextField;
    private JTextField allCourseMaxTextField;
    private JTextField englishMinTextField;
    private JTextField englishMeanTextField;
    private JTextField englishMaxTextField;
    private JButton backToMainWindow;
    private JLabel label96;
    private JTextField schoolTypetextField;
    private JButton varribleInfoButton;
    private JLabel label97;
    private JTextField politicsMinTextField;
    private JLabel label98;
    private JTextField textField97;
    private JLabel label99;
    private JTextField politicsMaxTextField;
    private JTextField politicsMeanTextField;
    private JLabel label100;
    private JLabel label101;
    private JLabel label102;
    private JTextField firstProfessionalMintextField;
    private JTextField firstProfessionalMeantextField;
    private JTextField firstProfessionalMaxtextField;
    private JTextField secondProfessionalMinTextField;
    private JLabel label103;
    private JLabel label104;
    private JTextField secondProfessionalMeanTextField;
    private JTextField secondProfessionalMaxTextField;
    private JLabel label105;
    private JLabel label106;
    private JTextField reExamNumberTextField;
    private JLabel tips;
    private JTextField allCourseMinTextField;
    private JButton findByNameButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        ModifySchoolInfoDialog modifySchoolInfoDialog = new ModifySchoolInfoDialog(mainFrameForAdmin,3);
        modifySchoolInfoDialog.setVisible(true);

    }
}
