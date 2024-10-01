package br.com.clubedolivro.clubedolivroapi.model;

import br.com.clubedolivro.clubedolivroapi.enums.LivroStatus;
import br.com.clubedolivro.clubedolivroapi.model.dto.LivroDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 80, nullable = false)
    private String titulo;
    @Column(length = 150, nullable = false)
    private String descricao;
    @Column(length = 2, nullable = false)
    private Float nota;
    private Integer qtedPaginas;
    @Enumerated(EnumType.STRING)
    private LivroStatus livroStatus;

    //conversor para o DTO
    public static Livro fromDto(LivroDto livroDto) {
        return new Livro(null, livroDto.titulo(), livroDto.descricao(),
                livroDto.nota(), livroDto.qtdePaginas(), livroDto.livroStatus());
    }
}
