public class RelogioDigital {
    private int hora = 12;
    private int minuto = 20;

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void tick(){
        minuto++;
        if(minuto > 59){
            hora++;
            minuto = 0;
        }
        if (hora > 23) {
            hora = 00;
        }
    }
}
