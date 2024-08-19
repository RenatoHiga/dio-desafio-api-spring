package dio.desafio.api.impl;

import dio.desafio.api.domain.model.Aluguel;

public interface AluguelService {
    Aluguel findById(Long id);

    Aluguel create(Aluguel aluguel);
}
