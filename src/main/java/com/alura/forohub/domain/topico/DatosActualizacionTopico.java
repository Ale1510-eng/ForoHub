package com.alura.forohub.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizacionTopico(
        String titulo,
        String mensaje,
        Status status,
        String curso
) {
}
