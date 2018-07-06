package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {

	public User findByLoginInfo(String loginId, String password) {
        Connection conn = null;
        try {
            conn = DBManager.getConnection();

            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
	public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            conn = DBManager.getConnection();

            String sql = "SELECT * FROM user";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }
	public User newUser(String newId,String pass,String pass2,String userName,String birth) {
		Connection conn = null;
        try {
            conn = DBManager.getConnection();
            String sql = "insert into user(login_id,name,password,birth_date,create_date,update_date) values(?,?,?,?,now(),now())";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, newId);
            pStmt.setString(2, userName);
            pStmt.setString(3, pass);
            pStmt.setString(4, birth);
            pStmt.executeUpdate();
            return new User(newId, userName);

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
	public User detailUser(String loginId) {
		Connection conn = null;
        try {
            conn = DBManager.getConnection();

            String sql = "SELECT * FROM user WHERE login_id = ?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            Date birthData=rs.getDate("birth_date");
            String createData = rs.getString("create_date");
            String updateData = rs.getString("update_date");

            return new User(loginIdData, nameData,birthData,createData,updateData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
	public User kousinUser(String loginId) {
		Connection conn = null;
        try {
            conn = DBManager.getConnection();

            String sql = "SELECT * FROM user WHERE login_id = ?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            Date birthData=rs.getDate("birth_date");

            return new User(loginIdData, nameData,birthData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}
