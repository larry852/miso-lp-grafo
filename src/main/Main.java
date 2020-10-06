package main;

import java.util.List;

import main.impl.Nodo;

public class Main {

	public static void main(String[] args) throws Exception {
		Grafo grafo = FabricaGrafo.obtenerNuevoGrafo();
		EstrategiaBusqueda estrategiaBusqueda = FabricaGrafo.obtenerEstrategiaBusqueda();
		
		grafo.addNodo("A");
		grafo.addNodo("B");
		grafo.addNodo("C");
		
		grafo.addArco("A", "B");
		grafo.addArco("B", "C");
		grafo.addArco("A", "C");

		Nodo nodoA = grafo.buscarNodo("A");
		Nodo nodoC = grafo.buscarNodo("C");
		List<Nodo> camino = estrategiaBusqueda.buscarRuta(nodoA, nodoC);

		if (camino == null) {
			System.out.println("Camino A -> C no encontrado");
		} else {
			System.out.println("Camino A -> C encontrado");
			for (Nodo nodo: camino) {
				System.out.println(nodo.getNombre());
			}				
		}
		
		
	}

}
