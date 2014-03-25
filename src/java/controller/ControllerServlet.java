/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.DBDerby;
import model.Product;
import model.ShoppingCart;

/**
 *
 * @author Anthony, Etienne, Timothée
 */
public class ControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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

        DBDerby dbcommerce;
        ShoppingCart cart;
        Customer client;

        HttpSession session = request.getSession();
        String url = "default.jsp";

        client = (Customer) session.getAttribute("client");
        cart = (ShoppingCart) session.getAttribute("cart");
        dbcommerce = (DBDerby) session.getAttribute("dbcommerce");
        if (dbcommerce == null) {
            dbcommerce = new DBDerby("root", " ", "jdbc:derby://localhost/eCommerce");
            session.setAttribute("dbcommerce", dbcommerce);
        }

        String action = (String) request.getParameter("action");

        if (action != null) {
            if (action.equals("accueil")) {
                url = "index.jsp";
            } else if (action.equals("produits")) {//affichage de la page des produits
                request.setAttribute("id", 0);
                url = "view/catalogue.jsp";
            } else if (action.equals("catalogue")) {//affichage produit avec catégorie
                int i = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("id", i);
                url = "view/catalogue.jsp";
            } else if (action.equals("detailProduit")) {//affichage produit selectionné
                url = "view/detailProduit.jsp";
            } else if (action.equals("ajout")) {
                if (cart == null) {
                    cart = new ShoppingCart();
                    session.setAttribute("cart", cart);
                }
                int id = Integer.parseInt(request.getParameter("id"));
                int quantity = Integer.parseInt(request.getParameter("quantite"));
                Product product = dbcommerce.getProduct(id);
                cart.addProduct(product, quantity);
                request.setAttribute("product", product);//pour afficher validation
                url = "view/ajoutConfirmation.jsp";
            } else if (action.equals("caddie")) {//affichage du caddie
                url = "view/caddie.jsp";
            } else if (action.equals("modife")) {//prise en compte modif ou suppression dans caddie
                String param = request.getParameter("modifier");
                int id = Integer.parseInt(request.getParameter("id"));
                int quantity = Integer.parseInt(request.getParameter("quantite"));
                Product product = dbcommerce.getProduct(id);
                if (param.equals("supprimer")) {
                    cart.removeProduct(product);
                } else if (param.equals("modifier")) {
                    cart.removeProduct(product);
                    cart.addProduct(product, quantity);
                }
                url = "view/caddie.jsp";
            } else if (action.equals("valider achats")) {//validation du caddie
                if (client == null) {
                    request.setAttribute("message", "Vous devez vous identifier pour valider vos achats. Si vous n'etes pas encore inscrit, inscrivez vous.");
                    url = "view/connexion.jsp";
                } else {
                    url = "view/validerAddress.jsp";
                }
            } else if (action.equals("Connexion")) {
                client = new Customer(request.getParameter("email"), request.getParameter("password"));
                String erreur = dbcommerce.getCustomer(client);
                request.setAttribute("erreur", erreur);
                if (erreur == null) {
                    session.setAttribute("client", client);
                    url = "view/profil.jsp";
                } else {
                    url = "view/connexion.jsp";
                }
            } else if (action.equals("Inscription")) {
                url = "view/inscription.jsp";
            } else if (action.equals("validerInscription")) {
                String firstname = (String) request.getParameter("firstname");
                String lastname = (String) request.getParameter("lastname");
                String phone = (String) request.getParameter("phone");
                String address = (String) request.getParameter("address");
                String cc = (String) request.getParameter("cc");
                String email = (String) request.getParameter("email");
                String password = (String) request.getParameter("password");
                client = new Customer(firstname, lastname, phone, address, cc, email, password);
                String erreur = dbcommerce.setCustomer(client);
                if (erreur == null) {
                    session.setAttribute("client", client);
                    url = "view/confirmeInscription.jsp";
                } else {
                    request.setAttribute("erreur", erreur);
                    url = "view/inscription.jsp";
                }
            } else if (action.equals("profil")) {
                url = "view/profil.jsp";
            } else if (action.equals("deconnexion")) {//gestion de la recherche
                session.removeAttribute("client");
                url = "index.jsp"; //affichage des produits correspondant au critères
            } else if (action.equals("Accepter")) {
                //insertion dans la BD
                dbcommerce.insertOrder(cart, client);
                url = "view/finAchats.jsp";
            } else if (action.equals("recherche")) {//gestion de la recherche
                //String critere = request.getParameter("recherche");
                //request.setAttribute("critere",critere);
                request.setAttribute("products", dbcommerce.getSearchedProducts(request.getParameter("recherche")));
                url = "view/search.jsp"; //affichage des produits correspondant au critères
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
        //processRequest(request, response);
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
        doGet(request, response);
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

}
