package dio.desafio.api.controller;

import dio.desafio.api.domain.model.Aluguel;
import dio.desafio.api.domain.model.Carro;
import dio.desafio.api.impl.AluguelService;
import dio.desafio.api.impl.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping
public class AluguelController {
    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> findById(@PathVariable Long id) {
        var aluguel = aluguelService.findById(id);
        return ResponseEntity.ok(aluguel);
    }

    @PostMapping
    public ResponseEntity<Aluguel> create(@RequestBody Aluguel aluguel) {
        var clienteCreated = aluguelService.create(aluguel);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(aluguel.getId())
                .toUri();
        return ResponseEntity.created(location).body(aluguel);
    }
}
