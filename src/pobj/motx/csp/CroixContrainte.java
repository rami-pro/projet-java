package pobj.motx.csp;

import pobj.csp.IContrainte;
import pobj.motx.grille.GrillePotentiel;
import pobj.motx.mots.Dictionnaire;

public class CroixContrainte implements IContrainte {
	private int m1, c1, m2, c2;

	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
	}

	public int reduce(GrillePotentiel grille) {
		int i = 0;

		Dictionnaire dic1 = grille.getMotsPot().get(m1);
		Dictionnaire dic2 = grille.getMotsPot().get(m2);

		EnsembleLettre en1 = dic1.lettresPosition(c2);
		EnsembleLettre en2 = dic2.lettresPosition(c2);

		EnsembleLettre inter = en1.intersection(en2);

		if (en1.size() > inter.size())
			i += dic1.filtreParLettres(inter, c1);
		if (en2.size() > inter.size())
			i += dic2.filtreParLettres(inter, c2);

		return i;
	}
}
