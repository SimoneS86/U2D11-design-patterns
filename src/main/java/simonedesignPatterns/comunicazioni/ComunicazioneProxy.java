package simonedesignPatterns.comunicazioni;

import simonedesignPatterns.sonda.Sonda;

public class ComunicazioneProxy {
	private String centroControlloUrl;

	public ComunicazioneProxy(String centroControlloUrl) {
		this.centroControlloUrl = centroControlloUrl;
	}

	public void inviaAllarme(Sonda sonda) {
		if (sonda.getSmokeLevel() >= 5) {
			String url = creaUrl(sonda);
			System.out.println("Invio allarme: " + url);
		}
	}

	private String creaUrl(Sonda sonda) {
		return "http://" + centroControlloUrl + "/alarm?idsonda=" + sonda.getIdSonda() + "&lat=" + sonda.getLatitude()
				+ "&lon=" + sonda.getLongitude() + "&smokelevel=" + sonda.getSmokeLevel();
	}
}
