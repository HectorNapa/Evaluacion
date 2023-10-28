package com.krakedev.evaluacione.test;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicio.ServiciosCategoria;
import com.krakedev.evaluaciones.entidades.Categoria;

public class TestActualizarCategoria {

	public static void main(String[] args) {
		Categoria cater= new Categoria("COO8","xxx");
		try {
			ServiciosCategoria.actualizar(cater);
		} catch (KrakeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


