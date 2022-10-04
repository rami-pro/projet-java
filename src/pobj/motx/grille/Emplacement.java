package pobj.motx.grille;

import java.util.ArrayList;
import java.util.List;

public class Emplacement {
	private List<Case> lettres = new ArrayList<>();
	private EmplacementType type = EmplacementType.VID;

	public List<Case> getLettres() {
		return lettres;
	}

	public void setLettres(List<Case> lettres) {
		this.lettres = lettres;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(Case c: lettres) {
			builder.append(c.getChar());
		}
		
		return builder.toString();
	}
	
	public int size() {
		return lettres.size();
	}
	
	public Case getCase(int i) {
		return lettres.get(i);
	}
	
	public EmplacementType getType() {
		return this.type;
	}

	public void setType(EmplacementType type) {
		this.type = type;
	}
	
	public boolean add(Case c) {
		int size = lettres.size();
		
		if(type == EmplacementType.INC) {
			return false;
		}
		
		if(size == 0) {
			this.setType(EmplacementType.UNE);
			return lettres.add(c);
		}
		
		Case lastOfList = this.getCase(size - 1);
		
		if(c.getLig() == lastOfList.getLig() && c.getCol() == lastOfList.getCol() + 1) {
			this.setType(EmplacementType.HOR);
			
		} else if(c.getCol() == lastOfList.getCol() && c.getLig() == lastOfList.getLig() + 1){
			this.setType(EmplacementType.VER);
		} else {
			this.setType(EmplacementType.INC);
		}
		
		return lettres.add(c);
	}

}
