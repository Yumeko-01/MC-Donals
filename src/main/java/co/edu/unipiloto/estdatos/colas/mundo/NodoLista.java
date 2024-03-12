/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.estdatos.colas.mundo;

/**
 *
 * @author medin
 */
public class NodoLista<E> {

    private E element;
    private NodoLista<E> next;
    private NodoLista<E> prev;

    public NodoLista(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public NodoLista<E> getNext() {
        return next;
    }

    public void setNext(NodoLista<E> next) {
        this.next = next;
    }

    public NodoLista<E> getPrev() {
        return prev;
    }

    public void setPrev(NodoLista<E> prev) {
        this.prev = prev;
    }
}
