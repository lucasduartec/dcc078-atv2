public class PedidoEstadoEmEntrega extends PedidoEstado {

    private PedidoEstadoEmEntrega() {
    }
    ;
    private static PedidoEstadoEmEntrega instance = new PedidoEstadoEmEntrega();

    public static PedidoEstadoEmEntrega getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em entrega";
    }

    @Override
    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }

}