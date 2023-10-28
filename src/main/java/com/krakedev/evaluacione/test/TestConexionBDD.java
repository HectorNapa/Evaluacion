package com.krakedev.evaluacione.test;

import java.sql.Connection;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;

public class TestConexionBDD {

	public static void main(String[] args) {
		Connection conectar= null;
		try {
			conectar=ConexionBDD.conectar();
			System.out.println("conexion "+conectar);
		} catch (KrakeException e) {
			System.out.println("Error conexion "+e.getMessage());
		}

	}

}
