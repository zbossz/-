package Utils.zzy;

import DAO.yx.SchoolListDAO;
import DAO.zyx.Student;
import DAO.zyx.StudentDAO;
import DAO.yx.Admin;
import DAO.yx.AdminDAO;
import DAO.zyx.SchoolInfoDAO;
import UI.yx.MainFrameForAdmin;
import UI.yx.SearchDialogForAdmin;
import UI.zyx.MainFrameForStudent;
import UI.zyx.SearchDialogForStudent;
import UI.zzy.LoginFrame;
import UI.zzy.ModifySchoolInfoDialog;

public class CommonData {
    public static ModifySchoolInfoDialog msid = null;
    public static Admin admin = null;
    public static Student student = null;
    public static StudentDAO studentDAO = new StudentDAO();
    public static AdminDAO adminDAO = new AdminDAO();
    public static SchoolInfoDAO schoolInfoDAO = new SchoolInfoDAO();
    public static SchoolListDAO schoolListDAO = new SchoolListDAO();
    public static String userAccount = null;
    public static String userPassword = null;

    public static MainFrameForAdmin mainFrameForAdmin = new MainFrameForAdmin();
    public static MainFrameForStudent mainFrameForStudent = new MainFrameForStudent();
    public static SearchDialogForAdmin searchDialogForAdmin = new SearchDialogForAdmin(mainFrameForAdmin);
    public static SearchDialogForStudent searchDialogForStudent = new SearchDialogForStudent(mainFrameForStudent);
    public static LoginFrame loginFrame = new LoginFrame();

    /*public  static JCheckBox rememberPasswordcheckBox =new JCheckBox();
    public  static JCheckBox rememberAccountcheckBox =new JCheckBox();*/
}
