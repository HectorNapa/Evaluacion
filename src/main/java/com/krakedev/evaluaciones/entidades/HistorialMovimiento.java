package com.krakedev.evaluaciones.entidades;

import java.util.Date;

public class HistorialMovimiento {
	private int id;
	private Producto idProducto;
	private int cantidad;
	private Date fechaMovimiento;
	public HistorialMovimiento() {
		super();
	}
	public HistorialMovimiento(int id, Producto idProducto, int cantidad, Date fechaMovimiento) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.fechaMovimiento = fechaMovimiento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Producto getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	@Override
	public String toString() {
		return "HistorialMovimiento [id=" + id + ", idProducto=" + idProducto + ", cantidad=" + cantidad
				+ ", fechaMovimiento=" + fechaMovimiento + "]";
	}
	
}
