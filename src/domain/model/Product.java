package domain.model;

import domain.DomainException;

public class Product {

    private String naam;
    private double hoeveelheidKilo;
    private double prijsAanbieding;

    public Product(String naam, double hoeveelheidKilo, double prijsAanbieding) {
        this.setNaam(naam);
        this.setHoeveelheidKilo(hoeveelheidKilo);
        this.setPrijsAanbieding(prijsAanbieding);
    }

    public Product(String naam) {
        this.setNaam(naam);
    }

    public Product(){

    }

    public Product(double hoeveelheidKilo, double prijsAanbieding){
        this.setHoeveelheidKilo(hoeveelheidKilo);
        this.setPrijsAanbieding(prijsAanbieding);
    }

    public boolean equals (Object o) {
        if (o instanceof Product) {
            return this.getNaam().equals(((Product)o).getNaam());
        }
        return false;
    }

    public static boolean isValidString(String input) {
        return (input != null) && !(input.trim().isEmpty());
    }
    public String getNaam() {
        return naam;
    }

    public double getHoeveelheidKilo() {
        return hoeveelheidKilo;
    }

    public double getPrijsAanbieding() {
        return prijsAanbieding;
    }

    public void setNaam(String naam) {
        if (isValidString(naam))
            this.naam = naam;
        else throw new DomainException("No valid name");
    }


    public void setHoeveelheidKilo(double hoeveelheidKilo) {
        if(hoeveelheidKilo <= 0){
            throw new DomainException("Hoeveelheid moet groter zijn dan nul.");
        }else{
            this.hoeveelheidKilo = hoeveelheidKilo;
        }
    }

    public void setPrijsAanbieding(double prijsAanbieding) {
        if(prijsAanbieding <= 0){
            throw new DomainException("Prijsaanbieding moet groter zijn dan nul.");
        }else{
            this.prijsAanbieding = prijsAanbieding;
        }
}
    public boolean heeftNaam(String naam) {
        return naam.equals(this.getNaam());
    }

}
