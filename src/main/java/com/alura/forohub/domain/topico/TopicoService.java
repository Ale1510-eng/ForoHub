package com.alura.forohub.domain.topico;

import com.alura.forohub.domain.topico.validaciones.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository repository;

    public DatosDetalleTopico crear(DatosRegistroTopico datos){
        if(repository.existsByTitulo(datos.titulo())){
            if(repository.existsByMensaje(datos.mensaje())){
                throw new ValidacionException("El tópico que intenta crear ya existe");
            }
        }
        var topico = new Topico(datos);
        repository.save(topico);
        return new DatosDetalleTopico(topico);
    }



}
