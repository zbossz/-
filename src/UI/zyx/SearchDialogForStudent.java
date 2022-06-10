/*
 * Created by JFormDesigner on Sun Apr 24 22:00:43 CST 2022
 */

package UI.zyx;

import DAO.zyx.SchoolInfo;
import DAO.yx.SchoolList;
import DAO.zyx.Student;

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
public class SearchDialogForStudent extends JDialog {
    public SearchDialogForStudent(Window owner) {
        super(owner);
        initComponents();
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
        }
    }

    private void search(ActionEvent e) {
        // TODO add your code here
        /*
        * ��������ѯѧУ
        * �����Ͳ�ѯѧУ
        * �����Ʋ�ѯѧУ
        * ģ����ѯѧУ
        * �����Ʋ�ѯѧУרҵ��
        * ģ����ѯѧУרҵ��
        * */
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
        } else if (choicecomboBox.getSelectedItem().equals("��ѯ��ǰ�û���Ϣ")) {
            searchTextArea.setText(student.getStudentName());
            searchTextArea.setEditable(false);
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
                tableValue.addElement(vector);
            }
            tableModel = new DefaultTableModel(tableValue, tableTitle);
            tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
            contenttable.setModel(tableModel);
            tableTitle.removeAllElements();
        }

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

    private void backToMainFrame(ActionEvent e) {
        // TODO add your code here
        this.dispose();

        mainFrameForStudent.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        clearbutton = new JButton();
        choicecomboBox = new JComboBox<>();
        searchButton = new JButton();
        backToMainFrameButton = new JButton();
        label1 = new JLabel();
        searchTextArea = new JTextField();

        contenttable = new JTable(tableModel);

        scrollPane1 = new JScrollPane();
        contenttable = new JTable();

        //======== this ========
        setTitle("\u5b66\u751f\u67e5\u8be2\u7cfb\u7edf");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- clearbutton ----
                clearbutton.setText("\u6e05\u9664\u6570\u636e");
                clearbutton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                clearbutton.addActionListener(e -> clear(e));

                //---- choicecomboBox ----
                choicecomboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u6309\u5730\u533a\u67e5\u8be2\u5b66\u6821",
                    "\u6309\u7c7b\u578b\u67e5\u8be2\u5b66\u6821",
                    "\u6309\u540d\u79f0\u67e5\u8be2\u5b66\u6821",
                    "\u6a21\u7cca\u67e5\u8be2\u5b66\u6821",
                    "\u6309\u540d\u79f0\u67e5\u8be2\u5b66\u6821\u4e13\u4e1a\u8bfe",
                    "\u6a21\u7cca\u67e5\u8be2\u5b66\u6821\u4e13\u4e1a\u8bfe",
                    "\u67e5\u8be2\u5f53\u524d\u7528\u6237\u4fe1\u606f"
                }));
                choicecomboBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

                //---- searchButton ----
                searchButton.setText("\u67e5\u8be2");
                searchButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                searchButton.addActionListener(e -> search(e));

                //---- backToMainFrameButton ----
                backToMainFrameButton.setText("\u8fd4\u56de\u4e3b\u754c\u9762");
                backToMainFrameButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                backToMainFrameButton.addActionListener(e -> backToMainFrame(e));

                //---- label1 ----
                label1.setText("\u8fd9\u91cc\u662f\u63d0\u793a\u4fe1\u606f");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setForeground(Color.red);

                //---- searchTextArea ----
                searchTextArea.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                searchTextArea.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        searchTextAreaKeyReleased(e);
                    }
                });

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(contenttable);
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
                            .addGap(66, 66, 66)
                            .addComponent(backToMainFrameButton)
                            .addGap(53, 53, 53))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 824, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(choicecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(searchTextArea, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(searchButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(clearbutton)))
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(0, 1, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(choicecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(searchTextArea))
                                .addComponent(searchButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearbutton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(25, 25, 25)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(backToMainFrameButton)
                                .addComponent(label1))
                            .addGap(0, 6, Short.MAX_VALUE))
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
    private JButton clearbutton;
    protected JComboBox<String> choicecomboBox;
    private JButton searchButton;
    private JButton backToMainFrameButton;
    private JLabel label1;
    protected JTextField searchTextArea;
    private JScrollPane scrollPane1;
    protected JTable contenttable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    protected Vector<String> tableTitle = new Vector<String>();
    protected Vector<Vector> tableValue = new Vector<Vector>();
    protected DefaultTableModel tableModel = null;

    public static void main(String[] args) {
        SearchDialogForStudent searchDialogForStudent = new SearchDialogForStudent(mainFrameForStudent);
        searchDialogForStudent.setVisible(true);

    }
}
