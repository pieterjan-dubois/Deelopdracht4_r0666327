package domain.db;

import domain.DomainException;
import domain.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    private ArrayList<Product> producten = new ArrayList<Product>();

    public ProductDB() {
        Product p1 = new Product("kip", 12.00, 50.00);
        Product p2 = new Product("paprika", 0.5, 1.00);
        Product p3 = new Product("rund", 1, 15);
        Product p4 = new Product("bananen", 2.5, 5.5);
        voegToe(p1);
        voegToe(p2);
        voegToe(p3);
        voegToe(p4);
    }



    public void voegToe(Product product){
        if(product == null)
            throw new DomainException("Geen geldige student");
            this.producten.add(product);
    }

    public void update(String naam, double hoeveelheid, double prijsaanbod){
        for(Product p : producten){
            if(p.getNaam().equals(naam)){
                p.setHoeveelheidKilo(hoeveelheid);
                p.setPrijsAanbieding(prijsaanbod);
            }
        }
    }

    public void updatee(String naam){
        for(Product p : producten){
            if(p.getNaam().equals(naam)){
                p.getPrijsAanbieding();
                p.getHoeveelheidKilo();
            }
        }
    }

    public Product vindProduct(String naam){
        for(Product product: producten){
            if(product.heeftNaam(naam)){
                return product;
            }
        }
      throw new DomainException("De naam is niet juist, probeer nog eens");
    }

    public ArrayList<String> vindProductt(String naam){
        ArrayList<String> matches = new ArrayList<>();
        for(Product product: producten){
            if(product.heeftNaam(naam)){
                matches.add(naam);
                return matches;
            }
        }
        return null;
    }

    public ArrayList<Product> getProducten(){
        return producten;
    }

    public int berekenTotaalProducten(){
        int count = 0;
        for(Product p: this.producten){
            count++;
        }
        return count;
    }
    public double totaalGewicht(){
        int total= 0;
        for(Product p : this.producten){
            total += p.getHoeveelheidKilo();
        }
        return total;
    }

    public double totaalPrijs(){
        int total= 0;
        for(Product p: this.producten){
            total += p.getPrijsAanbieding();
        }
        return total;
    }

    public void verwijder (String naam) {
       producten.remove(new Product(naam));
    }


}
