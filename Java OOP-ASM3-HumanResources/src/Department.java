public class Department {
    private String maBP;
    private String tenBP;
    private int crNumEm;

    public Department  (String maBP, String tenBP, int crNumEm){
        this.maBP = maBP;
        this.tenBP = tenBP;
        this.crNumEm = crNumEm;
    }

    public void setMaBP(String maBP){
        this.maBP = maBP;
    }

    public void setTenBP(String tenBP){
        this.tenBP = tenBP;
    }

    public void setCrNumEm (int crNumEm){
        this.crNumEm = crNumEm;
    }

    public String getMaBP (){
        return maBP;
    }

    public String getTenBP (){
        return tenBP;
    }

    public int getCrNumEm (){
        return crNumEm;
    }
    public String toString (){
        return "Mã Bộ Phận: " + getMaBP() + ",Tên Bộ Phận: " + getMaBP() + ",Số lượng NV hiện tại: " + getCrNumEm()  ;
    }

}
