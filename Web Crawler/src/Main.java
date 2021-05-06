import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Main class will call the CrawlWikiService methods to crawl the wikipedia
 * pages.
 * 
 * @author Dheeraj
 *
 */
public class Main {

	/**
	 * Main class will call the CrawlWikiService methods to crawl the wikipedia pages.
	 * 
	 * @param args Command line arguments.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/**
		 * List of words
		 */
		List<String> startWordsList = new ArrayList<String>();
		startWordsList.add("India");
		startWordsList.add("father");

		CrawlWikiService.crawl(startWordsList);

		List<CrawlWiki> wordsReachedPhilosophy = CrawlWikiService.findWordsEndsWithPhilosophy();
		CrawlWikiService.printWordsReachedToPhilosophy(wordsReachedPhilosophy);
		CrawlWikiService.printAverageLength(wordsReachedPhilosophy);
		CrawlWikiService.printPercentageOfWordReachedToPhilosophy(startWordsList.size(), wordsReachedPhilosophy.size());
	}

}
