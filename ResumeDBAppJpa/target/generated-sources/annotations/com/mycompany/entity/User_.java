package com.mycompany.entity;

import com.mycompany.entity.Country;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.UserSkill;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-30T23:17:53", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, Date> birthdate;
    public static volatile SingularAttribute<User, String> profileDescription;
    public static volatile ListAttribute<User, EmploymentHistory> employmentHistoryList;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Country> birthplace;
    public static volatile SingularAttribute<User, Country> nationality;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile ListAttribute<User, UserSkill> userSkillList;

}