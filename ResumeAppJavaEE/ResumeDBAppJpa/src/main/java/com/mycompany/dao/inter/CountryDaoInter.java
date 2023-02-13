package com.mycompany.dao.inter;

import com.mycompany.entity.Country;
import java.util.List;

public interface CountryDaoInter {

    public List<Country> getAllCountry();
    
    public Country getCountryById(int id);

    Country getCountryByName(String name);

    Country getCountryByNationality(String nationality);
    
    public boolean updateCountry(Country c);
    
    public int addCountry(Country c);
    
    public boolean removeCountry(int id);

}
