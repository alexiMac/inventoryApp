package cursoAngular.inventarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //Definimos que es una clase de entidad
@Data //Para generar metodos set y get
@NoArgsConstructor //Se agrega un constructor vacio a la clase
@AllArgsConstructor //Agregamos un constructor con todos los argumentos
@ToString // Agregamos metodo to string
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProduct;

    String description;

    Double price;

    Integer existence;
}
