package simonedesignPatterns.sonda;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import simonedesignPatterns.centroDiControllo.CentroControllo;

@Getter
@Setter

public class Sonda {
	private String idSonda;
	private double latitude;
	private double longitude;
	private int smokeLevel;
	private List<CentroControllo> observers;

	public Sonda(String idSonda, double latitude, double longitude, int smokeLevel) {
		this.idSonda = idSonda;
		this.latitude = latitude;
		this.longitude = longitude;
		this.smokeLevel = smokeLevel;
		this.observers = new ArrayList<>();
	}

	public void aggiungiOsservatore(CentroControllo centroControllo) {
		observers.add(centroControllo);
	}

	public void rimuoviOsservatore(CentroControllo observer) {
		observers.remove(observer);
	}

	public void notificaIncendio() {
		if (smokeLevel >= 5) {
			for (CentroControllo observer : observers) {
				observer.aggiorna(this);
			}
		}
	}

}
