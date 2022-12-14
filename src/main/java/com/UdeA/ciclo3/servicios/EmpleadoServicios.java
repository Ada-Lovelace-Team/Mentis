package com.UdeA.ciclo3.servicios;

import com.UdeA.ciclo3.Modelos.Empleado;
import com.UdeA.ciclo3.repo.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicios {
    @Autowired
    EmpleadoRepository empleadoRepository;//creacion de un objeto tipo repositorio
    //Retorna las empleados
    public List<Empleado> getAllEmpleado(){
        List <Empleado> empleadoList = new ArrayList<>();
        empleadoRepository.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;

    }
    //reporna el empleado con el Id
    public Optional<Empleado> getEmpleadoById(Integer id){
        return empleadoRepository.findById(id);
    }

    // Guardar o actualizar
    public Empleado saverOurdateEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);

    }
    //Metodo para eliminar registros
    public boolean deleteEmpleado(Integer id){
        empleadoRepository.deleteById(id);
        if (this.empleadoRepository.findById(id).isPresent()){ //verificacion de eliminacion
            return false;

        }
        return true;

    }

    public ArrayList<Empleado> ObtenerPorEmpresa(Integer id) {

        return null;
    }


}