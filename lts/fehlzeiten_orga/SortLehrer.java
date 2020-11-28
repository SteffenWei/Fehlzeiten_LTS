package fehlzeiten_orga;

import java.util.Comparator;

public class SortLehrer implements Comparator<Lehrer> {
	@Override
	public int compare (Lehrer l1, Lehrer l2) {
		return l1.getKrzl().compareTo(l2.getKrzl()); 
	}

}
