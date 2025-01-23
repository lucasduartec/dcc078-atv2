public class PedidoEstadoEmPreparacao extends PedidoEstado {

    private PedidoEstadoEmPreparacao() {
    }
    ;
    private static PedidoEstadoEmPreparacao instance = new PedidoEstadoEmPreparacao();

    public static PedidoEstadoEmPreparacao getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em preparação";
    }

    @Override
    public boolean iniciarEntrega(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmEntrega.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}