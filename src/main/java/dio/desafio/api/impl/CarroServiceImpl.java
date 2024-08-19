package dio.desafio.api.impl;

import dio.desafio.api.domain.model.Carro;
import dio.desafio.api.domain.model.Cliente;
import dio.desafio.api.domain.repository.CarroRepository;
import dio.desafio.api.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CarroServiceImpl implements CarroService {
    private final CarroRepository carroRepository;

    public CarroServiceImpl(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Override
    public Carro findById(Long id) {
        return carroRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Carro create(Carro carro) {
        if (carro.getModelo() != null && carroRepository.existsById(carro.getId())) {
            throw new IllegalArgumentException("This user ID already exists");
        }
        return carroRepository.save(carro);
    }
}
