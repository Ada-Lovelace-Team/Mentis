package com.UdeA.ciclo3.Controller;

import com.UdeA.ciclo3.Modelos.Empleado;
import com.UdeA.ciclo3.Modelos.Empresa;
import com.UdeA.ciclo3.servicios.EmpleadoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ControlEmpleado {

    @Autowired
    EmpleadoServicios empleadoServicios;

    //Ver Json de los json de todos los empleados
    @GetMapping("/users")
    public List<Empleado> verEmpleados(){
        return empleadoServicios.getAllEmpleado();
    }
    //guardar un nuevo empleado
    @PostMapping("/users")
    public Optional<Empleado> guardarEmpleado(@RequestBody Empleado empleado){
       return Optional.ofNullable(this.empleadoServicios.saverOurdateEmpleado(empleado));
    }
    //Buscar por Id
    @GetMapping(path = "users/{id}")
    public Optional <Empleado> empleadoPorID(@PathVariable("id") Integer id){
        return this.empleadoServicios.getEmpleadoById(id);

    }
    // Consultar empleados por empresa
    //@GetMapping("/enterprises/{id}/users")
    //public ArrayList<Empleado> EmpleadoPorEmpresa(@PathVariable("id")Integer id){
        //return this.empleadoServicios.obtenerPorEmpresa(id); //Corregior

    @PatchMapping("/users/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado){
        Empleado empl= empleadoServicios.getEmpleadoById(id).get();
        empl.setNombre(empleado.getNombre());
        empl.setCedula(empleado.getCedula());
        empl.setCorreo(empleado.getCorreo());
        empl.setCargo(empleado.getCargo());
        empl.setEmpresa(empleado.getEmpresa());
        return empleadoServicios.saverOurdateEmpleado(empl);


    }

    @DeleteMapping (path= "users/{id}") //Eliminar registro de la bd
    public String DeleteEmpleado(@PathVariable("id") Integer id){
        boolean respuesta=empleadoServicios.deleteEmpleado(id); //eliminamos usando el servicio de nuestro service
        if (respuesta){ //si la respuesta booleana es true, si se eliminó
            return "Se eliminó exitosamente el empleado con el id "+id;
        }//Si la respuesta booleana es false, no se eliminó
        return "No se puedo eliminar el empleado con el id "+id;
    }


}