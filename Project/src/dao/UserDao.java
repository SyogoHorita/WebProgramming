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

            String sql = "SELECT * FROM user where id != '1'";

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
	public User newUser(String newId,String pass,String userName,String birth) {
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
	public void kousinUser(String loginId, String pass,String name,String birth) {
		Connection conn = null;
        try {
            conn = DBManager.getConnection();

            String sql = "UPDATE user set password=?,birth_date=?,name=? where login_id=?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,pass);
            pStmt.setString(2,birth);
            pStmt.setString(3,name);
            pStmt.setString(4,loginId);
            pStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	public void kousinUser(String loginId,String name, String birth) {
		Connection conn = null;
        try {
            conn = DBManager.getConnection();

            String sql = "UPDATE user set birth_date=?,name=? where login_id=?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,birth);
            pStmt.setString(2,name);
            pStmt.setString(3,loginId);
            pStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	public void deleteUser(String loginId) {
		Connection conn = null;
        try {
            conn = DBManager.getConnection();

            String sql = "DELETE from user where login_id=?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,loginId);
            pStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	public List<User> find(String id2,String name2,String date,String date2) {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            conn = DBManager.getConnection();

            String sql = "SELECT * FROM user where id != '1'";

            if(id2 != null && !id2.equals("")) {
            	sql += " AND login_id ='" + id2 + "'";
            }
            if(name2!=null&&!name2.equals("")) {
            	sql+=" AND name like '%"+name2+"%'";
            }
            if(date!=null&&!date.equals("")) {
            	sql+=" AND birth_date >= '" + date +" '";
            }
            if(date2!=null&&!date2.equals("")) {
            	sql+=" AND birth_date <= '" + date2 +" '";
            }

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
}