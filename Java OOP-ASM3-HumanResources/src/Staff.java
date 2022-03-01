abstract class Staff implements ICalculator {
    private String maNV;
    private String ten;
    private int tuoi;
    private double heSoLuong;
    private String ngayVaoLam;
    private String boPhan;
    private double ngayNghiPhep;

    public Staff(String maNV, String boPhan, String ten, int tuoi, String ngayVaoLam, double heSoLuong, double ngayNghiPhep ){
        this.maNV = maNV;
        this.ten = ten;
        this.tuoi = tuoi;
        this.heSoLuong = heSoLuong;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhan = boPhan;
        this.ngayNghiPhep = ngayNghiPhep;

    }


    abstract void displayInformation ();

    public String getMaNV (){
        return maNV;
    }
    public int getTuoi (){
        return tuoi;
    }
    public double getHeSoLuong (){
        return heSoLuong;
    }
    public String getNgayVaoLam (){
        return ngayVaoLam;
    }
    public double getNgayNghiPhep (){
        return ngayNghiPhep;
    }
    public String getTen (){
        return ten;
    }
    public String getBoPhan (){
        return boPhan;
    }
    public void setMaNV (String maNV){
        this.maNV = maNV;
    }
    public void setTuoi (int tuoi){
        this.tuoi = tuoi;
    }
    public void setHeSoLuong (int heSoLuong){
        this.heSoLuong = heSoLuong;
    }
    public void setNgayVaoLam (String ngayVaoLam){
        this.ngayVaoLam = ngayVaoLam;
    }
    public void setNgayNghiPhep (int ngayNghiPhep){
        this.ngayNghiPhep = ngayNghiPhep;
    }
    public void setTen (String ten){
        this.ten = ten;
    }
    public void setBoPhan (String boPhan){
        this.boPhan = boPhan;
    }
}