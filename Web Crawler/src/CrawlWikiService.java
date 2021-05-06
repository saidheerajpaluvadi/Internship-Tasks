import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

/**
 * 
 * CrawlWikiService has methods to crawl the wikipedia pages. To print the
 * average length to reach the word Philososphy. To print the percentage of
 * starting words reached the philosophy.
 * 
 * @author Dheeraj
 *
 */
public class CrawlWikiService {

	public final static String WIKI_LINK = "https://en.wikipedia.org/wiki/";
	public static List<CrawlWiki> crawlWikiList = new ArrayList<CrawlWiki>();

	/**
	 * It will crawl the wikipedia pages for the given words.
	 * 
	 * @param startWordsList The list of starting words.
	 * @throws IOException
	 */
	public static void crawl(List<String> startWordsList) throws IOException {
		for (String startWord : startWordsList) {
			CrawlWiki crawlWiki = new CrawlWiki();
			crawlWiki.setStartWord(startWord);

			Document doc = Jsoup.connect(WIKI_LINK + startWord).get();

			/**
			 * Set is used to keep track of pages
			 */
			Set<String> wordsPath = new LinkedHashSet<String>();
			wordsPath.add(startWord);

			int count = 0;

			while (true) {
				String word = null;
				Elements paras = doc.select("p");

				for (Element para : paras) {
					boolean isValidLink = false;
					for (TextNode tn : para.select("a[href]").textNodes()) {
						if (isValidText(tn.toString())) {
							word = tn.toString();
							isValidLink = true;
							break;
						}
					}
					if (isValidLink == true)
						break;
				}
				if (count == 100 || word == null || !wordsPath.add(word) || word.equalsIgnoreCase("philosophy"))
					break;

				count++;
				crawlWiki.setEndWord(word);
				System.out.format("%2s\t %15s\t%15s\n", count, word, new Date());

				try {
					doc = Jsoup.connect(WIKI_LINK + word).get();
				} catch (Exception e) {
					System.out.println(e + "\n");
				}
			}
			crawlWiki.setLength(count);
			crawlWikiList.add(crawlWiki);
			System.out.println(wordsPath + "\n");

		}

	}

	/**
	 * Print the percentage of random words that reached the philosophy
	 * 
	 * @param allWordsSize               The number of random words taken.
	 * @param wordsReachedPhilosophySize The number of words that reached philosophy
	 */
	public static void printPercentageOfWordReachedToPhilosophy(int allWordsSize, int wordsReachedPhilosophySize) {
		System.out.print("\nPercentage of words reached: ");
		System.out.println(((wordsReachedPhilosophySize * 100) / allWordsSize) + " %");

	}

	/**
	 * Print the average length to reach the word philosophy.
	 * 
	 * @param wordsReachedPhilosophy The words which reached the philosophy.
	 */
	public static void printAverageLength(List<CrawlWiki> wordsReachedPhilosophy) {
		if (wordsReachedPhilosophy.size() == 0) {
			System.out.println("\nNo words found. Could not calculate average length...");
		} else {
			double res = 0.0;
			for (CrawlWiki cw : wordsReachedPhilosophy) {
				res += cw.getLength();
			}
			res = res / wordsReachedPhilosophy.size();
			System.out.println(res);
		}
	}

	/**
	 * To find which words reached philosophy out of set of random words.
	 * 
	 * @return list of words reached the philosophy.
	 */
	public static List<CrawlWiki> findWordsEndsWithPhilosophy() {
		List<CrawlWiki> wordsReachedPhilosophy = crawlWikiList.stream()
				.filter(x -> x.getEndWord().equalsIgnoreCase("philosophy")).collect(Collectors.toList());
		return wordsReachedPhilosophy;

	}

	/**
	 * Print the words that reached the philosophy.
	 * 
	 * @param wordsReachedPhilosophy The words which reached the philosophy.
	 */
	public static void printWordsReachedToPhilosophy(List<CrawlWiki> wordsReachedPhilosophy) {
		if (wordsReachedPhilosophy.size() == 0) {
			System.out.println("Sorry, could not find any that ends with philosophy...");
		} else
			wordsReachedPhilosophy.forEach(x -> System.out.println(x));
	}

	/**
	 * Performs validation on text to avoid certain links.
	 * 
	 * @param inputText Text to be examined.
	 * @return true if the text is valid.
	 */
	public static boolean isValidText(String inputText) {
		if (inputText.matches("\\[[0-9a-z]+\\]")) // Regular expression to avoid links like [a],[1],[2]
			return false;
		if (inputText.equals("/"))
			return false;
		if (inputText.equals("listen"))
			return false;

		return true;
	}

}
