/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db_kosan.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dosen;
import sun.util.logging.PlatformLogger;


/**
 *
 * @author RiZz
 */
public class DosenDao {
    
    private koneksi kon;
    public DosenDao(){
        kon = new koneksi();
    }
    
    public List<Dosen> getAll(){
        koneksi kon = new koneksi();
        if(kon.getkon() == null){
            return null;
        } else {
            Statement stmt = null ;
            ResultSet rs = null ; 
            List<Dosen> listDosen = null;
            try{
                stmt = kon.getkon().createStatement();
                rs = stmt.executeQuery("SELECT kode_dosen, nama_dosen FROM tb_dosen");
                listDosen = new ArrayList<>();
                
                while (rs.next()){
                    Dosen dataDosen = new Dosen();
                    dataDosen.setKodeDosen(rs.getString("kode_dosen"));
                    dataDosen.setNamaDosen(rs.getString("nama_dosen"));
                    listDosen.add(dataDosen);
                }
                rs.close();
                stmt.close();
                kon.getkon().close();
            } catch (SQLException ex) {
            }
            return listDosen;
        }
    }
    
    public boolean delete(String kodeDosen) {
        koneksi kon = new koneksi();
        if(kon.getkon() == null){
            return false;
        }else{
            Statement stmt = null ;
            try{
                stmt = kon.getkon().createStatement();
                int terhapus = stmt.executeUpdate("DELETE FROM tb_dosen WHERE kode_dosen = '" +kodeDosen+ "'");
                
                stmt.close();
                kon.getkon().close();
                if(terhapus > 0){
                    return true;
                }else{
                    return false;
                }
                
            } catch (SQLException ex) {
               return false;
            }
            
        }
    }
}

