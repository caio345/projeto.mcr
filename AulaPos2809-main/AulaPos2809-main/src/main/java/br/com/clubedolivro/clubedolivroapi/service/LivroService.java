package br.com.clubedolivro.clubedolivroapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.clubedolivro.clubedolivroapi.enums.LivroStatus;
import br.com.clubedolivro.clubedolivroapi.model.Livro;
import br.com.clubedolivro.clubedolivroapi.model.dto.LivroDto;
import br.com.clubedolivro.clubedolivroapi.repository.LivroRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public Page<LivroDto> findAll(Pageable pagination) {
        return livroRepository.findAll(pagination).map(l -> new LivroDto(l));
    }

    public LivroDto findById(Long id) {
        return new LivroDto(livroRepository.getReferenceById(id));
    }

    @Transactional
    public LivroDto save(LivroDto livroDto) {
        Livro livro = Livro.fromDto(livroDto);
        return new LivroDto(livroRepository.save(livro));
    }

    @Transactional
    public LivroDto update(Long id, LivroDto livroDto) {
        Livro livro = Livro.fromDto(livroDto);
        livro.setId(id);
        return new LivroDto(livroRepository.save(livro));
    }

    @Transactional
    public void delete(Long id) {
        livroRepository.deleteById(id);
    }

    @Transactional
    public LivroDto updateStatus (Long id, String status) {
        Livro livro = livroRepository.getReferenceById(id);
        livro.setLivroStatus(LivroStatus.valueOf(status));
        return new LivroDto(livro);
    }
}
