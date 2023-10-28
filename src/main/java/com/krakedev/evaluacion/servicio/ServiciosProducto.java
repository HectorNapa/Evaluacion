package com.krakedev.evaluacion.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;
import com.krakedev.evaluaciones.entidades.Producto;

public class ServiciosProducto {
	private static final Logger LOGGER = LogManager.getLogger(ServiciosProducto.class);

	public static void insertar(Producto producto) throws KrakeException {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("Producto a insetar>>>" + producto);
		try {
			// abrir conexion:
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("insert into producto (id, nombre,precio_venta,precio_compra,id_categoria)" 
			+ "values(?,?,?,?,?)");
			ps.setString(1, producto.getId());
			ps.setString(2, producto.getNombre());
			ps.setBigDecimal(3, producto.getPrecioVenta());
			ps.setBigDecimal(4, producto.getPrecioCompra());
			ps.setString(5, producto.getIdCategoria().getId());

			ps.executeUpdate();
		} catch (Exception e) {
			// logger el error
			LOGGER.error("Error al insertar", e);
			throw new KrakeException("Error al insertar");

		} finally {
			// cerrar conexion:
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de dato", e);
				throw new KrakeException("Error con la base de dato");
			}
		}
	}

	public static void actualizar(Producto producto) throws KrakeException {
		Connection coneccion = null;
		PreparedStatement ps = null;
		try {
			coneccion = ConexionBDD.conectar();
			ps = coneccion.prepareStatement("UPDATE producto SET nombre=?, precioVenta=?, precioCompra=?, IdCategoria=?  WHERE id=?");
			ps.setString(1, producto.getId());
			ps.setString(2, producto.getNombre());
			ps.setBigDecimal(3, producto.getPrecioVenta());
			ps.setBigDecimal(4, producto.getPrecioCompra());
			ps.setString(5, producto.getIdCategoria().getId());
			ps.executeUpdate();

		} catch (Exception e) {
			LOGGER.error("Error al insert", e);
			throw new KrakeException("Error al insertar");
		} finally {
			try {
				coneccion.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de dato", e);
				throw new KrakeException("Error con la base de dato");
			}
		}

	}

}
