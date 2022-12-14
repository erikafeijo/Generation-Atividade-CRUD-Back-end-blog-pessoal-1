package com.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlSchemaType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Schema(example = "email@email.com.br")
    @NotBlank
    @Email(message = "O email tem que ser valido")
    private String usuario;
    
    @NotBlank(message = "O atributo é obrigatório")
    private String nome;
    
    @NotBlank(message = "O atributo é obrigatório")
    @Size (min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String senha;
    
    @Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
    private String foto;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE) //Cascade = se apagar o usuário, apaga todas as suas postagens
    @JsonIgnoreProperties("usuario")
    private List<Postagem> postagem;
    

     public Usuario(Long id,String usuario,String nome,String senha,String foto) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.senha = senha;
        this.foto = foto;
    }//Não colocou postagem, pois é uma variável de relação (foreign key), então não precisa do construtor
     
     

    public Usuario() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Postagem> getPostagem() {
        return postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }
    
    

}