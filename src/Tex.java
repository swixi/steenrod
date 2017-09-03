import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

public class Tex {	
	static Charset utf8 = StandardCharsets.UTF_8;
	private static List<String> getHeader() {
		List<String> header = new ArrayList<String>();
		header.add("\\documentclass[12pt]{article}");
		header.add("\\usepackage{amsmath,amssymb,theorem}");
		header.add("\\topmargin -90pt \\oddsidemargin 0pt \\evensidemargin 0pt \\textwidth 6.5in \\textheight 10.25in");
		header.add("\\begin{document}");
		return header;
	}
	
	private static List<String> getCloser() {
		List<String> closer = new ArrayList<String>();
		closer.add("\\end{document}");
		return closer;
	}
	
	
	
	public static void writeToFile(List<String> input, String fileName) {
		try { 
			List<String> output = new ArrayList<String>();
			output.addAll(getHeader());
			output.addAll(input);
			output.addAll(getCloser());
			
			Files.write(Paths.get(fileName), output, utf8);
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
	}
}
