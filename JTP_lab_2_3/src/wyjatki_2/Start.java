package wyjatki_2;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter file path: ");
        String filePath = scan.nextLine();

        System.out.println("Enter file name: ");
        String fileName = scan.nextLine();

        DirectoryScanner.scan(filePath, fileName);

    }
}
