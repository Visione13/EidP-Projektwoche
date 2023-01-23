import java.util.Scanner;

public class Tilgung {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean weiter = true;
		do {
			Tilgung Tilgung = new Tilgung();
			
			double betrag = 0;
			double zinsrate = 0;
			double rate = 0;
			
			System.out.print("Darlehnsbetrag: ");
			betrag = scan.nextDouble();
			System.out.print("Jahreszinssatz: ");
			zinsrate = scan.nextDouble();
			zinsrate = zinsrate / 100;
			System.out.print("Anulitätsrate: ");
			rate = scan.nextDouble();
			
			Tilgung.graphic();
			Tilgung.rechner(betrag, zinsrate, rate);
			System.out.println("Noch einmal? Y/N");
			String choice = scan.next();
			if(choice == "N") {
				weiter = false;
			}
		}while(weiter);
		
		scan.close();
	}
	
	public void graphic() {
		System.out.println("Jahr        Zinsen        Tilgung        Restschulden");
		System.out.println("=====================================================");
	}
	
	public double zinsRechner(double betrag, double zinsrate) {
		double zinsen = 0;
		
		zinsen = betrag * zinsrate;
		zinsen = (double) Math.round(zinsen * 100) / 100;
		
		return zinsen;
	}
	
	public double tilgungsRechner(double rate, double zinsen) {
		double tilgung = 0;
		
		tilgung = rate - zinsen;
		tilgung = (double) Math.round(tilgung * 100) / 100;
		
		return tilgung;
	}
	
	public double restschuldenRechner(double betrag, double zinsen, double rate) {
		double restschulden = 0;
		
		restschulden = betrag - rate + zinsen;
		restschulden = (double) Math.round(restschulden * 100) / 100;
		return restschulden;
	}
	
	public void rechner (double betrag, double zinsrate, double rate) {
		double restschulden = betrag;
		double gesamtbetrag = betrag;
		double zinsen = zinsRechner(restschulden, zinsrate);
		if(zinsen> rate) {
			System.out.println("Kredit nicht abbezahlbar!");
		}else{
			int jahr = 1;
			do{
			zinsen = zinsRechner(restschulden, zinsrate);
			gesamtbetrag += zinsen;
			double tilgung = tilgungsRechner(rate, zinsen);
			restschulden = restschuldenRechner(restschulden, zinsen, rate);
			System.out.println(jahr+"          " + zinsen + "              " + tilgung + "           " + restschulden);
			jahr++;
			}while (restschulden>rate);
			
			System.out.println("Schlussrate: " + restschulden);
			System.out.println("Gesamtzahlung: " + gesamtbetrag);
			System.out.println("Anzahl der Raten: " + jahr);
		}
	}
}