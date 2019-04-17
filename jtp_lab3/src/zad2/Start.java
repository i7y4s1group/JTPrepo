package zad2;

import java.io.IOException;

public class Start {

	public static void main(String[] args) throws InterruptedException {
		String file = "3.txt";
		FileHandler fh = new FileHandler(file);
		for (int i = 0; i < 3; i++) {
			try {
				fh.scanning();
				System.out.println("I've deleted " + file);
			}catch (NoFile e) {
				e.printStackTrace();
				System.out.println("I will wait 60 seconds and scan again");
				e.fileWait();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
