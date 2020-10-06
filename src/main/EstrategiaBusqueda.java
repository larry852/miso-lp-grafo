package main;

import java.util.List;

import main.impl.Nodo;

public interface EstrategiaBusqueda {
	List<Nodo> buscarRuta(Nodo nodoOrigen, Nodo nodoDestino) throws Exception;
	boolean existeRuta(Nodo nodoOrigen, Nodo nodoDestino) throws Exception;
}
