package Kniffel;

import java.util.Scanner;

public class SpielerDumm extends Spieler{

	public SpielerDumm(Spielblock block) {
		super(block);
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
				auswahl = "0";
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
	
	protected void entscheideFeld(int[] werte, int spiel) {
		Scanner scan = new Scanner(System.in);
		int wert = 0;
		System.out.println("\n");
		int eintragen = (int)(Math.random() * 6) + 1;
		switch(eintragen) {
			case 1:
				for(int wertzahl : werte) {
					if(wertzahl == 1) {
						wert+=wertzahl;
					}
				}
				this.block.setWert(0, (spiel-1), wert);
				break;
			case 2:
				for(int wertzahl : werte) {
					if(wertzahl == 2) {
						wert+=wertzahl;
					}
				}
				this.block.setWert(1, (spiel-1), wert);
				break;
			case 3:
				for(int wertzahl : werte) {
					if(wertzahl == 3) {
						wert+=wertzahl;
					}
				}
				this.block.setWert(2, (spiel-1), wert);
				break;
			case 4:
				for(int wertzahl : werte) {
					if(wertzahl == 4) {
						wert+=wertzahl;
					}
				}
				this.block.setWert(3, (spiel-1), wert);
				break;
			case 5:
				for(int wertzahl : werte) {
					if(wertzahl == 5) {
						wert+=wertzahl;
					}
				}
				this.block.setWert(4, (spiel-1), wert);
				break;
			case 6:
				for(int wertzahl : werte) {
					if(wertzahl == 6) {
						wert+=wertzahl;
					}
				}
				this.block.setWert(5, (spiel-1), wert);
				break;
			default:
				break;
		}
		System.out.println("\n");
	}
}