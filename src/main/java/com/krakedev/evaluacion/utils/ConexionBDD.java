package com.krakedev.evaluacion.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.excepciones.KrakeException;

public class ConexionBDD {
	private final static String DRIVER="org.postgresql.Driver";
	private final static String URL="jdbc:postgresql://localhost:5432/postgres";
	private final static String USUARIO="postgres";
	private final static String CLAVE="postgres";
	private static final Logger LOGGER= LogManager.getLogger(ConexionBDD.class);
	//METODO:
	public static Connection conectar()throws KrakeException{
		System.out.println("entrando a conectar");
		
		Connection connection= null;
		try {
			Class.forName(DRIVER);
			LOGGER.debug("Obteniendo Conexion");
			connection= DriverManager.getConnection(URL,USUARIO,CLAVE);
			LOGGER.debug("Conexion exitosa");
		} catch (ClassNotFoundException e) {
			LOGGER.error("Error en la infraEstructura",e);
			throw new KrakeException("Error en la infraEstructura");
		} catch (SQLException e) {
			LOGGER.error("Error al conectar, revise usuario y clave",e);
			throw new KrakeException("Error al conectar, revise usuario y clave");
		}
		return connection;
	}
}
