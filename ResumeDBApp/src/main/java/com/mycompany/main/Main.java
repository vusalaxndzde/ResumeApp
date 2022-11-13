package com.mycompany.main;

import com.mycompany.dao.inter.EmploymentHistoryDaoInter;


public class Main {

    public static void main(String[] args) throws Exception {
        EmploymentHistoryDaoInter udi = Context.instanceEmploymentHistoryDao();
        System.out.println(udi.getEmploymentHistoryByUserId(1));
    }

}
