package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuario", nullable = false)
    private int idUsuario;
    @Basic
    @Column(name = "Nombre", nullable = true, length = 45)
    private String nombre;
    @Basic
    @Column(name = "Apellido", nullable = true, length = 45)
    private String apellido;
    @Basic
    @Column(name = "Apodo", nullable = true, length = 45)
    private String apodo;
    @Basic
    @Column(name = "Usuario", nullable = true, length = 45)
    private String usuario;
    @Basic
    @Column(name = "email", nullable = true, length = 45)
    private String email;
    @Basic
    @Column(name = "password", nullable = true, length = 45)
    private String password;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return idUsuario == usuario1.idUsuario && Objects.equals(nombre, usuario1.nombre) && Objects.equals(apellido, usuario1.apellido) && Objects.equals(apodo, usuario1.apodo) && Objects.equals(usuario, usuario1.usuario) && Objects.equals(email, usuario1.email) && Objects.equals(password, usuario1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombre, apellido, apodo, usuario, email, password);
    }
}
