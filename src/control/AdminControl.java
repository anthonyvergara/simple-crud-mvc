/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.UsuarioDao;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Anthony
 */
public class AdminControl {
        public List<Usuario> listaUsuarios(){
        return UsuarioDao.getUsuarios();
    }
    
    public List<Usuario> buscarUser(String nome){
        return UsuarioDao.buscaPersonalizada(nome);
    }
    
    public boolean deleteUser(String nomeUsuario){
        return UsuarioDao.deletar(nomeUsuario);
    }
}
