package com.alura.forohub.controller;

import com.alura.forohub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;
    @Autowired
    private TopicoService creacion;


    @PostMapping
    @Transactional
    public ResponseEntity registrar (@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder){
        var detalleTopico = creacion.crear(datos);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(detalleTopico.id()).toUri();
        return ResponseEntity.created(uri).body(detalleTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleListaTopico>> listar (
            @PageableDefault(size = 10, sort ={"fechaCreacion"}, direction = Sort.Direction.DESC) Pageable paginacion){
        var page = repository.findAll(paginacion).map(DatosDetalleListaTopico::new);
        return ResponseEntity.ok(page);
    }


}
