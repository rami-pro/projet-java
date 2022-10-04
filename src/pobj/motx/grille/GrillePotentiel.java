package pobj.motx.grille;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.mots.Dictionnaire;

public class GrillePotentiel {
	GrillePlaces grille;
	Dictionnaire dictComplet;
	private List<Dictionnaire> motsPot = new ArrayList<>();

	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}

	public void setMotsPot(List<Dictionnaire> motsPot) {
		this.motsPot = motsPot;
	}

	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grille = grille;
		this.dictComplet = dicoComplet;

		Dictionnaire dico = new Dictionnaire();
		int i = 0;
		for (Emplacement e : grille.getPlaces()) {
			dico = dicoComplet.copy();
			dico.filtreLongueur(e.size());
			i = 0;
			for (Case c : e.getLettres()) {
				if (!c.isVide())
					dico.filtreParLettre(c.getChar(), i);
				i++;
			}
			motsPot.add(dico);
		}
	}

	public GrillePotentiel fixer(int m , String soluce) {
		return new GrillePotentiel(grille.fixer(m, soluce), dictComplet);
	}
	
	public boolean isDead() {
		for (Dictionnaire d : motsPot) {
			if (d.size() == 0)
				return true;
		}
		return false;
	}
}
