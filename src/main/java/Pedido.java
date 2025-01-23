public class Pedido {

    private PedidoEstado estado;

    public Pedido() {
        this.estado = PedidoEstadoSolicitado.getInstance();
    }

    public void setEstado(PedidoEstado estado){
        this.estado = estado;
    }

    public PedidoEstado getEstado(){
        return estado;
    }

    public boolean solicitar() {
        return estado.solicitar(this);
    }

    public boolean iniciarPreparacao() {
        return estado.iniciarPreparacao(this);
    }

    public boolean iniciarEntrega() {
        return estado.iniciarEntrega(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }

    public boolean canelar() {
        return estado.cancelar(this);
    }

}