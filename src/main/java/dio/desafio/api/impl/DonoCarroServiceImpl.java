package dio.desafio.api.impl;

import dio.desafio.api.domain.model.Cliente;
import dio.desafio.api.domain.model.DonoCarro;
import dio.desafio.api.domain.repository.ClienteRepository;
import dio.desafio.api.domain.repository.DonoCarroRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DonoCarroServiceImpl implements DonoCarroService {

    private final DonoCarroRepository donoCarroRepository;

    public DonoCarroServiceImpl(DonoCarroRepository donoCarroRepository) {
        this.donoCarroRepository = donoCarroRepository;
    };

    @Override
    public DonoCarro findById(Long id) {
        return donoCarroRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public DonoCarro create(DonoCarro donoCarro) {
        if (donoCarro.getNome() != null && donoCarroRepository.existsById(donoCarro.getId())) {
            throw new IllegalArgumentException("This user ID already exists");
        }
        return donoCarroRepository.save(donoCarro);
    }
}
