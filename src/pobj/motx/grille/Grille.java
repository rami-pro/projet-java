package pobj.motx.grille;

public class Grille {
	private Case[][] m;
	
	public Grille(int hauteur, int largeur) {
		m = new Case[hauteur][largeur];
		for(int i = 0; i < hauteur; i ++) {
			for(int j = 0; j < largeur; j++) {
				m[i][j] = new Case(i, j, ' ');
			}
		}
	}
	
	public Grille(Case[][] n) {
		this.m = new Case[n.length][n[0].length];
		for(int i = 0; i < n.length; i ++) {
			for(int j = 0; j < n[0].length; j++) {
				this.m[i][j] = n[i][j].copy();
			}
		}
	}
	
	public Case getCase(int lig, int col) {
		return m[lig][col];
	}
	
	public String toString() {
		return GrilleLoader.serialize(this, false);
	}
	
	public int nbLig() {
		return m.length;
	}
	
	public int nbCol() {
		return m[0].length;
	}
	
	public Grille copy() {
		return new Grille(this.m);
	}
	
}
