package co.edu.unipiloto.estdatos.colas.estructuras;

public class ItemCola<T> {
	
	private ItemCola<T> siguiente;
	private T valor;
	
	public ItemCola(T cont){
		valor = cont;
		siguiente = null;
	}

	public ItemCola<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(ItemCola<T> siguiente) {
		this.siguiente = siguiente;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}
	
	

}
