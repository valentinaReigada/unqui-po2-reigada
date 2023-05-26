
package ar.edu.unq.po2.tp3;
import java.util.*;


public class DesarmandoNumeros {
	
	public int nroConMayorCantidadDeParesEn_(List<Integer> listaDeNumeros) {
        int mayorCantidadDeParesHastaAhora = 0;
        for (int numero:listaDeNumeros) {
        	if (cantidadDeParesPorDigitoDeUnNumero(numero) > cantidadDeParesPorDigitoDeUnNumero(mayorCantidadDeParesHastaAhora)) {
                mayorCantidadDeParesHastaAhora = numero;
            }
        }
        return mayorCantidadDeParesHastaAhora;
    } 
	
     
    public int cantidadDeParesPorDigitoDeUnNumero(int numero) {
        // aca va la logica de desarmado
        Counter counter = new Counter();
        List<Integer> listadoDeNumeroSegmentado = this.numeroSegmentadoYEnFormatoLista(numero);
        counter.addListNumber(listadoDeNumeroSegmentado);
        return counter.cantidadDePares();
    }
    
    private List<Integer> numeroSegmentadoYEnFormatoLista(int numero) {
        List<Integer> listadoDeNumeroSegmentado = new ArrayList<Integer>();
        int numeroRestante = numero;
        int digitos = (int) (Math.log10(numero) + 1);
        for (int num=0; num<digitos;num++) {
            listadoDeNumeroSegmentado.add(numeroRestante%10);
            numeroRestante = numeroRestante/10; //El resto de esto es el primer digito. ESTO almacena los otros digitos
        }
        listadoDeNumeroSegmentado.add(numeroRestante%10);
            
        // 
        return listadoDeNumeroSegmentado;
    }

}