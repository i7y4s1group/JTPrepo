import java.util.Random;

public class Generator {

    private final String[] Names = {"Tom", "Leopold", "Eustachy", "Franek" , "Antonio", "John", "Platon", "Barnaba", "Maciej", "Patryk", "Stanisław"};
    static private Random rand = new Random();
    private int iterator = 1;
    private int iterator2= 0;
    private String surnameSufiks = "abacki" ;

    public String[] getNames() {
        return Names;
    }

    public String generateName(){
        return Names[rand.nextInt(11)] ;
    }

    public String generateSurname(){
        String surname = surnameSufiks;
        for(int i= 0; i < iterator; i++){
            surname = (char)('A' + iterator2) + surname ;
        }
        iterator2 ++;
        if(iterator2 == 26){
            iterator++;
            iterator2=0;
        }
        return surname;

    }
}
