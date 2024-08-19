package dio.desafio.api.domain.repository;

import dio.desafio.api.domain.model.DonoCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoCarroRepository extends JpaRepository<DonoCarro, Long> {
}
