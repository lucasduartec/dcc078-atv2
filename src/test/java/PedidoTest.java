import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
    }

    // Estado: Solicitado

    @Test
    public void deveIniciarPreparacaoPedidoSolicitado() {
        pedido.setEstado(PedidoEstadoSolicitado.getInstance());
        assertTrue(pedido.iniciarPreparacao());
        assertEquals(PedidoEstadoEmPreparacao.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoSolicitado() {
        pedido.setEstado(PedidoEstadoSolicitado.getInstance());
        assertTrue(pedido.canelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveIniciarEntregaPedidoSolicitado() {
        pedido.setEstado(PedidoEstadoSolicitado.getInstance());
        assertFalse(pedido.iniciarEntrega());
    }

    @Test
    public void naoDeveEntregarPedidoSolicitado() {
        pedido.setEstado(PedidoEstadoSolicitado.getInstance());
        assertFalse(pedido.entregar());
    }

    // Estado: Em preparação

    @Test
    public void deveIniciarEntregaPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertTrue(pedido.iniciarEntrega());
        assertEquals(PedidoEstadoEmEntrega.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertTrue(pedido.canelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEntregarPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.entregar());
    }

    // Estado: Em entrega

    @Test
    public void deveEntregarPedidoEmEntrega() {
        pedido.setEstado(PedidoEstadoEmEntrega.getInstance());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveCancelarPedidoEmEntrega() {
        pedido.setEstado(PedidoEstadoEmEntrega.getInstance());
        assertFalse(pedido.canelar());
    }

    @Test
    public void naoDeveIniciarPreparacaoPedidoEmEntrega() {
        pedido.setEstado(PedidoEstadoEmEntrega.getInstance());
        assertFalse(pedido.iniciarPreparacao());
    }

    // Estado: Entregue

    @Test
    public void naoDeveAlterarEstadoPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.solicitar());
        assertFalse(pedido.iniciarPreparacao());
        assertFalse(pedido.iniciarEntrega());
        assertFalse(pedido.entregar());
        assertFalse(pedido.canelar());
    }

    // Estado: Cancelado

    @Test
    public void naoDeveAlterarEstadoPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.solicitar());
        assertFalse(pedido.iniciarPreparacao());
        assertFalse(pedido.iniciarEntrega());
        assertFalse(pedido.entregar());
        assertFalse(pedido.canelar());
    }

}