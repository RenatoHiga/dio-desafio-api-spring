package dio.desafio.api.impl;


import dio.desafio.api.domain.model.DonoCarro;

public interface DonoCarroService {

    DonoCarro findById(Long id);

    DonoCarro create(DonoCarro donoCarro);

}
