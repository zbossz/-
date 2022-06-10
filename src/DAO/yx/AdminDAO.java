package DAO.yx;
import DAO.yx.Admin;
import DAO.zzy.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class AdminDAO {
    /*ģ����������Ա��Ϣ*/
    public Vector<Admin> ViewSelectedAdminByFuzzyQuery(String adminname){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Vector<Admin> admins = new Vector<>();
        Admin admin =null;
        try{
            connection = DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.admin where adminName like '%"+adminname+"%'";
            statement = connection.prepareStatement(sql);//׼��sql���
            resultSet = statement.executeQuery();//ִ�в�ѯ����
            while(resultSet.next()){//ѭ����ȡresulset����
                admin = new Admin();//�½�һ��admin���󴢴�resultset.next()���
                admin.setAdminName(resultSet.getString("adminName"));
                admin.setAdminPassword(resultSet.getString("adminPassword"));
                admins.addElement(admin);//addElement��vector���������ѡ�����Ҳ������add
            }
            return admins;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    /*�����鿴���й���Ա��Ϣ*/
    public Vector<Admin> ViewAllAdmin(){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Vector<Admin> admins = new Vector<>();

        try{
            connection = DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.admin";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Admin admin = new Admin();
                admin.setAdminName(resultSet.getString("adminName"));
                admin.setAdminPassword(resultSet.getString("adminPassword"));
                admins.add(admin);
            }
            return admins;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    /*�����鿴�ض��Ĺ���Ա��Ϣ*/
    public Admin ViewSelectedAdminByName(String adminname){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Admin admin = null;

        try{
            connection = DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.admin where adminName = ?";//ռλ��
            statement = connection.prepareStatement(sql);
            statement.setString(1,adminname);

            resultSet = statement.executeQuery();

            if(resultSet.next()){
                admin = new Admin();
                admin.setAdminName(resultSet.getString("adminName"));
                admin.setAdminPassword(resultSet.getString("adminPassword"));
                return admin;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    /*��֤��¼��Ϣ*/
    public Admin FindSelectedAdmin(String adminname,String adminpassword){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Admin admin = null;

        try{
            connection = DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.admin where adminName = ? and adminPassword = ?";
            statement = connection.prepareStatement(sql);

            statement.setString(1,adminname);
            statement.setString(2,adminpassword);


            resultSet = statement.executeQuery();

            if(resultSet.next()){
               admin = new Admin();
               admin.setAdminName(resultSet.getString("adminName"));
               admin.setAdminPassword(resultSet.getString("adminPassword"));
               admin.setAdminId(resultSet.getInt("adminId"));
               return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    /*���ӹ���Ա��Ϣ*/
    public boolean InsertAdminInfo(String adminname,String adminpassword){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Admin admin = null;

        try{
            connection = DBUtil.getConnection();
            String sql = "insert into graduateschoolinquirysystem.admin values(null,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,adminname);
            statement.setString(2,adminpassword);
            int ret = statement.executeUpdate();//ִ�и��²���

            if(ret==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return false;
    }
    /*ɾ������Ա��Ϣ*/
    public boolean DeleteAdminInfo(String adminname){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Admin admin = null;

        try{
            connection = DBUtil.getConnection();
            String sql = "delete from graduateschoolinquirysystem.admin where adminName = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,adminname);
            int ret = statement.executeUpdate();
            return ret ==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return false;
    }
    /*�޸Ĺ���Ա��Ϣ*/
    public boolean ModifyAdminInfo(String adminname,String adminpassword){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Admin admin = null;

        try{
            connection = DBUtil.getConnection();
            String sql = "update graduateschoolinquirysystem.admin set adminPassword= ?where adminName = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,adminpassword);
            statement.setString(2,adminname);
            int ret = statement.executeUpdate();
            return ret ==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return false;
    }
}
