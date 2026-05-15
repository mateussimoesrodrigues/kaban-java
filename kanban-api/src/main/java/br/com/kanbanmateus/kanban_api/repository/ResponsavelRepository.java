package br.com.kanbanmateus.kanban_api.repository;

import br.com.kanbanmateus.kanban_api.entity.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> {
}
