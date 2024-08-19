package dio.desafio.api.impl;


import dio.desafio.api.domain.model.Cliente;

public interface ClienteService {

    Cliente findById(Long id);

    Cliente create(Cliente cliente);
}
