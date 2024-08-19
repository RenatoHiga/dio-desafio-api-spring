package dio.desafio.api.controller;

import dio.desafio.api.domain.model.Carro;
import dio.desafio.api.domain.model.DonoCarro;
import dio.desafio.api.impl.CarroService;
import dio.desafio.api.impl.DonoCarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private final CarroService carroService;

    public CarroController (CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id) {
        var carro = carroService.findById(id);
        return ResponseEntity.ok(carro);
    }

    @PostMapping
    public ResponseEntity<Carro> create(@RequestBody Carro carro) {
        var clienteCreated = carroService.create(carro);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carro.getId())
                .toUri();
        return ResponseEntity.created(location).body(carro);
    }
}
