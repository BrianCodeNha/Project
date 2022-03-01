public class Manager extends Staff {
    private String title;

    public Manager(String maNV, String boPhan, String ten, int tuoi, String ngayVaoLam, double heSoLuong, double ngayNghiPhep, String title ){
        super( maNV, boPhan, ten,  tuoi,  ngayVaoLam, heSoLuong, ngayNghiPhep);
        this.title = title;
    }


    public void setTitle (String title){
        this.title = title;
    }

    public String getTitle (){
        return title;
    }
    public void displayInformation(){
        System.out.println("Mã nhân viên: " + getMaNV() + ", Bộ Phận: " + getBoPhan() + ", Chức danh: " + getTitle() + ", Tên: " + getTen() + ", Tuổi: " + getTuoi() + ", Ngày vào làm: " + getNgayVaoLam() + ", Hệ số lương: " + getHeSoLuong());
    }

    public double calculateSalary(){
        double luongTN = 0;
        switch (title){
            case "Business-Leader":
                luongTN = 8000000;
                break;
            case "Project-Leader":
                luongTN = 5000000;
                break;
            case "Technical-Leader":
                luongTN = 6000000;
                break;
        }
        return super.getHeSoLuong()*3000000 + luongTN ;
    }
}
