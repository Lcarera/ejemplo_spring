package ar.edu.huergo.lcarera.ejemplo_spring.entity;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity // Indica que esta clase es una entidad JPA
@Table(name = "empleados") // Especifica el nombre de la tabla en la base de datos
public class Empleado {

    @Id // Indica que el campo es la clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el ID
    private Long id;
    private String nombre;

    // Constructor por defecto requerido por JPA
    public Empleado() {
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    //Decoradores de validación para el campo nombre
    // Estos decoradores se usan para validar los datos antes de guardarlos en la base de datos
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El nombre solo puede contener letras y espacios")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) { // Define como se comparan dos objetos de esta clase
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empleado other = (Empleado) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() { // Define como se calcula el hash de un objeto de esta clase
        return Objects.hash(id);
    }

    @Override
    public String toString() { // Define como se representa un objeto de esta clase como una cadena de caracteres
        return "Empleado [id=" + id + ", nombre=" + nombre + "]";
    }
}
