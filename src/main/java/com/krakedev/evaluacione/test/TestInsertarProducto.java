package com.krakedev.evaluacione.test;

import java.math.BigDecimal;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicio.ServiciosProducto;
import com.krakedev.evaluaciones.entidades.Categoria;
import com.krakedev.evaluaciones.entidades.Producto;

public class TestInsertarProducto {
	public static void main(String[] args) {
		
		BigDecimal pv = new BigDecimal(50);
		BigDecimal pc = new BigDecimal(40);
		Categoria c = new Categoria("C001","");
		Producto cater= new Producto("COO9","Picaditas", pv ,pc  , c);
		try {
			ServiciosProducto.insertar(cater);
		} catch (KrakeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}
}
