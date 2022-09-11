package com.UdeA.ciclo3.Controller;

import com.UdeA.ciclo3.Modelos.Empresa;
import com.UdeA.ciclo3.servicios.EmpresaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControlEmpresa {

        @Autowired
        EmpresaServicios serviceEmpresa;

        @GetMapping("/enterprises")
        public List<Empresa> verEmpresas(){
            return serviceEmpresa.getAllEmpresas();
        }
        //Guarda el Json del Body como una nueva empresa
        @PostMapping("/enterprises")
        public Empresa guardarEmpresa(@RequestBody Empresa company){
            return this.serviceEmpresa.saverOurdateEmpresa(company);
        }
        //BuscarEmpresa
        @GetMapping(path ="enterprises/{id}")
        public Empresa empresaPorID(@PathVariable("id")Integer id ){
            return this.serviceEmpresa.getEmpresaById(id);
        }

        //Editar empresa
       @PatchMapping("/enterprises/")
       public Optional<Empresa> actualizarEmpresa(@RequestBody Empresa editarEmpresa){
            return Optional.ofNullable(serviceEmpresa.saverOurdateEmpresa(editarEmpresa));
    }
        //Elimiar empresa
        @DeleteMapping("enterprises/{id}")
        public Boolean removerEmpresa(@PathVariable(value="id") Integer id){
        return serviceEmpresa.deleteEmpresa(id);
    }

}
