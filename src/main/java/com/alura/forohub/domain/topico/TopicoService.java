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

    public DatosDetalleListaTopico visualizarDetalles(Long id){
        if(!repository.existsById(id)){
            throw new ValidacionException("El id ingresado es incorrecto");
        }
        var topico = repository.getReferenceById(id);
        return new DatosDetalleListaTopico(topico);
    }

    public DatosDetalleListaTopico actualizar(Long id, DatosActualizacionTopico datos){
        var referenciaTopico = repository.findById(id);
        if(!referenciaTopico.isPresent()){
            throw new ValidacionException("No se encontró el tópico");
        }
        if(repository.existsByTitulo(datos.titulo())){
            if(repository.existsByMensaje(datos.mensaje())){
                throw new ValidacionException("El tópico que intenta actualizar ya existe");
            }
        }
        var topico = repository.getReferenceById(id);
        topico.actualizarInformacion(datos);
        return new DatosDetalleListaTopico(topico);
    }

    public void eliminarTopico (Long id){
        var referenciaTopico = repository.findById(id);
        if(!referenciaTopico.isPresent()){
            throw new ValidacionException("No se encontró el tópico");
        }
        repository.deleteById(id);
    }


}
