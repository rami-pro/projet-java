package pobj.motx.grille.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pobj.motx.grille.Grille;
import pobj.motx.grille.GrilleLoader;
import pobj.motx.grille.GrillePlaces;
import pobj.motx.grille.GrillePotentiel;
import pobj.motx.mots.Dictionnaire;
import pobj.motx.test.TestWithDataDir;

public class GrillePotentielTest2 extends TestWithDataDir {

	@Test
	public void testEasy2() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire(path_data_dir+"/frwords.txt");
		// grille 6x5, mots sans croisement
		Grille gr = GrilleLoader.loadGrille(path_data_dir+"/easy2.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());

		// System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);

		assertTrue(!gp.isDead());

		int[] expected = { 245, 302, 1 };

		GrillePotentielTest.testNombrePot(gp, expected);

	}

}
