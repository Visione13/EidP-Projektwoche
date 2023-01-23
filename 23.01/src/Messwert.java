import java.util.Scanner;

public class Messwert {

	public static void main(String[] args) {
		Messwert Messwert = new Messwert();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Anzahl der Messwerte?");
		int anzahl = scan.nextInt();
		
		System.out.println("Messwerte Eingeben:");
		int[] werte = new int[anzahl];
		for (int i=0; i<anzahl; i++) {
			werte[i] = scan.nextInt();
		}
		
		int max = Messwert.Maximum(werte);
		int sum = Messwert.Summe(werte);
		int min = Messwert.Minimum(werte, sum);
		double mid = Messwert. Mittelwert(sum, anzahl);
		
		System.out.println("Maximum: " + max);
		System.out.println("Minimum: " + min);
		System.out.println("Mittelwert: " + mid);
		System.out.println("Summe: " + sum);
		
		scan.close();
	}
	
	public int Maximum(int[] werte) {
		int max = 0;
		
		for (int wert : werte) {
			if (wert > max) {
				max = wert;
			}
		}
		return max;
	 }

	public int Summe(int[] werte) {
		int sum = 0;
	
		for (int wert : werte) {
			sum = sum + wert;
		}
		return sum;
 }

	public int Minimum(int[] werte, int Summe) {
		int min = Summe;
	
		for (int wert : werte) {
			if (wert < min) {
				min = wert;
			}
		}
		return min;
 }
	
	public double Mittelwert(int summe, int anzahl) {
		double mittel = summe / anzahl;
		
		return mittel;
	 }
}