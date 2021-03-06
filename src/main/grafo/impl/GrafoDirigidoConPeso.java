package main.grafo.impl;

import java.util.ArrayList;
import java.util.List;

import main.interfaz.Grafo;
import main.model.Arco;
import main.model.Nodo;

public class GrafoDirigidoConPeso implements Grafo {

	List<Nodo> nodos = new ArrayList<>();
	List<Arco> arcos = new ArrayList<>();

	public GrafoDirigidoConPeso() {
	}

	@Override
	public void addNodo(String nombre) {
		Nodo nodo = new Nodo();
		nodo.setNombre(nombre);
		nodos.add(nodo);

	}

	@Override
	public void addArco(String origen, String destino, int peso) throws Exception {
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);

		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}

		addArco(nodoOrigen, nodoDestino, peso);

	}

	@Override
	public void addArco(Nodo nodoOrigen, Nodo nodoDestino, int peso) {
		Arco arco = new Arco();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arco.setPeso(peso);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
	}

	@Override
	public void addArco(Nodo nodoOrigen, Nodo nodoDestino) {
		throw new UnsupportedOperationException();

	}

	@Override
	public Nodo buscarNodo(String nombre) {
		for (Nodo nodo : nodos) {
			if (nodo.getNombre().equals(nombre)) {
				return nodo;
			}
		}
		return null;
	}

	@Override
	public void addArco(String origen, String destino) {
		throw new UnsupportedOperationException();

	}

}
