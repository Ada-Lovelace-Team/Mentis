package com.UdeA.ciclo3.servicios;

import com.UdeA.ciclo3.Modelos.Empresa;
import com.UdeA.ciclo3.repo.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaServicios {
    @Autowired
    EmpresaRepository empresaRepository;//creacion de un objeto tipo repositorio
    //metodo que me dice todas las empresas que tengo por medio de jpaRepository
    //Retorna todas las empresas
    public List <Empresa> getAllEmpresas(){
        List <Empresa> empresaList = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;

    }
    //metodo que genera un objeto de tipo empresa con el ID de la misma
    public Empresa getEmpresaById(Integer id){
        return empresaRepository.findById(id).get();
    }

    // Guardar o actualizar
    public Empresa saverOurdateEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);

    }
    //Metodo para eliminar registros
    public boolean deleteEmpresa(Integer id){
        empresaRepository.deleteById(id);
        if (empresaRepository.findById(id)==null){ //verificacion de eliminacion
            return true;

        }
        return false;

    }
}
