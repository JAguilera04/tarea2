
package polera;
//Juan Aguilera
public class Polera{
    
    private String Talla;
    private String Material;
    private boolean Estampado;

    public Polera(String Talla, String Material, boolean Estampado) {
        this.Talla = Talla;
        this.Material = Material;
        this.Estampado = Estampado;
    }
    
    public String getTalla() {
        return Talla;
    }
    
    public String getMaterial() {
        return Material;
    }

    public boolean isEstampado() {
        return Estampado;
    }

    public void setTalla(String Talla) {
        this.Talla = Talla;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }
    

    public void setEstampado(boolean Estampado) {
        this.Estampado = Estampado;
    }

 
}
