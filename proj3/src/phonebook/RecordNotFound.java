package phonebook;

public class RecordNotFound extends RuntimeException{

    public RecordNotFound(String message){
        super(message);
    }

    public RecordNotFound() {

    }

}
