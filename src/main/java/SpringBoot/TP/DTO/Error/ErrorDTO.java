package SpringBoot.TP.DTO.Error;

import java.time.LocalDateTime;

public record ErrorDTO(LocalDateTime timestamp,
                       int status,
                       String mensaje,
                       String detalles) {
}
