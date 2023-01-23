import java.util.Scanner;

public class CaesarChiffre {

	public static void main(String[] args) {
		CaesarChiffre CaesarChiffre = new CaesarChiffre();
		Scanner scan = new Scanner(System.in);
		boolean close = false;
		String klartext = "";
		int shift = 0;
		String encrypted = "";
		
		while(close == false) {
			
			System.out.println("(1)Eingabe Klartext");
			System.out.println("(2)Eingabe Geheimtext");
			System.out.println("(3)Eingabe Verschiebung");
			System.out.println("(4)Verschlüsseln");
			System.out.println("(5)Entschlüsseln");
			System.out.println("(6)Entschlüsseln Durchlauf");
			System.out.println("(7)Ende");
			
			System.out.print("Auswahl: ");
			int eingabe = scan.nextInt();
			
			switch(eingabe) {
			
			case 1:
				System.out.println("Gebe den Klartext ein:  ");
				klartext = scan.nextLine();
				klartext += scan.nextLine();
				break;
			
			case 2:
				System.out.println("Gebe den Geheimtext ein:  ");
				encrypted = scan.nextLine();
				encrypted += scan.nextLine();
				break;
			
			case 3:
				System.out.println("Um wieviel verschieben?");
				shift = scan.nextInt();
				break;
			
			case 4:
				encrypted = CaesarChiffre.encrypt(klartext, shift);
				System.out.println(encrypted);
				break;
			
			case 5:
				klartext = CaesarChiffre.decrypt(encrypted, shift);
				System.out.println(klartext);
				break;
			
			case 6:
				CaesarChiffre.decryptDurchlauf(encrypted);
				break;
			
			case 7:
				close = true;
				break;
			
			default:
				System.out.println("Bitte Gültige Nummer eingeben");
			}
		}
	}
	
	public String encrypt(String klartext, int versatz) {
		String encrypted = "";
		char zeichenkette[] = new char[klartext.length()];
		char einzel = 'a';
		
		for (int i = 0; i < klartext.length(); i++) {
			einzel = klartext.charAt(i);
			einzel = (char) (einzel + versatz);
			zeichenkette[i] = einzel;
		}
		
		for (char zeichen : zeichenkette) {
			encrypted = encrypted + zeichen;
		}
		return encrypted;
	}
	
	public String decrypt(String encrypted, int versatz) {
		String encrypte = "";
		char zeichenkette[] = new char[encrypted.length()];
		char einzel = 'a';
		
		for (int i = 0; i < encrypted.length(); i++) {
			einzel = encrypted.charAt(i);
			einzel = (char) (einzel - versatz);
			zeichenkette[i] = einzel;
		}
		
		for (char zeichen : zeichenkette) {
			encrypte = encrypte + zeichen;
		}
		return encrypte;
	}
	
	public void decryptDurchlauf(String encrypted) {
		String encrypte = "";
		char zeichenkette[] = new char[encrypted.length()];
		char einzel = 'a';
		for (int x = 1; x < 26; x++) {
			encrypte = "";
			for (int i = 0; i < encrypted.length(); i++) {
				einzel = encrypted.charAt(i);
				if(einzel > 64 && einzel < 91) {
					einzel = (char) (einzel - x);
					if (!(einzel > 64 && einzel < 91)) {
						einzel += 26;
					}
				} else if (einzel > 96 && einzel < 123) {
					einzel = (char) (einzel - x);
					if (!(einzel > 96 && einzel < 123)) {
						einzel += 26;
					}
				}
				zeichenkette[i] = einzel;
			}
			
			for (char zeichen : zeichenkette) {
				encrypte = encrypte + zeichen;
			}
			System.out.println(encrypte);
		}
	}
}