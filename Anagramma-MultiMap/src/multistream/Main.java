package multistream;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import util.FileIO;
import util.StringUtil;

public class Main {

	public static void main(String[] args) {
		new Main().run();

	}

	private void run() {

		String fileName = "res/szavak.txt";

		List<String> words = new FileIO().readFromFile(fileName);

		
//		Solution-1 
//		Map<String, Set<String>> setOf = getMultiMapSet(words);
//		printIfSet(setOf, 3);
		
//		Solution-2		
		Map<String, Set<String>> setOf1 = getMultiMapTreeSet(words);
		printIfSet2(setOf1, 3);

	}

	private void printIfSet(Map<String, Set<String>> sameLetters, int n) {
		System.out.println("\nprintIfSet\n");

		sameLetters.entrySet().parallelStream()
					.filter(e -> e.getValue().size() > n)
					.map(e -> getsortedEntry(e))
					.sorted(new EntryComparator())
					.collect(Collectors.toList())
					.forEach(System.out::println);

	}
	
	private void printIfSet2(Map<String, Set<String>> sameLetters, int n) {
		System.out.println("\nprintIfSet2\n");

		sameLetters.entrySet().parallelStream()
					.filter(e -> e.getValue().size() > n)
					.sorted(new EntryComparator())
					.collect(Collectors.toList())
					.forEach(System.out::println);

	}

	private Entry<String, Set<String>> getsortedEntry(Entry<String, Set<String>> e) {
		String key = e.getKey();
		Set<String> sorted = new TreeSet<String>(e.getValue());
		
		Entry<String, Set<String>> out = new AbstractMap.SimpleEntry<String, Set<String>>(key, sorted);
		return out;
	}

	private static Map<String, Set<String>> getMultiMapSet(List<String> list) {

		return list.parallelStream().distinct().collect(Collectors.groupingBy(s -> getAnagram(s), Collectors.toSet()));
	}

	private static String getAnagram(String in) {
		return StringUtil.sortChars(in);
	};
	
	private static Map<String, Set<String>> getMultiMapTreeSet(List<String> list) {

		return list.parallelStream()
				.distinct()
				.collect(Collectors.groupingBy(s -> getAnagram(s), Collectors.toCollection(TreeSet::new)));
	}

}
