package Tech_Part;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Groupe {
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private final static String RESOURCES_PATH = "src/main/resources/";
	private final static String ELEVES_FILE_NAME = "eleves.txt";
	private final static char SEPARATOR = ';';

	File file = new File(RESOURCES_PATH + ELEVES_FILE_NAME);
	BufferedReader br = null;

	public ArrayList<Eleve> group = new ArrayList<Eleve>();
	String nomG = "inconnu";

	public Groupe(String nomG) {
		this.nomG = nomG;
	}

	public Groupe(ArrayList<Eleve> group, String nomG) {
		this.group = group;
		this.nomG = nomG;
	}

	public String getNomG() {
		return this.nomG;
	}

	public int getNumberStudent() {
		return group.size();
	}

	public void setNomG(String n) {
		this.nomG = n;
	}

	public void addStudent(Eleve e) {
		group.add(e);
	}

	public void removeStudent(Eleve n) {
		for (Eleve e : group) {
			if (e.getId() == n.getId()) {
				group.remove(e);
			}
		}
	}

	public Eleve getStudent(int id) {
		for (int i = 0; i < group.size(); i++) {
			if (group.get(i).getId() == id) {
				return group.get(i);
			}
		}
		return null;
	}

	public String toString() {
		return this.nomG + " : [" + getNumberStudent() + "]";
	}

	public void Save() {
		try {
			PrintStream l_out = new PrintStream(
					new FileOutputStream(file, true));
			for (Eleve e : group) {
				try {
					l_out.print(e.getId() + ";" + e.getName() + ";"
							+ e.getSurname() + ";" + e.arrayAbsToString() + ";" + e.arrayRetToString());
				} catch (java.lang.NullPointerException y) {
					l_out.print(e.getId() + ";" + e.getName() + ";"
							+ e.getSurname());
				}
			}
			l_out.flush();
			l_out.close();
			l_out = null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Load() {
		String nextLine = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException ex) {
		}
		try {
			while ((nextLine = br.readLine())!=null) {
				int size = nextLine.length();

				// ligne vide
				if (size == 0) {
					continue;
				}
				String debut = nextLine.trim();
				if (debut.length() == 0 && size == 1) {
					continue;
				}
				// ligne de commentaire
				if (debut.startsWith("#")) {
					continue;
				}
				String[] data = nextLine.split(";");
				final int id = Integer.parseInt(data[0]);
				final String prenom = data[1];
				final String nom = data[2];
				try {
					final String absS = data[3];

					ArrayList<Absence> absences = new ArrayList<Absence>();
					String temp = "";
					String temptemp = "";
					String temptemptemp = "";
					for (int i = 0; i < absS.length(); i++) {
						char a = absS.charAt(i);
						if (a != ',') {
							temp += a;
						} else {
							int z = 0;
							char b = a;
							while (b != '-') {
								b = temp.charAt(z);
								z++;
								temptemp += b;
							}
							z++;
							char c = a;
							while (c != ',') {
								c = temp.charAt(z);
								temptemptemp += c;
							}
						}
						Absence ab;
						try {
							ab = new Absence(formatter.parse(temptemp));
							absences.add(ab);
						} catch (java.text.ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					final String retT = data[3];

					ArrayList<Retard> retards = new ArrayList<Retard>();
					temp = "";
					temptemp = "";
					temptemptemp = "";
					for (int i = 0; i < retT.length(); i++) {
						char a = retT.charAt(i);
						if (a != ',') {
							temp += a;
						} else {
							int z = 0;
							char b = a;
							while (b != '-') {
								b = temp.charAt(z);
								z++;
								temptemp += b;
							}
							z++;
							char c = a;
							while (c != ',') {
								c = temp.charAt(z);
								temptemptemp += c;
							}
						}
						Retard re;
						try {
							re = new Retard(formatter.parse(temptemp));
							retards.add(re);
						} catch (java.text.ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					Eleve eleve = new Eleve(id, prenom, nom, absences, retards);
					this.group.add(eleve);
				} catch (java.lang.ArrayIndexOutOfBoundsException e) {
					Eleve eleve = new Eleve(id, prenom, nom);
					this.group.add(eleve);
				}
			
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
