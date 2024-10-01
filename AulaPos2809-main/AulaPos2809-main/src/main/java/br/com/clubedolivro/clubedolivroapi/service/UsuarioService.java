package br.com.clubedolivro.clubedolivroapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.clubedolivro.clubedolivroapi.model.Usuario;
import br.com.clubedolivro.clubedolivroapi.model.dto.UsuarioDto;
import br.com.clubedolivro.clubedolivroapi.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Page<UsuarioDto> findAll(Pageable pagination) {
        return usuarioRepository.findAll(pagination).map(l -> new UsuarioDto(l));
    }

    public UsuarioDto findById(Long id) {
        return new UsuarioDto(usuarioRepository.getReferenceById(id));
    }

    @Transactional
    public UsuarioDto save(UsuarioDto usuarioDto) {
        Usuario usuario = Usuario.fromDto(usuarioDto);
        return new UsuarioDto(usuarioRepository.save(usuario));
    }
}
