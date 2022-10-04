package pobj.motx.mots;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.csp.EnsembleLettre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionnaire {
	private List<String> mots;
	private EnsembleLettre[] cache = null;

	private Dictionnaire(List<String> mots) {
		this.mots = mots;
	}

	public Dictionnaire() {
		this.mots = new ArrayList<>();
	}

	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}

	public int size() {
		return mots.size();
	}

	public String get(int i) {
		return mots.get(i);
	}

	public Dictionnaire copy() {
		return new Dictionnaire(new ArrayList<>(mots));
	}

	public int filtreParLettre(char c, int i) {
		int sum = 0;
		List<String> moCopy = new ArrayList<>();

		for (int j = 0; j < mots.size(); j++) {
			if (mots.get(j).charAt(i) == c) {
				moCopy.add(mots.get(j));
				continue;
			}
			sum++;
		}

		this.mots = moCopy;

		return sum;
	}

	public int filtreParLettres(EnsembleLettre e, int i) {
		List<String> cible = new ArrayList<>();
		int cpt = 0;
		for (String mot : mots) {
			if (e.contains(mot.charAt(i)))
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		if (cpt > 0)
			this.cache = null;
		return cpt;
	}

	public int filtreLongueur(int len) {
		int sum = 0;
		List<String> moCopy = new ArrayList<>();

		for (int j = 0; j < mots.size(); j++) {
			if (mots.get(j).length() == len) {
				moCopy.add(mots.get(j));
				continue;
			}
			sum++;
		}

		this.mots = moCopy;

		return sum;
	}

	public EnsembleLettre lettresPosition(int index) {
		EnsembleLettre res = new EnsembleLettre();
		if (mots.isEmpty())
			return res;
		if (cache == null)
			cache = new EnsembleLettre[mots.get(0).length()];
		if (cache[index] == null) {
			for (String s : mots) {
				res.add(s.charAt(index));
			}
			cache[index] = res;
		}
		return cache[index];
	}

	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire dico = new Dictionnaire();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				dico.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dico;
	}

}