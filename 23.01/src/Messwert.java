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
		String forward = Messwert.Forward(werte);
		String backward = Messwert.Backward(werte);
		
		System.out.println("Maximum: " + max);
		System.out.println("Minimum: " + min);
		System.out.println("Mittelwert: " + mid);
		System.out.println("Summe: " + sum);
		System.out.println("Vorwärts: " + forward);
		System.out.println("Rückwärts: " + backward);
		
		
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
	
	public String Forward (int[] werte) {
		String forward = "";
		String[] strArray = new String[werte.length];
		
		for (int i = 0; i < werte.length; i++) {
			strArray[i] = String.valueOf(werte[i]);
		}
		
		for (String str : strArray) {
			forward = forward + " " + str;
		}
		
		return forward;
	}
	
	public String Backward (int[] werte) {
		String backward = "";
		
		String[] strArray = new String[werte.length];
		
		int j = 0;
		for (int i = werte.length; i > 0; i--) {
			strArray[i-1] = String.valueOf(werte[j]);
			j += 1;
		}
		
		for (String str : strArray) {
			backward = backward + " " + str;
		}
		return backward;	
	}
}