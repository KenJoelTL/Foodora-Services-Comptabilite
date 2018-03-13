
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodora.comptabilite.controleur;

import com.foodora.comptabilite.modele.Transaction;
import com.foodora.comptabilite.modele.TransactionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.gson.*;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.Config;
import jdbc.Connexion;

/**
 *
 * @author Joel
 */
public class ServiceComptabilite extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> and <code>PUT</code> and <code>DELETE</code> 
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                
            String action = request.getParameter("action");
            String id = request.getParameter("id");
            
            Transaction t = new Transaction();
            Gson gson = new Gson();
//            JSONObject jo = new JSONObject(t);

            // 1. Java object to JSON, and save into a file
            //gson.toJson(t, out);
            // 2. Java object to JSON, and assign to a String
            //String jsonInString = gson.toJson(t);            

            switch (action) {
                case "ajouter":
                        //appel du dao 
                    out.println("ajouter transaction");
                    break;
                case "Supprimer":
                        //appel du dao 
                    out.println("supprimer transaction");
                    break;
                default:
                    out.println("afficher transaction");
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        switch (action) {
            case "get":
                if (request.getParameter("id") != null) {
                    this.getTransaction(request, response);
                } else {
                    this.getAllTransaction(response);
                }
                break;
            default:
                this.getAllTransaction(response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              this.createTransaction(request, response);
    }
    
    /**
     * Handles the HTTP <code>PUT</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        this.updateTransaction(request, response);
    }
  
      @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException{
        this.deleteTransaction(req, resp);
    }


    
    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    //Pour afficher en Gson toutes les transactions de la BD
    public void getAllTransaction(HttpServletResponse response) { // | request GET
        try {
            Class.forName(Config.DRIVER);
            Connection cnx = Connexion.getInstance();
            TransactionDAO tDao = new TransactionDAO();
            tDao.setCnx(cnx);
            List liste = tDao.findAll();
            Gson gson = new Gson();
            gson.toJson(liste, response.getWriter());
        } catch (SQLException e) {
        } catch (IOException ex) {
            Logger.getLogger(ServiceComptabilite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServiceComptabilite.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Connexion.close();
        }    
    }
    
    
    public void getTransaction(HttpServletRequest request, HttpServletResponse response){
        try {
            if (request.getParameter("id") != null) { //id est un paramètre obligatoire | request GET
                String id = request.getParameter("id");
                Class.forName(Config.DRIVER);
                Connection cnx = Connexion.getInstance();
                TransactionDAO tDao = new TransactionDAO();
                tDao.setCnx(cnx);
                Transaction t = tDao.retrieve(id);
                Gson gson = new Gson();
                gson.toJson(t, response.getWriter());
            } 
            else {
                //message d'erreur en JSON { "Error" : Aucune données trouvé, "Resultat" : {} }
            }
        } 
        catch (SQLException e) { } 
        catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServiceComptabilite.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Connexion.close();
        }
    }
    
    
    public void updateTransaction(HttpServletRequest request, HttpServletResponse response){
        try {
            if (request.getParameter("id") != null && request.getParameter("transaction") !=null) { //id est un paramètre obligatoire | request PUT
                String id = request.getParameter("id");
                Class.forName(Config.DRIVER);
                Connection cnx = Connexion.getInstance();
                TransactionDAO tDao = new TransactionDAO();
                tDao.setCnx(cnx);
                Transaction t = new Transaction();
                Gson gson = new Gson();
                t = gson.fromJson(request.getParameter("transaction"), t.getClass());
               
                t.setId(Integer.parseInt(id));
               
                if(tDao.update(t)){
                    System.out.println("SUCCES !");
                    t = tDao.retrieve(id);
                    gson.toJson(t, response.getWriter());
                }
                //message d'erreur en JSON { "Error" : Aucune données trouvé, "Resultat" : {} }
            } else {
                //message d'erreur en JSON { "Error" : Aucune données trouvé, "Resultat" : {} }
                response.sendError(0, "Aucune données trouvé");
            }
        
        } catch (SQLException e) {
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServiceComptabilite.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Connexion.close();
        }
    }
  
  private void deleteTransaction(HttpServletRequest request, HttpServletResponse response) {
         try {
            if (request.getParameter("id") != null ) {
                String id = request.getParameter("id");
                Class.forName(Config.DRIVER);
                Connection cnx = Connexion.getInstance();
                TransactionDAO tDao = new TransactionDAO();
                tDao.setCnx(cnx);
                Transaction t = new Transaction();
                t = tDao.retrieve(id);
                
                if(tDao.delete(t))
                    response.getWriter().print("{'message':'transaction supprimee', 'id':" + t.getId() +"}");
                else 
                     response.getWriter().print("{}");
                
            } 
            else 
                    response.getWriter().print("{}");
            
        
        } catch (SQLException e) {
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServiceComptabilite.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Connexion.close();
        }
        
        
        
        
    }

    private void createTransaction(HttpServletRequest request, HttpServletResponse response) {
       try {
           System.out.println("CREATE TRANSACTION");
            if (request.getParameter("transaction") !=null) { 
                Class.forName(Config.DRIVER);
                Connection cnx = Connexion.getInstance();
                TransactionDAO tDao = new TransactionDAO();
                System.out.println("test3");                tDao.setCnx(cnx);
                Transaction t = new Transaction();
                Gson gson = new Gson();
                t = gson.fromJson(request.getParameter("transaction"), t.getClass());
              /* t.setIdClient(1);
               t.setIdSuccursale(1);
               t.setItems_commande("itemscommande");
               t.setPourboireCoursier(3);
               t.setSousTotal(23);*/

                if(tDao.create(t)){
         
                    System.out.println("SUCCES !");
                    gson.toJson(t, response.getWriter());
                }
                //message d'erreur en JSON { "Error" : Aucune données trouvé, "Resultat" : {} }
            } else {
                //message d'erreur en JSON { "Error" : Aucune données trouvé, "Resultat" : {} }
                response.sendError(0, "Aucune donnée créée");
            }
        
        } catch (SQLException e) {
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServiceComptabilite.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Connexion.close();
        }
    }
    
    
    
    
}

