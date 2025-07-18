package com.alura.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleListaTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        Status status,
        String autor,
        String curso
) {
    public DatosDetalleListaTopico(Topico topico) {
        this(topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso());
    }
}
