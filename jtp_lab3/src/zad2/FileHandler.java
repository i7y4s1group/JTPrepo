package zad2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	String path = "C:\\tmp\\";
	String filename;
	String log = "log.txt"; 
	String nl = "\r\n";
	
	public FileHandler(String file) {
		filename = file;
	}


	public void setLog(String log) {
		this.log = log;
	}


	public void scanning() throws IOException, NoFile{
		File toDelete = new File(path+filename);
		File toLog = new File(path + log);
		if (toDelete.exists()) {
			if (!toLog.exists()) {
				toLog.createNewFile();
			}
			FileWriter fw = new FileWriter(toLog, true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(path + filename + nl);
	        bw.close();
	        toDelete.delete();
		}		
		else {
			throw new NoFile("There was no file named " + filename + " in " + path);
		}
	}
	
}
