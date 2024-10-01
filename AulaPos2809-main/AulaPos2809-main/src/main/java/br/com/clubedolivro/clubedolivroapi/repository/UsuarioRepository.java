package br.com.clubedolivro.clubedolivroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clubedolivro.clubedolivroapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
