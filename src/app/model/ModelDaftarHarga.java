
package app.model;

public class ModelDaftarHarga {

    public int getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(int idJenis) {
        this.idJenis = idJenis;
    }

    public String getJenisCuci() {
        return jenisCuci;
    }

    public void setJenisCuci(String jenisCuci) {
        this.jenisCuci = jenisCuci;
    }
    public int getHarga() {
        return harga;
    }
    public void setHarga(int harga) {
        this.harga = harga;
    }
   private int idJenis;
   private String jenisCuci;
   private int harga; 
   
   public ModelDaftarHarga(int idJenis,String jenisCuci, int harga){
       this.idJenis=idJenis;
       this.jenisCuci=jenisCuci;
       this.harga=harga;
   }
   public ModelDaftarHarga(){
   }
}
