package simonedesignPatterns.centroDiControllo;

import lombok.NoArgsConstructor;
import simonedesignPatterns.comunicazioni.ComunicazioneProxy;
import simonedesignPatterns.sonda.Sonda;

@NoArgsConstructor
public class CentroControllo {
	public CentroControllo(ComunicazioneProxy proxyCentroControllo) {

	}

	public void aggiorna(Sonda sonda) {
		System.out.println("Allarme incendio! Sonda " + sonda.getIdSonda() + " - Lat: " + sonda.getLatitude()
				+ ", Lon: " + sonda.getLongitude() + ", Smoke Level: " + sonda.getSmokeLevel());
	}
}
