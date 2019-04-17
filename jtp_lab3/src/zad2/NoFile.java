package zad2;

import java.io.FileNotFoundException;

public class NoFile extends FileNotFoundException{
	
	public NoFile(String msg) {
		super(msg);
		
	};
	
	public void fileWait() throws InterruptedException {
		Thread.sleep(3000);
	}

}
