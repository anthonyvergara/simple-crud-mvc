/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.UsuarioDao;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Anthony
 */
public class UsuarioControl {
    private Usuario user;
    
    public UsuarioControl(){
    }
    
    public void criarUsuario(String nome, String nome_usuario){
        Usuario u1 = new Usuario(nome, nome_usuario);
        u1.setIdade("");
        this.user = u1;
        UsuarioDao.criarUsuario(user);
    }
    
}
