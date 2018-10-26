package centrocultural.model;

/**
 *
 * @author giselaRotatori
 */
public class Condicion {
    private int id;
    private String condicion;
    
    //Constructores
    public Condicion(){}

    public Condicion(String condicion) {
        this.condicion = condicion;
    }

    public Condicion(int id, String condicion) {
        this.id = id;
        this.condicion = condicion;
    }
    
    //getters/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    
    
}
