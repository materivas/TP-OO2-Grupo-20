package test;

import org.hibernate.Session;

import dao.HibernateUtil;

public class TestConexion {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("✅ Conexión exitosa con Hibernate y MySQL");
        } catch (Exception e) {
            System.err.println("❌ Error al conectar: " + e.getMessage());
        }
    }
}
