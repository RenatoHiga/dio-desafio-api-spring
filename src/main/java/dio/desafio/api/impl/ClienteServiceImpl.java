package dio.desafio.api.impl;

import dio.desafio.api.domain.model.Cliente;
import dio.desafio.api.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Cliente create(Cliente cliente) {
        if (cliente.getNome() != null && clienteRepository.existsById(cliente.getId())) {
            throw new IllegalArgumentException("This user ID already exists");
        }
        return clienteRepository.save(cliente);
    }
}
