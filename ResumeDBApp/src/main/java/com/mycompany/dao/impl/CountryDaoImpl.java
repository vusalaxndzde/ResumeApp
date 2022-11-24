package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.entity.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    public Country getCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");

        return new Country(id, name, nationality);
    }

    @Override
    public List<Country> getAllCountry() {
        List<Country> result = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from country");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Country country = getCountry(rs);
                result.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Country getCountryById(int id) {
        Country country = null;
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from country where id = " + id);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                country = getCountry(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public boolean updateCountry(Country c) {
        try (Connection con = connect()) {
            PreparedStatement pstmt = con.prepareStatement("update country set name = ?, nationality = ? "
                    + "where id = ?");
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getNationality());
            pstmt.setInt(3, c.getId());
            pstmt.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int addCountry(Country c) {
        int id = 0;
        try (Connection con = connect()) {
            PreparedStatement pstmt = con.prepareStatement("insert into country(name, nationality) values(?, ?)", 
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getNationality());
            pstmt.execute();
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            while (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    @Override
    public boolean removeCountry(int id) {
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("delete from country where id = " + id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
