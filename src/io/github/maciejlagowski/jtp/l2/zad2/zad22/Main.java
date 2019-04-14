package io.github.maciejlagowski.jtp.l2.zad2.zad22;

public class Main {
    public static void main(String[] args) {
        Thread fileSearcher = new FileSearcher("/home/maciek", "myFile.txt");
        fileSearcher.run();
    }
}
