package Tech_Part;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Retard {
	SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	SimpleDateFormat h = new SimpleDateFormat("");
	Date d1 = new Date(0, 0, 0);

	Retard(Date date) {
		String s = date.toString();
		try {
			this.d1 = d.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Retard() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return this.d1.toString();
	}
}
