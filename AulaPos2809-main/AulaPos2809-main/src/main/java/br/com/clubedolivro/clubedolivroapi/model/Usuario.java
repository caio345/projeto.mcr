package br.com.clubedolivro.clubedolivroapi.model;

import br.com.clubedolivro.clubedolivroapi.enums.UsuarioStatus;

import br.com.clubedolivro.clubedolivroapi.model.dto.UsuarioDto;
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
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 100, nullable = false)
    private String telefone;
    @Column(length = 11, nullable = false)
    private String endereco;
    @Column(nullable = false)
    private char genero;
    @Enumerated(EnumType.STRING)
    private UsuarioStatus usuarioStatus;

    //conversor para o DTO
    public static Usuario fromDto(UsuarioDto usuarioDto) {
        return new Usuario(null, usuarioDto.nome(), usuarioDto.email(),
                usuarioDto.telefone(), usuarioDto.endereco(), usuarioDto.genero(), usuarioDto.usuarioStatus());
    }

}
