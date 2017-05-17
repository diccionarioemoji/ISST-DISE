package es.upm.dit.isst.dise.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


@Entity
public class Puntuacion implements Serializable{
	@Index
	private int puntuacion;
	@Id
	private String usuario;
	
	public Puntuacion() {}
	
	public Puntuacion(String usuario) {
		super();
		this.puntuacion = 0;
		this.usuario = usuario;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Puntuacion [puntuacion=" + puntuacion + ", usuario=" + usuario + "]";
	}
	
	
	
}
