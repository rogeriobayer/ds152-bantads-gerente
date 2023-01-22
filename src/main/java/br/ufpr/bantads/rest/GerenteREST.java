package br.ufpr.bantads.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufpr.bantads.model.Gerente;
import br.ufpr.bantads.model.GerenteDTO;
import br.ufpr.bantads.repository.GerenteRepository;
import br.ufpr.bantads.repository.GerenteResponse;

@CrossOrigin
@RestController
public class GerenteREST {

	@Autowired
	private GerenteRepository repo;
	@Autowired
	private ModelMapper mapper;

	@PostMapping("/gerentes")
	public ResponseEntity<Object> inserir(@RequestBody GerenteDTO gerente) {
		Gerente g = repo.findByCpf(gerente.getCpf());
		if (g == null) {
			// Salva a entidade convertida do DTO
			repo.save(mapper.map(gerente, Gerente.class));
			// busca o usuário inserido

			// retorna DTO equivalente à entidade
			return new ResponseEntity<>(new GerenteResponse(true, "Gerente criado com sucesso", gerente),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(new GerenteResponse(false, "Já possui um gerente com este CPF", null),
				HttpStatus.CONFLICT);
	}

	@GetMapping("/gerentes")
	public List<GerenteDTO> listarTodos() {
		List<Gerente> lista = repo.findAll();
		return lista.stream().map(e -> mapper.map(e, GerenteDTO.class)).collect(Collectors.toList());
	}

	@GetMapping("/gerentes/{id}")
	public ResponseEntity<Object> obterPorId(@PathVariable("id") Long id) {
		Optional<Gerente> g = repo.findById(id);

		if (g.isEmpty()) {
			return new ResponseEntity<>(new GerenteResponse(false, "Gerente informado não encontrado", null),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(
				new GerenteResponse(true, "Gerente encontrado com sucesso", mapper.map(g, GerenteDTO.class)),HttpStatus.OK);
	}

	@DeleteMapping("/gerentes/{id}")
	public ResponseEntity<Object> removerGerente(@PathVariable("id") Long id) {
		Optional<Gerente> g = repo.findById(id);
		if (!(g.isEmpty())) {
			Gerente ger = g.get();
			repo.deleteById(ger.getId());
			return new ResponseEntity<>(new GerenteResponse(true, "Gerente removido com sucesso", null), HttpStatus.OK);
		}
		return new ResponseEntity<>(new GerenteResponse(false, "Gerente informado não encontrado", null),
				HttpStatus.NOT_FOUND);

	}

	@PutMapping("/gerentes/{id}")
	public ResponseEntity<Object> alterarGerente(@PathVariable("id") Long id, @RequestBody Gerente gerente) {
		Optional<Gerente> g = repo.findById(id);
		if (!(g.isEmpty())) {
			Gerente ger = g.get();
			ger.setNome(gerente.getNome());
			ger.setCpf(gerente.getCpf());
			ger.setEmail(gerente.getEmail());
			ger.setNum_clientes(gerente.getNum_clientes());
			repo.save(ger);
			return new ResponseEntity<>(new GerenteResponse(true, "Gerente alterado com sucesso", g), HttpStatus.OK);
		}
		return new ResponseEntity<>(new GerenteResponse(false, "Gerente não encontrado", null), HttpStatus.NOT_FOUND);
	}

}
