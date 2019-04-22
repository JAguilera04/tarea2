/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Pedido.Pedido;
import java.io.IOException;
/**
 *
 * @author usuario
 */
public class testPedido {
    Pedido caso2;
    
    @Before
    
    public void setUp(){
        caso2 = new Pedido("C:\\Users\\usuario\\Downloads\\listado.csv", "algodon,XL,false");
    }
    
    @Test
    public void testNumeroLinea(){
        int resultadoObtenido = caso2.numeroLinea("bacio.txt");
        int resultadoEsperado = -1;
        assertEquals(resultadoEsperado,resultadoObtenido);
    }
    
    
    
    
    @Test
    public void testLeerLinea() throws IOException{
        boolean resultadoObtenido = caso2.leerLineas("bacio.txt",0);
        boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado,resultadoObtenido);
    }

    @Test
    public void testlineaAgregada(){
        boolean resultadoObtenido = caso2.lineaAgregada("noExisto.txt","Esto no se agregará xd");
        boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado,resultadoObtenido);
    }
    
    

}
