package Zadanie1.files;

import Zadanie1.exceptions.MyFileException;

public interface FileHandling {

    void fileProccesing();
    void fileTransfer() throws MyFileException;
}
