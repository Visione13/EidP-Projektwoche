package Kniffel;

public class Spielblock {
	private int[][] punkte;
	
	public Spielblock(int zeilen, int spalten) {
		punkte = new int[zeilen][spalten];
	}
	
	public int getZeilen() {
		int zeilen;
		zeilen = punkte.length;
		return zeilen;
	}
	
	public int getSpalten() {
		int spalte;
		spalte = punkte[0].length;
		return spalte;
	}
	
	public int getWert(int zeile, int spalte) {
		int wert;
		wert = punkte[zeile][spalte];
		return wert;
	}
	
	public int getSumme(int spiel) {
		int summe = 0;
		
		for(int i = 0; i < punkte.length; i++) {
			summe+= punkte[i][spiel-1];
		}
		return summe;
	}
	
	public void setWert(int zeile, int spalte, int wert) {
		this.punkte[zeile][spalte] = wert;
	}
	
	public void ausgebenBlock() {
		System.out.print("Einer       ");
		ausgabeWerte(1);
		System.out.print("\nZweier      ");
		ausgabeWerte(2);
		System.out.print("\nDreier      ");
		ausgabeWerte(3);
		System.out.print("\nVierer      ");
		ausgabeWerte(4);
		System.out.print("\nFünfer      ");
		ausgabeWerte(5);
		System.out.print("\nSechser     ");
		ausgabeWerte(6);
		System.out.print("\nBonus     ");
		ausgabeWerte(7);
	}
	
	public void ausgebenSpiel(int x) {
		int spiel = (x - 1);
		System.out.print("Einer       ");
		ausgabeSpiel(spiel, 1);
		System.out.print("\nZweier      ");
		ausgabeSpiel(spiel, 2);
		System.out.print("\nDreier      ");
		ausgabeSpiel(spiel, 3);
		System.out.print("\nVierer      ");
		ausgabeSpiel(spiel, 4);
		System.out.print("\nFünfer      ");
		ausgabeSpiel(spiel, 5);
		System.out.print("\nSechser     ");
		ausgabeSpiel(spiel, 6);
	}
	
	public void ausgabeWerte(int x) {
		for (int i=0; i < punkte[0].length; i++) {
			System.out.print(punkte[x-1][i]);
			System.out.print("     ");
		}
	}
	
	public void ausgabeSpiel(int spiel, int x) {
		System.out.print(punkte[x-1][spiel]);
		System.out.print("     ");
	}
}