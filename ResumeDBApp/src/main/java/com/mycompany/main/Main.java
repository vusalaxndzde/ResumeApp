package com.mycompany.main;

import com.mycompany.dao.inter.CountryDaoInter;


public class Main {

    public static void main(String[] args) throws Exception {
        CountryDaoInter udi = Context.instanceCountryDao();
        System.out.println(udi.getAllCountry());
    }

}
