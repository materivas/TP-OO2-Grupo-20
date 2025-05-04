package negocio;

import java.util.List;
import dao.RolDao;
import datos.Rol;

public class RolABM {
    RolDao dao = new RolDao();

    
    public Rol traerRol(String nombre) {
        Rol r = dao.traerRol(nombre);
        // lanzar excepción si es null
        return r;
    }

    public int agregar(String nombreRol) {
        Rol r = new Rol();
        r.setNombreRol(nombreRol);
        return dao.agregar(r);
    }

    public void modificar(Rol r) {
        dao.actualizar(r);
    }

    public void eliminar(int idRol) {
        Rol r = dao.traerRol(idRol);
        if (r != null)
            dao.eliminar(r);
        // lanzar excepción si es null
    }

    public List<Rol> traerRoles() {
        return dao.traerRoles();
    }
}
