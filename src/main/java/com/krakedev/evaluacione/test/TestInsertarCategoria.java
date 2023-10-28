package com.krakedev.evaluacione.test;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicio.ServiciosCategoria;
import com.krakedev.evaluaciones.entidades.Categoria;

public class TestInsertarCategoria {

	public static void main(String[] args) {
		Categoria cater= new Categoria("COO9","Picaditas");
		try {
			ServiciosCategoria.insertar(cater);
		} catch (KrakeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
