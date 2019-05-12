package Zadanie1.files;

import Zadanie1.exceptions.MyFileException;
import Zadanie1.files.FileHandling;

//ZADANIE NA KOLOKWIUM
public class StrategyContext {
    private FileHandling typeOfTheStrategy;

    public StrategyContext(FileHandling typStrategii) {
        this.typeOfTheStrategy = typStrategii;
    }

    public void setTypeOfTheStrategy(FileHandling typeOfTheStrategy) {
        this.typeOfTheStrategy = typeOfTheStrategy;
    }

    public FileHandling getTypeOfTheStrategy() {
        return typeOfTheStrategy;
    }

    public void fileTransfer(){
        try {
            typeOfTheStrategy.fileTransfer();
        } catch (MyFileException e) {
            e.printStackTrace();
        }
    }

    public void fileProccesing(){
        typeOfTheStrategy.fileProccesing();
    }
}
