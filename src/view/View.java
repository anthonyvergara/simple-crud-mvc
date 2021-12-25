/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.AdminControl;
import control.UsuarioControl;
import dao.UsuarioDao;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Anthony
 */
public class View {
    public static void main(String args[]){

        UsuarioControl us = new UsuarioControl();
        AdminControl adm = new AdminControl();
        //us.criarUsuario("Michael", "m.rikoo");
        
       /* for(Usuario user : us.listaUsuarios()){
            System.out.println("Nome: "+user.getNome());
        }
        
        for(Usuario user : us.buscarUser("anthony")){
            System.out.println("Nome: "+user.getNome());
        }*/
       
    }
}
