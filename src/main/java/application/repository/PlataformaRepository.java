package application.repository;

import org.springframework.data.repository.CrudRepository;
import application.model.Plataforma;
import java.util.List;

public interface PlataformaRepository extends CrudRepository<Plataforma, Long> {
    List<Plataforma> findByTitulo(String titulo);
}
