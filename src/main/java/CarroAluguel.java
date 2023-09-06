public class CarroAluguel {
    private float valorPorKm;
    private int distanciaPercorrida = 0;

    private boolean disponivel = true;

    private boolean sinistro = false;
    public CarroAluguel(float valorPorKm){
        this.valorPorKm = valorPorKm;
    }

    public void setDistanciaPercorrida(int distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public void setValorPorKm(float valorPorKm) {
        this.valorPorKm = valorPorKm;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setSinistro(boolean sinistro) {
        this.sinistro = sinistro;
    }

    public float getValorPorKm() {
        return valorPorKm;
    }

    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public float getDebito(){
        return !sinistro? valorPorKm * distanciaPercorrida : (float) (0.60 * distanciaPercorrida * valorPorKm) + (distanciaPercorrida * valorPorKm);
    }

    public boolean hasSinistro(){
        return sinistro;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    void alugar() throws CarroIndisponivelException {
        if(disponivel){
            setDisponivel(false);
        }else{
            throw new CarroIndisponivelException();
        }
    }

    void devolver() throws CarroDisponivelException, CarroNaoPagoException {
        if(disponivel){
            throw new CarroDisponivelException();
        } else if (getDebito() != 0) {
            throw new CarroNaoPagoException();
        } else {
            setDisponivel(true);
            setDistanciaPercorrida(0);
            setSinistro(false);
        }
    }

    void pagar() throws CarroDisponivelException {
        if(disponivel){
            throw new CarroDisponivelException();
        }else {
            setDistanciaPercorrida(0);
        }
    }
}
