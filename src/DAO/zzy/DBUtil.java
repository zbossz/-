package DAO.zzy;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL ="jdbc:mysql://127.0.0.1:3306/graduateschoolinquirysystem?" +
            "characterEncoding=utf-8&" +
            "useSSL=true";
    private static final String USERNAME = "root";
    private static final String USERPASSWORD = "zbosszsql";
    private static DataSource dataSource = null;
    public static DataSource getDataSource(){
        if(dataSource == null){
            dataSource = new MysqlDataSource();
            ((MysqlDataSource)dataSource).setUrl(URL);
            ((MysqlDataSource)dataSource).setUser(USERNAME);
            ((MysqlDataSource)dataSource).setPassword(USERPASSWORD);
        }
        return dataSource;
    }
    public static Connection getConnection(){
        if(dataSource==null){
            dataSource = getDataSource();
        }
        try{
            return dataSource.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection , PreparedStatement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
