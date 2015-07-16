package org.hellscrum.db;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;
import org.hellscrum.bean.usuario;

public class Conexion {
	private SessionFactory session;
	private static Conexion instancia = null;
	private static Statistics estadisticas;
	
	public  void setInstancia(){
		this.instancia=null;
	}
	
	
	public Conexion() {
		try {
			session = new Configuration().configure().buildSessionFactory();
			estadisticas=session.getStatistics();
			estadisticas.setStatisticsEnabled(true);
			
			System.out.println("Configuracion finalizada");
		} catch (Throwable ex) {
			System.out.println("Mensaje de ERROR");
			ex.getMessage();
			System.out.println("Traza de error");
			ex.printStackTrace();
			System.out
					.println("Error al establecer conexion con motor de base de datos");
		}
	}
	
    /**
     * Cierra la sesion.
     */
    public void closeSession()throws HibernateException {
        try {
        	
            if (session.isClosed()==false | session.getCurrentSession().isOpen()) {
            	session.close();
            	session.getCurrentSession().close();
            }
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

	
	public Statistics getEstadisticas(){
		return this.estadisticas;
	}
	
	public synchronized static Conexion getInstancia() {
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}

	public Session getSession() {
		return session.getCurrentSession();
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Object> hacerConsulta(String consulta) {
		Session session = this.getSession();
		List <Object> listado=null;
		session.beginTransaction();
		listado=session.createQuery(consulta).list();
		session.getTransaction().commit();
		return listado;
		
	}

	public void modificar(Object obj) {
		Session session = this.getSession();
		session.beginTransaction();
		session.merge(obj);
		session.getTransaction().commit();
	}

	public void agregar(Object obj) {
		Session session = this.getSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
	}

	public Object Buscar(Class<?> classX, int ID) {
		Session session = this.getSession();
		session.beginTransaction();
		Object objeto=session.get(classX, ID);
		session.getTransaction().commit();
		return objeto;
	}

	public Object Buscar(Class<?> classX, String ID) {
		Session session = this.getSession();
		session.beginTransaction();
		Object objeto=session.get(classX, ID);
		session.getTransaction().commit();
		return objeto;
	}

	public void eliminar(Object obj) {
			Session session = getSession();
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
	}
	
	public usuario autenticarUsuario(String usr, String pass){
		usuario usuario=null;
		usuario=(usuario)this.hacerConsulta("From usuario u where u.nickname='"+usr+"' and u.contrasena='"+pass+"'").get(0);
		return usuario;
	}
	
	
}