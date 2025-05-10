package negocio;

import java.util.List;

import dao.AdministradorDao;
import datos.Administrador;
import datos.Rol;

public class AdministradorABM {
    AdministradorDao dao = new AdministradorDao();

    public Administrador traerAdministrador(String user) {
        Administrador a = dao.traerAdministrador(user);
        // lanzar excepción si es null
        return a;
    }

    public int agregar(String nombre, String apellido, int dni, String email, String user, String password, Rol rol) {
        Administrador a = new Administrador();
        a.setNombre(nombre);
        a.setApellido(apellido);
        a.setDni(dni);
        a.setEmail(email);
        a.setUser(user);
        a.setPassword(password);
        a.setRol(rol);
        return dao.agregar(a);
    }

    public void modificar(Administrador admin) {
        dao.actualizar(admin);
    }

    public void eliminar(String user) {
        Administrador admin = dao.traerAdministrador(user);
        if (admin != null) {
            dao.eliminar(admin);
        }
    }

    public List<Administrador> traerAdministradores() {
        return dao.traerAdministradores();
    }
}

