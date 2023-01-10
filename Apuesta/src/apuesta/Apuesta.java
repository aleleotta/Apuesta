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

    /*Constructor por defecto*/
    /**
     * Constructor Apuesta por defecto
     */
    public Apuesta() {
    }

    /*Contructor con parametros*/
    /**
     * Constructor Apuesta con parametros
     * @param dinero_disp
     * @param goles_local
     * @param goles_visitante
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
     * @return
     */
    public int getDinero_disp() {
        return dinero_disp;
    }
    
    /*Metodo para modificar el valor del atributo dinero_disp.*/
    /**
     * Metodo para modificar el valor del atributo dinero_disp (Dinero disponible).
     * @param dinero_disp
     */
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /* Metodo para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible.
     */
    /**
     * Metodo para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible.
     * @param dinero
     * @throws Exception
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1�");
        }

        if (dinero > dinero_disp) {
            throw new Exception("No se puede apostar m�s de lo que tienes");
        }
        {
            dinero_disp = dinero - dinero_disp;
            apostado = dinero;
        }
    }
    
    /* Metodo que comprueba si se ha acertado el resultado del partido.
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles.
     */
    /**
     * Metodo que comprueba si se ha acertado el resultado del partido.
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles.
     * @param local
     * @param visitante
     * @return
     * @throws Exception
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (goles_local == local && goles_visitante == visitante) {
            acertado = true;
        }
        return acertado;
    }
    
    /* Metodo para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10 al saldo disponible.
     */
    /**
     * Metodo para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10 al saldo disponible.
     * @param cantidad_goles_local
     * @param cantidad_goles_visit
     * @throws Exception
     */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {
        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dinero_disp = dinero_disp * 10;
    }
}
