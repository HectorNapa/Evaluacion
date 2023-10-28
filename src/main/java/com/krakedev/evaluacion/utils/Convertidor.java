package com.krakedev.evaluacion.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.excepciones.KrakeException;

public class Convertidor {
	private static final String FORMATO_FECHA= "yyyy/MM/dd";
	private static final String FORMATO_HORA= "hh:mm:ss";
	private static final String FORMATO_FECHA_COMPLETA= "dd/MM/yyyy hh:mm:ss";
	private static final Logger LOGGER= LogManager.getLogger(Convertidor.class);
	
	public static Date convertirFecha(String fechaStr) throws KrakeException {
		SimpleDateFormat sdf= new SimpleDateFormat(FORMATO_FECHA);
		Date fechaDate= null;
		try {
			LOGGER.trace("Convirtiendo fecha "+fechaStr);
			fechaDate =sdf.parse(fechaStr);
			LOGGER.trace("Fecha convertida "+fechaDate);
		} catch (ParseException e) {
			LOGGER.error("La fecha no tiene el formato correcto "+fechaStr,e);
			throw new KrakeException("La fecha no tiene el formato correcto ");
		}
		return fechaDate;
	}
	public static Date convertirHora(String horaStr) throws KrakeException {
		SimpleDateFormat sdf= new SimpleDateFormat(FORMATO_HORA);
		Date horaDate= null;
		try {
			horaDate =sdf.parse(horaStr);
		} catch (ParseException e) {
			LOGGER.error("La hora no tiene el formato correcto "+horaStr,e);
			throw new KrakeException("La hora no tiene el formato correcto ");
		}
		return horaDate;
	}
	//----------------------------------------------------------
	public static Date convertirFechaCompleta(String fechaCompletaStr) throws KrakeException {
		SimpleDateFormat sdf= new SimpleDateFormat(FORMATO_FECHA_COMPLETA);
		Date fechaCompleta= null;
		try {
			fechaCompleta =sdf.parse(fechaCompletaStr);
		} catch (ParseException e) {
			LOGGER.error("La hora no tiene el formato correcto "+fechaCompletaStr,e);
			throw new KrakeException("La hora no tiene el formato correcto ");
		}
		return fechaCompleta;
	}
}

