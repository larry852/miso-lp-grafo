package main.estrategia.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import main.EstrategiaBusqueda;
import main.model.Nodo;

public class EstrategiaBusquedaDfs implements EstrategiaBusqueda {

	@Override
	public boolean existeRuta(Nodo nodoOrigen , Nodo nodoDestino) throws Exception {
		if (buscarRuta(nodoOrigen, nodoDestino) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Nodo> buscarRuta(Nodo nodoOrigen , Nodo nodoDestino) throws Exception {
		List<Nodo> nodosRuta = new ArrayList<>();

		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}

		if (buscarRutaDFS(nodosRuta, nodoOrigen, nodoDestino)) {
			return nodosRuta;
		} else {
			return null;
		}
	}

	private boolean buscarRutaDFS(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino) {

		// agrega el origen
		nodosRuta.add(nodoOrigen);

		// origen y destino son el mismo ?
		if (nodoOrigen.getNombre().equals(nodoDestino.getNombre())) {
			return true;
		}

		// si no son el mismo, revise las rutas usando una pila
		Stack<Nodo> pilaDeNodos = new Stack<>();
		ArrayList<Nodo> nodosVisitados = new ArrayList<>();

		pilaDeNodos.add(nodoOrigen);

		while (!pilaDeNodos.isEmpty()) {
			Nodo actual = pilaDeNodos.pop();

			// ignore los nodos ya visitados
			if (nodosVisitados.contains(actual))
				continue;

			// es el nodo que estamos buscando ?
			if (actual.equals(nodoDestino)) {
				nodosRuta.addAll(pilaDeNodos);
				nodosRuta.add(nodoDestino);
				return true;
			} else {
				// siga buscando en las rutas no visitadas
				nodosVisitados.add(actual);
				for (Nodo nodo : actual.getNodosAdyacentes()) {
					if (!pilaDeNodos.contains(nodo))
						pilaDeNodos.add(nodo);
				}
			}
		}
		return false;

	}

}
