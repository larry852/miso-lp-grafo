package main;

import main.impl.EstrategiaBusquedaBfs;
import main.impl.EstrategiaBusquedaDfs;
import main.impl.GrafoDirigido;
import main.impl.GrafoDirigidoConPeso;
import main.impl.GrafoNormal;

public class FabricaGrafo {
	public static Grafo obtenerNuevoGrafo() {
		boolean normal = true;
		boolean dirigido = false;
		boolean dirigidoPeso = false;

		if (normal) {
			return new GrafoNormal();
		} else if (dirigido) {
			return new GrafoDirigido();
		} else if (dirigidoPeso) {
			return new GrafoDirigidoConPeso();
		}
		
		return null;
	}
	
	public static EstrategiaBusqueda obtenerEstrategiaBusqueda() {
		boolean dfs = true;
		boolean bfs = false;

		if (dfs) {
			return new EstrategiaBusquedaDfs();
		} else if (bfs) {
			return new EstrategiaBusquedaBfs();
		}
		
		return null;
	}
}
