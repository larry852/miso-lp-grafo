package main;

import java.util.List;

import main.fabrica.FabricaGrafo;
import main.interfaz.EstrategiaBusqueda;
import main.interfaz.Grafo;
import main.model.Nodo;

public class MainPeso {

	public static void main(String[] args) throws Exception {
		EstrategiaBusqueda estrategiaBusqueda = FabricaGrafo.obtenerEstrategiaBusqueda();

		try {

			Grafo g = FabricaGrafo.obtenerNuevoGrafo();

			g.addNodo("A");
			g.addNodo("B");
			g.addNodo("C");

			g.addArco("A", "B", 1);
			g.addArco("B", "C", 1);
			g.addArco("A", "C", 2);

			Nodo nodoA = g.buscarNodo("A");
			Nodo nodoC = g.buscarNodo("C");
			List<Nodo> camino = estrategiaBusqueda.buscarRuta(nodoA, nodoC);

			if (camino == null) {
				System.out.println("Camino A -> C no encontrado");
			} else {
				System.out.println("Camino A -> C encontrado");
				for (Nodo nodo : camino) {
					System.out.println(nodo.getNombre());
				}
			}
			System.out.println();

		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		try {

			Grafo g = FabricaGrafo.obtenerNuevoGrafo();

			g.addNodo("A");
			g.addNodo("B");
			g.addNodo("C");
			g.addNodo("D");
			g.addNodo("E");

			g.addArco("A", "B", 1);
			g.addArco("B", "C", 1);
			g.addArco("C", "D", 1);
			g.addArco("E", "D", 2);
			g.addArco("A", "C", 3);

			Nodo nodoA = g.buscarNodo("A");
			Nodo nodoE = g.buscarNodo("E");
			List<Nodo> camino = estrategiaBusqueda.buscarRuta(nodoA, nodoE);

			if (camino == null) {
				System.out.println("Camino A -> E no encontrado");
			} else {
				System.out.println("Camino A -> E encontrado");
				for (Nodo nodo : camino) {
					System.out.println(nodo.getNombre());
				}
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
