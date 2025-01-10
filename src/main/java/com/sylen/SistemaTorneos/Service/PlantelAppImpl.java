package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.DAO.IPlantelDAO;
import com.sylen.SistemaTorneos.Model.entity.Plantel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantelAppImpl implements PlantelApp{

    @Autowired
    private IPlantelDAO plantelDAO;

    @Override
    public List<Plantel> findAll() {
        return plantelDAO.findAll();
    }

    @Override
    public Plantel findOne( Long id ) {
        return plantelDAO.findOne(id);
    }

}
