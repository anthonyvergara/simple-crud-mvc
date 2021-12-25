/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author Anthony
 */
public abstract class UsuarioDao {
    private static Connection con = null;
    private static PreparedStatement prepared = null;
    private static ResultSet result = null;
    
    public static void criarUsuario(Usuario user){
        try {
            con = ConnectionFactory.getConnection();
            prepared = con.prepareStatement("insert INTO usuario (nome,idade,usuario,perfilimg) VALUES (?,?,?,?)");
            prepared.setString(1, user.getNome());
            prepared.setString(2, user.getIdade());
            prepared.setString(3, user.getNome_usuario()); 
            prepared.setString(4, "");
            
            prepared.executeUpdate();
            System.out.println("Usuário criado!");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar usuário: "+ex.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, prepared);
        }
    }
    
    public static List<Usuario> getUsuarios(){
        List<Usuario> listUser = new ArrayList();
        try {
            con = ConnectionFactory.getConnection();
            prepared = con.prepareStatement("SELECT nome FROM usuario ");
            result = prepared.executeQuery();
            
            
            while(result.next()){
                Usuario user = new Usuario();
                user.setNome(result.getString("nome"));
                listUser.add(user);
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Erro ao listar usuários: "+ex.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, prepared, result);
        }
        
        return listUser;
    }
    
    public static List<Usuario> buscaPersonalizada(String nome){
        List<Usuario> listaUsuario = new ArrayList();
        try {
            con = ConnectionFactory.getConnection();
            prepared = con.prepareStatement("select * from usuario where nome = ?");
            prepared.setString(1, nome);
            result = prepared.executeQuery();

            if(result.next()){
                do{
                    Usuario user = new Usuario();
                    user.setNome(result.getString("nome"));
                    listaUsuario.add(user);
                }while(result.next());
            }
            else{
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar usuário: "+ex.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, prepared, result);
        }
        
        return listaUsuario;
    }
    
    private static boolean getStatus(String nomeUsuario){
        boolean status = false;
        
        try {
            con = ConnectionFactory.getConnection();
            prepared = con.prepareStatement("SELECT * from usuario where usuario = ?");
            prepared.setString(1, nomeUsuario);
            result = prepared.executeQuery();
            
            if(result.next()){
                status = true;
            }else{
                status = false;
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Erro getStatus: "+ex.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, prepared, result);
        }
        
        return status;
    }
    
    public static boolean deletar(String nomeUsuario){
        boolean deletado = false;
        boolean status = getStatus(nomeUsuario);
        try {
            
            if(status == true){
                con = ConnectionFactory.getConnection();
                prepared = con.prepareStatement("delete from usuario where usuario = ?");
                prepared.setString(1, nomeUsuario);
                prepared.executeUpdate();
                deletado = true;
            }else{
                deletado = false;
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar: "+ex.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, prepared);
        }
        return deletado;
    }
}
