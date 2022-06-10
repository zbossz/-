/*
 * Created by JFormDesigner on Sun Apr 24 21:58:13 CST 2022
 */

package UI.yx;

import DAO.yx.SchoolList;
import DAO.zyx.Student;
import DAO.yx.Admin;
import DAO.zyx.SchoolInfo;

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
public class SearchDialogForAdmin extends JDialog {
    public SearchDialogForAdmin(Window owner) {
        super(owner);
        initComponents();
    }

    private void clear(ActionEvent e) {
        // TODO add your code here

        searchTextArea.setText("");
        tableTitle.removeAllElements();
        tableValue.removeAllElements();
        tableModel = new DefaultTableModel(tableValue, tableTitle);
        tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
        contenttable.setModel(tableModel);
    }



    
    

    protected void search(ActionEvent e) {
        // TODO add your code here
        if(choicecomboBox.getSelectedItem().equals("��������ѯѧУ")){
            tableTitle.add("¼ȡ����");
            tableTitle.add("Ӣ�￼�����");
            tableTitle.add("��ѧ�������");
            tableTitle.add("���ο������");
            tableTitle.add("ѧУ����");
            tableTitle.add("ѧУ��ַ");
            tableTitle.add("ѧУ����");
            tableTitle.add("���Կ�Ŀ");
            tableTitle.add("���Կ�Ŀ");

            Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByArea(searchTextArea.getText());
            tableValue.removeAllElements();
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
                tableValue.addElement(vector);
            }
            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }
        else if (choicecomboBox.getSelectedItem().equals("�����Ͳ�ѯѧУ")) {

            tableTitle.add("¼ȡ����");
            tableTitle.add("Ӣ�￼�����");
            tableTitle.add("��ѧ�������");
            tableTitle.add("���ο������");
            tableTitle.add("ѧУ����");
            tableTitle.add("ѧУ��ַ");
            tableTitle.add("ѧУ����");
            tableTitle.add("���Կ�Ŀ");
            tableTitle.add("���Կ�Ŀ");

            Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByType(searchTextArea.getText());
            tableValue.removeAllElements();
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
                tableValue.addElement(vector);
            }
            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }
        else if (choicecomboBox.getSelectedItem().equals("�����Ʋ�ѯѧУ")) {
            tableTitle.add("¼ȡ����");
            tableTitle.add("Ӣ�￼�����");
            tableTitle.add("��ѧ�������");
            tableTitle.add("���ο������");
            tableTitle.add("ѧУ����");
            tableTitle.add("ѧУ��ַ");
            tableTitle.add("ѧУ����");
            tableTitle.add("���Կ�Ŀ");
            tableTitle.add("���Կ�Ŀ");

            SchoolList schoolList = schoolListDAO.ViewselectedSchoolListByName(searchTextArea.getText());
            tableValue.removeAllElements();
            if(schoolList !=null){
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
                tableValue.addElement(vector);
            }

            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }
        else if (choicecomboBox.getSelectedItem().equals("ģ����ѯѧУ")) {
            tableTitle.add("¼ȡ����");
            tableTitle.add("Ӣ�￼�����");
            tableTitle.add("��ѧ�������");
            tableTitle.add("���ο������");
            tableTitle.add("ѧУ����");
            tableTitle.add("ѧУ��ַ");
            tableTitle.add("ѧУ����");
            tableTitle.add("���Կ�Ŀ");
            tableTitle.add("���Կ�Ŀ");

            Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByFuzzyQuery(searchTextArea.getText());
            tableValue.removeAllElements();
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
                tableValue.addElement(vector);
            }
            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }
        else if (choicecomboBox.getSelectedItem().equals("�����Ʋ�ѯѧУרҵ��")) {
            tableTitle.add("ѧУ����");
            tableTitle.add("ѧУ���");
            tableTitle.add("ȫ����ͷ�");
            tableTitle.add("ȫ��ƽ����");
            tableTitle.add("ȫ����߷�");
            tableTitle.add("Ӣ����ͷ�");
            tableTitle.add("Ӣ��ƽ����");
            tableTitle.add("Ӣ����߷�");
            tableTitle.add("������ͷ�");
            tableTitle.add("����ƽ����");
            tableTitle.add("������߷�");
            tableTitle.add("רҵ��1��ͷ�");
            tableTitle.add("רҵ��1ƽ����");
            tableTitle.add("רҵ��1��߷�");
            tableTitle.add("רҵ��2��ͷ�");
            tableTitle.add("רҵ��2ƽ����");
            tableTitle.add("רҵ��2��߷�");
            tableTitle.add("��������");

            SchoolInfo schoolInfo = schoolInfoDAO.ViewSelectedSchoolInfoByName(searchTextArea.getText());
            tableValue.removeAllElements();
            if(schoolInfo !=null){
                Vector<String> vector = new Vector<String>();
                vector.addElement(String.valueOf(schoolInfo.getSchoolName()));
                vector.addElement(String.valueOf(schoolInfo.getSchoolType()));
                vector.addElement(String.valueOf(schoolInfo.getAllCoursesMin()));
                vector.addElement(String.valueOf(schoolInfo.getAllCoursesMean()));
                vector.addElement(String.valueOf(schoolInfo.getAllCoursesMax()));
                vector.addElement(String.valueOf(schoolInfo.getEnglishMin()));
                vector.addElement(String.valueOf(schoolInfo.getEnglishMean()));
                vector.addElement(String.valueOf(schoolInfo.getEnglishMax()));
                vector.addElement(String.valueOf(schoolInfo.getPoliticsMin()));
                vector.addElement(String.valueOf(schoolInfo.getPoliticsMean()));
                vector.addElement(String.valueOf(schoolInfo.getPoliticsMax()));
                vector.addElement(String.valueOf(schoolInfo.getFirstProfessionalMin()));
                vector.addElement(String.valueOf(schoolInfo.getFirstProfessionalMean()));
                vector.addElement(String.valueOf(schoolInfo.getFirstProfessionalMax()));
                vector.addElement(String.valueOf(schoolInfo.getSecondProfessionalMin()));
                vector.addElement(String.valueOf(schoolInfo.getSecondProfessionalMean()));
                vector.addElement(String.valueOf(schoolInfo.getSecondProfessionalMax()));
                vector.addElement(String.valueOf(schoolInfo.getReExamNumber()));
                tableValue.addElement(vector);
            }

            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }
        else if (choicecomboBox.getSelectedItem().equals("ģ����ѯѧУרҵ��")) {

            tableTitle.add("ѧУ����");
            tableTitle.add("ѧУ���");
            tableTitle.add("ȫ����ͷ�");
            tableTitle.add("ȫ��ƽ����");
            tableTitle.add("ȫ����߷�");
            tableTitle.add("Ӣ����ͷ�");
            tableTitle.add("Ӣ��ƽ����");
            tableTitle.add("Ӣ����߷�");
            tableTitle.add("������ͷ�");
            tableTitle.add("����ƽ����");
            tableTitle.add("������߷�");
            tableTitle.add("רҵ��1��ͷ�");
            tableTitle.add("רҵ��1ƽ����");
            tableTitle.add("רҵ��1��߷�");
            tableTitle.add("רҵ��2��ͷ�");
            tableTitle.add("רҵ��2ƽ����");
            tableTitle.add("רҵ��2��߷�");
            tableTitle.add("��������");

            Vector<SchoolInfo> schoolInfos = schoolInfoDAO.ViewSelectedSchoolInfoByFuzzyQuery(searchTextArea.getText());
            tableValue.removeAllElements();
            for (SchoolInfo x: schoolInfos) {
                Vector<String> vector = new Vector<String>();
                vector.addElement(String.valueOf(x.getSchoolName()));
                vector.addElement(String.valueOf(x.getSchoolType()));
                vector.addElement(String.valueOf(x.getAllCoursesMin()));
                vector.addElement(String.valueOf(x.getAllCoursesMean()));
                vector.addElement(String.valueOf(x.getAllCoursesMax()));
                vector.addElement(String.valueOf(x.getEnglishMin()));
                vector.addElement(String.valueOf(x.getEnglishMean()));
                vector.addElement(String.valueOf(x.getEnglishMax()));
                vector.addElement(String.valueOf(x.getPoliticsMin()));
                vector.addElement(String.valueOf(x.getPoliticsMean()));
                vector.addElement(String.valueOf(x.getPoliticsMax()));
                vector.addElement(String.valueOf(x.getFirstProfessionalMin()));
                vector.addElement(String.valueOf(x.getFirstProfessionalMean()));
                vector.addElement(String.valueOf(x.getFirstProfessionalMax()));
                vector.addElement(String.valueOf(x.getSecondProfessionalMin()));
                vector.addElement(String.valueOf(x.getSecondProfessionalMean()));
                vector.addElement(String.valueOf(x.getSecondProfessionalMax()));
                vector.addElement(String.valueOf(x.getReExamNumber()));
                tableValue.addElement(vector);
            }
            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }
        else if (choicecomboBox.getSelectedItem().equals("���û�����ѯ�û�")) {

            tableTitle.add("ѧ������");
            tableTitle.add("ѧ������");
            tableTitle.add("ѧ������ԺУ����");
            tableTitle.add("ѧ������ԺУ����");
            tableTitle.add("ѧ������");
            tableTitle.add("ѧ��־ԸѧУ����");
            tableTitle.add("ѧ��־ԸѧУ��ַ");
            tableTitle.add("ѧ��־ԸѧУ����");

            Student student = studentDAO.ViewSelectedStudentByName(searchTextArea.getText());
            tableValue.removeAllElements();
            if(student !=null){
                Vector<String> vector = new Vector<String>();
                vector.addElement(String.valueOf(student.getStudentName()));
                vector.addElement(String.valueOf(student.getStudentPassword()));
                vector.addElement(String.valueOf(student.getSchoolName()));
                vector.addElement(String.valueOf(student.getSchoolType()));
                vector.addElement(String.valueOf(student.getDreamSchoolType()));
                vector.addElement(String.valueOf(student.getDreamSchoolLoc()));
                vector.addElement(String.valueOf(student.getDreamSchoolName()));
                tableValue.addElement(vector);
            }

            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }
        
        else if (choicecomboBox.getSelectedItem().equals("��ѯ�����û�")) {
            tableTitle.add("ѧ������");
            tableTitle.add("ѧ������");
            tableTitle.add("ѧ������ԺУ����");
            tableTitle.add("ѧ������ԺУ����");
            tableTitle.add("ѧ������");
            tableTitle.add("ѧ��־ԸѧУ����");
            tableTitle.add("ѧ��־ԸѧУ��ַ");
            tableTitle.add("ѧ��־ԸѧУ����");

            Vector<Student> students = studentDAO.ViewAllStudent();
            tableValue.removeAllElements();
            for (Student x :students) {
                Vector<String> vector = new Vector<String>();
                vector.addElement(String.valueOf(x.getStudentName()));
                vector.addElement(String.valueOf(x.getStudentPassword()));
                vector.addElement(String.valueOf(x.getSchoolName()));
                vector.addElement(String.valueOf(x.getSchoolType()));
                vector.addElement(String.valueOf(x.getDreamSchoolType()));
                vector.addElement(String.valueOf(x.getDreamSchoolLoc()));
                vector.addElement(String.valueOf(x.getDreamSchoolName()));
                tableValue.addElement(vector);
            }
            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }
        else if (choicecomboBox.getSelectedItem().equals("ģ����ѯ�û�")) {
            tableTitle.add("ѧ������");
            tableTitle.add("ѧ������");
            tableTitle.add("ѧ������ԺУ����");
            tableTitle.add("ѧ������ԺУ����");
            tableTitle.add("ѧ������");
            tableTitle.add("ѧ��־ԸѧУ����");
            tableTitle.add("ѧ��־ԸѧУ��ַ");
            tableTitle.add("ѧ��־ԸѧУ����");

            Vector<Student> students = studentDAO.ViewSelectedStudentByFuzzyQuery(searchTextArea.getText());
            tableValue.removeAllElements();
            for (Student x :students) {
                Vector<String> vector = new Vector<String>();

                vector.addElement(String.valueOf(x.getStudentName()));
                vector.addElement(String.valueOf(x.getStudentPassword()));
                vector.addElement(String.valueOf(x.getSchoolName()));
                vector.addElement(String.valueOf(x.getSchoolType()));
                vector.addElement(String.valueOf(x.getDreamSchoolType()));
                vector.addElement(String.valueOf(x.getDreamSchoolLoc()));
                vector.addElement(String.valueOf(x.getDreamSchoolName()));
                tableValue.addElement(vector);
            }
            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }
        else if (choicecomboBox.getSelectedItem().equals("���û�����ѯ����Ա")) {
            tableTitle.add("����Ա����");
            tableTitle.add("����Ա����");

            Admin admin = adminDAO.ViewSelectedAdminByName(searchTextArea.getText());
            tableValue.removeAllElements();
            if(admin!=null){
                Vector<String> vector = new Vector<String>();

                vector.addElement(String.valueOf(admin.getAdminName()));
                vector.addElement(String.valueOf(admin.getAdminPassword()));
                tableValue.addElement(vector);
            }
            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }
        else if (choicecomboBox.getSelectedItem().equals("��ѯ���й���Ա")) {
            tableTitle.add("����Ա����");
            tableTitle.add("����Ա����");
            Vector<Admin> admins = adminDAO.ViewAllAdmin();
            tableValue.removeAllElements();
            for (Admin x : admins) {
                Vector<String> vector = new Vector<String>();

                vector.addElement(String.valueOf(x.getAdminName()));
                vector.addElement(String.valueOf(x.getAdminPassword()));
                tableValue.addElement(vector);
            }
            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }
        else if (choicecomboBox.getSelectedItem().equals("ģ����ѯ����Ա")) {
            tableTitle.add("����Ա����");
            tableTitle.add("����Ա����");
            Vector<Admin> admins = adminDAO.ViewSelectedAdminByFuzzyQuery(searchTextArea.getText());
            tableValue.removeAllElements();
            for (Admin x : admins) {
                Vector<String> vector = new Vector<String>();

                vector.addElement(String.valueOf(x.getAdminName()));
                vector.addElement(String.valueOf(x.getAdminPassword()));
                tableValue.addElement(vector);
            }
            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }
    }

    private void searchTextAreaKeyReleased(KeyEvent e) {
        // TODO add your code here
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(choicecomboBox.getSelectedItem().equals("��������ѯѧУ")){

                tableTitle.add("¼ȡ����");
                tableTitle.add("Ӣ�￼�����");
                tableTitle.add("��ѧ�������");
                tableTitle.add("���ο������");
                tableTitle.add("ѧУ����");
                tableTitle.add("ѧУ��ַ");
                tableTitle.add("ѧУ����");
                tableTitle.add("���Կ�Ŀ");
                tableTitle.add("���Կ�Ŀ");

                Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByArea(searchTextArea.getText());
                tableValue.removeAllElements();
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
                    tableValue.addElement(vector);
                }
                tableModel = new DefaultTableModel(tableValue, tableTitle);
                tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
                contenttable.setModel(tableModel);
                tableTitle.removeAllElements();
            }
            else if (choicecomboBox.getSelectedItem().equals("�����Ͳ�ѯѧУ")) {
                tableTitle.add("¼ȡ����");
                tableTitle.add("Ӣ�￼�����");
                tableTitle.add("��ѧ�������");
                tableTitle.add("���ο������");
                tableTitle.add("ѧУ����");
                tableTitle.add("ѧУ��ַ");
                tableTitle.add("ѧУ����");
                tableTitle.add("���Կ�Ŀ");
                tableTitle.add("���Կ�Ŀ");

                Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByType(searchTextArea.getText());
                tableValue.removeAllElements();
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
                    tableValue.addElement(vector);
                }
                tableModel = new DefaultTableModel(tableValue, tableTitle);
                tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
                contenttable.setModel(tableModel);
                tableTitle.removeAllElements();
            }
            else if (choicecomboBox.getSelectedItem().equals("�����Ʋ�ѯѧУ")) {

                tableTitle.add("¼ȡ����");
                tableTitle.add("Ӣ�￼�����");
                tableTitle.add("��ѧ�������");
                tableTitle.add("���ο������");
                tableTitle.add("ѧУ����");
                tableTitle.add("ѧУ��ַ");
                tableTitle.add("ѧУ����");
                tableTitle.add("���Կ�Ŀ");
                tableTitle.add("���Կ�Ŀ");

                SchoolList schoolList = schoolListDAO.ViewselectedSchoolListByName(searchTextArea.getText());
                tableValue.removeAllElements();
                if(schoolList !=null){
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
                    tableValue.addElement(vector);
                }

                tableModel = new DefaultTableModel(tableValue, tableTitle);
                tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
                contenttable.setModel(tableModel);
                tableTitle.removeAllElements();
            }
            else if (choicecomboBox.getSelectedItem().equals("ģ����ѯѧУ")) {
                tableTitle.add("¼ȡ����");
                tableTitle.add("Ӣ�￼�����");
                tableTitle.add("��ѧ�������");
                tableTitle.add("���ο������");
                tableTitle.add("ѧУ����");
                tableTitle.add("ѧУ��ַ");
                tableTitle.add("ѧУ����");
                tableTitle.add("���Կ�Ŀ");
                tableTitle.add("���Կ�Ŀ");

                Vector<SchoolList> schoolLists = schoolListDAO.ViewselectedSchoolListByFuzzyQuery(searchTextArea.getText());
                tableValue.removeAllElements();
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
                    tableValue.addElement(vector);
                }
                tableModel = new DefaultTableModel(tableValue, tableTitle);
                tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
                contenttable.setModel(tableModel);
                tableTitle.removeAllElements();
            }
            else if (choicecomboBox.getSelectedItem().equals("�����Ʋ�ѯѧУרҵ��")) {
                tableTitle.add("ѧУ����");
                tableTitle.add("ѧУ���");
                tableTitle.add("ȫ����ͷ�");
                tableTitle.add("ȫ��ƽ����");
                tableTitle.add("ȫ����߷�");
                tableTitle.add("Ӣ����ͷ�");
                tableTitle.add("Ӣ��ƽ����");
                tableTitle.add("Ӣ����߷�");
                tableTitle.add("������ͷ�");
                tableTitle.add("����ƽ����");
                tableTitle.add("������߷�");
                tableTitle.add("רҵ��1��ͷ�");
                tableTitle.add("רҵ��1ƽ����");
                tableTitle.add("רҵ��1��߷�");
                tableTitle.add("רҵ��2��ͷ�");
                tableTitle.add("רҵ��2ƽ����");
                tableTitle.add("רҵ��2��߷�");
                tableTitle.add("��������");


                SchoolInfo schoolInfo = schoolInfoDAO.ViewSelectedSchoolInfoByName(searchTextArea.getText());
                tableValue.removeAllElements();
                if(schoolInfo !=null){
                    Vector<String> vector = new Vector<String>();

                    vector.addElement(String.valueOf(schoolInfo.getSchoolName()));
                    vector.addElement(String.valueOf(schoolInfo.getSchoolType()));
                    vector.addElement(String.valueOf(schoolInfo.getAllCoursesMin()));
                    vector.addElement(String.valueOf(schoolInfo.getAllCoursesMean()));
                    vector.addElement(String.valueOf(schoolInfo.getAllCoursesMax()));
                    vector.addElement(String.valueOf(schoolInfo.getEnglishMin()));
                    vector.addElement(String.valueOf(schoolInfo.getEnglishMean()));
                    vector.addElement(String.valueOf(schoolInfo.getEnglishMax()));
                    vector.addElement(String.valueOf(schoolInfo.getPoliticsMin()));
                    vector.addElement(String.valueOf(schoolInfo.getPoliticsMean()));
                    vector.addElement(String.valueOf(schoolInfo.getPoliticsMax()));
                    vector.addElement(String.valueOf(schoolInfo.getFirstProfessionalMin()));
                    vector.addElement(String.valueOf(schoolInfo.getFirstProfessionalMean()));
                    vector.addElement(String.valueOf(schoolInfo.getFirstProfessionalMax()));
                    vector.addElement(String.valueOf(schoolInfo.getSecondProfessionalMin()));
                    vector.addElement(String.valueOf(schoolInfo.getSecondProfessionalMean()));
                    vector.addElement(String.valueOf(schoolInfo.getSecondProfessionalMax()));
                    vector.addElement(String.valueOf(schoolInfo.getReExamNumber()));
                    tableValue.addElement(vector);
                }

                tableModel = new DefaultTableModel(tableValue, tableTitle);
                tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
                contenttable.setModel(tableModel);
                tableTitle.removeAllElements();
            }
            else if (choicecomboBox.getSelectedItem().equals("ģ����ѯѧУרҵ��")) {
                tableTitle.add("ѧУ����");
                tableTitle.add("ѧУ���");
                tableTitle.add("ȫ����ͷ�");
                tableTitle.add("ȫ��ƽ����");
                tableTitle.add("ȫ����߷�");
                tableTitle.add("Ӣ����ͷ�");
                tableTitle.add("Ӣ��ƽ����");
                tableTitle.add("Ӣ����߷�");
                tableTitle.add("������ͷ�");
                tableTitle.add("����ƽ����");
                tableTitle.add("������߷�");
                tableTitle.add("רҵ��1��ͷ�");
                tableTitle.add("רҵ��1ƽ����");
                tableTitle.add("רҵ��1��߷�");
                tableTitle.add("רҵ��2��ͷ�");
                tableTitle.add("רҵ��2ƽ����");
                tableTitle.add("רҵ��2��߷�");
                tableTitle.add("��������");


                Vector<SchoolInfo> schoolInfos = schoolInfoDAO.ViewSelectedSchoolInfoByFuzzyQuery(searchTextArea.getText());
                tableValue.removeAllElements();
                for (SchoolInfo x: schoolInfos) {
                    Vector<String> vector = new Vector<String>();

                    vector.addElement(String.valueOf(x.getSchoolName()));
                    vector.addElement(String.valueOf(x.getSchoolType()));
                    vector.addElement(String.valueOf(x.getAllCoursesMin()));
                    vector.addElement(String.valueOf(x.getAllCoursesMean()));
                    vector.addElement(String.valueOf(x.getAllCoursesMax()));
                    vector.addElement(String.valueOf(x.getEnglishMin()));
                    vector.addElement(String.valueOf(x.getEnglishMean()));
                    vector.addElement(String.valueOf(x.getEnglishMax()));
                    vector.addElement(String.valueOf(x.getPoliticsMin()));
                    vector.addElement(String.valueOf(x.getPoliticsMean()));
                    vector.addElement(String.valueOf(x.getPoliticsMax()));
                    vector.addElement(String.valueOf(x.getFirstProfessionalMin()));
                    vector.addElement(String.valueOf(x.getFirstProfessionalMean()));
                    vector.addElement(String.valueOf(x.getFirstProfessionalMax()));
                    vector.addElement(String.valueOf(x.getSecondProfessionalMin()));
                    vector.addElement(String.valueOf(x.getSecondProfessionalMean()));
                    vector.addElement(String.valueOf(x.getSecondProfessionalMax()));
                    vector.addElement(String.valueOf(x.getReExamNumber()));
                    tableValue.addElement(vector);
                }
                tableModel = new DefaultTableModel(tableValue, tableTitle);
                tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
                contenttable.setModel(tableModel);
                tableTitle.removeAllElements();
            }
            else if (choicecomboBox.getSelectedItem().equals("���û�����ѯ�û�")) {
                tableTitle.add("ѧ������");
                tableTitle.add("ѧ������");
                tableTitle.add("ѧ������ԺУ����");
                tableTitle.add("ѧ������ԺУ����");
                tableTitle.add("ѧ������");
                tableTitle.add("ѧ��־ԸѧУ����");
                tableTitle.add("ѧ��־ԸѧУ��ַ");
                tableTitle.add("ѧ��־ԸѧУ����");


                Student student = studentDAO.ViewSelectedStudentByName(searchTextArea.getText());
                tableValue.removeAllElements();
                if(student !=null){
                    Vector<String> vector = new Vector<String>();

                    vector.addElement(String.valueOf(student.getStudentName()));
                    vector.addElement(String.valueOf(student.getStudentPassword()));
                    vector.addElement(String.valueOf(student.getSchoolName()));
                    vector.addElement(String.valueOf(student.getSchoolType()));
                    vector.addElement(String.valueOf(student.getDreamSchoolType()));
                    vector.addElement(String.valueOf(student.getDreamSchoolLoc()));
                    vector.addElement(String.valueOf(student.getDreamSchoolName()));
                    tableValue.addElement(vector);
                }

                tableModel = new DefaultTableModel(tableValue, tableTitle);
                tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
                contenttable.setModel(tableModel);
                tableTitle.removeAllElements();
            }

            else if (choicecomboBox.getSelectedItem().equals("��ѯ�����û�")) {
                tableTitle.add("ѧ������");
                tableTitle.add("ѧ������");
                tableTitle.add("ѧ������ԺУ����");
                tableTitle.add("ѧ������ԺУ����");
                tableTitle.add("ѧ������");
                tableTitle.add("ѧ��־ԸѧУ����");
                tableTitle.add("ѧ��־ԸѧУ��ַ");
                tableTitle.add("ѧ��־ԸѧУ����");


                Vector<Student> students = studentDAO.ViewAllStudent();
                tableValue.removeAllElements();
                for (Student x :students) {
                    Vector<String> vector = new Vector<String>();

                    vector.addElement(String.valueOf(x.getStudentName()));
                    vector.addElement(String.valueOf(x.getStudentPassword()));
                    vector.addElement(String.valueOf(x.getSchoolName()));
                    vector.addElement(String.valueOf(x.getSchoolType()));
                    vector.addElement(String.valueOf(x.getDreamSchoolType()));
                    vector.addElement(String.valueOf(x.getDreamSchoolLoc()));
                    vector.addElement(String.valueOf(x.getDreamSchoolName()));
                    tableValue.addElement(vector);
                }
                tableModel = new DefaultTableModel(tableValue, tableTitle);
                tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
                contenttable.setModel(tableModel);
                tableTitle.removeAllElements();
            }
            else if (choicecomboBox.getSelectedItem().equals("ģ����ѯ�û�")) {
                tableTitle.add("ѧ������");
                tableTitle.add("ѧ������");
                tableTitle.add("ѧ������ԺУ����");
                tableTitle.add("ѧ������ԺУ����");
                tableTitle.add("ѧ������");
                tableTitle.add("ѧ��־ԸѧУ����");
                tableTitle.add("ѧ��־ԸѧУ��ַ");
                tableTitle.add("ѧ��־ԸѧУ����");


                Vector<Student> students = studentDAO.ViewSelectedStudentByFuzzyQuery(searchTextArea.getText());
                tableValue.removeAllElements();
                for (Student x :students) {
                    Vector<String> vector = new Vector<String>();

                    vector.addElement(String.valueOf(x.getStudentName()));
                    vector.addElement(String.valueOf(x.getStudentPassword()));
                    vector.addElement(String.valueOf(x.getSchoolName()));
                    vector.addElement(String.valueOf(x.getSchoolType()));
                    vector.addElement(String.valueOf(x.getDreamSchoolType()));
                    vector.addElement(String.valueOf(x.getDreamSchoolLoc()));
                    vector.addElement(String.valueOf(x.getDreamSchoolName()));
                    tableValue.addElement(vector);
                }
                tableModel = new DefaultTableModel(tableValue, tableTitle);
                tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
                contenttable.setModel(tableModel);
                tableTitle.removeAllElements();
            }
            else if (choicecomboBox.getSelectedItem().equals("���û�����ѯ����Ա")) {
                tableTitle.add("����Ա����");
                tableTitle.add("����Ա����");

                Admin admin = adminDAO.ViewSelectedAdminByName(searchTextArea.getText());
                tableValue.removeAllElements();
                if(admin!=null){
                    Vector<String> vector = new Vector<String>();

                    vector.addElement(String.valueOf(admin.getAdminName()));
                    vector.addElement(String.valueOf(admin.getAdminPassword()));
                    tableValue.addElement(vector);
                }
                tableModel = new DefaultTableModel(tableValue, tableTitle);
                tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
                contenttable.setModel(tableModel);
                tableTitle.removeAllElements();
            }
            else if (choicecomboBox.getSelectedItem().equals("��ѯ���й���Ա")) {
                tableTitle.add("����Ա����");
                tableTitle.add("����Ա����");

                Vector<Admin> admins = adminDAO.ViewAllAdmin();
                tableValue.removeAllElements();
                for (Admin x : admins) {
                    Vector<String> vector = new Vector<String>();

                    vector.addElement(String.valueOf(x.getAdminName()));
                    vector.addElement(String.valueOf(x.getAdminPassword()));
                    tableValue.addElement(vector);
                }
                tableModel = new DefaultTableModel(tableValue, tableTitle);
                tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
                contenttable.setModel(tableModel);
                tableTitle.removeAllElements();
            }
            else if (choicecomboBox.getSelectedItem().equals("ģ����ѯ����Ա")) {
                tableTitle.add("����Ա����");
                tableTitle.add("����Ա����");

                Vector<Admin> admins = adminDAO.ViewSelectedAdminByFuzzyQuery(searchTextArea.getText());
                tableValue.removeAllElements();
                for (Admin x : admins) {
                    Vector<String> vector = new Vector<String>();

                    vector.addElement(String.valueOf(x.getAdminName()));
                    vector.addElement(String.valueOf(x.getAdminPassword()));
                    tableValue.addElement(vector);
                }
                tableModel = new DefaultTableModel(tableValue, tableTitle);
                tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
                contenttable.setModel(tableModel);
                tableTitle.removeAllElements();
            }
        }
    }

    private void backToMainFrame(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        mainFrameForAdmin.setVisible(true);
    }
    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();

        contenttable = new JTable(tableModel);
        clearButton = new JButton();
        choicecomboBox = new JComboBox<>();
        searchbutton = new JButton();
        contenttable = new JTable(tableModel);
        backToMainFrameButton = new JButton();
        label1 = new JLabel();
        searchTextArea = new JTextField();
        scrollPane = new JScrollPane();
        contenttable = new JTable();
        contenttable = new JTable(tableModel);

        //======== this ========
        setTitle("\u7ba1\u7406\u5458\u67e5\u8be2\u7cfb\u7edf");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- clearButton ----
                clearButton.setText("\u6e05\u9664\u6570\u636e");
                clearButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                clearButton.addActionListener(e -> clear(e));

                //---- choicecomboBox ----
                choicecomboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u6309\u5730\u533a\u67e5\u8be2\u5b66\u6821",
                    "\u6309\u7c7b\u578b\u67e5\u8be2\u5b66\u6821",
                    "\u6309\u540d\u79f0\u67e5\u8be2\u5b66\u6821",
                    "\u6a21\u7cca\u67e5\u8be2\u5b66\u6821",
                    "\u6309\u540d\u79f0\u67e5\u8be2\u5b66\u6821\u4e13\u4e1a\u8bfe",
                    "\u6a21\u7cca\u67e5\u8be2\u5b66\u6821\u4e13\u4e1a\u8bfe",
                    "\u6309\u7528\u6237\u540d\u67e5\u8be2\u7528\u6237",
                    "\u67e5\u8be2\u6240\u6709\u7528\u6237",
                    "\u6a21\u7cca\u67e5\u8be2\u7528\u6237",
                    "\u6309\u7528\u6237\u540d\u67e5\u8be2\u7ba1\u7406\u5458",
                    "\u67e5\u8be2\u6240\u6709\u7ba1\u7406\u5458",
                    "\u6a21\u7cca\u67e5\u8be2\u7ba1\u7406\u5458"
                }));
                choicecomboBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- searchbutton ----
                searchbutton.setText("\u67e5\u8be2");
                searchbutton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                searchbutton.addActionListener(e -> search(e));

                //---- backToMainFrameButton ----
                backToMainFrameButton.setText("\u8fd4\u56de\u4e3b\u754c\u9762");
                backToMainFrameButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                backToMainFrameButton.addActionListener(e -> backToMainFrame(e));

                //---- label1 ----
                label1.setText("\u8fd9\u91cc\u662f\u63d0\u793a\u4fe1\u606f");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setForeground(Color.red);
                label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

                //---- searchTextArea ----
                searchTextArea.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        searchTextAreaKeyReleased(e);
                    }
                });

                //======== scrollPane ========
                {
                    scrollPane.setViewportView(contenttable);
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(choicecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(searchTextArea, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(searchbutton)
                                    .addGap(6, 6, 6)
                                    .addComponent(clearButton))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(110, 110, 110)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
                                    .addGap(63, 63, 63)
                                    .addComponent(backToMainFrameButton)))
                            .addGap(37, 37, 37))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane)
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(choicecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchbutton)
                                .addComponent(clearButton)
                                .addComponent(searchTextArea, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label1)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(backToMainFrameButton)))
                            .addGap(29, 29, 29))
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
    private JButton clearButton;
    public JComboBox<String> choicecomboBox;
    private JButton searchbutton;
    private JButton backToMainFrameButton;
    private JLabel label1;
    public JTextField searchTextArea;
    private JScrollPane scrollPane;
    public JTable contenttable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public Vector<String> tableTitle = new Vector<String>();
    public Vector<Vector> tableValue = new Vector<Vector>();
    public DefaultTableModel tableModel = null;
    public static void main(String[] args) {
        SearchDialogForAdmin searchDialogForAdmin = new SearchDialogForAdmin(mainFrameForAdmin);
        searchDialogForAdmin.setVisible(true);
    }
}
