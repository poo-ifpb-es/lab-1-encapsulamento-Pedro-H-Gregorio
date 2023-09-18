import java.text.NumberFormat;
import java.util.Locale;

public class Circulo {
    private float raio;

    public Circulo(float raio){
        this.raio = raio;
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    public float getArea(){
        return Float.parseFloat(String.format(new Locale("pt-br"),"%.4f", (raio * raio *3.14159f)));
    }

    public float getCircunferencia(){
        return 2 * 3.14159f * raio;
    }

}
