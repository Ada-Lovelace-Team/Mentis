package com.UdeA.ciclo3.repo;

import com.UdeA.ciclo3.Modelos.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EmpleadoRepository extends CrudRepository<Empleado,Integer> {
    @Query("select e from Empleado e where e.empresa = ?1")
    public abstract ArrayList<Empleado> findByEmpresa(Integer id);
}
