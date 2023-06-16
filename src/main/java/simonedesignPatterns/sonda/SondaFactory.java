package simonedesignPatterns.sonda;

public class SondaFactory {
	public static Sonda creaSonda(String idSonda, double latitude, double longitude, int smokeLevel) {
		return new Sonda(idSonda, latitude, longitude, smokeLevel);
	}
}