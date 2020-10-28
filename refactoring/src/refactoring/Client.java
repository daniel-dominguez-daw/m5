package refactoring;
import java.util.Vector;

public class Client {
    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }


    public String informe() {
        return composaCapsalera() +
                composaDetall() +
                composaPeu();
    }
    
    public String informeHTML() {
        return composaCapsaleraHTML() +
                composaDetallHTML() +
                composaPeuHTML();
    }
    
    private String composaCapsaleraHTML() {
        return "<h1>Informe de lloguers</h1" +
                "<p>Informe de lloguers del client <em>" + getNom() +
                "</em> (<strong>" + getNif() + "</strong>)</p>";
    }
    
    private String composaDetallHTML() {
        String resultat = "<table>" + 
                "<tr><td><strong>Marca</strong></td>" +
                "<tr><td><strong>Model</strong></td>" +
                "<tr><td><strong>Import</strong></td></tr>";
                
        for (Lloguer lloguer: lloguers) {
            // composa els resultats d'aquest lloguer
            resultat += "<tr><td>" +
                lloguer.getVehicle().getMarca() + "</td><td>" +
                " " +
                lloguer.getVehicle().getModel()  + "</td><td>" +
                (lloguer.quantitat() * 30) + "€"  + "</td><td></tr>";
        }
        
        return resultat + "</table>";
    }
    
    private String composaPeuHTML() {
        return "<p>Import a pagar: <em>" + importeTotal() + "€</em></p>" +
                "</em> (<strong>" + getNif() + "</strong>)</p>";
    }
    
    private String composaCapsalera() {
        String resultat = "Informe de lloguers del client " +
                getNom() +
                " (" + getNif() + ")\n";
        return resultat;
    }
    
    private String composaDetall() {
        String resultat = "";
        for (Lloguer lloguer: lloguers) {
            // composa els resultats d'aquest lloguer
            resultat += "\t" +
                lloguer.getVehicle().getMarca() +
                " " +
                lloguer.getVehicle().getModel() + ": " +
                (lloguer.quantitat() * 30) + "€" + "\n";
        }
        return resultat;
    }
    
    private String composaPeu() {
        // afegeix informació final
        String resultat = "Import a pagar: " + importeTotal() + "€\n" +
            "Punts guanyats: " + bonificacionsTotal() + "\n";
        return resultat;
    }
    public double bonificacionsTotal() {
        double bonificacions = 0;
        for (Lloguer lloguer: lloguers) {
            bonificacions += lloguer.bonificacions();
        }
        return bonificacions;
    }
    
    public double importeTotal() {
        double total = 0;
        for (Lloguer lloguer: lloguers) {
            total += lloguer.quantitat() * 30;
        }
        return total;
    }
}