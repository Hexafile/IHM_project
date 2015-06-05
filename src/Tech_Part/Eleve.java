package Tech_Part;

import java.util.ArrayList;

public class Eleve {

	private int id;
	private String name = "";
	private String surname = "";
	private ArrayList<Absence> absences = new ArrayList<Absence>();
	private ArrayList<Retard> retards = new ArrayList<Retard>();

	Eleve(String name, String surname, ArrayList<Absence> absences, ArrayList<Retard> retards) {
		this.id = (int) (Math.random() * 10000);
		this.name = name;
		this.surname = surname;
		this.absences = absences;
		this.retards = retards;
	}

	Eleve(int id, String name, String surname, ArrayList<Absence> absences, ArrayList<Retard> retards) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.absences = absences;
		this.retards = retards;
	}
	
	public ArrayList<Retard> getRetards() {
		return retards;
	}

	public void setRetards(ArrayList<Retard> retards) {
		this.retards = retards;
	}

	Eleve(int id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.absences = absences;
		this.retards = retards;
	}
	
	public Eleve(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public int getNumberAbsences() {
		return this.absences.size();
	}
	
	public int getNumberRetards() {
		return this.retards.size();
	}

	public String getSurname() {
		return this.surname;
	}

	public String getName() {
		return this.name;
	}

	public void addAbsence() {
		Absence a = new Absence();
		this.absences.add(a);
	}
	
	public void addRetard() {
		Retard r = new Retard();
		this.retards.add(r);
	}

	public void removeAbsence(Absence a) {
		for (Absence abs : this.absences) {
			if (abs.toString() == a.toString()) {
				this.absences.remove(abs);
			}
		}
	}

	public void removeRetard(Retard r) {
		for (Retard ret : this.retards) {
			if (ret.toString() == r.toString()) {
				this.absences.remove(ret);
			}
		}
	}
	
	public String getAbsences() {
		String getA = "";
		for (Absence a : this.absences) {
			getA = getA + a.toString() + ", ";
		}
		return getA;
	}

	public String toString() {
		return this.id + ";" + this.name + ";" + this.surname + ";"
				+ this.absences.toString();
	}

	public String absToString() {
		return this.name + " " + this.surname + " : [" + getNumberAbsences()
				+ ", " + getAbsences() + "]";
	}
	
	public String retToString() {
		return this.name + " " + this.surname + " : [" + getNumberRetards()
				+ ", " + getRetards() + "]";
	}

	public String arrayAbsToString() {
		String abs = "";
		if (!(getNumberAbsences()==0)) {
			for (Absence a : this.absences) {
				abs += a.toString() + ",";
			}
		}
		return abs;
	}
	
	public String arrayRetToString() {
		String ret = "";
		if (!(getNumberAbsences()==0)) {
			for (Retard r : this.retards) {
				ret += r.toString() + ",";
			}
		}
		return ret;
	}
}
