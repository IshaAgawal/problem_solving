import java.io.*;
import java.net.*;

public class JavaRegex {

	public static void main(String[] args) {
		// TODO code application logic here

		// https://cis.temple.edu/~jfiore/2017/spring/1068/assignments/08/files/jaws.txt
		String contents = getWebContents("https://cis.temple.edu/~jfiore/2017/spring/1068/assignments/08/files/jaws.txt");

		String mcontents = modify(contents);

		saveDoc(mcontents, "brody-crib-sheet.txt");

	}
private static String modify(String contents) {
	return contents
			.replaceAll("eer( |,|.)","eeyah$1")  // replacing word ending with (eer or eer, or eer.) to (eeyah or eeyah, or eeyah.)respectively 
			.replaceAll("ir( |,|.)","iyah$1") 	// replacing word ending with (ir or ir, or ir.) to iyah or iyah, or iyah.)respectively 
			.replaceAll("oor( |,|.)","oowah$1")	   // same as above
			.replaceAll(" very( |,|.)", " wicked$1")    // replacing very or very, or very. to respective value
			.replaceAll("([a|e|i|o|u])r", "$1h")   // 'r' following a vowel replace with h
			.replaceAll("([a-z|A-Z])a( |,|.)", "$1ar$2");  // word ending with a or a, or a. to ar or ar, or ar.
}

/* url is the address of a file on the web, e.g., http://www.espn.com
* If successful, the method returns the contents of the URL as a String.
* On failure, it returns null */
@SuppressWarnings("finally")
	public static String getWebContents(String url) {
		BufferedReader br = null;
		String result = null;
		try {
			URL toFetch = new URL(url);
			br = new BufferedReader(new InputStreamReader(toFetch.openStream()));
			StringBuilder ret = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				ret.append(line + '\n');
				line = br.readLine();
			}
			result = ret.toString();

		} catch (MalformedURLException ex) {
			ex.printStackTrace();
			System.err.println("Malformed URL: " + url);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.err.println("Error reading from URL: " + url);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
					System.err
							.println("Couldn't close connection to url properly: "
									+ url);
				}
			}
			return result;
		}
	}

	/*
	 * Saves the String contents into a file with name filename.
	 * 
	 * If the file did not previously exist, it is created. If the file with the
	 * same name existed previously, it is overwritten.
	 */
	public static void saveDoc(String contents, String filename) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(new File(filename)));
			pw.print(contents);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.err.println("Error writing to file: " + filename);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

}