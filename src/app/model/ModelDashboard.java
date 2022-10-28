
package app.model;


public class ModelDashboard {

    /**
     * @return the idCucian
     */
    public int getIdCucian() {
        return idCucian;
    }

    /**
     * @param idCucian the idCucian to set
     */
    public void setIdCucian(int idCucian) {
        this.idCucian = idCucian;
    }



   
    public String getNama() {
        return nama;
    }


    public void setNama(String nama) {
        this.nama = nama;
    }


    public String getNoHp() {
        return noHp;
    }

    
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }


    public String getAlamat() {
        return alamat;
    }


    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
    private int idCucian;
    private String nama;
    private String noHp;
    private String alamat;
    private String status;
    
    public ModelDashboard(int idCucian,String nama, String noHp, String alamat, String status) {
        this.idCucian=idCucian;
        this.nama=nama;
        this.noHp=noHp;
        this.alamat=alamat;
        this.status=status;
    }
    public ModelDashboard(){
    }
 
}
