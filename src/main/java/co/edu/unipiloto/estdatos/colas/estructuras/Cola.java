package co.edu.unipiloto.estdatos.colas.estructuras;

import java.util.Iterator;

public class Cola<T> implements Iterable<T>{
	
	private ItemCola<T> primero;
	private ItemCola<T> ultimo;
	private int tamanio;
	
	public boolean estaVacio(){
		return tamanio==0;
	}
	
	public int tamanio(){
		return tamanio;
	}
	
	public void encolar(T valor){
		ItemCola<T> nuevo = new ItemCola<T>(valor);
		if(primero == null)
		{
			primero = ultimo = nuevo;
		}
		else{
			ultimo.setSiguiente(nuevo);
			ultimo = nuevo;
		}
		tamanio++;
	}
	
	public T desencolar(){
		if (estaVacio())
			return null;
		T ret = primero.getValor();
		primero = primero.getSiguiente();
		tamanio--;
		return ret;
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ColaIterator();
		
		
	}
	
	private class ColaIterator implements Iterator<T>{
		
		private ItemCola<T> actual = primero;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return actual!=null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T ret = actual.getValor();
			actual = actual.getSiguiente();
			return ret;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
