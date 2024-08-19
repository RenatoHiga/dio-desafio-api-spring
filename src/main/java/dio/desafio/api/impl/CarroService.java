package dio.desafio.api.impl;

import dio.desafio.api.domain.model.Carro;

public interface CarroService {
    Carro findById(Long id);

    Carro create(Carro carro);
}
