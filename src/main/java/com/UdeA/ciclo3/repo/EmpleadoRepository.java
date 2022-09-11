package com.UdeA.ciclo3.repo;

import com.UdeA.ciclo3.Modelos.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EmpleadoRepository extends CrudRepository<Empleado,Integer> {

    @Query(value = "SELECT *From empleado where e.empresa_id = ?1",nativeQuery = true)
    public abstract ArrayList<Empleado> findByEmpresa(Integer id);
}
