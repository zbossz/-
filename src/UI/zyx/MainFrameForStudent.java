/*
 * Created by JFormDesigner on Wed Apr 20 10:34:29 CST 2022
 */

package UI.zyx;

import DAO.yx.SchoolList;
import DAO.zyx.Student;
import Operations.ViewSchoolListByAreaOp;
import Operations.ViewSchoolListByTypeOp;
import UI.zzy.ModifyStudentInfoDialog;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import static Utils.zzy.CommonData.*;
import static Utils.zzy.CommonData.loginFrame;

/**
 * @author 1
 */
public class MainFrameForStudent extends JFrame {
    public MainFrameForStudent() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here

    }

    private void delStudent(ActionEvent e) {
//        System.out.println(JOptionPane.YES_OPTION);
        int result = JOptionPane.showConfirmDialog(mainFrameForStudent,"是否注销当前用户呢？");
//        System.out.println(result);//“是”为0，“否”为1，“取消”为2

        if (result == JOptionPane.YES_OPTION){
            studentDAO.DeleteStudent(student.getStudentName());
            JOptionPane.showMessageDialog(mainFrameForStudent,"用户已经删除！请重新登录已有帐户或注册新账户。");
            mainFrameForStudent.setVisible(false);
            loginFrame.loginPrompt.setText("");
            loginFrame.setVisible(true);
        }
    }

    private void modifyStudent(ActionEvent e) {
        ModifyStudentInfoDialog modifyStudentInfoDialog = new ModifyStudentInfoDialog(mainFrameForStudent,3);
        modifyStudentInfoDialog.setVisible(true);
    }

    private void quitLogin(ActionEvent e) {
        mainFrameForStudent.dispose();
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

    private void quitSystem(ActionEvent e) {
        System.exit(0);
    }

    private void checkSystemUpdateTime(ActionEvent e) {
        JOptionPane.showMessageDialog(mainFrameForStudent,"系统信息更新时间是:"
                +"2021"+"年考研信息!！"+"\n"+"系统更新时间是:"+"2022年5月29日"+"\n"+"当前系统时间是 : "
                +new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date()));
    }

    private void aboutAuthor(ActionEvent e) {
        JOptionPane.showMessageDialog(mainFrameForStudent,"作者: zbossz（禁止盗用）");
    }

    private void viewCurrrentStudentInfo(ActionEvent e) {
        // TODO add your code here
        searchDialogForStudent.choicecomboBox.setSelectedIndex(6);
        searchDialogForStudent.choicecomboBox.setEditable(false);

        searchDialogForStudent.searchTextArea.setText(student.getStudentName());
        searchDialogForStudent.searchTextArea.setEditable(false);

        searchDialogForStudent.tableTitle.add("学生姓名");
        searchDialogForStudent.tableTitle.add("学生密码");
        searchDialogForStudent.tableTitle.add("学生本科院校名称");
        searchDialogForStudent.tableTitle.add("学生本科院校类型");
        searchDialogForStudent.tableTitle.add("学生籍贯");
        searchDialogForStudent.tableTitle.add("学生志愿学校类型");
        searchDialogForStudent.tableTitle.add("学生志愿学校地址");
        searchDialogForStudent.tableTitle.add("学生志愿学校名称");
        Student student = studentDAO.ViewSelectedStudentByName(searchDialogForStudent.searchTextArea.getText());

        searchDialogForStudent.tableValue.removeAllElements();
        if(student!=null){
            Vector vector = new Vector();

            vector.addElement(String.valueOf(student.getStudentName()));
            vector.addElement(String.valueOf(student.getStudentPassword()));
            vector.addElement(String.valueOf(student.getSchoolName()));
            vector.addElement(String.valueOf(student.getSchoolType()));
            vector.addElement(String.valueOf(student.getCameFrom()));
            vector.addElement(String.valueOf(student.getDreamSchoolType()));
            vector.addElement(String.valueOf(student.getDreamSchoolLoc()));
            vector.addElement(String.valueOf(student.getDreamSchoolName()));
            searchDialogForStudent.tableValue.addElement(vector);
        }
        searchDialogForStudent.tableModel = new DefaultTableModel(searchDialogForStudent.tableValue, searchDialogForStudent.tableTitle);
        searchDialogForStudent.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForStudent.contenttable.setModel(searchDialogForStudent.tableModel);
        searchDialogForStudent.tableTitle.removeAllElements();
        searchDialogForStudent.setVisible(true);
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
        searchDialogForStudent.searchTextArea.setText("");
        searchDialogForStudent.searchTextArea.setEditable(true);

        searchDialogForStudent.choicecomboBox.setSelectedIndex(3);
        searchDialogForStudent.tableTitle.add("录取人数");
        searchDialogForStudent.tableTitle.add("英语考试类别");
        searchDialogForStudent.tableTitle.add("数学考试类别");
        searchDialogForStudent.tableTitle.add("政治考试类别");
        searchDialogForStudent.tableTitle.add("学校名称");
        searchDialogForStudent.tableTitle.add("学校地址");
        searchDialogForStudent.tableTitle.add("学校类型");
        searchDialogForStudent.tableTitle.add("初试科目");
        searchDialogForStudent.tableTitle.add("复试科目");


        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByFuzzyQuery(searchDialogForStudent.searchTextArea.getText());
        searchDialogForStudent.tableValue.removeAllElements();
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
            searchDialogForStudent.tableValue.addElement(vector);
        }
        searchDialogForStudent.tableModel = new DefaultTableModel(searchDialogForStudent.tableValue, searchDialogForStudent.tableTitle);
        searchDialogForStudent.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForStudent.contenttable.setModel(searchDialogForStudent.tableModel);
        searchDialogForStudent.tableTitle.removeAllElements();
        searchDialogForStudent.setVisible(true);
    }

    private void SuggestByType(ActionEvent e) {
        // TODO add your code here
        searchDialogForStudent.choicecomboBox.setSelectedIndex(1);

        searchDialogForStudent.tableTitle.add("录取人数");
        searchDialogForStudent.tableTitle.add("英语考试类别");
        searchDialogForStudent.tableTitle.add("数学考试类别");
        searchDialogForStudent.tableTitle.add("政治考试类别");
        searchDialogForStudent.tableTitle.add("学校名称");
        searchDialogForStudent.tableTitle.add("学校地址");
        searchDialogForStudent.tableTitle.add("学校类型");
        searchDialogForStudent.tableTitle.add("初试科目");
        searchDialogForStudent.tableTitle.add("复试科目");

        searchDialogForStudent.searchTextArea.setText(student.getDreamSchoolType());
        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByType(searchDialogForStudent.searchTextArea.getText());
        searchDialogForStudent.tableValue.removeAllElements();
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
            searchDialogForStudent.tableValue.addElement(vector);
        }
        searchDialogForStudent.tableModel = new DefaultTableModel(searchDialogForStudent.tableValue, searchDialogForStudent.tableTitle);
        searchDialogForStudent.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForStudent.contenttable.setModel(searchDialogForStudent.tableModel);
        searchDialogForStudent.tableTitle.removeAllElements();
        searchDialogForStudent.setVisible(true);


    }

    private void SuggestByArea(ActionEvent e) {
        // TODO add your code here
        searchDialogForStudent.choicecomboBox.setSelectedIndex(0);
        searchDialogForStudent.tableTitle.add("录取人数");
        searchDialogForStudent.tableTitle.add("英语考试类别");
        searchDialogForStudent.tableTitle.add("数学考试类别");
        searchDialogForStudent.tableTitle.add("政治考试类别");
        searchDialogForStudent.tableTitle.add("学校名称");
        searchDialogForStudent.tableTitle.add("学校地址");
        searchDialogForStudent.tableTitle.add("学校类型");
        searchDialogForStudent.tableTitle.add("初试科目");
        searchDialogForStudent.tableTitle.add("复试科目");

        searchDialogForStudent.searchTextArea.setText(student.getDreamSchoolLoc());
        Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByArea(searchDialogForStudent.searchTextArea.getText());
        searchDialogForStudent.tableValue.removeAllElements();
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
            searchDialogForStudent.tableValue.addElement(vector);
        }
        searchDialogForStudent.tableModel = new DefaultTableModel(searchDialogForStudent.tableValue, searchDialogForStudent.tableTitle);
        searchDialogForStudent.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForStudent.contenttable.setModel(searchDialogForStudent.tableModel);
        searchDialogForStudent.tableTitle.removeAllElements();
        searchDialogForStudent.setVisible(true);
    }

    private void SuggestByName(ActionEvent e) {
        // TODO add your code here
        searchDialogForStudent.choicecomboBox.setSelectedIndex(2);
        searchDialogForStudent.tableTitle.add("录取人数");
        searchDialogForStudent.tableTitle.add("英语考试类别");
        searchDialogForStudent.tableTitle.add("数学考试类别");
        searchDialogForStudent.tableTitle.add("政治考试类别");
        searchDialogForStudent.tableTitle.add("学校名称");
        searchDialogForStudent.tableTitle.add("学校地址");
        searchDialogForStudent.tableTitle.add("学校类型");
        searchDialogForStudent.tableTitle.add("初试科目");
        searchDialogForStudent.tableTitle.add("复试科目");

        searchDialogForStudent.searchTextArea.setText(student.getDreamSchoolName());
        SchoolList schoolList = schoolListDAO.ViewselectedSchoolListByName(searchDialogForStudent.searchTextArea.getText());
        searchDialogForStudent.tableValue.removeAllElements();
        if (schoolList!=null) {
            Vector<String> vector = new Vector<String>();

            vector.addElement(String.valueOf(schoolList.getRecruitNumber()));
            vector.addElement(String.valueOf(schoolList.getEnglishType()));
            vector.addElement(String.valueOf(schoolList.getMathType()));
            vector.addElement(String.valueOf(schoolList.getPoliticType()));
            vector.addElement(String.valueOf(schoolList.getSchoolName()));
            vector.addElement(String.valueOf(schoolList.getSchoolLoc()));
            vector.addElement(String.valueOf(schoolList.getSchoolType()));
            vector.addElement(String.valueOf(schoolList.getPreProfessionalCourses()));
            vector.addElement(String.valueOf(schoolList.getReProfessionalCourses()));
            searchDialogForStudent.tableValue.addElement(vector);
        }
        searchDialogForStudent.tableModel = new DefaultTableModel(searchDialogForStudent.tableValue, searchDialogForStudent.tableTitle);
        searchDialogForStudent.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForStudent.contenttable.setModel(searchDialogForStudent.tableModel);
        searchDialogForStudent.tableTitle.removeAllElements();
        searchDialogForStudent.setVisible(true);
    }

    private void initComponents() {
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
                    if(!MainFrameForStudent.this.isShowing()){
                        MainFrameForStudent.this.setVisible(true);
                        MainFrameForStudent.this.setExtendedState(NORMAL);//这个窗口显示到面板
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

            MainFrameForStudent.this.addWindowListener(new WindowAdapter() {
                @Override
                //这个是窗口最小化事件
                public void windowIconified(WindowEvent e) {
                    try {
                        tray.add(trayIcon);
                    } catch (AWTException ex) {
                        throw new RuntimeException(ex);
                    }
                    mainFrameForStudent.setVisible(false);
                }
            });
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getButton()==MouseEvent.BUTTON1) {//button3是右键，button1是左键
                        super.mouseClicked(e);
                        int clickedtimes = e.getClickCount();
                        if (clickedtimes == 1) {
                            mainFrameForStudent.setVisible(true);
                            mainFrameForStudent.setExtendedState(NORMAL);//这个窗口显示到面板
                        }
                        tray.remove(trayIcon);
                    }
                }
            });
        }
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu3 = new JMenu();
        viewCurrrentStudentInfo = new JMenuItem();
        modifyStudentmenuItem = new JMenuItem();
        delStudentmenuItem = new JMenuItem();
        quitLoginmenuItem = new JMenuItem();
        menu7 = new JMenu();
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
        menu5 = new JMenu();
        SuggestByType = new JMenuItem();
        SuggestByArea = new JMenuItem();
        SuggestByName = new JMenuItem();
        menu6 = new JMenu();
        checkSystemUpdateTimemenuItem = new JMenuItem();
        aboutUsmenuItem = new JMenuItem();
        quitSystemmenuItem = new JMenuItem();
        studentMainLabel = new JLabel();

        //======== this ========
        setTitle("\u5b66\u751f\u7cfb\u7edf");
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu3 ========
            {
                menu3.setText("\u4e2a\u4eba\u4fe1\u606f");
                menu3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

                //---- viewCurrrentStudentInfo ----
                viewCurrrentStudentInfo.setText("\u67e5\u770b\u4fe1\u606f");
                viewCurrrentStudentInfo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                viewCurrrentStudentInfo.addActionListener(e -> viewCurrrentStudentInfo(e));
                menu3.add(viewCurrrentStudentInfo);

                //---- modifyStudentmenuItem ----
                modifyStudentmenuItem.setText("\u4fee\u6539\u4fe1\u606f");
                modifyStudentmenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                modifyStudentmenuItem.addActionListener(e -> modifyStudent(e));
                menu3.add(modifyStudentmenuItem);

                //---- delStudentmenuItem ----
                delStudentmenuItem.setText("\u6ce8\u9500\u7528\u6237");
                delStudentmenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                delStudentmenuItem.addActionListener(e -> delStudent(e));
                menu3.add(delStudentmenuItem);

                //---- quitLoginmenuItem ----
                quitLoginmenuItem.setText("\u9000\u51fa\u767b\u5f55");
                quitLoginmenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                quitLoginmenuItem.addActionListener(e -> quitLogin(e));
                menu3.add(quitLoginmenuItem);
            }
            menuBar1.add(menu3);

            //======== menu7 ========
            {
                menu7.setText("\u67e5\u8be2\u9662\u6821");
                menu7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

                //======== menu9 ========
                {
                    menu9.setText("\u6309\u5730\u533a\u67e5\u8be2\u9662\u6821\u540d\u5355");
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
                menu7.add(menu9);

                //======== menu10 ========
                {
                    menu10.setText("\u6309\u7c7b\u522b\u67e5\u8be2\u9662\u6821\u540d\u5355");
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
                menu7.add(menu10);

                //---- ViewSchoolListBySelf ----
                ViewSchoolListBySelf.setText("\u67e5\u8be2\u6307\u5b9a\u9662\u6821\u4fe1\u606f");
                ViewSchoolListBySelf.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                ViewSchoolListBySelf.addActionListener(e -> ViewSchoolListBySelf(e));
                menu7.add(ViewSchoolListBySelf);
            }
            menuBar1.add(menu7);

            //======== menu5 ========
            {
                menu5.setText("\u63a8\u8350\u9662\u6821");
                menu5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

                //---- SuggestByType ----
                SuggestByType.setText("\u6309\u7167\u5fd7\u613f\u5b66\u6821\u7c7b\u578b\u63a8\u8350");
                SuggestByType.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                SuggestByType.addActionListener(e -> SuggestByType(e));
                menu5.add(SuggestByType);

                //---- SuggestByArea ----
                SuggestByArea.setText("\u6309\u7167\u5fd7\u613f\u5b66\u6821\u5730\u533a\u63a8\u8350");
                SuggestByArea.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                SuggestByArea.addActionListener(e -> SuggestByArea(e));
                menu5.add(SuggestByArea);

                //---- SuggestByName ----
                SuggestByName.setText("\u67e5\u770b\u4e2a\u4eba\u5fd7\u613f\u5b66\u6821\u4fe1\u606f");
                SuggestByName.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                SuggestByName.addActionListener(e -> SuggestByName(e));
                menu5.add(SuggestByName);
            }
            menuBar1.add(menu5);

            //======== menu6 ========
            {
                menu6.setText("\u8bbe\u7f6e");
                menu6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

                //---- checkSystemUpdateTimemenuItem ----
                checkSystemUpdateTimemenuItem.setText("\u67e5\u770b\u7cfb\u7edf\u66f4\u65b0\u65f6\u95f4");
                checkSystemUpdateTimemenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                checkSystemUpdateTimemenuItem.addActionListener(e -> checkSystemUpdateTime(e));
                menu6.add(checkSystemUpdateTimemenuItem);

                //---- aboutUsmenuItem ----
                aboutUsmenuItem.setText("\u5173\u4e8e\u4f5c\u8005");
                aboutUsmenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                aboutUsmenuItem.addActionListener(e -> aboutAuthor(e));
                menu6.add(aboutUsmenuItem);

                //---- quitSystemmenuItem ----
                quitSystemmenuItem.setText("\u9000\u51fa");
                quitSystemmenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                quitSystemmenuItem.addActionListener(e -> quitSystem(e));
                menu6.add(quitSystemmenuItem);
            }
            menuBar1.add(menu6);
        }
        setJMenuBar(menuBar1);

        //---- studentMainLabel ----
        studentMainLabel.setText("\u6b22\u8fce");
        studentMainLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
        studentMainLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(studentMainLabel, GroupLayout.PREFERRED_SIZE, 692, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 813, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(studentMainLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 448, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu3;
    private JMenuItem viewCurrrentStudentInfo;
    private JMenuItem modifyStudentmenuItem;
    private JMenuItem delStudentmenuItem;
    private JMenuItem quitLoginmenuItem;
    private JMenu menu7;
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
    private JMenu menu5;
    private JMenuItem SuggestByType;
    private JMenuItem SuggestByArea;
    private JMenuItem SuggestByName;
    private JMenu menu6;
    private JMenuItem checkSystemUpdateTimemenuItem;
    private JMenuItem aboutUsmenuItem;
    private JMenuItem quitSystemmenuItem;
    private JLabel studentMainLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        mainFrameForStudent.setVisible(true);
    }
}
