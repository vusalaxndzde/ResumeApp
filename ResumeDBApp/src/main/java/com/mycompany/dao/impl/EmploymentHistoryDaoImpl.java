package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {
    
    public EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String header = rs.getString("header");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");
        int userId = rs.getInt("user_id");
        
        return new EmploymentHistory(id, header, beginDate, endDate, jobDescription, new User(userId));
    }

    @Override
    public List<EmploymentHistory> getEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("select * from employment_history where user_id = ?");
            pstmt.setInt(1, userId);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                EmploymentHistory employmentHistory = getEmploymentHistory(rs);
                result.add(employmentHistory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory eh) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("update employment_history set header = ?, "
                    + "begin_date = ?, end_date = ?, job_description = ?, user_id = ? where id = ?");
            pstmt.setString(1, eh.getHeader());
            pstmt.setDate(2, eh.getBeginDate());
            pstmt.setDate(3, eh.getEndDate());
            pstmt.setString(4, eh.getJobDescription());
            pstmt.setInt(5, eh.getUser().getId());
            pstmt.setInt(6, eh.getId());
            pstmt.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int addEmploymentHistory(EmploymentHistory eh) {
        int id = 0;
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("insert into employment_history(header, "
                    + "begin_date, end_date, job_description, user_id) values(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, eh.getHeader());
            pstmt.setDate(2, eh.getBeginDate());
            pstmt.setDate(3, eh.getEndDate());
            pstmt.setString(4, eh.getJobDescription());
            pstmt.setInt(5, eh.getUser().getId());
            pstmt.execute();
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("delete from employment_history where id = " + id);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}
