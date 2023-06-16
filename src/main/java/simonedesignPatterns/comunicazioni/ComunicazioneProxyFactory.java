package simonedesignPatterns.comunicazioni;

public class ComunicazioneProxyFactory {
	public static ComunicazioneProxy creaComunicazioneProxy(String centroControlloUrl) {
		return new ComunicazioneProxy(centroControlloUrl);
	}
}