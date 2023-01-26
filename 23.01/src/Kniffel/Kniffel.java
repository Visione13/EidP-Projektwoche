package Kniffel;
import java.util.Scanner;

public class Kniffel {
	
	private int spalten = 3;
	private int zeilen = 7;
	private int spieleranzahl;
	private Spieler[] player;

	public static void main(String[] args) {
		Kniffel Kniffel = new Kniffel();
		Kniffel.start();
		Kniffel.createPlayer();
		Kniffel.gameStart();
	}
	
	public void start() {
		System.out.println("Willkommen Bei Kniffel");
		Scanner scan = new Scanner(System.in);
		System.out.println("Wieviele Spieler? (2-8) ");
		boolean ungültig = true;
		do {
			spieleranzahl = scan.nextInt();
			if(spieleranzahl > 1 && spieleranzahl < 9) {
				ungültig = false;
			}else {
				System.out.println("Bitte gültige anzahl eingeben");
			}
		}while(ungültig);
	}
	
	public void gameStart() {
		int spiel = 1;
		int runde = 1;
		int spieler = 1;
		while(spiel <= zeilen) {
			while(runde<=zeilen) {
				spieler = 1;
				while(spieler <= spieleranzahl) {
					System.out.println("\n");
					System.out.println("\nSpieler " +spieler + "   " + player[spieler-1].block.getSumme(spiel) + " Punkte");
					player[spieler-1].zugAusfuehren(spiel);
					player[spieler-1].block.setWert(5, spiel-1, 60);
					System.out.print(player[spieler-1].block.getSumme(spiel));
					player[spieler-1].block.ausgebenBlock();
					spieler++;
				}
				runde++;
			}
		spiel++;
		}
	}
	
	public void createPlayer() {
		player = new Spieler[spieleranzahl];
		for(int i = 0; i < spieleranzahl; i++) {
			player[i] = new KonsolenSpieler(new Spielblock(zeilen, spalten));
			i++;
			player[i] = new SpielerDumm(new Spielblock(zeilen, spalten));
		}
	}
}