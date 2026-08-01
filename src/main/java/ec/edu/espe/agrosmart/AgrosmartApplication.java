package ec.edu.espe.agrosmart;

import ec.edu.espe.agrosmart.entity.ProductoEntity;
import ec.edu.espe.agrosmart.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;

@SpringBootApplication
public class AgrosmartApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgrosmartApplication.class, args);
    }

    @Bean
    CommandLineRunner sembrarProductos(ProductoRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                
                // VÁLIDOS (precio > 0 y con correos)
                ProductoEntity p1 = new ProductoEntity();
                p1.setNombreProducto("Quinua blanca premium");
                p1.setPrecioUsd(new BigDecimal("12.50"));
                p1.setStockKg(150);
                p1.setCategoria("Quinua");
                p1.setCorreosNotificacion("ventas@agrosmart.ec");
                repository.save(p1);

                ProductoEntity p2 = new ProductoEntity();
                p2.setNombreProducto("Quinua roja andina");
                p2.setPrecioUsd(new BigDecimal("14.00"));
                p2.setStockKg(100);
                p2.setCategoria("Quinua");
                p2.setCorreosNotificacion("pedidos@agrosmart.ec");
                repository.save(p2);

                ProductoEntity p3 = new ProductoEntity();
                p3.setNombreProducto("Quinua negra orgánica");
                p3.setPrecioUsd(new BigDecimal("15.00"));
                p3.setStockKg(80);
                p3.setCategoria("Quinua");
                p3.setCorreosNotificacion("ventas@agrosmart.ec,info@agrosmart.ec");
                repository.save(p3);                

                // INVÁLIDO: precio = 0
                ProductoEntity p4 = new ProductoEntity();
                p4.setNombreProducto("Quinua tricolor");
                p4.setPrecioUsd(BigDecimal.ZERO);
                p4.setStockKg(50);
                p4.setCategoria("Quinua");
                p4.setCorreosNotificacion("ventas@agrosmart.ec");
                repository.save(p4);                

                // INVÁLIDO: sin correos
                ProductoEntity p5 = new ProductoEntity();
                p5.setNombreProducto("Quinua básica");
                p5.setPrecioUsd(new BigDecimal("5.00"));
                p5.setStockKg(200);
                p5.setCategoria("Quinua");
                p5.setCorreosNotificacion("");
                repository.save(p5);
            }
        };
    }
}