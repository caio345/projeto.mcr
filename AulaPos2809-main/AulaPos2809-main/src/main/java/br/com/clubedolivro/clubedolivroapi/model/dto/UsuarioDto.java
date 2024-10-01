package br.com.clubedolivro.clubedolivroapi.model.dto;

import br.com.clubedolivro.clubedolivroapi.enums.UsuarioStatus;
import br.com.clubedolivro.clubedolivroapi.model.Usuario;

public record UsuarioDto(
        Long id,
        String nome,
        String email,
        String telefone,
        String endereco,
        char genero,
        UsuarioStatus usuarioStatus) {

    public UsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(),
                usuario.getTelefone(), usuario.getEndereco(), usuario.getGenero(),
                usuario.getUsuarioStatus());
    }
}
