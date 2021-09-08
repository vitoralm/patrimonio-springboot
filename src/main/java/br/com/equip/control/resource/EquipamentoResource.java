package br.com.equip.control.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.equip.control.model.Equipamento;
import br.com.equip.control.repository.EquipamentoRepository;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoResource {

	@Autowired
	private EquipamentoRepository eqpRepository;

	@GetMapping
	public List<Equipamento> list() {
		return eqpRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Equipamento> findById(@PathVariable Long id) {
		return eqpRepository.findById(id);
	}

	@PostMapping
	public ResponseEntity<Equipamento> create(@RequestBody Equipamento equipamento, HttpServletResponse response) {
		Equipamento save = eqpRepository.save(equipamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId())
				.toUri();
		return ResponseEntity.created(uri).body(save);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		eqpRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Equipamento> update(@PathVariable Long id, @RequestBody Equipamento equipamento) {
		Optional<Equipamento> equipamentoBanco = eqpRepository.findById(id);
		BeanUtils.copyProperties(equipamento, equipamentoBanco.get(), "id");
		eqpRepository.save(equipamentoBanco.get());
		return ResponseEntity.ok(equipamentoBanco.get());
	}
}
