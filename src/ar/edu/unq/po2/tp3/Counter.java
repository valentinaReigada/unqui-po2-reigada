package ar.edu.unq.po2.tp3;
import java.util.ArrayList;
import java.util.List;


public class Counter {
	
	private List<Integer> listNumeros = new ArrayList<Integer>();
	
	//La cantidad de pares
	public int cantidadDePares() {
		return (int) listNumeros.stream().filter(num -> this.esPar(num)).count();
	}
	
	public Boolean esPar(int num) {
		return num%2 == 0;
	};
	
	
	//La cantidad de impares
	public int cantidadDeImpares() {
		return (int) listNumeros.stream().filter(num -> !this.esPar(num)).count();
	}
	//La cantidad de multiplos de un cierto numero
	
	public int cantidadDeMultiplosDeNumeroHasta(int num, int maximo) {
		int cantidad = 0;
		for (int i=1; i <= maximo; i++) {
			if (i%num == 0) {
				cantidad++;
			}
		}
		return cantidad;
	};
	
	public void addNumber(int numero) {
		this.listNumeros.add(numero);
	}
    public void addListNumber(List<Integer> listaDeNumeros) {
        
        for (int numero:listaDeNumeros) {
            this.addNumber(numero);
        }
    }
	
	
	

}