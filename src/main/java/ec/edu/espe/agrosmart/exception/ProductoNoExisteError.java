package ec.edu.espe.agrosmart.exception;

public class ProductoNoExisteError extends RuntimeException {
    public ProductoNoExisteError(Long id) {
        super("Producto no encontrado con id: " + id);
    }
}
