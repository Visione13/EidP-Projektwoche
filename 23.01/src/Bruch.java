public class Bruch {

	private int zaehler;
	private int nenner;
	
	public Bruch(int zaehler, int nenner) {
		this.zaehler = zaehler;
		this.nenner = nenner;
	}
	
	public Bruch(int zaehler) {
		this.zaehler = zaehler;
		this.nenner = 1;
	}
	
	public static void main(String[] args) {

	}
	
	public int getZaehler() {
		int zaehler = this.zaehler;
		return zaehler;
	}
	
	public int getNenner() {
		int nenner = this.zaehler;
		return nenner;
	}
	
	public void multipliziere (int i) {
		this.nenner *= i;
	}
	
	public void multipliziereBruch(Bruch b) {
		this.nenner *= b.nenner;
		this.zaehler *= b.zaehler;
	}
	
	public void multipliziere(Bruch b) {
		this.nenner *=b.zaehler;
		this.zaehler *=b.nenner;
	}
	
	public String toString() {
		String zeichenBruch = this.zaehler + "/" + this.nenner;
		return zeichenBruch;
	}
	
	public static int ggt(int a, int b) {
		int z1, z2, r;
		
		if (a<b)
		{
			z2 = a ;
			z1 = b;
		} 
		else
		{
			z1 = a;
			z2 = b;
		}
		
		
		r = z1 % z2; 
		 		
		while (r!=0)
		{
			z1 = z2;
			z2 = r;
			r = z1 % z2;
			
		 }
		 
		 return z2;
	}
}