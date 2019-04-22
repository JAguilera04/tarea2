
package Pedido;
import polera.Polera;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//juan aguilera
// se crea el Array y un arreglo lo primero
public class Pedido {
    String [] extraerLinea;
    ArrayList<Polera> Pedido = new ArrayList<Polera>();
    /*
    metodo pedido que hara la funcion de llamar a los otros metodos
    */
    public Pedido(String ubicacionTexto, String textoParaAgregar){
        int numeroDeLineas = numeroLinea(ubicacionTexto);
        leerLineas(ubicacionTexto, numeroDeLineas);
        crearPedido(numeroDeLineas);
        mostrarPedido();
        lineaAgregada(ubicacionTexto, textoParaAgregar);
    }
    /*
    metodo numerolinea lee el numero de lineas del testo
    */
    public int numeroLinea(String direccionTexto){
        int numeroLinea = 0;
        try{
            FileReader fr = new FileReader(direccionTexto);
            BufferedReader bf = new BufferedReader(fr);
            while (bf.readLine()!=null) {
                numeroLinea++;
            }
            return numeroLinea - 1;
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
            return -1;
        }catch(IOException e){
            return -1;
        }
    }
    /*
    metodo crearpedido usando las lineas leidas anteriormente agega cada linea al Array
    y usa el metodo separarlinea para no contar las ","
    */
    public void crearPedido(int numeroLinea){
        for (int i = 0; i < numeroLinea; i++){
            this.Pedido.add(new Polera(separarLinea(i)[0], separarLinea(i)[1], Boolean.parseBoolean(separarLinea(i)[2])));
        }
    }
    /*
    metodo separarlinea para no contar las "," y usa el metodo leer lineas para agregarlo al arreglo creedo
    */
    public String[] separarLinea(int posicion){
        try{
             return extraerLinea[posicion].split(",");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
            String [] vacio = {" ", " ", " "};
            return vacio;
        }
    }
    /*
    metodo leerLineas lee las lineas del texto y la ingresa a un arreglo
    */
    public boolean leerLineas(String direccionTexto, int numeroLinea){
        try{
            extraerLinea = new String[numeroLinea];
            File file = new File (direccionTexto);
            if (file.exists() && numeroLinea >= 0){
                FileReader fl = new FileReader(direccionTexto);
                BufferedReader br = new BufferedReader(fl);  
                while(br.readLine() != null){
                    for(int i = 0; i < numeroLinea; i++){
                        extraerLinea[i] = br.readLine();
                    }
                }
                return true;
            }
            else{
                return false;
            }
        }catch(FileNotFoundException e){
            return false;
        }
        catch(IOException e){
            return false;
        }
    }
    /*
    metodo lineaAgregada agrega la ultima linea que se pide en el archivo
    */
    public boolean lineaAgregada (String direccionTexto, String textoParaAgregar){
       try{
        File file = new File(direccionTexto);
        if(file.exists()){
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(textoParaAgregar);
            bw.close();
            fw.close();
            return true;
        }
        else{
            return false;
        }
        }catch(IOException e){
            return false;
        }
    }
    /*
    metodo mostrarPedido muestra el pedido
    */
    public void mostrarPedido(){
        for(int i = 0; i < this.Pedido.size(); i++){
            System.out.println("Polera "+(i+1)+":" );
            System.out.println("Material: "+this.Pedido.get(i).getMaterial());
            System.out.println("Talla: "+this.Pedido.get(i).getTalla());
            System.out.println(this.Pedido.get(i).isEstampado());
            System.out.println();
        }
    }
    
    
    
}

