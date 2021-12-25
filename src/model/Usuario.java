/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anthony
 */
public class Usuario extends Pessoa{
    
    private String nome_usuario;
    
    public Usuario(){
        
    }
    public Usuario(String nome, String nome_usuario){
        this.setNome(nome);
        this.setNome_usuario(nome_usuario);
    }
    
    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }
    
}
