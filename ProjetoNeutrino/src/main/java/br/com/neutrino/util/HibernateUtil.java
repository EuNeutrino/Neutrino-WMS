package br.com.neutrino.util;

import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author David Nogueira
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml)
			// config file.
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Log the exception.
			System.err.println("MOSTRAR AQUI O ERRO>>" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Connection getConexao() {
		Session sessao = getSessionFactory().openSession();
		Connection conexao = sessao.doReturningWork(new ReturningWork<Connection>() {
			@Override
			public Connection execute(Connection conn) throws SQLException {
				return conn;
			}
		});
		return conexao;
	}
}
