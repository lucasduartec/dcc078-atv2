public abstract class PedidoEstado {

    public abstract String getEstado();

    public boolean solicitar(Pedido pedido) {
        return false;
    }

    public boolean iniciarPreparacao(Pedido pedido) {
        return false;
    }

    public boolean iniciarEntrega(Pedido pedido) {
        return false;
    }

    public boolean entregar(Pedido pedido) {
        return false;
    }

    public boolean cancelar(Pedido pedido) {
        return false;
    }
}