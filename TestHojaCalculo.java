
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author David Sena 
 *  
 */
public class TestHojaCalculo
{

    /**
     * Constructor  
     */
    public TestHojaCalculo()    {

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podrá guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1() {    
        HojaCalculo prueba1 = new HojaCalculo("HOJA1");          
        prueba1.addFila(new Fila("Fila1",new Fecha(4, 10,2020),25.50,132));  
        prueba1.addFila(new Fila("Fila2",new Fecha(5,10,2020),300,350));    
        prueba1.addFila(new Fila("Fila3"));        
        prueba1.addFila(new Fila("Fila4"));              
        HojaCalculo copia = prueba1.duplicarHoja();        
        System.out.println(prueba1.toString());        
        System.out.println(copia.toString());     

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
        HojaCalculo prueba2 = new HojaCalculo("HOJA2");          
        prueba2.addFila(new Fila("Fila1",new Fecha(7, 10,2020),260,125));  
        prueba2.addFila(new Fila("Fila2",new Fecha(8,10,2020),125,245));                  
        HojaCalculo copia = prueba2.duplicarHoja();        
        System.out.println(prueba2.toString());        
        System.out.println(copia.toString());  

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
         HojaCalculo prueba3 = new HojaCalculo("HOJA3");          
        prueba3.addFila(new Fila("Fila1",new Fecha(4, 10,2020),25.50,132));       
        HojaCalculo copia = prueba3.duplicarHoja();        
        System.out.println(prueba3.toString());        
        System.out.println(copia.toString());     

    }

}
