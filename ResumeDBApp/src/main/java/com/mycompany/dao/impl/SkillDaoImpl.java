package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.entity.Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    public Skill getSkill(ResultSet rs) throws Exception {
        int skillId = rs.getInt("id");
        String skillName = rs.getString("name");

        return new Skill(skillId, skillName);
    }

    @Override
    public List<Skill> getAllSkill() {
        List<Skill> result = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from skill");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Skill skill = getSkill(rs);
                result.add(skill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Skill getSkillById(int id) {
        Skill skill = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from skill where id = " + id);
            while (rs.next()) {
                skill = getSkill(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return skill;
    }

    @Override
    public boolean updateSkill(Skill s) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("update skill set name = ? where id = ?");
            pstmt.setString(1, s.getName());
            pstmt.setInt(2, s.getId());
            pstmt.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addSkill(Skill s) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("insert into skill(name) value(?)");
            pstmt.setString(1, s.getName());
            pstmt.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeSkill(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("delete from skill where id = " + id);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
