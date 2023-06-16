package simonedesignPatterns;

import java.util.ArrayList;
import java.util.List;

import simonedesignPatterns.centroDiControllo.CentroControllo;
import simonedesignPatterns.comunicazioni.ComunicazioneProxy;
import simonedesignPatterns.comunicazioni.ComunicazioneProxyFactory;
import simonedesignPatterns.sonda.Sonda;
import simonedesignPatterns.sonda.SondaFactory;

public class U2D11DesignPatternsApplication {
	public static void main(String[] args) {
		// Creazione delle sonde
		Sonda sonda1 = SondaFactory.creaSonda("Sonda1", 40.7128, -74.0060, 3);
		Sonda sonda2 = SondaFactory.creaSonda("Sonda2", 38.9072, -77.0369, 6);
		Sonda sonda3 = SondaFactory.creaSonda("Sonda3", 37.7749, -122.4194, 7);
		Sonda sonda4 = SondaFactory.creaSonda("Sonda4", 51.5074, -0.1278, 4);

		// Creazione dei proxy per i centri di controllo
		ComunicazioneProxy proxyCentroControllo1 = ComunicazioneProxyFactory
				.creaComunicazioneProxy("centrocontrollo1.com");
		ComunicazioneProxy proxyCentroControllo2 = ComunicazioneProxyFactory
				.creaComunicazioneProxy("centrocontrollo2.com");
		ComunicazioneProxy proxyCentroControllo3 = ComunicazioneProxyFactory
				.creaComunicazioneProxy("centrocontrollo3.com");

		// Creazione dei centri di controllo
		CentroControllo centroControllo1 = new CentroControllo(proxyCentroControllo1);
		CentroControllo centroControllo2 = new CentroControllo(proxyCentroControllo2);
		CentroControllo centroControllo3 = new CentroControllo(proxyCentroControllo3);

		// Aggiunta dei proxy alla lista degli osservatori delle sonde
		sonda1.aggiungiOsservatore(centroControllo1);
		sonda2.aggiungiOsservatore(centroControllo1);
		sonda2.aggiungiOsservatore(centroControllo2);
		sonda3.aggiungiOsservatore(centroControllo3);
		sonda4.aggiungiOsservatore(centroControllo3);

		// Creazione della lista di centri di controllo per ogni sonda
		List<List<ComunicazioneProxy>> proxyCentriControllo = new ArrayList<>();
		proxyCentriControllo.add(List.of(proxyCentroControllo1));
		proxyCentriControllo.add(List.of(proxyCentroControllo1, proxyCentroControllo2));
		proxyCentriControllo.add(List.of(proxyCentroControllo3));
		proxyCentriControllo.add(List.of(proxyCentroControllo3));

		// Invio degli allarmi tramite i relativi proxy dei centri di controllo per ogni
		// sonda
		List<Sonda> sonde = List.of(sonda1, sonda2, sonda3, sonda4);
		for (int i = 0; i < sonde.size(); i++) {
			Sonda sonda = sonde.get(i);
			List<ComunicazioneProxy> proxyCentroControllo = proxyCentriControllo.get(i);

			sonda.notificaIncendio();
			for (ComunicazioneProxy proxy : proxyCentroControllo) {
				proxy.inviaAllarme(sonda);
			}
		}
	}
}
