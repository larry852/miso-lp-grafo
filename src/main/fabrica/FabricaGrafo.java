package main.fabrica;

import main.estrategia.impl.EstrategiaBusquedaBfs;
import main.estrategia.impl.EstrategiaBusquedaDfs;
import main.grafo.impl.GrafoDirigido;
import main.grafo.impl.GrafoDirigidoConPeso;
import main.grafo.impl.GrafoNormal;
import main.interfaz.EstrategiaBusqueda;
import main.interfaz.Grafo;

public class FabricaGrafo {

	public static Grafo obtenerNuevoGrafo() {
		Configuracion configuracion = new Configuracion();

		if (configuracion.isNormal()) {
			return new GrafoNormal();
		} else if (configuracion.isDirigido()) {
			return new GrafoDirigido();
		} else if (configuracion.isDirigidoPeso()) {
			return new GrafoDirigidoConPeso();
		}

		return null;
	}

	public static EstrategiaBusqueda obtenerEstrategiaBusqueda() {
		Configuracion configuracion = new Configuracion();

		if (configuracion.isDfs()) {
			return new EstrategiaBusquedaDfs();
		} else if (configuracion.isBfs()) {
			return new EstrategiaBusquedaBfs();
		}

		return null;
	}
}
