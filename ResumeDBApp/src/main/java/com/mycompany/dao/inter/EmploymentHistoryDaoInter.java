package com.mycompany.dao.inter;

import com.mycompany.entity.EmploymentHistory;
import java.util.List;

public interface EmploymentHistoryDaoInter {
    
    public List<EmploymentHistory> getEmploymentHistoryByUserId(int userId);
    
}
