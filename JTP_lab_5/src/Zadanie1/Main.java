package Zadanie1;

import Zadanie1.exceptions.MyFileException;
import Zadanie1.scanner.DirectoryScanner;

public class Main {
    //FilenameUtils
    //scrum -> metodologia do pracy w gru[ie, zasady solid
    //do 9 maja poprzednie do następnej niedzieli dzisiejsze zadanie
    //ma się wyświetlać info obrobiłem plik
    //wzorce regularne w javie - > poczytać
    //FileUtilities, metoda do znajdowania rozszerzenia, typy rozszerzeń w enumach przetrzymać
    //klasa csv{ metoda do przetworzenie, mtetoda do przeniesienia} i tak analogicznie
    //przetwarzanie -> metoda napisze przetwarzam plik --typu
    //przeniesienie -> ścieżka archiwalna do jednego z 3 folderów txt, xml, csv i komunikat
    //metoda musi sprawdzić czy foldery już są, czy są uprawnienia do ich stworzenia, jeśli nie to rzuca wyjątek
    //zawsze dodaje plik_25.05.2019:12:25.txt -> SimpleTimeFormatter
    //te metody ma mieć interfejs ma mieć metody przeniesienie, przetworzeniePliku
    //doczytać o strategii
    /*
    Zadanie1.files.StrategyContext{
    polet Interfejs typInterfejsu;

    ustawTypStrategii(Interfejs typStrategii){
      this.typInterfejsu = typSt
    }
     */
    public static void main(String[] args) {
        DirectoryScanner directoryScanner = new DirectoryScanner("D:\\WAT_PROGRAMY\\JTP_lab_5\\src\\Zadanie1\\SourceDirectory");

        try {
            directoryScanner.startFileProcessing();
        } catch (MyFileException e) {
            e.printStackTrace();
        }
    }
}
