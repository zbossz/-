package Operations;

import DAO.yx.SchoolList;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

import static Utils.zzy.CommonData.schoolListDAO;
import static Utils.zzy.CommonData.searchDialogForAdmin;

/**
 * @Author zbossz
 * @Date 2022��05��29��16ʱ04��
 **/
public interface ViewSchoolListByAreaOp {
    public static void ViewSchoolListByArea(String area , int choice){
        searchDialogForAdmin.choicecomboBox.setSelectedIndex(choice);

        searchDialogForAdmin.tableTitle.add("¼ȡ����");
        searchDialogForAdmin.tableTitle.add("Ӣ�￼�����");
        searchDialogForAdmin.tableTitle.add("��ѧ�������");
        searchDialogForAdmin.tableTitle.add("���ο������");
        searchDialogForAdmin.tableTitle.add("ѧУ����");
        searchDialogForAdmin.tableTitle.add("ѧУ��ַ");
        searchDialogForAdmin.tableTitle.add("ѧУ����");
        searchDialogForAdmin.tableTitle.add("���Կ�Ŀ");
        searchDialogForAdmin.tableTitle.add("���Կ�Ŀ");

        searchDialogForAdmin.searchTextArea.setText(area);
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

        searchDialogForAdmin.tableModel.fireTableDataChanged();//������ݸı䣬֪ͨUI����
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);
    }

}
