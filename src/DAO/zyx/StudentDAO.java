package DAO.zyx;

import DAO.zyx.Student;
import DAO.zzy.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StudentDAO {
    /**
     * 注册用户
     * info[学生姓名，学生密码，毕业院校，毕业院校类型，籍贯，目标院校类型，目标院校地址，目标院校名称]
     */
    public Student AddStudent(String[] info){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement =null;
        Student student = null;
        int ret =-1;
        try{
            connection = DBUtil.getConnection();
            String sql = "insert into graduateschoolinquirysystem.student values(null,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,info[0]);
            statement.setString(2,info[1]);
            statement.setString(3,info[2]);
            statement.setString(4,info[3]);
            statement.setString(5,info[4]);
            statement.setString(6,info[5]);
            statement.setString(7,info[6]);
            statement.setString(8,info[7]);
            ret = statement.executeUpdate();
            if(ret == 1){
                student = ViewSelectedStudentByName(info[0]);
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    /**
     * 注销用户
     */
    public boolean DeleteStudent(String studentname){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement =null;
        int ret =-1;
        try{
            connection = DBUtil.getConnection();
            String sql = "delete from graduateschoolinquirysystem.student where studentName = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,studentname);
            ret = statement.executeUpdate();
            return ret==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return false;
    }
    /**
     * 修改用户信息
     * info[学生姓名，学生密码，毕业院校，毕业院校类型，籍贯，目标院校类型，目标院校地址，目标院校名称]
     */
    public Student ModifyStudent(String[] info){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement =null;
        Student student =null;
        int ret =-1;
        try{
            connection = DBUtil.getConnection();
            String sql = "update graduateschoolinquirysystem.student set studentName = ?," +
                    "studentPassword = ?," +
                    "schoolName = ?," +
                    "schoolType =?," +
                    "cameFrom = ?," +
                    "dreamSchoolType = ?," +
                    "dreamSchoolLoc = ?," +
                    "dreamSchoolName = ? " +
                    "where studentName = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,info[0]);
            statement.setString(2,info[1]);
            statement.setString(3,info[2]);
            statement.setString(4,info[3]);
            statement.setString(5,info[4]);
            statement.setString(6,info[5]);
            statement.setString(7,info[6]);
            statement.setString(8,info[7]);
            statement.setString(9,info[0]);
            ret = statement.executeUpdate();
            if(ret == 1){
                student = ViewSelectedStudentByName(info[0]);
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    /**
     * 查看所有个人信息
     */
    public Vector<Student> ViewAllStudent(){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Vector<Student> students = new Vector<>();
        try{
            connection  =DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.student";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Student student = new Student();
                student.setStudentId(resultSet.getInt("studentId"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setStudentPassword(resultSet.getString("studentPassword"));
                student.setSchoolName(resultSet.getString("schoolName"));
                student.setSchoolType(resultSet.getString("schoolType"));
                student.setCameFrom(resultSet.getString("cameFrom"));
                student.setDreamSchoolType(resultSet.getString("dreamSchoolType"));
                student.setDreamSchoolLoc(resultSet.getString("dreamSchoolLoc"));
                student.setDreamSchoolName(resultSet.getString("dreamSchoolName"));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }


    /**
     * 查看指定个人信息
     */
    public Student ViewSelectedStudentByName(String studentname){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Student student = null;

        try{
            connection = DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.student where studentName = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,studentname);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                student = new Student();
                student.setStudentId(resultSet.getInt("studentId"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setStudentPassword(resultSet.getString("studentPassword"));
                student.setSchoolName(resultSet.getString("schoolName"));
                student.setSchoolType(resultSet.getString("schoolType"));
                student.setCameFrom(resultSet.getString("cameFrom"));
                student.setDreamSchoolType(resultSet.getString("dreamSchoolType"));
                student.setDreamSchoolLoc(resultSet.getString("dreamSchoolLoc"));
                student.setDreamSchoolName(resultSet.getString("dreamSchoolName"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
    public Vector<Student> ViewSelectedStudentByFuzzyQuery(String studentname){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Student student = null;
        Vector<Student> students = new Vector<>();
        try{
            connection  =DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.student where studentName like '%"+studentname+"%'";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                student = new Student();
                student.setStudentId(resultSet.getInt("studentId"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setStudentPassword(resultSet.getString("studentPassword"));
                student.setSchoolName(resultSet.getString("schoolName"));
                student.setSchoolType(resultSet.getString("schoolType"));
                student.setCameFrom(resultSet.getString("cameFrom"));
                student.setDreamSchoolType(resultSet.getString("dreamSchoolType"));
                student.setDreamSchoolLoc(resultSet.getString("dreamSchoolLoc"));
                student.setDreamSchoolName(resultSet.getString("dreamSchoolName"));
                students.addElement(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    /**
     * 验证登录信息
     */
    public static Student FindSelectedStudent(String studentname,String studentpassword){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Student student = null;
        
        try{
            connection = DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.student " +
                    "where studentName = ? and studentPassword = ?";
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1,studentname);
            statement.setString(2,studentpassword);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                student = new Student();
                student.setStudentId(resultSet.getInt("studentId"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setStudentPassword(resultSet.getString("studentPassword"));
                student.setSchoolName(resultSet.getString("schoolName"));
                student.setSchoolType(resultSet.getString("schoolType"));
                student.setCameFrom(resultSet.getString("cameFrom"));
                student.setDreamSchoolType(resultSet.getString("dreamSchoolType"));
                student.setDreamSchoolLoc(resultSet.getString("dreamSchoolLoc"));
                student.setDreamSchoolName(resultSet.getString("dreamSchoolName"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    /*public static void main(String[] args) {
        Student student = studentDAO.FindSelectedStudent("zzy","123");
        System.out.println(student);
    }*/
}
