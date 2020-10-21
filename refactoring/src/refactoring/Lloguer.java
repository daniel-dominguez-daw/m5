package refactoring;

import java.util.Date;

public class Lloguer {
    private Date data;
    private int dies;
    private Vehicle vehicle;
    
    public Lloguer(Date data, int dies, Vehicle vehicle) {
        this.data = data;
        this.dies = dies;
        this.vehicle = vehicle;
    }
    public Date getData() {
        return data;
    }
    public Vehicle getVehicle() {
        // TODO Auto-generated method stub
        return vehicle;
    }
    public int getDies() {
        return dies;
    }
    
}
