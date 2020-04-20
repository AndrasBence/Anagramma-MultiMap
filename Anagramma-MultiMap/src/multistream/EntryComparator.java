package multistream;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;

public class EntryComparator implements Comparator<Entry<String, Set<String>>> {

	@Override
	public int compare(Entry<String, Set<String>> e1, Entry<String, Set<String>> e2) {
		if (e1.getKey().length() > e2.getKey().length()) {
			return 1;
		} else if (e1.getKey().length() < e2.getKey().length()) {
			return -1;
		} else {
			if (e1.getValue().size() < e2.getValue().size()) {
				return -1;
			} else if (e1.getValue().size() > e2.getValue().size()) {
				return 1;
			} else {
				return e1.getKey().compareTo(e2.getKey());
			}

		}

	}

}
