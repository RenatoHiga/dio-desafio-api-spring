package dio.desafio.api.controller;

import dio.desafio.api.domain.model.Cliente;
import dio.desafio.api.domain.model.DonoCarro;
import dio.desafio.api.impl.ClienteService;
import dio.desafio.api.impl.DonoCarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/donos-carro")
public class DonoCarroController {
    private final DonoCarroService donoCarroService;

    public DonoCarroController (DonoCarroService donoCarroService) {
        this.donoCarroService = donoCarroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonoCarro> findById(@PathVariable Long id) {
        var donoCarro = donoCarroService.findById(id);
        return ResponseEntity.ok(donoCarro);
    }

    @PostMapping
    public ResponseEntity<DonoCarro> create(@RequestBody DonoCarro donoCarro) {
        var clienteCreated = donoCarroService.create(donoCarro);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(donoCarro.getId())
                .toUri();
        return ResponseEntity.created(location).body(donoCarro);
    }
}
