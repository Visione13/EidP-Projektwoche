package Kniffel;

import java.util.Scanner;

public abstract class Spieler {
	
	Spielblock block;
	int[]würfel = new int[5];
	boolean[]würfelBehalten = new boolean[5];
	
	public Spieler(Spielblock block) {
		this.block = block;
	}

	public Spielblock getBlock() {
		return block;
	}

	public void zugAusfuehren(int spiel) {
		int[] werte = new int[5];
		int zug = 1;
		Scanner scan = new Scanner(System.in);
		String auswahl;
		
		do {
			würfeln(zug);
			if(zug != 3) {
				System.out.println("Welche Würfel behalten?");
				boolean gültig = false;
				auswahl = scan.nextLine();
				int[] würfelauswahl = new int[auswahl.length()];
				String[] strAuswahl = auswahl.split("");
				for(int i = 0; i<strAuswahl.length; i++) {
					würfelauswahl[i] = Integer.valueOf(strAuswahl[i]);
				}
				if(Integer.valueOf(auswahl) != 0) {
					entscheideBehalten(würfelauswahl, würfelBehalten);
				}
			}else {
				auswahl = "";
				int[] würfelauswahl = new int[auswahl.length()];
				entscheideBehalten(würfelauswahl, würfelBehalten);
			}
			zug++;
		}while (zug!=4);
		System.out.println("\nWo Punkte eintragen?");
		block.ausgebenSpiel(spiel);
		entscheideFeld(würfel, spiel);
	}
	
	public void würfeln(int zug) {
		for(int i = 0; i < 5; i++) {
			if(würfelBehalten[i]!=true) {
				würfel[i] = (int)(Math.random() * 6) + 1;
			}else {
				würfelBehalten[i] = false;
			}
			System.out.println("Würfel " + (i+1) + ": " + würfel[i]);
		}
	}
	
	protected void entscheideBehalten(int[] werte, boolean[] behalten) {
		for (int i = 0; i < werte.length; i++) {
			int würfel = werte[i];
			würfelBehalten[(würfel-1)] = true;
		}
	}
	
	protected void entscheideFeld(int[] werte, int spiel) {
		Scanner scan = new Scanner(System.in);
		int wert = 0;
		System.out.println("\n");
		String eintragen = scan.nextLine();
		switch(eintragen) {
			case "Einer":
				for(int wertzahl : werte) {
					if(wertzahl == 1) {
						wert+=wertzahl;
					}
				}
				this.block.setWert(0, (spiel-1), wert);
				break;
			case "Zweier":
				for(int wertzahl : werte) {
					if(wertzahl == 2) {
						wert+=wertzahl;
					}
				}
				this.block.setWert(1, (spiel-1), wert);
				break;
			case "Dreier":
				for(int wertzahl : werte) {
					if(wertzahl == 3) {
						wert+=wertzahl;
					}
				}
				this.block.setWert(2, (spiel-1), wert);
				break;
			case "Vierer":
				for(int wertzahl : werte) {
					if(wertzahl == 4) {
						wert+=wertzahl;
					}
				}
				this.block.setWert(3, (spiel-1), wert);
				break;
			case "Fünfer":
				for(int wertzahl : werte) {
					if(wertzahl == 5) {
						wert+=wertzahl;
					}
				}
				this.block.setWert(4, (spiel-1), wert);
				break;
			case "Sechser":
				for(int wertzahl : werte) {
					if(wertzahl == 6) {
						wert+=wertzahl;
					}
				}
				this.block.setWert(5, (spiel-1), wert);
				break;
			default:
				System.out.print("Bitte gültige Stelle angeben");
				break;
		}
		System.out.println("\n");
	}
}