package Operations;

import DAO.yx.SchoolList;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

import static Utils.zzy.CommonData.schoolListDAO;
import static Utils.zzy.CommonData.searchDialogForAdmin;

/**
 * @Author zbossz
 * @Date 2022年05月29日16时04分
 **/
public interface ViewSchoolListByAreaOp {
    public static void ViewSchoolListByArea(String area , int choice){
        searchDialogForAdmin.choicecomboBox.setSelectedIndex(choice);

        searchDialogForAdmin.tableTitle.add("录取人数");
        searchDialogForAdmin.tableTitle.add("英语考试类别");
        searchDialogForAdmin.tableTitle.add("数学考试类别");
        searchDialogForAdmin.tableTitle.add("政治考试类别");
        searchDialogForAdmin.tableTitle.add("学校名称");
        searchDialogForAdmin.tableTitle.add("学校地址");
        searchDialogForAdmin.tableTitle.add("学校类型");
        searchDialogForAdmin.tableTitle.add("初试科目");
        searchDialogForAdmin.tableTitle.add("复试科目");

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

        searchDialogForAdmin.tableModel.fireTableDataChanged();//表格数据改变，通知UI更新
        searchDialogForAdmin.contenttable.setModel(searchDialogForAdmin.tableModel);
        searchDialogForAdmin.tableTitle.removeAllElements();
        searchDialogForAdmin.setVisible(true);
    }

}
