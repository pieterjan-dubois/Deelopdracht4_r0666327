package ui.controller;

import domain.DomainException;
import domain.db.ProductDB;
import domain.model.Product;
import org.openqa.selenium.devtools.schema.model.Domain;
import org.openqa.selenium.grid.data.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    ProductDB prodlijst = new ProductDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String command = "home";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }
        for (Cookie c : request.getCookies()) {
            if (c.getName().equals("Nieuwsbrief")) {
                request.setAttribute("nieuwsbrief", c.getValue());
                break;
            }
        }
        String destination;
        switch (command) {
            case "home":
                destination = getHome(request, response);
                break;
            case "winkel":
                destination = getWinkel(request, response);
                break;
            case "bestelling":
                destination = getBestelling(request, response);
                break;
            case "add":
                destination = getAdd(request, response);
                break;
            case "vindproduct":
                destination = getVindProduct(request, response);
                break;
            case "find":
                destination = getFind(request, response);
                break;
            case "delete":
                destination = getDelete(request, response);
                break;
            case "deleteconfirm":
                destination = "deleteconfirmation.jsp";
                break;
            case "update":
                destination = "update.jsp";
                break;
            case "updateproduct":
                destination = getUpdateProduct(request, response);
                break;
            case "nieuwsbrief":
                destination = setCookie(request, response);
                break;
            case "getLaatsteNieuws":
                destination = "laatstenieuws.jsp";
                break;
            case "logcount":
                destination = getLogCount(request, response);
                break;
            default:
                destination = getHome(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String getLogCount(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Date createTime = new Date(session.getCreationTime());
        Date getLastAccesTime = new Date(session.getLastAccessedTime());

        String titleKey;
        int visitCount = 0;
        String visitCountKey = "visitCount";

        if (session.isNew()) {
            titleKey = "Welkom!";

        } else {
            titleKey = "Welkom terug!";
            Integer sessionVisitCount = (Integer) session.getAttribute(visitCountKey);
            if (sessionVisitCount != null) {
                visitCount = sessionVisitCount.intValue() + 1;
            }
        }

        session.setAttribute(visitCountKey, Integer.valueOf(visitCount));
        session.setAttribute("createTime", createTime);
        session.setAttribute("lastAccessTime", getLastAccesTime);
        session.setAttribute("title", titleKey);

        return "activiteit.jsp";
    }


    private String setCookie(HttpServletRequest request, HttpServletResponse response) {
        String nieuwsbrief = null;
        nieuwsbrief = request.getParameter("nieuwsbrief");
        if (request.getCookies() != null) {
            Cookie cookie = new Cookie("Nieuwsbrief", nieuwsbrief);
            response.addCookie(cookie);
            request.setAttribute("nieuwsbrief", nieuwsbrief);
            return "index.jsp";
        }
        return null;
    }

    private String getUpdateProduct(HttpServletRequest request, HttpServletResponse response) {

      ArrayList<String> errors = new ArrayList<>();
        String naam = request.getParameter("naam");
        String hoeveelheidFromParam = request.getParameter("hoeveelheid");
        double hoeveelheid = Integer.parseInt(hoeveelheidFromParam);
        String prijsaanbodFromParam = request.getParameter("prijsaanbod");
        double prijsaanbod = Integer.parseInt(prijsaanbodFromParam);

        Product product = prodlijst.vindProduct(naam);


        setHoeveelheid(product, request, errors);
        setPrijsAanbod(product, request,errors);

        if(errors.size() == 0){
            try{
                prodlijst.update(naam, hoeveelheid, prijsaanbod);
                return getBestelling(request, response);
            }catch(DomainException exc){
                errors.add(exc.getMessage());

            }
        }
        request.setAttribute("error", errors);
        return "update.jsp";

    }


    private String getDelete(HttpServletRequest request, HttpServletResponse response) {
        String naam = request.getParameter("naam");
        prodlijst.verwijder(naam);
        return getBestelling(request, response);
    }


    private String getFind(HttpServletRequest request, HttpServletResponse response) {
        String naam = request.getParameter("naam");
        ArrayList<String> errors = new ArrayList<>();
        try {
            Product product = prodlijst.vindProduct(naam);
            request.setAttribute("product", product);
            return "gevonden.jsp";
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
        request.setAttribute("error", errors);
        return "vindproduct.jsp";
    }

    private String getVindProduct(HttpServletRequest request, HttpServletResponse response) {
        return "vindproduct.jsp";
    }

    private String getAdd(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        Product product = new Product();

        setNaam(product, request, errors);
        setHoeveelheid(product, request, errors);
        setPrijsAanbod(product, request, errors);

        if (errors.size() == 0) {
            try {
                prodlijst.voegToe(product);
                return getBestelling(request, response);
            } catch (IllegalArgumentException exc) {
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("error", errors);
        return "winkel.jsp";

    }

    private void setNaam(Product product, HttpServletRequest request, ArrayList<String> errors) {
        String naam = request.getParameter("productnaam");
        try {
            product.setNaam(naam);
            request.setAttribute("productnaamPreviousValue", naam);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setHoeveelheid(Product product, HttpServletRequest request, ArrayList<String> errors) {
        String hoeveelheid = request.getParameter("hoeveelheid");
        try {
            product.setHoeveelheidKilo(Integer.parseInt(hoeveelheid));
            request.setAttribute("hoeveelheidPreviousValue", hoeveelheid);

        } catch (NumberFormatException exc) {
            errors.add("Vul een geldig nummer in (boven 0)");
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setPrijsAanbod(Product product, HttpServletRequest request, ArrayList<String> errors) {
        String prijsAanbod = request.getParameter("prijsaanbod");
        try {
            product.setPrijsAanbieding(Integer.parseInt(prijsAanbod));
            request.setAttribute("prijsAanbodPreviousValue", prijsAanbod);
        } catch (NumberFormatException exc) {
            errors.add("Vul een geldig nummer in (boven 0)");
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    private String getBestelling(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("producten", prodlijst.getProducten());
        String totaalGewicht = "" + prodlijst.totaalGewicht();
        request.setAttribute("totaalGewicht", totaalGewicht);
        String totaalProducten = "" + prodlijst.berekenTotaalProducten();
        request.setAttribute("totaalProducten", totaalProducten);
        String totaalPrijs = "" + prodlijst.totaalPrijs();
        request.setAttribute("totaalPrijs", totaalPrijs);

        return "mijnbestelling.jsp";
    }

    private String getWinkel(HttpServletRequest request, HttpServletResponse response) {

        return "winkel.jsp";
    }

    private String getHome(HttpServletRequest request, HttpServletResponse response) {

        return "index.jsp";
    }
}


