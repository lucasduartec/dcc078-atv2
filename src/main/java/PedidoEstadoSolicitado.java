public class PedidoEstadoSolicitado extends PedidoEstado {

    private PedidoEstadoSolicitado() {
    }
    ;
    private static PedidoEstadoSolicitado instance = new PedidoEstadoSolicitado();

    public static PedidoEstadoSolicitado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Solicitado";
    }

    @Override
    public boolean iniciarPreparacao(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}