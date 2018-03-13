/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodora.comptabilite.modele.DAO;

import com.foodora.comptabilite.modele.ItemTransaction;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joel
 */
public class ItemTransactionDAO extends DAO<ItemTransaction> {

    @Override
    public boolean create(ItemTransaction x) {
        /*System.out.println("creaaaaateeeeeeeeeeeeeeeeee");

        String req = "INSERT INTO transaction (`CODE` , `ID_TRANSACTION`, `QUANTITE`) VALUES (?,?,?)";
        System.out.println("test6");
        PreparedStatement paramStm = null;
        try {
            System.out.println("test7");
            paramStm = cnx.prepareStatement(req);

            System.out.println("test8");
            paramStm.setInt(1, x);
            paramStm.setInt(2, x.getIdClient());
            paramStm.setDouble(3, x.getSousTotal());
            paramStm.setDouble(4, x.getPourboireCoursier());
            int n = paramStm.executeUpdate();
            System.out.println("test9");
            if (n > 0) {
                paramStm.close();
                //stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            try {
                if (paramStm != null) {
                    paramStm.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;*/
    }

    @Override
    public ItemTransaction retrieve(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemTransaction retrieve(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ItemTransaction x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ItemTransaction x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemTransaction> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
