package com.br.controlePedidos.controller;
import com.br.chocolatePontoVirgula.controller.PedidoController;
import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.entity.Pedido;
import com.br.chocolatePontoVirgula.model.services.PedidoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.*;
import java.net.URI;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PedidoControllerTest {

   private MockMvc mockMvc;
   @MockBean
    private PedidoService pedidoService;
    @InjectMocks
    private PedidoController pedidoController;

    @Test
    void quandoOCadastroEValido_retorna200() throws Exception {
       Pedido pedido=new Pedido();
       pedido.setDataPedido(pedido.getDataAtual());
       pedido.setEnderecoEntrega("Rua Capitão João Urias, 984, Centro, Águas da Prata/SP, 13890-972");
       pedido.setAberto(true);
       pedido.setPercentualDesconto(0);
       pedido.setQuantidadeTotal(10);
       pedido.setValorTotal(35.0);
       Cliente cliente=new Cliente();
       cliente.setId(Long.parseLong(1+""));
       pedido.setCliente(cliente);
       MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders
                        .post("pedidos")
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(pedido))).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(201,status);
    }


    @Test
    void update() {
    }

    @Test
    void findById() {
        /*given(ContentType);
        .when().get("").then("/{id}").statusCode(HttpStatus.OK.value());*/
    }

    @Test
    void listarTudo() {
    }

    @Test
    void retornaTotalpaginas() {
    }

    @Test
    void consultaPedidoCliente() {
    }

    @Test
    void fecharPedido() {
    }
}