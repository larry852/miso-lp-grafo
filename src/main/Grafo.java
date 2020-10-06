package main;

import main.impl.Nodo;

public interface Grafo {
	
	void addNodo(String nombre);
	
	void addArco(String origen, String destino, int peso) throws Exception;
	void addArco(Nodo nodoOrigen, Nodo nodoDestino, int peso);
	
	void addArco(String origen, String destino);
	void addArco(Nodo nodoOrigen, Nodo nodoDestino);
	
	Nodo buscarNodo(String nombre);

}
