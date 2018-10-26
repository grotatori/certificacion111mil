package centrocultural.controller;

import centrocultural.dao.CondicionHardCore;
import centrocultural.excepciones.ExistException;
import centrocultural.model.Profesor;
import centrocultural.model.Tematica;
import centrocultural.ui.JFInscripcion;
import centrocultural.ui.JFRegistro;

/**
 *
 * @author giselaRotatori
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFInscripcion fInscripcion = new JFInscripcion();
        fInscripcion.setVisible(true);
    }
    
}
