package pt.tangela.example.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.tangela.example.persistence.models.Example;

public interface ExampleJpaRepository extends JpaRepository<Example, Long> {
}
