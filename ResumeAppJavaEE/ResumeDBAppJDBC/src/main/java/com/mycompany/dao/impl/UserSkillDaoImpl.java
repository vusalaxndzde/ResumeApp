package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    public UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userSkillId = rs.getInt("userskill_id");
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        return new UserSkill(userSkillId, new User(userId), new Skill(skillId, skillName), power);
    }

    @Override
    public List<UserSkill> getAllUserSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select us.id as userskill_id, u.*, s.id as skill_id, "
                    + "s.name as skill_name, us.power from user_skill us "
                    + "left join user u on us.user_id = u.id "
                    + "left join skill s on us.skill_id = s.id "
                    + "where u.id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill userSkill = getUserSkill(rs);
                result.add(userSkill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addUserSkill(UserSkill us) {
        int id = 0;
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("insert into user_skill(user_id, skill_id, power) "
                    + "values(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, us.getUser().getId());
            pstmt.setInt(2, us.getSkill().getId());
            pstmt.setInt(3, us.getPower());
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

    @Override
    public boolean removeUserSkill(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("delete from user_skill where id = " + id);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUserSkill(UserSkill us) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("update user_skill set user_id = ?, "
                    + "skill_id = ?, power = ? where id = ?");
            pstmt.setInt(1, us.getUser().getId());
            pstmt.setInt(2, us.getSkill().getId());
            pstmt.setInt(3, us.getPower());
            pstmt.setInt(4, us.getId());
            pstmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
