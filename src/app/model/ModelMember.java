package app.model;

public class ModelMember {

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

    public int getKodeMember() {
        return kodeMember;
    }

    public void setKodeMember(int kodeMember) {
        this.kodeMember = kodeMember;
    }
    private int MemberID;
    private String nama;
    private String alamat;
    private String noHP;
    private int kodeMember;
    public ModelMember(int MemberID,String nama, String alamat, String noHP){ 
        this.MemberID = MemberID;
        this.nama = nama;
        this.alamat = alamat;
        this.noHP = noHP;
        this.kodeMember = kodeMember;
    }
    public ModelMember(){
    }
}
