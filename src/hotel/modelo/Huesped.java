package hotel.modelo;

public class Huesped {

    private int huespedId;

    private int huespedDni;

    private String huespedNombre;

    private String huespedDomicilio;

    private String huespedEmail;

    private String huespedCelular;

    public Huesped() {
    }

    public Huesped(int huespedId, int huespedDni, String huespedNombre, String huespedDomicilio, String huespedEmail, String huespedCelular) {
        this.huespedId = huespedId;
        this.huespedDni = huespedDni;
        this.huespedNombre = huespedNombre;
        this.huespedDomicilio = huespedDomicilio;
        this.huespedEmail = huespedEmail;
        this.huespedCelular = huespedCelular;
    }

    public Huesped(int huespedDni, String huespedNombre, String huespedDomicilio, String huespedEmail, String huespedCelular) {
        this.huespedDni = huespedDni;
        this.huespedNombre = huespedNombre;
        this.huespedDomicilio = huespedDomicilio;
        this.huespedEmail = huespedEmail;
        this.huespedCelular = huespedCelular;
    }

    public int getHuespedId() {
        return huespedId;
    }

    public void setHuespedId(int huespedId) {
        this.huespedId = huespedId;
    }

    public int getHuespedDni() {
        return huespedDni;
    }

    public void setHuespedDni(int huespedDni) {
        this.huespedDni = huespedDni;
    }

    public String getHuespedNombre() {
        return huespedNombre;
    }

    public void setHuespedNombre(String huespedNombre) {
        this.huespedNombre = huespedNombre;
    }

    public String getHuespedDomicilio() {
        return huespedDomicilio;
    }

    public void setHuespedDomicilio(String huespedDomicilio) {
        this.huespedDomicilio = huespedDomicilio;
    }

    public String getHuespedEmail() {
        return huespedEmail;
    }

    public void setHuespedEmail(String huespedEmail) {
        this.huespedEmail = huespedEmail;
    }

    public String getHuespedCelular() {
        return huespedCelular;
    }

    public void setHuespedCelular(String huespedCelular) {
        this.huespedCelular = huespedCelular;
    }

    void add(Huesped huesped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String toString(){
    
        String value = (huespedDni ==0)?huespedNombre:huespedNombre+" - "+huespedDni;
        return  value;
    }
    
}
