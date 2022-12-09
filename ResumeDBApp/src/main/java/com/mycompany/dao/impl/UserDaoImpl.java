package com.mycompany.dao.impl;

import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private User getUser(ResultSet rs) throws SQLException{
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String profileDescription = rs.getString("profile_description");
        String address = rs.getString("address");
        Date birthdate = rs.getDate("birthdate");
        int birthplaceId = rs.getInt("birthplace_id");
        int nationalityId = rs.getInt("nationality_id");
        String birthplaceStr = rs.getString("birthplace");
        String nationalityStr = rs.getString("nationality");

        Country birthplace = new Country(birthplaceId, birthplaceStr, null);
        Country nationality = new Country(nationalityId, null, nationalityStr);
        
        return new User(id, name, surname, phone, email, profileDescription, address, birthdate, birthplace, nationality);
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select u.*, c.name birthplace, n.nationality from user u "
                    + "left join country c "
                    + "on u.birthplace_id = c.id "
                    + "left join country n "
                    + "on u.nationality_id = n.id");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User user = getUser(rs);
                userList.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> filter(String name, String surname, Integer nationalityId) {
        List<User> userList = new ArrayList<>();
        try ( Connection c = connect()) {
            String query = "select u.*, c.name birthplace, n.nationality from user u "
                    + "left join country c "
                    + "on u.birthplace_id = c.id "
                    + "left join country n "
                    + "on u.nationality_id = n.id where 1=1 ";
            if (name != null && !name.trim().equals("")) {
                query += "and u.name = ? ";
            }
            if (surname != null && !surname.trim().equals("")) {
                query += "and u.surname = ? ";
            }
            if (nationalityId != null) {
                query += "and u.nationality_id = ? ";
            }

            PreparedStatement pstmt = c.prepareStatement(query);
            int i = 1;
            if (name != null && !name.trim().equals("")) {
                pstmt.setString(i, name);
                i++;
            }
            if (surname != null && !surname.trim().equals("")) {
                pstmt.setString(i, surname);
                i++;
            }
            if (nationalityId != null) {
                pstmt.setInt(i, nationalityId);
            }

            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                User user = getUser(rs);
                userList.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean updateUser(User u) {
        try ( Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("update user set name = ?, surname = ?, phone = ?, "
                    + "email = ?, profile_description = ?, address = ?, birthdate = ?, "
                    + "birthplace_id = ?, nationality_id = ? where id = ?");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurname());
            pstmt.setString(3, u.getPhone());
            pstmt.setString(4, u.getEmail());
            pstmt.setString(5, u.getProfileDescription());
            pstmt.setString(6, u.getAddress());
            pstmt.setDate(7, u.getBrithdate());
            pstmt.setInt(8, u.getBirthplace().getId());
            pstmt.setInt(9, u.getNationality().getId());
            pstmt.setInt(10, u.getId());
            pstmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("delete from user where id = " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public User getById(int id) {
        User result = null;
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select u.*, c.name birthplace, n.nationality from user u "
                    + "left join country c "
                    + "on u.birthplace_id = c.id "
                    + "left join country n "
                    + "on u.nationality_id = n.id where u.id = " + id);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User user = getUser(rs);
                result = user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addUser(User u) {
        int id = 0;
        try ( Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("insert into user(name, surname, phone, email, "
                    + "profile_description, address, birthdate, birthplace_id, nationality_id) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurname());
            pstmt.setString(3, u.getPhone());
            pstmt.setString(4, u.getEmail());
            pstmt.setString(5, u.getProfileDescription());
            pstmt.setString(6, u.getAddress());
            pstmt.setDate(7, u.getBrithdate());
            pstmt.setInt(8, u.getBirthplace().getId());
            pstmt.setInt(9, u.getNationality().getId());
            pstmt.execute();
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

}
