package hotel.modelo;

public class TipoCama {

    private int tipoCamaId;

    private String tipoCamaNombre;

    public TipoCama() {
    }

    public TipoCama(int tipoCamaId, String tipoCamaNombre) {
        this.tipoCamaId = tipoCamaId;
        this.tipoCamaNombre = tipoCamaNombre;
    }

    public TipoCama(String tipoCamaNombre) {
        this.tipoCamaNombre = tipoCamaNombre;
    }

    public int getTipoCamaId() {
        return tipoCamaId;
    }

    public void setTipoCamaId(int tipoCamaId) {
        this.tipoCamaId = tipoCamaId;
    }

    public String getTipoCamaNombre() {
        return tipoCamaNombre;
    }

    public void setTipoCamaNombre(String tipoCamaNombre) {
        this.tipoCamaNombre = tipoCamaNombre;
    }
   
}
