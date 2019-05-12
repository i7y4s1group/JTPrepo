package Blok2.Zadanie1;

public class MyException2 extends Exception{
    private String message;

    public MyException2(String wiadomosc){
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
