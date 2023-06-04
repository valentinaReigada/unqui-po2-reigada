package ar.edu.unq.po2.tp5;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class Caja implements Cobrable, Agencia{
	
	Map<Integer, Integer> stockProductos = new HashMap<>();
	double montoAPagar	=	0;
	
	public Caja(Map<Integer, Integer>stockProductos ) {
		this.stockProductos	=	stockProductos;
	}
	
	public double getMontoAPagar(){
		return this.montoAPagar;
	}
	
	public void inicializarMonto() {
		this.montoAPagar	= 0;
	}
	
	public void setMontoAPagar(double monto) {
		this.montoAPagar	+= monto;
	}
	
	public int stockDe(Producto producto) {
		return stockProductos.get(producto.getCodigo());
	}
	
	public void actualizarStockDe(Producto producto) {
		int stockActual = this.stockDe(producto);
		int stockActualizado = (stockActual > 1) ? stockActual -= 1 : 0;
		this.stockProductos.put(producto.codigo, stockActualizado);
	}
	
	public void registrarProducto(Producto producto) {
		this.setMontoAPagar(producto.getPrecio());
		this.actualizarStockDe(producto);
	}
	
	
	public void cobrarFactura(Factura factura) {
		setMontoAPagar(factura.montoAPagar());
		this.registrarPago(factura);
	}


	@Override
	public double cobrarProductos(ArrayList<Producto> productos) {
		this.inicializarMonto();
		productos.forEach(producto -> this.registrarProducto(producto));
		return this.montoAPagar;
		
	}
	
	@Override
	public double cobrarFacturas(ArrayList<Factura> facturas) {
		this.inicializarMonto();
		facturas.forEach(factura -> this.cobrarFactura(factura));
		return this.montoAPagar;
	}

	@Override
	public void registrarPago(Factura factura) {
		// TODO Auto-generated method stub
		
	}
	

}














