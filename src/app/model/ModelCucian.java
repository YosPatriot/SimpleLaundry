package app.model;

import java.sql.Date;

public class ModelCucian {

    /**
     * @return the estimasi
     */
    public Date getEstimasi() {
        return estimasi;
    }

    /**
     * @param estimasi the estimasi to set
     */
    public void setEstimasi(Date estimasi) {
        this.estimasi = estimasi;
    }

    public int getCucianID() {
        return cucianID;
    }

    public void setCucianID(int cucianID) {
        this.cucianID = cucianID;
    }

    public ModelCustomer getCustomer() {
        return customer;
    }


    public void setCustomer(ModelCustomer customer) {
        this.customer = customer;
    }

    public String getJenisCucian() {
        return jenisCucian;
    }

    public void setJenisCucian(String jenisCucian) {
        this.jenisCucian = jenisCucian;
    }

    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public String getStatus() {
        return status;
    }

 
    public void setStatus(String status) {
        this.status = status;
    }
    public ModelCucian(int cucianID, ModelCustomer customer, String jenisCucian, Date tglMasuk,Date estimasi,int berat, String status){
       this.cucianID = cucianID;
       this.customer = customer;
       this.jenisCucian = jenisCucian;
       this.tglMasuk = tglMasuk;
       this.estimasi = estimasi;
       this.berat = berat;
       this.status = status;
    }
    public ModelCucian(){
    }
    private int cucianID;
    private ModelCustomer customer;
    private String jenisCucian;
    private Date tglMasuk;
    private Date estimasi;
    private int berat;
    private String status;
    
    
}
