public class MyException2 extends Exception {
    private String message;

    public MyException2(String message) {
        this.message = message ;
    }
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
