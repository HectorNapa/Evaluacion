package com.krakedev.evaluacion.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;
import com.krakedev.evaluaciones.entidades.Categoria;

public class ServiciosCategoria {
	private static final Logger LOGGER= LogManager.getLogger(ServiciosCategoria.class);

	public static void insertar(Categoria categoria) throws KrakeException{
		Connection con=null;
		PreparedStatement ps= null;
		LOGGER.trace("Categoria a insetar>>>"+categoria );
		try {
			//abrir conexion:
			 con= ConexionBDD.conectar();
			ps= con.prepareStatement("insert into categorias(id, nombre)"
					+ "values(?,?)");
			ps.setString(1,categoria.getId());
			ps.setString(2,categoria.getNombre());
			
			ps.executeUpdate();
		}catch(Exception e){
			//logger el error
			LOGGER.error("Error al insertar",e);
			throw new KrakeException("Error al insertar");
			
		}finally {
			//cerrar conexion:
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de dato",e);
				throw new KrakeException("Error con la base de dato");
			}
		}
	}
	
	public static  void actualizar(Categoria categoria) throws KrakeException  {
		Connection coneccion= null;
		PreparedStatement ps= null;
		try {
			coneccion=ConexionBDD.conectar();
			ps=coneccion.prepareStatement("UPDATE categorias SET nombre=? WHERE id=?");
			ps.setString(1,categoria.getNombre());
			ps.setString(2,categoria.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			LOGGER.error("Error al insert",e);
			throw new KrakeException("Error al insertar");
		}finally {
			try {
				coneccion.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de dato",e);
				throw new KrakeException("Error con la base de dato");
			}
		}
	
	}
	
	
	
}