
package app.model;


public class ModelPegawai {

    
    public int getPegawaiID() {
        return pegawaiID;
    }

   
    public void setPegawaiID(int pegawaiID) {
        this.pegawaiID = pegawaiID;
    }

  
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   
    public String getPassword() {
        return password;
    }

   
    public void setPassword(String password) {
        this.password = password;
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

   
    public String getNoHp() {
        return noHp;
    }

   
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    
    public String getEmail() {
        return email;
    }

   
    public void setEmail(String email) {
        this.email = email;
    }


    public String getJabatan() {
        return jabatan;
    }

   
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

  
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    public ModelPegawai(){ 
    }
    public ModelPegawai(int pegawaiID, String nama, String alamat, String noHp,String email,String jabatan){
        this.pegawaiID=pegawaiID;
        this.nama=nama;
        this.alamat=alamat;
        this.noHp = noHp;
        this.email=email;
        this.jabatan=jabatan;
    }
    private int pegawaiID;
    private String username;
    private String password;
    private String nama;
    private String alamat;
    private String noHp;
    private String email;
    private String jabatan;
    private int userID;
}
