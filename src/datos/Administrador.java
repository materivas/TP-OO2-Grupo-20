package datos;

<<<<<<< HEAD
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import datos.Persona;
>>>>>>> branch 'main' of https://github.com/materivas/TP-OO2-Grupo-20.git



public class Administrador extends Persona {
   
    private String user;
    private String password;
    private Rol rol;

    
    
    // Getters y Setters

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
