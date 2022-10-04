package pobj.motx.grille;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces {
	private Grille grille;
	private List<Emplacement> places = new ArrayList<>();
	private int nbHorizontal = 0;

	public GrillePlaces(Grille grille) {
		this.grille = grille;
		for (int i = 0; i < grille.nbLig(); i++) {
			cherchePlaces(getLig(i));
		}

		this.nbHorizontal = this.places.size();
		for (int j = 0; j < grille.nbCol(); j++) {
			cherchePlaces(getCol(j));
		}
	}

	public Grille getGrille() {
		return grille;
	}

	public List<Emplacement> getPlaces() {
		return new ArrayList<>(this.places);
	}

	public int getNbHorizontal() {
		return nbHorizontal;
	}

	private List<Case> getLig(int lig) {
		List<Case> l = new ArrayList<>();
		for (int i = 0; i < grille.nbCol(); i++) {
			l.add(grille.getCase(lig, i));
		}
		return l;
	}

	private List<Case> getCol(int col) {
		List<Case> l = new ArrayList<>();
		for (int i = 0; i < grille.nbLig(); i++) {
			l.add(grille.getCase(i, col));
		}
		return l;
	}

	private void cherchePlaces(List<Case> cases) {
		Emplacement emplacement = new Emplacement();

		for (Case c : cases) {
			if (c.isPleine()) {
				if (emplacement.size() > 1) {
					System.out.println(emplacement);
					places.add(emplacement);
				}
				emplacement = new Emplacement();
				continue;
			}

			emplacement.add(c);
		}
		if (emplacement.size() > 1) {
			System.out.println(emplacement);
			places.add(emplacement);
		}
	}

	public GrillePlaces fixer(int m, String soluce) {
		Grille g = grille.copy();
		int i = 0;
		for (Case c : places.get(m).getLettres()) {
			g.getCase(c.getLig(), c.getCol()).setChar(soluce.charAt(i));
			i++;
		}
		return new GrillePlaces(g);
	}
}
