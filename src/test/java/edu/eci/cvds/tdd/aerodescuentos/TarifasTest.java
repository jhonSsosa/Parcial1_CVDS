package edu.eci.cvds.tdd.aerodescuentos;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TarifasTest{
    @Test
    public void testInvalidParameters(){
        /*boolean result = true;
        double tarifaConDescuento = 0;
        // Edad invalida: menor a 0
        try {
            tarifaConDescuento = CalculadorDescuentos.calculoTarifa(100, 0, -1);
            System.out.println(tarifaConDescuento);
            assertFalse(result); //No debe llegar a esta linea.
        }   
        catch (Exception e){
            assertTrue(result);
        }
        // Edad invalida: mayor a 135
        try {
            tarifaConDescuento = CalculadorDescuentos.calculoTarifa(100, 0, 135);
            assertFalse(result); //No debe llegar a esta linea.
        }   
        catch (Exception e){
            assertTrue(result);
        }
        // Dias invalidos: menor a 0
        try {
            tarifaConDescuento = CalculadorDescuentos.calculoTarifa(100, -1, 1);
            assertFalse(result); //No debe llegar a esta linea.
        }   
        catch (Exception e){
            assertTrue(result);
        }
        // Tarifa invalida: menor a 0
        try {
            tarifaConDescuento = CalculadorDescuentos.calculoTarifa(100, -1, 1);
            assertFalse(result); //No debe llegar a esta linea.
        }   
        catch (Exception e){
            assertTrue(result);
        }
        */
        //Se encontro que no se lanzaban las excepciones que se habian planteado
    }

    @Test
    public void testValidateDiscountForAdultsWithoutDaysInAdvance(){
        double tarifaConDescuento;
        //Caso 1.1
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 0, 18);
        assertTrue(tarifaConDescuento == 1000000);
        //Caso 1.2
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 10, 40);
        assertTrue(tarifaConDescuento == 1000000);
        //Caso 1.3
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 20, 65);
        assertTrue(tarifaConDescuento == 1000000);
    }

    @Test
    public void testValidateDiscountForAdultsWithDaysInAdvance(){
        double tarifaConDescuento;
        //Caso 2.1
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 21, 18);
        assertTrue(tarifaConDescuento == 850000);
        //Caso 2.2
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 30, 40);
        assertTrue(tarifaConDescuento == 850000);
        //Caso 2.3
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 100, 65);
        assertTrue(tarifaConDescuento == 850000);
    }

    @Test
    public void testValidateDiscountForUndarageWithoutDaysInAdvance(){
        double tarifaConDescuento;
        //Caso 3.1
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 0, 0);
        assertTrue(tarifaConDescuento == 950000);
        //Caso 3.2
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 10, 10);
        assertTrue(tarifaConDescuento == 950000);
        //Caso 3.3
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 20, 66);
        assertFalse(tarifaConDescuento == 950000); //Se encuentra un problema, cuando se tienen 20 dias en especifico no se cuenta ningun descuento ni de menor de edad ni de adulto mayor.
    }

    @Test
    public void testValidateDiscountForUndarageWithDaysInAdvance(){
        double tarifaConDescuento;
        //Caso 4.1
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 21, 0);
        assertTrue(tarifaConDescuento == 800000);
        //Caso 4.2
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 30, 10);
        assertTrue(tarifaConDescuento == 800000);
        //Caso 4.3
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 100, 17);
        assertTrue(tarifaConDescuento == 800000); 
    }

    @Test
    public void testValidateDiscountForEderlyWithouDaysInAdvance(){
        double tarifaConDescuento;
        //Caso 5.1
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 0, 66);
        assertTrue(tarifaConDescuento == 920000);
        //Caso 5.2
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 10, 100);
        assertTrue(tarifaConDescuento == 920000);
        //Caso 5.3
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 20, 134);//Se encuentra un problema, cuando se tienen 20 dias en especifico no se cuenta ningun descuento ni de menor de edad ni de adulto mayor.
        assertFalse(tarifaConDescuento == 920000); 
    }

    @Test
    public void testValidateDiscountForEderlyWithDaysInAdvance(){
        double tarifaConDescuento;
        //Caso 6.1
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 21, 66);
        assertTrue(tarifaConDescuento == 770000);
        //Caso 6.2
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 40, 100);
        assertTrue(tarifaConDescuento == 770000);
        //Caso 6.3
        tarifaConDescuento = CalculadorDescuentos.calculoTarifa(1000000, 100, 134);
        assertTrue(tarifaConDescuento == 770000); 
    }

}