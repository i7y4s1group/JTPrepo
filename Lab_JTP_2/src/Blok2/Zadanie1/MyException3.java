package Blok2.Zadanie1;

public class MyException3 extends Exception{
    private String message;

    public MyException3(String wiadomosc){
        this.message = wiadomosc;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
