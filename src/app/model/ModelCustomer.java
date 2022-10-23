package app.model;

public class ModelCustomer {

    /**
     * @return the MemberID
     */
    public int getMemberID() {
        return MemberID;
    }

    /**
     * @param MemberID the MemberID to set
     */
    public void setMemberID(int MemberID) {
        this.MemberID = MemberID;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getNoHP() {
        return noHP;
    }
    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    private int MemberID;
    private String nama;
    private String alamat;
    private String noHP;
    public ModelCustomer(int MemberID,String nama, String alamat, String noHP){ 
        this.MemberID = MemberID;
        this.nama = nama;
        this.alamat = alamat;
        this.noHP = noHP;
    }
    public ModelCustomer(){
    }
}
