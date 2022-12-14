package com.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blogpessoal.model.Usuario;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @BeforeAll
    void start() {
        
        usuarioRepository.deleteAll();
        
        usuarioRepository.save(new Usuario(0L, "joao@email.com.br", "João da Silva", "13465278", "https://i.imgur.com/h4t8loa.jpg"));
        
        usuarioRepository.save(new Usuario(0L, "manuela@email.com.br", "Manuela da Silva",  "13465278", "https://i.imgur.com/NtyGneo.jpg"));
        
        usuarioRepository.save(new Usuario(0L, "adriana@email.com.br", "Adriana da Silva",  "13465278", "https://i.imgur.com/5M2p5Wb.jpg"));
        
        usuarioRepository.save(new Usuario(0L, "paulo@email.com.br", "Paulo Antunes",  "13465278", "https://i.imgur.com/FETvs20.jpg"));
        
    }
    
    @Test
    @DisplayName("Retornar 1 usuário")
    public void deveRetornarUmUsuario() {
        
        Optional <Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com.br");
        assertTrue(usuario.get().getUsuario().equals("joao@email.com.br"));
    
    }
    
    @Test
    @DisplayName("Retorna 3 usuarios")
    public void deveRetornarTresUsuarios() {
        
        List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
        assertEquals(3, listaDeUsuarios.size());
        assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
        assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
        assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));
    }
    
    
    
    

}