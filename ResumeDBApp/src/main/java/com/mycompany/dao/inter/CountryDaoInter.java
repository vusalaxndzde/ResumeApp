package com.mycompany.dao.inter;

import com.mycompany.entity.Country;
import java.util.List;

public interface CountryDaoInter {

    public List<Country> getAllCountry();
    
    public Country getCountryById(int id);
    
    public boolean updateCountry(Country c);
    
    public boolean addCountry(Country c);
    
    public boolean removeCountry(int id);

}
