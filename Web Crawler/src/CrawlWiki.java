
public class CrawlWiki {

	private String startWord;
	private String endWord;
	private int length;

	public String getStartWord() {
		return startWord;
	}

	public void setStartWord(String startWord) {
		this.startWord = startWord;
	}

	public String getEndWord() {
		return endWord;
	}

	public void setEndWord(String endWord) {
		this.endWord = endWord;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "CrawlWiki [startWord=" + startWord + ", endWord=" + endWord + ", length=" + length + "]";
	}

}
