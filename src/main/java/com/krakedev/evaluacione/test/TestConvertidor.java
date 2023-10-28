package com.krakedev.evaluacione.test;

import java.sql.Time;
import java.util.Date;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.Convertidor;

public class TestConvertidor {

	public static void main(String[] args) {
		try {
			Date fechaCompleta= Convertidor.convertirFechaCompleta("23/01/2023 23:23:00");
			long fechaMilis= fechaCompleta.getTime();
			java.sql.Date fechaSQL= new java.sql.Date(fechaMilis);
			Time timeSQL= new Time(fechaMilis);
			System.out.println(fechaSQL+" "+timeSQL);
		} catch (KrakeException e) {
			System.out.println("Error del formato: "+e.getMessage());
		}
	}
}
