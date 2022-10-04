package pobj.motx.csp;

import java.util.ArrayList;
import java.util.List;

/**
 * Un ensemble de lettre.
 */
public class EnsembleLettre {

  // stockage des caractères
  private List<Character> ensemble;

  /**
   * Constructeur d'EnsembleLettre
   * consistant en l'initialisation d'une ArrayList de caractère
   */
  public EnsembleLettre() {
    this.ensemble = new ArrayList<Character>();
  }

  /**
   * @param c
   * @return true si c appartient à ensemble, false sinon
   */
  public boolean contains(Character c) {
    return ensemble.contains(c);
  }

  /**
   * ajoute c à l'ensemble sans doublons
   *
   * @param c
   */
  public void add(Character c) {
    if (!contains(c)) {
      ensemble.add(c);
    }
  }

  /**
   * @param i
   * @return le caractère c à l'indice i
   */
  public Character getChar(int i) {
    return ensemble.get(i);
  }

  /**
   * @return int taille de l'ensemble
   */
  public int size() {
    return ensemble.size();
  }

  /**
   * @param e2
   * @return inter l'intersection mathématiques de deux ensemble e2 et l'ensemble
   *         courant
   */
  public EnsembleLettre intersection(EnsembleLettre e2) {
    /*
     * EnsembleLettre inter = new EnsembleLettre(); for (Character c : ensemble) {
     * if (e2.contains(c)) inter.add(c); } return inter;
     */
    EnsembleLettre res = this.copy();
    res.ensemble.retainAll(e2.ensemble);
    return res;
  }

  /**
   * retourne la copie de notre ensemble de lettre
   * @return la copie
   */
  private EnsembleLettre copy() {
    EnsembleLettre copie = new EnsembleLettre();
    copie.ensemble.addAll(ensemble);
    return copie;
  }
}
