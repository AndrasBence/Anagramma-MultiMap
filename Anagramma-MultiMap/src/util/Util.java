package util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Util {

	private Util() {
	}

	public static <K, V> void printMap(Map<K, V> map) {
		map.forEach((key, value) -> System.out.println(key + " = " + value));
	}

	public static <E> void printSet(Set<E> set) {
		set.forEach(System.out::println);
	}

	public static void printException(Exception e) {
		System.out.print(e.getClass() + ": ");
		System.out.println(e.getMessage() + "\n");
		System.out.println();
		// e.printStackTrace();
	}

	public static <E> Comparator<E> getComparatorChain(List<Comparator<E>> cList) {

		if (cList.size() == 0)
			return null;
		
		Comparator<E> out;
		Iterator<Comparator<E>> iterator = cList.listIterator(); 

		out = iterator.next();
		while (iterator.hasNext()){
			out = out.thenComparing(iterator.next());
		}
		return out;
	}

}