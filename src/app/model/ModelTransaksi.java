package app.model;
public class ModelTransaksi {

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the transaksiID
     */
    public int getTransaksiID() {
        return transaksiID;
    }

    /**
     * @param transaksiID the transaksiID to set
     */
    public void setTransaksiID(int transaksiID) {
        this.transaksiID = transaksiID;
    }

    /**
     * @return the cucian
     */
    public ModelCucian getCucian() {
        return cucian;
    }

    /**
     * @param cucian the cucian to set
     */
    public void setCucian(ModelCucian cucian) {
        this.cucian = cucian;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the diskon
     */
    public double getDiskon() {
        return diskon;
    }

    /**
     * @param diskon the diskon to set
     */
    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    /**
     * @return the grandTotal
     */
    public double getGrandTotal() {
        return grandTotal;
    }

    /**
     * @param grandTotal the grandTotal to set
     */
    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
    private int transaksiID;
    private ModelCucian cucian;
    private double subTotal;
    private double diskon;
    private double grandTotal;
    private String status;
    public ModelTransaksi(int transaksiID, ModelCucian cucian,double subTotal,double diskon,double grandTotal,String status){
        this.transaksiID = transaksiID;
        this.cucian = cucian;
        this.subTotal = subTotal;
        this.diskon = diskon;
        this.grandTotal = grandTotal;
        this.status = status;
    }
    public ModelTransaksi(double subTotal,double diskon,double grandTotal,String status){
        this.subTotal = subTotal;
        this.diskon = diskon;
        this.grandTotal = grandTotal;
         this.status = status;
    }
    public ModelTransaksi(){}
}
