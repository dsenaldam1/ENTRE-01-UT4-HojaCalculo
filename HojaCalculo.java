
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author David Sena   
 *  
 */
public class HojaCalculo
{
    private String nombre;
    private Fila fila1;
    private Fila fila2;
    private Fila fila3;

    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre)    {
        this.nombre = nombre;
        this.fila1 = null;
        this.fila2 = null;
        this.fila3 = null;

    }

    /**
     * accesor para el nombre de la hoja
     */
    public String getNombre() {
        return this.nombre;

    }

    /**
     * accesor para la fila1
     */
    public Fila getFila1() {
        return this.fila1;

    }

    /**
     * accesor para la fila2
     */
    public Fila getFila2() {
        return this.fila2;

    }

    /**
     * accesor para la fila3
     */
    public Fila getFila3() {
        return this.fila3;

    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int num = 0;
        if(fila1!= null){
             num ++;
        }
        if(fila2 != null){
            num ++;
        }
        if (fila3 != null){
            num ++;
        }
        return num;
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if (getNumeroFilas() == 3){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if(hojaCompleta() == true){
            System.out.println(fila.getId() + " no se puede añadir en " + this.nombre);
        }
        else{
            if(fila1 == null){
                fila1 = fila;
            }
            else if(fila2 == null){
                fila2 = fila;
            }
            else if (fila3 == null){
                fila3 = fila;
            }
        }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila fila = new Fila(id, fecha, ingresos, gastos);
        if(fila1 == null){
                fila1 = fila;
            }
            else if(fila2 == null){
                fila2 = fila;
            }
            else if (fila3 == null){
                fila3 = fila;
            }
            else{
                System.out.println(fila.getId() + " no se puede añadir en " + this.nombre);
            }
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        return fila1.getIngresos() + fila2.getIngresos() + fila3.getIngresos();  
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        return fila1.getGastos() + fila2.getGastos() + fila3.getGastos();
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        return getTotalIngresos() - getTotalGastos();
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String str = "";
        str += String.format("%8", this.nombre +"\n");
        str+= String.format ("%24s %16s %16s %16s\n" + "FECHA" + "INGRESOS" + "GASTOS" + "BENEFICIOS");
        if(getNumeroFilas() == 1){
            str += fila1.toString() + "\n";
        }
        if(getNumeroFilas() == 2){
            str +=  fila1.toString() + "\n" + fila2.toString() + "\n";
        }
        if(getNumeroFilas() ==3){
             str += fila1.toString() + "\n" + fila2.toString() + "\n" + fila3.toString() + "\n";
        }
        
        return  String.format ("%24s%15.2f€%15.2f€%15.2f€\n", "", getTotalIngresos(), getTotalGastos(), getBeneficio());
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo duplicacion = new HojaCalculo ("Duplicada " + this.nombre);
        duplicacion.addFila(fila1);
        duplicacion.addFila(fila2);
        duplicacion.addFila(fila3);
        return duplicacion;
    }

}
