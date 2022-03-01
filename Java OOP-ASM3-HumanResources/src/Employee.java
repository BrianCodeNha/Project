 public class Employee extends Staff {
    private double gioLamThem;

    public Employee(String maNV, String boPhan, String ten, int tuoi, String ngayVaoLam, double heSoLuong, double ngayNghiPhep, double gioLamThem ){
        super( maNV, boPhan, ten,  tuoi,  ngayVaoLam, heSoLuong, ngayNghiPhep);
        this.gioLamThem = gioLamThem;
    }

    public void setGioLamThem (double gioLamThem){
        this.gioLamThem = gioLamThem;
    }

    public double getGioLamThem (){
        return gioLamThem;
    }

    public double calculateSalary (){

        return  super.getHeSoLuong()*3000000 + gioLamThem*200000;
    }

     public void displayInformation(){
        System.out.println("Mã nhân viên: " + getMaNV() + ", Bộ Phận: " + getBoPhan() + ", Tên: " + getTen() + ", Tuổi: " + getTuoi() + ", Ngày vào làm: " + getNgayVaoLam() + ", Hệ số lương: " + getHeSoLuong());
     }
}
