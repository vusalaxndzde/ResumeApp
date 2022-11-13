/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {
    
    public UserSkill getUserSkill(ResultSet rs) throws Exception{
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");
        
        return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power);
    }

    @Override
    public List<UserSkill> getAllUserSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select u.*, s.id as skill_id, s.name as skill_name, us.power from user_skill us "
                    + "left join user u on us.user_id = u.id "
                    + "left join skill s on us.skill_id = s.id "
                    + "where u.id = " + userId);
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

}
