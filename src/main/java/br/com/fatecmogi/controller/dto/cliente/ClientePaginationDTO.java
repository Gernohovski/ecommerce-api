package br.com.fatecmogi.controller.dto.cliente;

import br.com.fatecmogi.model.entity.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ClientePaginationDTO {

	public List<Cliente> content;

	public long totalElements;

	public int page;

	public int size;

}
