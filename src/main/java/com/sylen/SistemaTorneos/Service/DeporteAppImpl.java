package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.DAO.IDeporteDAO;
import com.sylen.SistemaTorneos.Model.entity.Deporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteAppImpl implements DeporteApp{

    @Autowired
    private IDeporteDAO deporteDAO;

    @Override
    public List<Deporte> getAllDeportes() {
        return deporteDAO.findAll();
    }

    @Override
    public Deporte getOneDeporte( Long id ) {
        return deporteDAO.findOne(id);
    }

    @Override
    public void save(Deporte deporte) {
        // TODO: Validaciones a Priori
        deporteDAO.save(deporte);
    }
}
