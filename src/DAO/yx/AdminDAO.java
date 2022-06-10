package DAO.yx;
import DAO.yx.Admin;
import DAO.zzy.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class AdminDAO {
    /*模糊搜索管理员信息*/
    public Vector<Admin> ViewSelectedAdminByFuzzyQuery(String adminname){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Vector<Admin> admins = new Vector<>();
        Admin admin =null;
        try{
            connection = DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.admin where adminName like '%"+adminname+"%'";
            statement = connection.prepareStatement(sql);//准备sql语句
            resultSet = statement.executeQuery();//执行查询操作
            while(resultSet.next()){//循环读取resulset内容
                admin = new Admin();//新建一个admin对象储存resultset.next()结果
                admin.setAdminName(resultSet.getString("adminName"));
                admin.setAdminPassword(resultSet.getString("adminPassword"));
                admins.addElement(admin);//addElement是vector的特有添加选项，这里也可以用add
            }
            return admins;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    /*搜索查看所有管理员信息*/
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
    /*搜索查看特定的管理员信息*/
    public Admin ViewSelectedAdminByName(String adminname){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        Admin admin = null;

        try{
            connection = DBUtil.getConnection();
            String sql = "select * from graduateschoolinquirysystem.admin where adminName = ?";//占位符
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
    /*验证登录信息*/
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
    /*增加管理员信息*/
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
            int ret = statement.executeUpdate();//执行更新操作

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
    /*删除管理员信息*/
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
    /*修改管理员信息*/
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
