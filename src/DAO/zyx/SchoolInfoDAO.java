package DAO.zyx;

import DAO.yx.Admin;
import DAO.zzy.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SchoolInfoDAO {

    /*查看特定的院校信息*/
    public SchoolInfo ViewSelectedSchoolInfoByName(String schoolname){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        SchoolInfo schoolInfo = new SchoolInfo();

        try{
            connection = DBUtil.getConnection();

            String sql = "select * from 985schoolinfo where schoolName=? " +
                    "union all select * from 211schoolinfo where schoolName=? " +
                    "union all select * from normalschoolinfo where schoolName= ?  ";

            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1,schoolname);
            statement.setString(2,schoolname);
            statement.setString(3,schoolname);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                schoolInfo.setSchoolId(resultSet.getInt("schoolId"));
                schoolInfo.setSchoolName(resultSet.getString("schoolName"));
                schoolInfo.setSchoolType(resultSet.getString("schoolType"));
                schoolInfo.setAllCoursesMin(resultSet.getDouble("allCoursesMin"));
                schoolInfo.setAllCoursesMean(resultSet.getDouble("allCoursesMean"));
                schoolInfo.setAllCoursesMax(resultSet.getDouble("allCoursesMax"));

                schoolInfo.setEnglishMin(resultSet.getDouble("englishMin"));
                schoolInfo.setEnglishMean(resultSet.getDouble("englishMean"));
                schoolInfo.setEnglishMax(resultSet.getDouble("englishMax"));

                schoolInfo.setPoliticsMin(resultSet.getDouble("politicsMin"));
                schoolInfo.setPoliticsMean(resultSet.getDouble("politicsMean"));
                schoolInfo.setPoliticsMax(resultSet.getDouble("politicsMax"));

                schoolInfo.setFirstProfessionalMin(resultSet.getDouble("firstProfessionalMin"));
                schoolInfo.setFirstProfessionalMean(resultSet.getDouble("firstProfessionalMean"));
                schoolInfo.setFirstProfessionalMax(resultSet.getDouble("firstProfessionalMax"));

                schoolInfo.setSecondProfessionalMin(resultSet.getDouble("secondProfessionalMin"));
                schoolInfo.setSecondProfessionalMean(resultSet.getDouble("secondProfessionalMean"));
                schoolInfo.setSecondProfessionalMax(resultSet.getDouble("secondProfessionalMax"));

                schoolInfo.setReExamNumber(resultSet.getInt("reExamNumber"));
                return schoolInfo;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    /*
    * 模糊查询学校信息
    * */
    public Vector<SchoolInfo> ViewSelectedSchoolInfoByFuzzyQuery(String schoolname){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Vector<SchoolInfo> schoolInfos = new Vector<>();
        SchoolInfo schoolInfo = new SchoolInfo();

        try{
            connection = DBUtil.getConnection();

            String sql = "select * from 985schoolinfo where schoolName like '%"+schoolname+"%' " +
                    "union all select * from 211schoolinfo where schoolName like '%"+schoolname+"%' " +
                    "union all select * from normalschoolinfo where schoolName like '%"+schoolname+"%' " ;

            assert connection != null;
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                schoolInfo.setSchoolId(resultSet.getInt("schoolId"));
                schoolInfo.setSchoolName(resultSet.getString("schoolName"));
                schoolInfo.setSchoolType(resultSet.getString("schoolType"));
                schoolInfo.setAllCoursesMin(resultSet.getDouble("allCoursesMin"));
                schoolInfo.setAllCoursesMean(resultSet.getDouble("allCoursesMean"));
                schoolInfo.setAllCoursesMax(resultSet.getDouble("allCoursesMax"));

                schoolInfo.setEnglishMin(resultSet.getDouble("englishMin"));
                schoolInfo.setEnglishMean(resultSet.getDouble("englishMean"));
                schoolInfo.setEnglishMax(resultSet.getDouble("englishMax"));

                schoolInfo.setPoliticsMin(resultSet.getDouble("politicsMin"));
                schoolInfo.setPoliticsMean(resultSet.getDouble("politicsMean"));
                schoolInfo.setPoliticsMax(resultSet.getDouble("politicsMax"));

                schoolInfo.setFirstProfessionalMin(resultSet.getDouble("firstProfessionalMin"));
                schoolInfo.setFirstProfessionalMean(resultSet.getDouble("firstProfessionalMean"));
                schoolInfo.setFirstProfessionalMax(resultSet.getDouble("firstProfessionalMax"));

                schoolInfo.setSecondProfessionalMin(resultSet.getDouble("secondProfessionalMin"));
                schoolInfo.setSecondProfessionalMean(resultSet.getDouble("secondProfessionalMean"));
                schoolInfo.setSecondProfessionalMax(resultSet.getDouble("secondProfessionalMax"));

                schoolInfo.setReExamNumber(resultSet.getInt("reExamNumber"));
                schoolInfos.addElement(schoolInfo);
            }
            return schoolInfos;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    /*修改特定的院校信息*/
    public SchoolInfo ModifySelectedSchoolInfo(String schoolname,String schooltype,BigDecimal[] score,int recruitnumber){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Admin admin = null;
        SchoolInfo schoolInfo = null;
        List<String> schooltypes= new ArrayList<>();
        schooltypes.add("985schoolinfo");
        schooltypes.add("211schoolinfo");
        schooltypes.add("normalschoolinfo");

        try{
            connection = DBUtil.getConnection();


            if(schooltype.equals("985")){
                String sql = "update graduateschoolinquirysystem.985schoolinfo " +
                        "set allCoursesMin = ?, allCoursesMean = ?, allCoursesMax = ?," +
                        " englishMin = ?, englishMean = ?, englishMax = ?,"+
                        " politicsMin = ?, politicsMean = ?, politicsMax = ?,"+
                        " firstProfessionalMin = ?, firstProfessionalMean = ?, firstProfessionalMax = ?,"+
                        " secondProfessionalMin = ?, secondProfessionalMean = ?, secondProfessionalMax = ? ,"+
                        " reExamNumber = ? "+
                        "where schoolName = ?";
                statement = connection.prepareStatement(sql);
            }
            else if (schooltype.equals("211")) {
                String sql = "update graduateschoolinquirysystem.211schoolinfo " +
                        "set allCoursesMin = ?, allCoursesMean = ?, allCoursesMax = ?," +
                        " englishMin = ?, englishMean = ?, englishMax = ?,"+
                        " politicsMin = ?, politicsMean = ?, politicsMax = ?,"+
                        " firstProfessionalMin = ?, firstProfessionalMean = ?, firstProfessionalMax = ?,"+
                        " secondProfessionalMin = ?, secondProfessionalMean = ?, secondProfessionalMax = ? ,"+
                        " reExamNumber = ? "+
                        "where schoolName = ?";
                statement = connection.prepareStatement(sql);
            }
            else{
                String sql = "update graduateschoolinquirysystem.normalschoolinfo " +
                        "set allCoursesMin = ?, allCoursesMean = ?, allCoursesMax = ?," +
                        " englishMin = ?, englishMean = ?, englishMax = ?,"+
                        " politicsMin = ?, politicsMean = ?, politicsMax = ?,"+
                        " firstProfessionalMin = ?, firstProfessionalMean = ?, firstProfessionalMax = ?,"+
                        " secondProfessionalMin = ?, secondProfessionalMean = ?, secondProfessionalMax = ? ,"+
                        " reExamNumber = ? "+
                        "where schoolName = ?";
                statement = connection.prepareStatement(sql);
            }

            statement.setBigDecimal(1,score[0]);
            statement.setBigDecimal(2,score[1]);
            statement.setBigDecimal(3,score[2]);

            statement.setBigDecimal(4,score[3]);
            statement.setBigDecimal(5,score[4]);
            statement.setBigDecimal(6,score[5]);

            statement.setBigDecimal(7,score[6]);
            statement.setBigDecimal(8,score[7]);
            statement.setBigDecimal(9,score[8]);

            statement.setBigDecimal(10,score[9]);
            statement.setBigDecimal(11,score[10]);
            statement.setBigDecimal(12,score[11]);

            statement.setBigDecimal(13,score[12]);
            statement.setBigDecimal(14,score[13]);
            statement.setBigDecimal(15,score[14]);

            statement.setInt(16,recruitnumber);
            statement.setString(17,schoolname);

            int ret = statement.executeUpdate();
            if(ret==1){
                schoolInfo = ViewSelectedSchoolInfoByName(schoolname);
                return schoolInfo;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    /*删除特定的院校信息*/
    public boolean DeleteSelectedSchoolInfo(String schoolname, String schooltype){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection=DBUtil.getConnection();


            if(schooltype.equals("985")){
                String sql = "delete from graduateschoolinquirysystem.985schoolinfo where  schoolName= ?";
                statement=connection.prepareStatement(sql);
            }
            else if (schooltype.equals("211")) {
                String sql = "delete from graduateschoolinquirysystem.211schoolinfo where  schoolName= ?";
                statement=connection.prepareStatement(sql);
            }
            else{
                String sql = "delete from graduateschoolinquirysystem.normalschoolinfo where  schoolName= ?";
                statement=connection.prepareStatement(sql);
            }

            statement.setString(1, schoolname);
            int ret = statement.executeUpdate();
            return ret ==1;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
        return false;
    }
    /**
     * 增加特定的院校信息
     * score(全科最低，全科平均，全科最大，英语最低，英语平均，英语最大，政治最低，政治平均，政治最大，专业一最低，专业一平均，专业1最大，专业2最低，专业2平均，专业2最大)
     * */
    public SchoolInfo AddSelectedSchoolInfo(String schoolname, String schooltype, BigDecimal[] score, int recruitnumber){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        SchoolInfo schoolInfo = null;
        List<String> schooltypes= new ArrayList<>();
        schooltypes.add("985schoolinfo");
        schooltypes.add("211schoolinfo");
        schooltypes.add("normalschoolinfo");

        try{
            connection = DBUtil.getConnection();


            if(schooltype.equals("985")){
                String sql = "insert into graduateschoolinquirysystem.985schoolinfo values(null,?,'985',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                statement = connection.prepareStatement(sql);
            }
            else if (schooltype.equals("211")) {
                String sql = "insert into graduateschoolinquirysystem.211schoolinfo values(null,?,'211',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                statement = connection.prepareStatement(sql);
            }
            else if (schooltype.equals("normal")){
                String sql = "insert into graduateschoolinquirysystem.normalschoolinfo values(null,?,'normal',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                statement = connection.prepareStatement(sql);
            }

            //statement.setString(1, schooltypes.get(1));

            statement.setString(1,schoolname);
            statement.setBigDecimal(2,score[0]);
            statement.setBigDecimal(3,score[1]);
            statement.setBigDecimal(4,score[2]);

            statement.setBigDecimal(5,score[3]);
            statement.setBigDecimal(6,score[4]);
            statement.setBigDecimal(7,score[5]);

            statement.setBigDecimal(8,score[6]);
            statement.setBigDecimal(9,score[7]);
            statement.setBigDecimal(10,score[8]);

            statement.setBigDecimal(11,score[9]);
            statement.setBigDecimal(12,score[10]);
            statement.setBigDecimal(13,score[11]);

            statement.setBigDecimal(14,score[12]);
            statement.setBigDecimal(15,score[13]);
            statement.setBigDecimal(16,score[14]);

            statement.setInt(17,recruitnumber);
            int ret = statement.executeUpdate();
            if(ret==1){
                schoolInfo = ViewSelectedSchoolInfoByName(schoolname);
            }
            return schoolInfo;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return schoolInfo;
    }

    public static void main(String[] args) {

    }
}
