package br.com.clubedolivro.clubedolivroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clubedolivro.clubedolivroapi.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
