package centrocultural.excepciones;

/**
 *
 * @author giselaRotatori
 */
public class ExistException extends Exception{
    private String message;
    
    public ExistException(String mens){
        this.message = mens;
    }
    
    @Override
    public String getMessage(){
        return this.message;
    }
}
