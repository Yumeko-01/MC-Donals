/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.estdatos.colas.mundo;

import java.util.Iterator;

/**
 *
 * @author medin
 */
public class ListaDobleEncadenada<E> implements Iterable<E> {

    private NodoLista<E> first;
    private NodoLista<E> last;
    private int size;

    public ListaDobleEncadenada() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E element) {
        NodoLista<E> newNode = new NodoLista<>(element);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first.setPrev(newNode);
            first = newNode;
        }
        size++;
    }

    public void addLast(E element) {
        NodoLista<E> newNode = new NodoLista<>(element);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E element = first.getElement();
        first = first.getNext();
        if (first != null) {
            first.setPrev(null);
        } else {
            last = null;
        }
        size--;
        return element;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E element = last.getElement();
        last = last.getPrev();
        if (last != null) {
            last.setNext(null);
        } else {
            first = null;
        }
        size--;
        return element;
    }

    public E first() {
        return (isEmpty()) ? null : first.getElement();
    }

    public E last() {
        return (isEmpty()) ? null : last.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new ListaDobleEncadenadaIterator();
    }

    private class ListaDobleEncadenadaIterator implements Iterator<E> {

        private NodoLista<E> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                return null;
            }
            E element = current.getElement();
            current = current.getNext();
            return element;
        }
    }
}
