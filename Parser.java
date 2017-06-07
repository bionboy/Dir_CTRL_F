package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Parser {

	private Scanner dataParser;
	private String path, tag;
	private ArrayList<String> files, data;
	private File folder;

	Parser(String path, String tag) {
		// TODO add a conditional that lets the user get away w/wo a final "\"
		this.path = path + "\\";
		this.tag = tag;
		data = new ArrayList<String>();
	}

	void data() {
		int i = 0;
		folder = new File(path);
		files = new ArrayList<String>(Arrays.asList(folder.list()));

		while (i < files.size()) {
			try {
				dataParser = new Scanner(new File(path + files.get(i)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while (dataParser.hasNextLine()) {
				String line = dataParser.nextLine();
				if (line.contains(tag)) {
					data.add(line);
				}
			}
			i++;
		}
	}

	void print() {
		// for(String string : data){
		// System.out.println(string);
		// }
		data.forEach(System.out::println); // Optimized version of above code
	}

	public ArrayList<String> getFiles() {
		return files;
	}

	public ArrayList<String> getData() {
		return data;
	}

	public File getFolder() {
		return folder;
	}
}
