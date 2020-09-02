package br.com.unilito.rango.msvrangopedidos.resource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.uniliva.commonsutils.utils.UltronJsonUtils;
import com.github.uniliva.librangobase.dto.CategoriaDTO;
import com.github.uniliva.librangobase.dto.PedidoDTO;
import com.github.uniliva.librangobase.dto.ProdutoDTO;
import com.github.uniliva.librangobase.dto.UsuarioDTO;
import com.github.uniliva.librangobase.enums.SexoEnum;
import com.github.uniliva.librangobase.enums.StatusPedidoEnum;
import com.github.uniliva.restutils.dto.DadosResponse;
import com.github.uniliva.restutils.resource.BaseResource;

import br.com.unilito.rango.msvrangopedidos.service.ProducerService;

@RestController
@RequestMapping(value = "v1/pedido")
public class PedidoResource implements BaseResource {

	@Autowired
	private ProducerService producerService;

	@PostMapping
	public ResponseEntity<DadosResponse<String>> registrarPedido(@RequestBody PedidoDTO pedido) {
		this.producerService.sendMessage(UltronJsonUtils.paraJson(pedido));
		return retornarCriado("Sucesso!");
	}

	@GetMapping
	public ResponseEntity<PedidoDTO> get() {
		final PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setUsuario(new UsuarioDTO(1L, "Wel", "well@wel.com", "1784645747", SexoEnum.NAO_DEFINIDO));
		pedidoDTO.setDtSolicitacao(LocalDateTime.now());
		pedidoDTO.setProdutos(
				Arrays.asList(new ProdutoDTO(1L, "PC", "PCC", new CategoriaDTO(1L, "Informal"), new BigDecimal(2000))));
		pedidoDTO.setStatus(StatusPedidoEnum.ENCAMINHADO);
		return ResponseEntity.ok(pedidoDTO);
	}
}
