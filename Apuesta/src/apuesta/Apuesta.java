package apuesta;

/**
 * Clase Apuesta con atributos
 * @author aleleotta
 *
 */
public class Apuesta {
	/**
	 * Dinero disponible (Tipo: entero)
	 */
    private int dinero_disp;
    /**
	 * Goles del equipo local (Tipo: entero)
	 */
    private int goles_local;
    /**
	 * Goles del equipo visitante (Tipo: entero)
	 */
    private int goles_visitante;
    /**
	 * Dinero apostado (Tipo: entero)
	 */
    private int apostado;

    /**
     * Constructor Apuesta por defecto
     */
    public Apuesta() { //Constructor por defecto.
    }

    /*Contructor con parametros*/
    /**
     * Constructor Apuesta con parametros
     * @param dinero_disp Dinero disponible
     * @param goles_local Goles del equipo local
     * @param goles_visitante Goles del equipo visitante
     */
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    
    /*Metodo para obtener el valor del atributo dinero_disp.*/
    /**
     * Metodo para obtener el valor del atributo dinero_disp (Dinero disponible).
     * @return Devuelve el dinero disponible.
     */
    public int getDinero_disp() {
        return dinero_disp;
    }
    
    /*Metodo para modificar el valor del atributo dinero_disp.*/
    /**
     * Metodo para modificar el valor del atributo dinero_disp (Dinero disponible).
     * @param dinero_disp Dinero disponible
     */
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /* Metodo para apostar.
     * Permite elegir la cantidad a apostar.
     */
    /**
     * Metodo para apostar.
     * Permite elegir la cantidad a apostar.
     * @param dinero Cantidad de dinero
     * @throws Exception Previene un error.
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1�");
        }

        if (dinero > dinero_disp) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            dinero_disp = dinero - dinero_disp;
            apostado = dinero;
        }
    }
    
    /* Metodo que comprueba si se ha acertado el resultado del partido.
     */
    /**
     * Metodo que comprueba si se ha acertado el resultado del partido.
     * 
     * @param local Equipo local
     * @param visitante Equipo visitante
     * @return Devuelve el valor boolean por si se ha acertado la comprobación.
     * @throws Exception Previene un error.
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if (local < 0 || visitante < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (goles_local == local && goles_visitante == visitante) {
            acertado = true;
        }
        return acertado;
    }
    
    /* Metodo para cobrar la apuesta.
     */
    /**
     * Metodo para cobrar la apuesta.
     * @param cantGolesLocal La cantidad de goles del equipo local.
     * @param cantGolesVisit La cantidad de goles del equipo visitante.
     * @throws Exception Previene un error.
     */
    void cobrar_apuesta(int cantGolesLocal, int cantGolesVisit) throws Exception {
        if (!comprobar_resultado(cantGolesLocal, cantGolesVisit)) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dinero_disp = dinero_disp * 10;
    }
}
