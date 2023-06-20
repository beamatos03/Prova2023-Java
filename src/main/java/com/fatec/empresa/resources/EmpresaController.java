package com.fatec.empresa.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.empresa.entities.Empresa;
import com.fatec.empresa.services.EmpresaService;

@CrossOrigin
@RequestMapping("empresas")
@RestController
public class EmpresaController {


    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> saveClient(@RequestBody Empresa ent){

        Empresa newEmpresa = empresaService.save(ent);
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(ent.getId())
        .toUri();
        
        return ResponseEntity.created(location).body(newEmpresa);
    }

    
}
