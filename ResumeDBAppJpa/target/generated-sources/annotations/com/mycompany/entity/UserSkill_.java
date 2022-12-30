package com.mycompany.entity;

import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-30T23:17:53", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(UserSkill.class)
public class UserSkill_ { 

    public static volatile SingularAttribute<UserSkill, Skill> skill;
    public static volatile SingularAttribute<UserSkill, Integer> id;
    public static volatile SingularAttribute<UserSkill, Integer> power;
    public static volatile SingularAttribute<UserSkill, User> user;

}