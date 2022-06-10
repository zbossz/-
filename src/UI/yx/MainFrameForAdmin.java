/*
 * Created by JFormDesigner on Wed Apr 20 15:06:46 CST 2022
 */

package UI.yx;

import DAO.yx.Admin;
import DAO.yx.SchoolList;
import DAO.zyx.Student;
import Operations.ViewSchoolListByAreaOp;
import Operations.ViewSchoolListByTypeOp;
import UI.zzy.ModifyAdminInfoDialog;
import UI.zzy.ModifySchoolInfoDialog;
import UI.zzy.ModifySchoolListDialog;
import UI.zzy.ModifyStudentInfoDialog;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import static Utils.zzy.CommonData.*;

/**
 * @author 1
 */
public class MainFrameForAdmin extends JFrame {
    public MainFrameForAdmin() {
        initComponents();
    }

    private void viewCurrrentAdminInfo(ActionEvent e) {
        searchDialogForAdmin.choicecomboBox.setSelectedIndex(9);
        searchDialogForAdmin.searchTextArea.setText(admin.getAdminName());

        Vector<String> vector = new Vector<>();
        vector.addElement("管理员ID");
        vector.addElement("管理员姓名");
        vector.addElement("管理员密码");
        searchDialogForAdmin.tableTitle.addAll(vector);

        Admin admin = adminDAO.ViewSelectedAdminByName(searchDialogForAdmin.searchTextArea.getText());

        searchDialogForAdmin.tableValue.removeAllElements();
        if(admin!=null){
            Vector<String> vector1 = new Vector<String>();
            vector1.addElement(String.valueOf(admin.getAdminId()));
            vector1.addElement(String.valueOf(admin.getAdminName()));
            vector1.addElement(String.valueOf(admin.getAdminPassword()));
            searchDialogForAdmin.tableValue.addElement(vector1);
        }

        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);
    }
    private void viewAllAdminInfo(ActionEvent e) {
        // TODO add your code here
        searchDialogForAdmin.choicecomboBox.setSelectedIndex(10);
        searchDialogForAdmin.tableTitle.add("管理员ID");
        searchDialogForAdmin.tableTitle.add("管理员姓名");
        searchDialogForAdmin.tableTitle.add("管理员密码");

        Vector<Admin> admins = adminDAO.ViewAllAdmin();

        searchDialogForAdmin.tableValue.removeAllElements();
        for (Admin x : admins) {
            Vector<String> vector = new Vector<String>();
            vector.addElement(String.valueOf(x.getAdminId()));
            vector.addElement(String.valueOf(x.getAdminName()));
            vector.addElement(String.valueOf(x.getAdminPassword()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);
    }
    private void modifyCurrentAdminInfo(ActionEvent e) {
        ModifyAdminInfoDialog modifyAdminInfoDialog = new ModifyAdminInfoDialog(mainFrameForAdmin,1);

        modifyAdminInfoDialog.setVisible(true);
    }

    private void addAminInfoItem(ActionEvent e) {
        ModifyAdminInfoDialog modifyAdminInfoDialog = new ModifyAdminInfoDialog(mainFrameForAdmin,2);

        modifyAdminInfoDialog.setVisible(true);
    }

    private void delAdminItem(ActionEvent e) {
        ModifyAdminInfoDialog modifyAdminInfoDialog = new ModifyAdminInfoDialog(mainFrameForAdmin,3);

        modifyAdminInfoDialog.setVisible(true);
    }

    private void quitSystem(ActionEvent e) {
        System.exit(0);
    }

    private void quitLogin(ActionEvent e) {
        mainFrameForAdmin.dispose();
        loginFrame.loginPrompt.setText("");
        if(!loginFrame.rememberAccountcheckBox.isSelected()&&!loginFrame.rememberPasswordcheckBox.isSelected()){
            loginFrame.AccountTextField.setText("");
            loginFrame.passwordField.setText("");
            loginFrame.loginPrompt.setText("");
        }
        else if( loginFrame.rememberAccountcheckBox.isSelected()&&!loginFrame.rememberPasswordcheckBox.isSelected()) {
            loginFrame.passwordField.setText("");
            loginFrame.loginPrompt.setText("");
            student = null;
        }else if( loginFrame.rememberPasswordcheckBox.isSelected()&&!loginFrame.rememberAccountcheckBox.isSelected()) {
            loginFrame.AccountTextField.setText("");
            loginFrame.loginPrompt.setText("");

            student=null;
        }
        loginFrame.setVisible(true);
    }

    private void addSchoolInfoMenu(ActionEvent e) {
        ModifySchoolInfoDialog modifySchoolInfoDialog = new ModifySchoolInfoDialog(mainFrameForAdmin,1);
        modifySchoolInfoDialog.setVisible(true);
    }

    private void delSchoolInfoMenu(ActionEvent e) {
        ModifySchoolInfoDialog modifySchoolInfoDialog = new ModifySchoolInfoDialog(mainFrameForAdmin,2);
        modifySchoolInfoDialog.setVisible(true);
    }

    private void modifySchoolInfoMenu(ActionEvent e) {
        ModifySchoolInfoDialog modifySchoolInfoDialog = new ModifySchoolInfoDialog(mainFrameForAdmin,3);
        modifySchoolInfoDialog.setVisible(true);
    }

    private void addSchoolListMenu(ActionEvent e) {
        ModifySchoolListDialog modifySchoolListDialog = new ModifySchoolListDialog(mainFrameForAdmin,1);
        modifySchoolListDialog.setVisible(true);
    }

    private void delSchoolListMenu(ActionEvent e) {
        ModifySchoolListDialog modifySchoolListDialog = new ModifySchoolListDialog(mainFrameForAdmin,2);
        modifySchoolListDialog.setVisible(true);
    }

    private void modifySchoolListMenu(ActionEvent e) {
        ModifySchoolListDialog modifySchoolListDialog = new ModifySchoolListDialog(mainFrameForAdmin,3);
        modifySchoolListDialog.setVisible(true);
    }


    private void viewSelectedAdminInfo(ActionEvent e) {
        // TODO add your code here

        searchDialogForAdmin.choicecomboBox.setSelectedIndex(11);
        searchDialogForAdmin.setVisible(true);

    }

    private void ViewSchoolListByAnHui(ActionEvent e) {
        // TODO add your code here
        /*searchDialogForAdmin.choicecomboBox.setSelectedIndex(0);

        searchDialogForAdmin.tableTitle.add("录取人数");
        searchDialogForAdmin.tableTitle.add("英语考试类别");
        searchDialogForAdmin.tableTitle.add("数学考试类别");
        searchDialogForAdmin.tableTitle.add("政治考试类别");
        searchDialogForAdmin.tableTitle.add("学校名称");
        searchDialogForAdmin.tableTitle.add("学校地址");
        searchDialogForAdmin.tableTitle.add("学校类型");
        searchDialogForAdmin.tableTitle.add("初试科目");
        searchDialogForAdmin.tableTitle.add("复试科目");

        searchDialogForAdmin.searchTextArea.setText("安徽");
        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByArea(searchDialogForAdmin.searchTextArea.getText());

        searchDialogForAdmin.tableValue.removeAllElements();

        for (SchoolList x:schoolLists) {
            Vector<String> vector = new Vector<String>();
            vector.addElement(String.valueOf(x.getRecruitNumber()));
            vector.addElement(String.valueOf(x.getEnglishType()));
            vector.addElement(String.valueOf(x.getMathType()));
            vector.addElement(String.valueOf(x.getPoliticType()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolLoc()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getPreProfessionalCourses()));
            vector.addElement(String.valueOf(x.getReProfessionalCourses()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }

        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);

        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);*/
        ViewSchoolListByAreaOp.ViewSchoolListByArea("安徽",0);
    }

    private void ViewSchoolListByJiangSu(ActionEvent e) {
        // TODO add your code here
        ViewSchoolListByAreaOp.ViewSchoolListByArea("江苏",0);
        /*searchDialogForAdmin.choicecomboBox.setSelectedIndex(0);
        searchDialogForAdmin.tableTitle.add("录取人数");
        searchDialogForAdmin.tableTitle.add("英语考试类别");
        searchDialogForAdmin.tableTitle.add("数学考试类别");
        searchDialogForAdmin.tableTitle.add("政治考试类别");
        searchDialogForAdmin.tableTitle.add("学校名称");
        searchDialogForAdmin.tableTitle.add("学校地址");
        searchDialogForAdmin.tableTitle.add("学校类型");
        searchDialogForAdmin.tableTitle.add("初试科目");
        searchDialogForAdmin.tableTitle.add("复试科目");
        searchDialogForAdmin.searchTextArea.setText("江苏");
        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByArea(searchDialogForAdmin.searchTextArea.getText());
        searchDialogForAdmin.tableValue.removeAllElements();
        for (SchoolList x:schoolLists) {
            Vector<String> vector = new Vector<String>();
            vector.addElement(String.valueOf(x.getRecruitNumber()));
            vector.addElement(String.valueOf(x.getEnglishType()));
            vector.addElement(String.valueOf(x.getMathType()));
            vector.addElement(String.valueOf(x.getPoliticType()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolLoc()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getPreProfessionalCourses()));
            vector.addElement(String.valueOf(x.getReProfessionalCourses()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);*/
    }

    private void ViewSchoolListByShangHai(ActionEvent e) {
        // TODO add your code here
        ViewSchoolListByAreaOp.ViewSchoolListByArea("上海",0);
        /*searchDialogForAdmin.choicecomboBox.setSelectedIndex(0);
        searchDialogForAdmin.tableTitle.add("录取人数");
        searchDialogForAdmin.tableTitle.add("英语考试类别");
        searchDialogForAdmin.tableTitle.add("数学考试类别");
        searchDialogForAdmin.tableTitle.add("政治考试类别");
        searchDialogForAdmin.tableTitle.add("学校名称");
        searchDialogForAdmin.tableTitle.add("学校地址");
        searchDialogForAdmin.tableTitle.add("学校类型");
        searchDialogForAdmin.tableTitle.add("初试科目");
        searchDialogForAdmin.tableTitle.add("复试科目");
        searchDialogForAdmin.searchTextArea.setText("上海");
        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByArea(searchDialogForAdmin.searchTextArea.getText());
        searchDialogForAdmin.tableValue.removeAllElements();
        for (SchoolList x:schoolLists) {
            Vector<String> vector = new Vector<String>();
            vector.addElement(String.valueOf(x.getRecruitNumber()));
            vector.addElement(String.valueOf(x.getEnglishType()));
            vector.addElement(String.valueOf(x.getMathType()));
            vector.addElement(String.valueOf(x.getPoliticType()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolLoc()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getPreProfessionalCourses()));
            vector.addElement(String.valueOf(x.getReProfessionalCourses()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);*/
    }

    private void ViewSchoolListByGuangDong(ActionEvent e) {
        // TODO add your code here
        ViewSchoolListByAreaOp.ViewSchoolListByArea("广东",0);
        /*searchDialogForAdmin.choicecomboBox.setSelectedIndex(0);
        searchDialogForAdmin.tableTitle.add("录取人数");
        searchDialogForAdmin.tableTitle.add("英语考试类别");
        searchDialogForAdmin.tableTitle.add("数学考试类别");
        searchDialogForAdmin.tableTitle.add("政治考试类别");
        searchDialogForAdmin.tableTitle.add("学校名称");
        searchDialogForAdmin.tableTitle.add("学校地址");
        searchDialogForAdmin.tableTitle.add("学校类型");
        searchDialogForAdmin.tableTitle.add("初试科目");
        searchDialogForAdmin.tableTitle.add("复试科目");
        searchDialogForAdmin.searchTextArea.setText("广东");
        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByArea(searchDialogForAdmin.searchTextArea.getText());
        searchDialogForAdmin.tableValue.removeAllElements();
        for (SchoolList x:schoolLists) {
            Vector<String> vector = new Vector<String>();
            vector.addElement(String.valueOf(x.getRecruitNumber()));
            vector.addElement(String.valueOf(x.getEnglishType()));
            vector.addElement(String.valueOf(x.getMathType()));
            vector.addElement(String.valueOf(x.getPoliticType()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolLoc()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getPreProfessionalCourses()));
            vector.addElement(String.valueOf(x.getReProfessionalCourses()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);*/
    }

    private void ViewSchoolListByGuiZhou(ActionEvent e) {
        // TODO add your code here
        ViewSchoolListByAreaOp.ViewSchoolListByArea("贵州",0);
        /*searchDialogForAdmin.choicecomboBox.setSelectedIndex(0);
        searchDialogForAdmin.tableTitle.add("录取人数");
        searchDialogForAdmin.tableTitle.add("英语考试类别");
        searchDialogForAdmin.tableTitle.add("数学考试类别");
        searchDialogForAdmin.tableTitle.add("政治考试类别");
        searchDialogForAdmin.tableTitle.add("学校名称");
        searchDialogForAdmin.tableTitle.add("学校地址");
        searchDialogForAdmin.tableTitle.add("学校类型");
        searchDialogForAdmin.tableTitle.add("初试科目");
        searchDialogForAdmin.tableTitle.add("复试科目");
        searchDialogForAdmin.searchTextArea.setText("贵州");
        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByArea(searchDialogForAdmin.searchTextArea.getText());
        searchDialogForAdmin.tableValue.removeAllElements();
        for (SchoolList x:schoolLists) {
            Vector<String> vector = new Vector<String>();
            vector.addElement(String.valueOf(x.getRecruitNumber()));
            vector.addElement(String.valueOf(x.getEnglishType()));
            vector.addElement(String.valueOf(x.getMathType()));
            vector.addElement(String.valueOf(x.getPoliticType()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolLoc()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getPreProfessionalCourses()));
            vector.addElement(String.valueOf(x.getReProfessionalCourses()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);*/
    }

    private void ViewSchoolListBySiChuan(ActionEvent e) {
        // TODO add your code here
        ViewSchoolListByAreaOp.ViewSchoolListByArea("四川",0);
        /*searchDialogForAdmin.choicecomboBox.setSelectedIndex(0);
        searchDialogForAdmin.tableTitle.add("录取人数");
        searchDialogForAdmin.tableTitle.add("英语考试类别");
        searchDialogForAdmin.tableTitle.add("数学考试类别");
        searchDialogForAdmin.tableTitle.add("政治考试类别");
        searchDialogForAdmin.tableTitle.add("学校名称");
        searchDialogForAdmin.tableTitle.add("学校地址");
        searchDialogForAdmin.tableTitle.add("学校类型");
        searchDialogForAdmin.tableTitle.add("初试科目");
        searchDialogForAdmin.tableTitle.add("复试科目");
        searchDialogForAdmin.searchTextArea.setText("四川");
        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByArea(searchDialogForAdmin.searchTextArea.getText());
        searchDialogForAdmin.tableValue.removeAllElements();
        for (SchoolList x:schoolLists) {
            Vector<String> vector = new Vector<String>();

            vector.addElement(String.valueOf(x.getRecruitNumber()));
            vector.addElement(String.valueOf(x.getEnglishType()));
            vector.addElement(String.valueOf(x.getMathType()));
            vector.addElement(String.valueOf(x.getPoliticType()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolLoc()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getPreProfessionalCourses()));
            vector.addElement(String.valueOf(x.getReProfessionalCourses()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);*/
    }

    private void ViewSchoolListByJiangXi(ActionEvent e) {
        // TODO add your code here
        ViewSchoolListByAreaOp.ViewSchoolListByArea("江西",0);
        /*searchDialogForAdmin.choicecomboBox.setSelectedIndex(0);
        searchDialogForAdmin.tableTitle.add("录取人数");
        searchDialogForAdmin.tableTitle.add("英语考试类别");
        searchDialogForAdmin.tableTitle.add("数学考试类别");
        searchDialogForAdmin.tableTitle.add("政治考试类别");
        searchDialogForAdmin.tableTitle.add("学校名称");
        searchDialogForAdmin.tableTitle.add("学校地址");
        searchDialogForAdmin.tableTitle.add("学校类型");
        searchDialogForAdmin.tableTitle.add("初试科目");
        searchDialogForAdmin.tableTitle.add("复试科目");
        searchDialogForAdmin.searchTextArea.setText("江西");
        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByArea(searchDialogForAdmin.searchTextArea.getText());
        searchDialogForAdmin.tableValue.removeAllElements();
        for (SchoolList x:schoolLists) {
            Vector<String> vector = new Vector<String>();

            vector.addElement(String.valueOf(x.getRecruitNumber()));
            vector.addElement(String.valueOf(x.getEnglishType()));
            vector.addElement(String.valueOf(x.getMathType()));
            vector.addElement(String.valueOf(x.getPoliticType()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolLoc()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getPreProfessionalCourses()));
            vector.addElement(String.valueOf(x.getReProfessionalCourses()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);*/
    }

    private void ViewSchoolListBy985(ActionEvent e) {
        // TODO add your code here
        /*searchDialogForAdmin.choicecomboBox.setSelectedIndex(1);
        searchDialogForAdmin.tableTitle.add("录取人数");
        searchDialogForAdmin.tableTitle.add("英语考试类别");
        searchDialogForAdmin.tableTitle.add("数学考试类别");
        searchDialogForAdmin.tableTitle.add("政治考试类别");
        searchDialogForAdmin.tableTitle.add("学校名称");
        searchDialogForAdmin.tableTitle.add("学校地址");
        searchDialogForAdmin.tableTitle.add("学校类型");
        searchDialogForAdmin.tableTitle.add("初试科目");
        searchDialogForAdmin.tableTitle.add("复试科目");
        searchDialogForAdmin.searchTextArea.setText("985");
        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByType(searchDialogForAdmin.searchTextArea.getText());
        searchDialogForAdmin.tableValue.removeAllElements();
        for (SchoolList x:schoolLists) {
            Vector<String> vector = new Vector<String>();

            vector.addElement(String.valueOf(x.getRecruitNumber()));
            vector.addElement(String.valueOf(x.getEnglishType()));
            vector.addElement(String.valueOf(x.getMathType()));
            vector.addElement(String.valueOf(x.getPoliticType()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolLoc()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getPreProfessionalCourses()));
            vector.addElement(String.valueOf(x.getReProfessionalCourses()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);*/
        ViewSchoolListByTypeOp.ViewSchoolListByNormalReapt("985",1);
    }

    private void ViewSchoolListBy211(ActionEvent e) {
        // TODO add your code here
        /*searchDialogForAdmin.choicecomboBox.setSelectedIndex(1);
        searchDialogForAdmin.tableTitle.add("录取人数");
        searchDialogForAdmin.tableTitle.add("英语考试类别");
        searchDialogForAdmin.tableTitle.add("数学考试类别");
        searchDialogForAdmin.tableTitle.add("政治考试类别");
        searchDialogForAdmin.tableTitle.add("学校名称");
        searchDialogForAdmin.tableTitle.add("学校地址");
        searchDialogForAdmin.tableTitle.add("学校类型");
        searchDialogForAdmin.tableTitle.add("初试科目");
        searchDialogForAdmin.tableTitle.add("复试科目");
        searchDialogForAdmin.searchTextArea.setText("211");
        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByType(searchDialogForAdmin.searchTextArea.getText());
        searchDialogForAdmin.tableValue.removeAllElements();
        for (SchoolList x:schoolLists) {
            Vector<String> vector = new Vector<String>();

            vector.addElement(String.valueOf(x.getRecruitNumber()));
            vector.addElement(String.valueOf(x.getEnglishType()));
            vector.addElement(String.valueOf(x.getMathType()));
            vector.addElement(String.valueOf(x.getPoliticType()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolLoc()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getPreProfessionalCourses()));
            vector.addElement(String.valueOf(x.getReProfessionalCourses()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);*/
        ViewSchoolListByTypeOp.ViewSchoolListByNormalReapt("211",1);
    }

    private void ViewSchoolListByNormal(ActionEvent e) {
        // TODO add your code here

        /*
        searchDialogForAdmin.choicecomboBox.setSelectedIndex(1);
        searchDialogForAdmin.tableTitle.add("录取人数");
        searchDialogForAdmin.tableTitle.add("英语考试类别");
        searchDialogForAdmin.tableTitle.add("数学考试类别");
        searchDialogForAdmin.tableTitle.add("政治考试类别");
        searchDialogForAdmin.tableTitle.add("学校名称");
        searchDialogForAdmin.tableTitle.add("学校地址");
        searchDialogForAdmin.tableTitle.add("学校类型");
        searchDialogForAdmin.tableTitle.add("初试科目");
        searchDialogForAdmin.tableTitle.add("复试科目");
        searchDialogForAdmin.searchTextArea.setText("normal");
        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByType(searchDialogForAdmin.searchTextArea.getText());
        searchDialogForAdmin.tableValue.removeAllElements();
        for (SchoolList x:schoolLists) {
            Vector<String> vector = new Vector<String>();
            vector.addElement(String.valueOf(x.getRecruitNumber()));
            vector.addElement(String.valueOf(x.getEnglishType()));
            vector.addElement(String.valueOf(x.getMathType()));
            vector.addElement(String.valueOf(x.getPoliticType()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolLoc()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getPreProfessionalCourses()));
            vector.addElement(String.valueOf(x.getReProfessionalCourses()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);*/
        ViewSchoolListByTypeOp.ViewSchoolListByNormalReapt("normal",1);
    }

    private void ViewSchoolListBySelf(ActionEvent e) {
        // TODO add your code here
        searchDialogForAdmin.searchTextArea.setText("");
        searchDialogForAdmin.choicecomboBox.setSelectedIndex(3);
        searchDialogForAdmin.tableTitle.add("录取人数");
        searchDialogForAdmin.tableTitle.add("英语考试类别");
        searchDialogForAdmin.tableTitle.add("数学考试类别");
        searchDialogForAdmin.tableTitle.add("政治考试类别");
        searchDialogForAdmin.tableTitle.add("学校名称");
        searchDialogForAdmin.tableTitle.add("学校地址");
        searchDialogForAdmin.tableTitle.add("学校类型");
        searchDialogForAdmin.tableTitle.add("初试科目");
        searchDialogForAdmin.tableTitle.add("复试科目");

        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByFuzzyQuery(searchDialogForAdmin.searchTextArea.getText());
        searchDialogForAdmin.tableValue.removeAllElements();
        for (SchoolList x:schoolLists) {
            Vector<String> vector = new Vector<String>();
            vector.addElement(String.valueOf(x.getRecruitNumber()));
            vector.addElement(String.valueOf(x.getEnglishType()));
            vector.addElement(String.valueOf(x.getMathType()));
            vector.addElement(String.valueOf(x.getPoliticType()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolLoc()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getPreProfessionalCourses()));
            vector.addElement(String.valueOf(x.getReProfessionalCourses()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);
    }

    private void ViewAllUser(ActionEvent e) {
        // TODO add your code here
        searchDialogForAdmin.choicecomboBox.setSelectedIndex(8);
        searchDialogForAdmin.tableTitle.add("学生姓名");
        searchDialogForAdmin.tableTitle.add("学生密码");
        searchDialogForAdmin.tableTitle.add("学生本科院校名称");
        searchDialogForAdmin.tableTitle.add("学生本科院校类型");
        searchDialogForAdmin.tableTitle.add("学生籍贯");
        searchDialogForAdmin.tableTitle.add("学生志愿学校类型");
        searchDialogForAdmin.tableTitle.add("学生志愿学校地址");
        searchDialogForAdmin.tableTitle.add("学生志愿学校名称");

        Vector<Student> students = studentDAO.ViewAllStudent();
        searchDialogForAdmin.tableValue.removeAllElements();
        for (Student x :students) {
            Vector<String> vector = new Vector<String>();
            vector.addElement(String.valueOf(x.getStudentName()));
            vector.addElement(String.valueOf(x.getStudentPassword()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getDreamSchoolType()));
            vector.addElement(String.valueOf(x.getDreamSchoolLoc()));
            vector.addElement(String.valueOf(x.getDreamSchoolName()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);
    }

    private void ViewSelectedUser(ActionEvent e) {
        // TODO add your code here
        searchDialogForAdmin.choicecomboBox.setSelectedIndex(9);
        searchDialogForAdmin.tableTitle.add("学生姓名");
        searchDialogForAdmin.tableTitle.add("学生密码");
        searchDialogForAdmin.tableTitle.add("学生本科院校名称");
        searchDialogForAdmin.tableTitle.add("学生本科院校类型");
        searchDialogForAdmin.tableTitle.add("学生籍贯");
        searchDialogForAdmin.tableTitle.add("学生志愿学校类型");
        searchDialogForAdmin.tableTitle.add("学生志愿学校地址");
        searchDialogForAdmin.tableTitle.add("学生志愿学校名称");

        Vector<Student> students = studentDAO.ViewSelectedStudentByFuzzyQuery(searchDialogForAdmin.searchTextArea.getText());
        searchDialogForAdmin.tableValue.removeAllElements();
        for (Student x :students) {
            Vector<String> vector = new Vector<String>();

            vector.addElement(String.valueOf(x.getStudentName()));
            vector.addElement(String.valueOf(x.getStudentPassword()));
            vector.addElement(String.valueOf(x.getSchoolName()));
            vector.addElement(String.valueOf(x.getSchoolType()));
            vector.addElement(String.valueOf(x.getDreamSchoolType()));
            vector.addElement(String.valueOf(x.getDreamSchoolLoc()));
            vector.addElement(String.valueOf(x.getDreamSchoolName()));
            searchDialogForAdmin.tableValue.addElement(vector);
        }
        searchDialogForAdmin.tableModel = new DefaultTableModel(searchDialogForAdmin.tableValue, searchDialogForAdmin.tableTitle);
        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);
    }

    private void DelUser(ActionEvent e) {
        // TODO add your code here
        ModifyStudentInfoDialog modifyStudentInfoDialog = new ModifyStudentInfoDialog(mainFrameForAdmin,2);
        modifyStudentInfoDialog.setVisible(true);
    }

    private void DelCurrentAdmin(ActionEvent e) {
        // TODO add your code here

        int result = JOptionPane.showConfirmDialog(mainFrameForAdmin,"是否注销当前用户呢？");
//        System.out.println(result);//“是”为0，“否”为1，“取消”为2

        if (result == JOptionPane.YES_OPTION){
            adminDAO.DeleteAdminInfo(admin.getAdminName());
            JOptionPane.showMessageDialog(mainFrameForAdmin,"用户已经删除！请重新登录已有帐户或联系管理员申请管理员账户。");
            mainFrameForAdmin.setVisible(false);
            loginFrame.loginPrompt.setText("");
            loginFrame.setVisible(true);
        }
    }





    /*这个是增加学校信息*/

    public void initComponents() {
        //加载一个图片当作托盘图标
        Image image = Toolkit.getDefaultToolkit().getImage("月亮.jpg");

        if(SystemTray.isSupported()){
            //获取当前平台的系统托盘
            SystemTray tray = SystemTray.getSystemTray();

            PopupMenu popupMenu = new PopupMenu();

            MenuItem openItem = new MenuItem("打开");
            MenuItem exitItem = new MenuItem("退出");

            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!MainFrameForAdmin.this.isShowing()){
                        MainFrameForAdmin.this.setVisible(true);
                        MainFrameForAdmin.this.setExtendedState(NORMAL);//这个窗口显示到面板
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

            MainFrameForAdmin.this.addWindowListener(new WindowAdapter() {
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
                        MainFrameForAdmin.this.setVisible(true);
                        MainFrameForAdmin.this.setExtendedState(NORMAL);//这个窗口显示到面板
                        tray.remove(trayIcon);
                    }
                }
            });
        }
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        viewCurrrentAdminInfo = new JMenuItem();
        viewAllAdminInfo = new JMenuItem();
        viewSelectedAdminInfo = new JMenuItem();
        modifyCurrentAdminInfo = new JMenuItem();
        addAminInfoItem = new JMenuItem();
        menu7 = new JMenu();
        delAdminItem = new JMenuItem();
        quitSystem = new JMenuItem();
        DelCurrentAdmin = new JMenuItem();
        quitLogin = new JMenuItem();
        menu2 = new JMenu();
        menu8 = new JMenu();
        addSchoolInfoMenu = new JMenuItem();
        delSchoolInfoMenu = new JMenuItem();
        modifySchoolInfoMenu = new JMenuItem();
        menu13 = new JMenu();
        addSchoolListMenu = new JMenuItem();
        delSchoolListMenu = new JMenuItem();
        modifySchoolListMenu = new JMenuItem();
        menu3 = new JMenu();
        menu9 = new JMenu();
        ViewSchoolListByAnHui = new JMenuItem();
        ViewSchoolListByJiangSu = new JMenuItem();
        ViewSchoolListByShangHai = new JMenuItem();
        ViewSchoolListByGuangDong = new JMenuItem();
        ViewSchoolListByGuiZhou = new JMenuItem();
        ViewSchoolListBySiChuan = new JMenuItem();
        ViewSchoolListByJiangXi = new JMenuItem();
        menu10 = new JMenu();
        ViewSchoolListBy985 = new JMenuItem();
        ViewSchoolListBy211 = new JMenuItem();
        ViewSchoolListByNormal = new JMenuItem();
        ViewSchoolListBySelf = new JMenuItem();
        menu6 = new JMenu();
        ViewAllUser = new JMenuItem();
        ViewSelectedUser = new JMenuItem();
        DelUser = new JMenuItem();
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        adminMainLabel = new JLabel();

        //======== this ========
        setTitle("\u7ba1\u7406\u5458\u7cfb\u7edf");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7ba1\u7406\u5458\u4fe1\u606f");
                menu1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

                //---- viewCurrrentAdminInfo ----
                viewCurrrentAdminInfo.setText("\u67e5\u770b\u5f53\u524d\u7ba1\u7406\u5458\u4fe1\u606f");
                viewCurrrentAdminInfo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                viewCurrrentAdminInfo.addActionListener(e -> viewCurrrentAdminInfo(e));
                menu1.add(viewCurrrentAdminInfo);

                //---- viewAllAdminInfo ----
                viewAllAdminInfo.setText("\u67e5\u770b\u6240\u6709\u7ba1\u7406\u5458\u4fe1\u606f");
                viewAllAdminInfo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                viewAllAdminInfo.addActionListener(e -> viewAllAdminInfo(e));
                menu1.add(viewAllAdminInfo);

                //---- viewSelectedAdminInfo ----
                viewSelectedAdminInfo.setText("\u67e5\u770b\u6307\u5b9a\u7ba1\u7406\u5458\u4fe1\u606f");
                viewSelectedAdminInfo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                viewSelectedAdminInfo.addActionListener(e -> viewSelectedAdminInfo(e));
                menu1.add(viewSelectedAdminInfo);

                //---- modifyCurrentAdminInfo ----
                modifyCurrentAdminInfo.setText("\u4fee\u6539\u5f53\u524d\u7ba1\u7406\u5458\u4fe1\u606f");
                modifyCurrentAdminInfo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                modifyCurrentAdminInfo.addActionListener(e -> modifyCurrentAdminInfo(e));
                menu1.add(modifyCurrentAdminInfo);

                //---- addAminInfoItem ----
                addAminInfoItem.setText("\u589e\u52a0\u7ba1\u7406\u5458\u4fe1\u606f");
                addAminInfoItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                addAminInfoItem.addActionListener(e -> addAminInfoItem(e));
                menu1.add(addAminInfoItem);

                //======== menu7 ========
                {
                    menu7.setText("\u9ad8\u5371\u9009\u9879");
                    menu7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- delAdminItem ----
                    delAdminItem.setText("\u5220\u9664\u7279\u5b9a\u7ba1\u7406\u5458\u4fe1\u606f");
                    delAdminItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    delAdminItem.addActionListener(e -> delAdminItem(e));
                    menu7.add(delAdminItem);

                    //---- quitSystem ----
                    quitSystem.setText("\u505c\u6b62\u7cfb\u7edf\u670d\u52a1");
                    quitSystem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    quitSystem.addActionListener(e -> quitSystem(e));
                    menu7.add(quitSystem);
                }
                menu1.add(menu7);

                //---- DelCurrentAdmin ----
                DelCurrentAdmin.setText("\u6ce8\u9500\u5f53\u524d\u7ba1\u7406\u5458\u8d26\u6237");
                DelCurrentAdmin.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                DelCurrentAdmin.addActionListener(e -> DelCurrentAdmin(e));
                menu1.add(DelCurrentAdmin);

                //---- quitLogin ----
                quitLogin.setText("\u9000\u51fa\u767b\u5f55");
                quitLogin.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                quitLogin.addActionListener(e -> quitLogin(e));
                menu1.add(quitLogin);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u9662\u6821\u4fee\u6539");
                menu2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

                //======== menu8 ========
                {
                    menu8.setText("\u589e\u52a0/\u5220\u9664/\u4fee\u6539\u9662\u6821\u4fe1\u606f");
                    menu8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- addSchoolInfoMenu ----
                    addSchoolInfoMenu.setText("\u589e\u52a0\u9662\u6821");
                    addSchoolInfoMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    addSchoolInfoMenu.addActionListener(e -> addSchoolInfoMenu(e));
                    menu8.add(addSchoolInfoMenu);

                    //---- delSchoolInfoMenu ----
                    delSchoolInfoMenu.setText("\u5220\u9664\u9662\u6821");
                    delSchoolInfoMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    delSchoolInfoMenu.addActionListener(e -> delSchoolInfoMenu(e));
                    menu8.add(delSchoolInfoMenu);

                    //---- modifySchoolInfoMenu ----
                    modifySchoolInfoMenu.setText("\u4fee\u6539\u9662\u6821");
                    modifySchoolInfoMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    modifySchoolInfoMenu.addActionListener(e -> modifySchoolInfoMenu(e));
                    menu8.add(modifySchoolInfoMenu);
                }
                menu2.add(menu8);

                //======== menu13 ========
                {
                    menu13.setText("\u589e\u52a0/\u5220\u9664/\u4fee\u6539\u9662\u6821\u5217\u8868");
                    menu13.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- addSchoolListMenu ----
                    addSchoolListMenu.setText("\u589e\u52a0\u9662\u6821");
                    addSchoolListMenu.setFont(addSchoolListMenu.getFont().deriveFont(addSchoolListMenu.getFont().getSize() + 2f));
                    addSchoolListMenu.addActionListener(e -> addSchoolListMenu(e));
                    menu13.add(addSchoolListMenu);

                    //---- delSchoolListMenu ----
                    delSchoolListMenu.setText("\u5220\u9664\u9662\u6821");
                    delSchoolListMenu.setFont(delSchoolListMenu.getFont().deriveFont(delSchoolListMenu.getFont().getSize() + 2f));
                    delSchoolListMenu.addActionListener(e -> delSchoolListMenu(e));
                    menu13.add(delSchoolListMenu);

                    //---- modifySchoolListMenu ----
                    modifySchoolListMenu.setText("\u4fee\u6539\u9662\u6821");
                    modifySchoolListMenu.setFont(modifySchoolListMenu.getFont().deriveFont(modifySchoolListMenu.getFont().getSize() + 2f));
                    modifySchoolListMenu.addActionListener(e -> modifySchoolListMenu(e));
                    menu13.add(modifySchoolListMenu);
                }
                menu2.add(menu13);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u67e5\u8be2\u9662\u6821");
                menu3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

                //======== menu9 ========
                {
                    menu9.setText("\u6309\u5730\u533a\u67e5\u8be2");
                    menu9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- ViewSchoolListByAnHui ----
                    ViewSchoolListByAnHui.setText("\u5b89\u5fbd");
                    ViewSchoolListByAnHui.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    ViewSchoolListByAnHui.addActionListener(e -> ViewSchoolListByAnHui(e));
                    menu9.add(ViewSchoolListByAnHui);

                    //---- ViewSchoolListByJiangSu ----
                    ViewSchoolListByJiangSu.setText("\u6c5f\u82cf");
                    ViewSchoolListByJiangSu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    ViewSchoolListByJiangSu.addActionListener(e -> ViewSchoolListByJiangSu(e));
                    menu9.add(ViewSchoolListByJiangSu);

                    //---- ViewSchoolListByShangHai ----
                    ViewSchoolListByShangHai.setText("\u4e0a\u6d77");
                    ViewSchoolListByShangHai.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    ViewSchoolListByShangHai.addActionListener(e -> ViewSchoolListByShangHai(e));
                    menu9.add(ViewSchoolListByShangHai);

                    //---- ViewSchoolListByGuangDong ----
                    ViewSchoolListByGuangDong.setText("\u5e7f\u4e1c");
                    ViewSchoolListByGuangDong.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    ViewSchoolListByGuangDong.addActionListener(e -> ViewSchoolListByGuangDong(e));
                    menu9.add(ViewSchoolListByGuangDong);

                    //---- ViewSchoolListByGuiZhou ----
                    ViewSchoolListByGuiZhou.setText("\u8d35\u5dde");
                    ViewSchoolListByGuiZhou.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    ViewSchoolListByGuiZhou.addActionListener(e -> ViewSchoolListByGuiZhou(e));
                    menu9.add(ViewSchoolListByGuiZhou);

                    //---- ViewSchoolListBySiChuan ----
                    ViewSchoolListBySiChuan.setText("\u56db\u5ddd");
                    ViewSchoolListBySiChuan.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    ViewSchoolListBySiChuan.addActionListener(e -> ViewSchoolListBySiChuan(e));
                    menu9.add(ViewSchoolListBySiChuan);

                    //---- ViewSchoolListByJiangXi ----
                    ViewSchoolListByJiangXi.setText("\u6c5f\u897f");
                    ViewSchoolListByJiangXi.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    ViewSchoolListByJiangXi.addActionListener(e -> ViewSchoolListByJiangXi(e));
                    menu9.add(ViewSchoolListByJiangXi);
                }
                menu3.add(menu9);

                //======== menu10 ========
                {
                    menu10.setText("\u6309\u7c7b\u522b\u67e5\u8be2");
                    menu10.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                    //---- ViewSchoolListBy985 ----
                    ViewSchoolListBy985.setText("\u67e5\u8be2985\u9662\u6821");
                    ViewSchoolListBy985.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    ViewSchoolListBy985.addActionListener(e -> ViewSchoolListBy985(e));
                    menu10.add(ViewSchoolListBy985);

                    //---- ViewSchoolListBy211 ----
                    ViewSchoolListBy211.setText("\u67e5\u8be2211\u9662\u6821");
                    ViewSchoolListBy211.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    ViewSchoolListBy211.addActionListener(e -> ViewSchoolListBy211(e));
                    menu10.add(ViewSchoolListBy211);

                    //---- ViewSchoolListByNormal ----
                    ViewSchoolListByNormal.setText("\u67e5\u8be2\u666e\u672c\u9662\u6821");
                    ViewSchoolListByNormal.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                    ViewSchoolListByNormal.addActionListener(e -> ViewSchoolListByNormal(e));
                    menu10.add(ViewSchoolListByNormal);
                }
                menu3.add(menu10);

                //---- ViewSchoolListBySelf ----
                ViewSchoolListBySelf.setText("\u67e5\u8be2\u6307\u5b9a\u9662\u6821\u4fe1\u606f");
                ViewSchoolListBySelf.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                ViewSchoolListBySelf.addActionListener(e -> ViewSchoolListBySelf(e));
                menu3.add(ViewSchoolListBySelf);
            }
            menuBar1.add(menu3);

            //======== menu6 ========
            {
                menu6.setText("\u64cd\u4f5c\u7528\u6237\u4fe1\u606f");
                menu6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

                //---- ViewAllUser ----
                ViewAllUser.setText("\u67e5\u8be2\u6240\u6709\u7528\u6237\u4fe1\u606f");
                ViewAllUser.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                ViewAllUser.addActionListener(e -> ViewAllUser(e));
                menu6.add(ViewAllUser);

                //---- ViewSelectedUser ----
                ViewSelectedUser.setText("\u6839\u636e\u7528\u6237\u540d\u67e5\u8be2");
                ViewSelectedUser.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                ViewSelectedUser.addActionListener(e -> ViewSelectedUser(e));
                menu6.add(ViewSelectedUser);

                //---- DelUser ----
                DelUser.setText("\u5220\u9664\u7528\u6237\u4fe1\u606f");
                DelUser.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                DelUser.addActionListener(e -> DelUser(e));
                menu6.add(DelUser);
            }
            menuBar1.add(menu6);
        }
        setJMenuBar(menuBar1);

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- adminMainLabel ----
                adminMainLabel.setText("\u6b22\u8fce");
                adminMainLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
                adminMainLabel.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(adminMainLabel, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(156, Short.MAX_VALUE)
                            .addComponent(adminMainLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                            .addGap(122, 122, 122))
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
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem viewCurrrentAdminInfo;
    private JMenuItem viewAllAdminInfo;
    private JMenuItem viewSelectedAdminInfo;
    private JMenuItem modifyCurrentAdminInfo;
    private JMenuItem addAminInfoItem;
    private JMenu menu7;
    private JMenuItem delAdminItem;
    private JMenuItem quitSystem;
    private JMenuItem DelCurrentAdmin;
    private JMenuItem quitLogin;
    private JMenu menu2;
    private JMenu menu8;
    private JMenuItem addSchoolInfoMenu;
    private JMenuItem delSchoolInfoMenu;
    private JMenuItem modifySchoolInfoMenu;
    private JMenu menu13;
    private JMenuItem addSchoolListMenu;
    private JMenuItem delSchoolListMenu;
    private JMenuItem modifySchoolListMenu;
    private JMenu menu3;
    private JMenu menu9;
    private JMenuItem ViewSchoolListByAnHui;
    private JMenuItem ViewSchoolListByJiangSu;
    private JMenuItem ViewSchoolListByShangHai;
    private JMenuItem ViewSchoolListByGuangDong;
    private JMenuItem ViewSchoolListByGuiZhou;
    private JMenuItem ViewSchoolListBySiChuan;
    private JMenuItem ViewSchoolListByJiangXi;
    private JMenu menu10;
    private JMenuItem ViewSchoolListBy985;
    private JMenuItem ViewSchoolListBy211;
    private JMenuItem ViewSchoolListByNormal;
    private JMenuItem ViewSchoolListBySelf;
    private JMenu menu6;
    private JMenuItem ViewAllUser;
    private JMenuItem ViewSelectedUser;
    private JMenuItem DelUser;
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel adminMainLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        mainFrameForAdmin.setVisible(true);
    }
}
