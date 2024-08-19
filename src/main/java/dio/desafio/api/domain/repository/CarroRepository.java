package dio.desafio.api.domain.repository;

import dio.desafio.api.domain.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
