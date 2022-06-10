package DAO.yx;

import DAO.zzy.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SchoolListDAO {
    /**
     * 通过学校地区查看学校名单信息
     * */
    public Vector<SchoolList> ViewselectedSchoolListByArea(String schoolloc){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        //List<SchoolList> schoolLists = new ArrayList<>();
        Vector<SchoolList> schoolLists = new Vector();
        try{
            connection = DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.`985schoollist` where schoolLoc = ? " +
                    "union all select * from graduateschoolinquirysystem.`211schoollist` where schoolLoc = ? " +
                    "union all select * from  graduateschoolinquirysystem.normalschoollist where schoolLoc = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, schoolloc);
            statement.setString(2,schoolloc);
            statement.setString(3,schoolloc);

            resultSet = statement.executeQuery();
            while (resultSet.next()){
                SchoolList schoolList = new SchoolList();
                schoolList.setSchoolId(resultSet.getInt("schoolId"));
                schoolList.setSchoolName(resultSet.getString("schoolName"));
                schoolList.setSchoolLoc(resultSet.getString("schoolLoc"));
                schoolList.setSchoolType(resultSet.getString("schoolType"));
                schoolList.setRecruitNumber(resultSet.getInt("recruitNumber"));
                schoolList.setEnglishType(resultSet.getInt("englishType"));
                schoolList.setMathType(resultSet.getInt("mathType"));
                schoolList.setPoliticType(resultSet.getInt("politicType"));
                schoolList.setPreProfessionalCourses(resultSet.getString("preProfessionalCourses"));
                schoolList.setReProfessionalCourses(resultSet.getString("reProfessionalCourses"));
                schoolLists.addElement(schoolList);
            }
            return schoolLists;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    /**
     * 通过学校类型查看学校名单信息
     * */
    public Vector<SchoolList> ViewselectedSchoolListByType(String schooltype){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Admin admin = null;
        Vector<SchoolList> schoolLists = new Vector<>();
        try{
            connection = DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.`985schoollist` where schoolType = ?  union all select * from `211schoollist` where schoolType = ? union all select * from normalschoollist where normalschoollist.schoolType = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, schooltype);
            statement.setString(2,schooltype);
            statement.setString(3,schooltype);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                SchoolList schoolList = new SchoolList();
                schoolList.setSchoolId(resultSet.getInt("schoolId"));
                schoolList.setSchoolName(resultSet.getString("schoolName"));
                schoolList.setSchoolLoc(resultSet.getString("schoolLoc"));
                schoolList.setSchoolType(resultSet.getString("schoolType"));
                schoolList.setRecruitNumber(resultSet.getInt("recruitNumber"));
                schoolList.setEnglishType(resultSet.getInt("englishType"));
                schoolList.setMathType(resultSet.getInt("mathType"));
                schoolList.setPoliticType(resultSet.getInt("politicType"));
                schoolList.setPreProfessionalCourses(resultSet.getString("preProfessionalCourses"));
                schoolList.setReProfessionalCourses(resultSet.getString("reProfessionalCourses"));
                schoolLists.addElement(schoolList);
            }
            return schoolLists;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    /**
     * 通过学校名称查看学校名单信息
     * */
    public SchoolList ViewselectedSchoolListByName(String schoolname){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        SchoolList schoolList = new SchoolList();
        try{
            connection = DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.`985schoollist` where schoolName = ?  union all select * from `211schoollist` where schoolName = ? union all select * from normalschoollist where normalschoollist.schoolName = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, schoolname);
            statement.setString(2,schoolname);
            statement.setString(3,schoolname);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                schoolList.setSchoolId(resultSet.getInt("schoolId"));
                schoolList.setSchoolName(resultSet.getString("schoolName"));
                schoolList.setSchoolLoc(resultSet.getString("schoolLoc"));
                schoolList.setSchoolType(resultSet.getString("schoolType"));
                schoolList.setRecruitNumber(resultSet.getInt("recruitNumber"));
                schoolList.setEnglishType(resultSet.getInt("englishType"));
                schoolList.setMathType(resultSet.getInt("mathType"));
                schoolList.setPoliticType(resultSet.getInt("politicType"));
                schoolList.setPreProfessionalCourses(resultSet.getString("preProfessionalCourses"));
                schoolList.setReProfessionalCourses(resultSet.getString("reProfessionalCourses"));
                return schoolList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    public Vector<SchoolList> ViewselectedSchoolListByFuzzyQuery(String schoolname){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Vector<SchoolList> schoolLists = new Vector<>();
        try{
            connection = DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.`985schoollist` where schoolName like '%" +schoolname+"%'"+
                    "union all select * from `211schoollist` where schoolName like '%" +schoolname+"%' " +
                    "union all select * from normalschoollist where schoolName like '%" +schoolname+"%' ";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                SchoolList schoolList = new SchoolList();
                schoolList.setSchoolId(resultSet.getInt("schoolId"));
                schoolList.setSchoolName(resultSet.getString("schoolName"));
                schoolList.setSchoolLoc(resultSet.getString("schoolLoc"));
                schoolList.setSchoolType(resultSet.getString("schoolType"));
                schoolList.setRecruitNumber(resultSet.getInt("recruitNumber"));
                schoolList.setEnglishType(resultSet.getInt("englishType"));
                schoolList.setEnglishType(resultSet.getInt("mathType"));
                schoolList.setEnglishType(resultSet.getInt("politicType"));
                schoolList.setPreProfessionalCourses(resultSet.getString("preProfessionalCourses"));
                schoolList.setReProfessionalCourses(resultSet.getString("reProfessionalCourses"));
                schoolLists.addElement(schoolList);
            }
            return schoolLists;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    /**
     * 增加院校信息
     * info1[学校姓名，学校地址（不要加省），学校类型，初试科目，复试科目]
     * info2[招生人数，英语，数学]
     * */
    public SchoolList AddSchoolList(String[] info1,int[] info2 ){
        ResultSet resultSet = null;
        Connection connection = null;

        PreparedStatement statement = null;
        SchoolList schoolList = null;

        try {
            connection = DBUtil.getConnection();

            if(info1[2].equals("985")){
                String sql = "insert into graduateschoolinquirysystem.985schoollist values(null,?,?,'985',?,?,?,1,?,?)";
                statement = connection.prepareStatement(sql);
            }
            else if(info1[2].equals("211")){
                String sql = "insert into graduateschoolinquirysystem.211schoollist values(null,?,?,'211',?,?,?,1,?,?)";
                statement = connection.prepareStatement(sql);
            }
            else if(info1[2].equals("normal")){
                String sql = "insert into graduateschoolinquirysystem.normalschoollist values(null,?,?,'normal',?,?,?,1,?,?)";
                statement = connection.prepareStatement(sql);
            }
            else {
                System.out.println("请输入正确的学校类型！");
            }
            statement.setString(1,info1[0]);
            statement.setString(2,info1[1]);
            statement.setInt(3,info2[0]);
            statement.setInt(4,info2[1]);
            statement.setInt(5,info2[2]);
            statement.setString(6,info1[3]);
            statement.setString(7,info1[4]);
            int ret  = statement.executeUpdate();
            if(ret==1){
                schoolList = ViewselectedSchoolListByName(info1[0]);
            }
            return schoolList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return schoolList;
    }

    /**
     * 删除院校List信息
     */
    public boolean DeleteSchoolList(String schoolname,String schooltype){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        SchoolList schoolList = null;
        int ret =-1;
        try {
            connection = DBUtil.getConnection();

            if(schooltype.equals("985")){
                String sql = "delete from graduateschoolinquirysystem.985schoollist where schoolName = ?";
                statement = connection.prepareStatement(sql);
            }
            else if(schooltype.equals("211")){
                String sql = "delete from graduateschoolinquirysystem.211schoollist where schoolName = ?";
                statement = connection.prepareStatement(sql);
            }
            else{
                String sql = "delete from graduateschoolinquirysystem.normalschoollist where schoolName = ?";
                statement = connection.prepareStatement(sql);
            }

            statement.setString(1,schoolname);
            ret = statement.executeUpdate();
            return  ret==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return false;
    }
    /**
     * 修改院校信息(不可以修改类型，如果要修改类型，要删除，重新加)
     * info1[学校姓名，学校地址（不要加省），学校类型，初试科目，复试科目]
     * info2[招生人数，英语，数学]
     * */
    public SchoolList ModifySchoolList(String[] info1,int[] info2){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        SchoolList schoolList = null;

        int ret =-1;
        try{
            connection = DBUtil.getConnection();


            if(info1[2].equals("985")){
                String sql = "update graduateschoolinquirysystem.985schoollist " +
                        "set schoolName = ?, schoolLoc = ?," +
                        " recruitNumber = ?,"+
                        " englishType = ?, mathType = ?, politicType = 1,"+
                        " preProfessionalCourses = ?, reProfessionalCourses = ? "+
                        "where schoolName = ?";
                statement = connection.prepareStatement(sql);
            }
            else if (info1[2].equals("211")) {
                String sql = "update graduateschoolinquirysystem.211schoollist " +
                        "set schoolName = ?, schoolLoc = ?," +
                        " recruitNumber = ?,"+
                        " englishType = ?, mathType = ?, politicType = 1,"+
                        " preProfessionalCourses = ?, reProfessionalCourses = ? "+
                        "where schoolName = ?";
                statement = connection.prepareStatement(sql);
            }
            else{
                String sql = "update graduateschoolinquirysystem.normalschoollist " +
                        "set schoolName = ?, schoolLoc = ?," +
                        " recruitNumber = ?,"+
                        " englishType = ?, mathType = ?, politicType = 1,"+
                        " preProfessionalCourses = ?, reProfessionalCourses = ? "+
                        "where schoolName = ?";
                statement = connection.prepareStatement(sql);
            }

            statement.setString(1,info1[0]);/*学校名称*/
            statement.setString(2,info1[1]);/*学校地址*/
            statement.setInt(3,info2[0]);/*招生人数*/

            statement.setInt(4,info2[1]);/*英语类型*/
            statement.setInt(5,info2[2]);/*数学类型*/
            statement.setString(6,info1[3]);/*初试课程*/

            statement.setString(7,info1[4]);/*复试课程*/
            statement.setString(8,info1[0]);/*学校名字*/
            ret = statement.executeUpdate();
            if(ret==1){
                schoolList = ViewselectedSchoolListByName(info1[0]);
            }
            return schoolList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
}
