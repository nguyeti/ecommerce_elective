/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.beans.EventHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony, Etienne, Timothée
 */
public class DBDerby {
    
    private String username;
    private String password;
    private String url;
    private Connection conn;
    
    public DBDerby(String username, String password, String url){
        this.username = username;
        this.password = password;
        this.url = url;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex){
            //
        }
        try{
            conn = DriverManager.getConnection(this.url, this.username, this.password);
        }catch(SQLException ex){
            
        }
    }
    
    public List<Product> getProducts(int CatId){
        Product product = null;
        List<Product> products = new ArrayList<Product>();
        String requete;
        if(CatId!=0){
            requete = "SELECT * FROM APP.PRODUCT WHERE category_id=?";
        }else{
            requete = "SELECT * FROM APP.PRODUCT";
        }
        try {
            PreparedStatement pst = conn.prepareStatement(requete);
            if(CatId!=0)
                pst.setInt(1, CatId);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setPrice(rs.getFloat(4));
                product.setMaker(rs.getString(5));
                product.setWeight(rs.getString(6));
                product.setCategoryId(rs.getInt(7));
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return products;
    }
    
    
    public List<Category> getCategories(){
        Category categorie = null;
        List<Category> categories = new ArrayList<Category>();
        String requete = "SELECT * FROM APP.CATEGORY";
        try {
            PreparedStatement pst = conn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                categorie = new Category();
                categorie.setId(rs.getInt(1));
                categorie.setName(rs.getString(2));
                categorie.setDescription(rs.getString(3));
                categories.add(categorie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
    
    public Product getProduct(int id){
        Product product = new Product();
        String requete = "SELECT * FROM APP.PRODUCT WHERE product_id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                product.setId(id);
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));                
                product.setPrice(rs.getFloat(4));
                product.setMaker(rs.getString(5));
                product.setWeight(rs.getString(6));
                product.setCategoryId(rs.getInt(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return product;
    }
    
    public String getCustomer(Customer client){
        String requete = "SELECT * FROM APP.CUSTOMER WHERE customer_email=?";
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(requete);
            pst.setString(1, client.getEmail());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                if((rs.getString(8)).equals(client.getPwd())){
                    client.setId(rs.getInt(1));
                    client.setFirstname(rs.getString(2));
                    client.setLastname(rs.getString(3));
                    client.setPhone(rs.getString(4));
                    client.setAddress(rs.getString(5));
                    client.setCc(rs.getString(6));
                    return null;
                }else{
                    return "Mot de passe invalide.";
                }
            }else{
                return "Client inexistant. Veuillez vous enregistrer.";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Serveur d'identification non atteint. Veuillez ré-essayer s'il vous plait.";
    }
    
    public String setCustomer(Customer client){
        String requete = "INSERT INTO APP.CUSTOMER(customer_id, customer_firstname, customer_lastname, customer_phone, customer_address, customer_cc, customer_email, customer_pwd) VALUES(default, ?,?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(requete);
            pst.setString(1, client.getFirstname());
            pst.setString(2, client.getLastname());
            pst.setString(3, client.getPhone());
            pst.setString(4, client.getAddress());
            pst.setString(5, client.getCc());
            pst.setString(6, client.getEmail());
            pst.setString(7, client.getPwd());
            pst.execute();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
            return "Cette adresse email est déjà enregistré";
        }

    }
    
    private int getLastOrderId(Customer client){
        int order_id=0;
        String requete = "SELECT MAX(customer_order_id) FROM APP.CUSTOMER_ORDER WHERE customer_id=?";
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(requete);
            pst.setInt(1, client.getId());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                order_id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return order_id;
    }
    
    public void insertOrder(ShoppingCart cart, Customer client){   
        this.insertCustomerOrder(cart, client);
        this.insertOrderedProduct(cart, client);    
    }
    
    private void insertCustomerOrder(ShoppingCart cart, Customer client){
        String customerOrderRequest = "INSERT INTO APP.CUSTOMER_ORDER"
                                      + "(customer_order_id, customer_order_amount, customer_order_dateCreated, customer_order_confirm_num, customer_id)"
                                        + "VALUES(default, ?, ?, ?, ?)";
         int confirm_num = Integer.parseInt(client.getId()+""+this.getLastOrderId(client));
        try {
            PreparedStatement pst = conn.prepareStatement(customerOrderRequest);
            pst.setFloat(1, cart.getAmount());
            pst.setTimestamp(2, new Timestamp((Calendar.getInstance()).getTimeInMillis()));
            pst.setInt(3, confirm_num);
            pst.setInt(4, client.getId());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void insertOrderedProduct(ShoppingCart cart, Customer client){
        String orderedProductRequest = "INSERT INTO APP.ORDERED_PRODUCT"
                                        +"(customer_order_id, product_id, quantity)"
                                        + "VALUES(?,?,?)";
        int customer_order_id = this.getLastOrderId(client);
        for(Product product : cart.getProducts()){
            try {
                PreparedStatement pst = conn.prepareStatement(orderedProductRequest);
                pst.setInt(1, customer_order_id);
                pst.setInt(2, product.getId());
                pst.setInt(3, cart.getQuantity(product));
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public List<Product> getSearchedProducts(String message){
        Product product = null;
        List<Product> products = new ArrayList<Product>();
        String requete = "SELECT * FROM APP.PRODUCT where product_name LIKE ?";
        try {
            PreparedStatement pst = conn.prepareStatement(requete);
            pst.setString(1, "%"+message+"%");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setPrice(rs.getFloat(4));
                product.setMaker(rs.getString(5));
                product.setWeight(rs.getString(6));
                product.setCategoryId(rs.getInt(7));
                products.add(product);
            }
        } catch (SQLException ex) {
                Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return products;
    }
    
    
}
