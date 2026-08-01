package ec.edu.espe.agrosmart.mapper;

import ec.edu.espe.agrosmart.domain.Producto;
import ec.edu.espe.agrosmart.entity.ProductoEntity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductoMapper {

    public static Producto toDominio(ProductoEntity entity) {
        String correosStr = entity.getCorreosNotificacion();
        List<String> correos;
        if (correosStr == null || correosStr.isBlank()) {
            correos = Collections.emptyList();
        } else {
            correos = Arrays.asList(correosStr.split(","));
        }

        return new Producto(
                entity.getIdProducto(),
                entity.getNombreProducto(),
                entity.getCategoria(),
                entity.getPrecioUsd(),
                correos
        );
    }
}