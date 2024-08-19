package dio.desafio.api.impl;

import dio.desafio.api.domain.model.Aluguel;
import dio.desafio.api.domain.model.Carro;
import dio.desafio.api.domain.repository.AluguelRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AluguelServiceImpl implements AluguelService {
    private final AluguelRepository aluguelRepository;

    public AluguelServiceImpl(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    @Override
    public Aluguel findById(Long id) {
        return aluguelRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Aluguel create(Aluguel aluguel) {
        if (aluguel.getData_inicio() != null && aluguelRepository.existsById(aluguel.getId())) {
            throw new IllegalArgumentException("This user ID already exists");
        }
        return aluguelRepository.save(aluguel);
    }

}
