package main.fabrica;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracion {
	boolean normal;
	boolean dirigido;
	boolean dirigidoPeso;
	boolean dfs;
	boolean bfs;

	public Configuracion() {
		InputStream entrada = null;
		Properties opciones = new Properties();
		try {
			entrada = new FileInputStream("application.properties");
			opciones.load(entrada);
			this.normal = Boolean.valueOf(opciones.getProperty("normal"));
			this.dirigido = Boolean.valueOf(opciones.getProperty("dirigido"));
			this.dirigidoPeso = Boolean.valueOf(opciones.getProperty("dirigidoPeso"));
			this.dfs = Boolean.valueOf(opciones.getProperty("dfs"));
			this.bfs = Boolean.valueOf(opciones.getProperty("bfs"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public boolean isNormal() {
		return normal;
	}

	public void setNormal(boolean normal) {
		this.normal = normal;
	}

	public boolean isDirigido() {
		return dirigido;
	}

	public void setDirigido(boolean dirigido) {
		this.dirigido = dirigido;
	}

	public boolean isDirigidoPeso() {
		return dirigidoPeso;
	}

	public void setDirigidoPeso(boolean dirigidoPeso) {
		this.dirigidoPeso = dirigidoPeso;
	}

	public boolean isDfs() {
		return dfs;
	}

	public void setDfs(boolean dfs) {
		this.dfs = dfs;
	}

	public boolean isBfs() {
		return bfs;
	}

	public void setBfs(boolean bfs) {
		this.bfs = bfs;
	}

}
