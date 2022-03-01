import java.util.ArrayList;
import java.util.Scanner;

public class HumanResources {
    public static ArrayList<Employee> eList = new ArrayList <>();
    public static ArrayList<Manager> mList = new ArrayList<>();
    public static ArrayList<Department> dList = new ArrayList<>();
    public static ArrayList<Staff> tList = new ArrayList<>();



    public static String yn = "";

    public static void main(String[] args) {

        DS ();
        luaChonChucNang ();
    }

    // Đưa danh sách NV ban đầu vào
    public static void DS (){
        Employee n1 = new Employee("001", "MKT","Trung",25,"20/11/2021",1,0,10);

        Employee n2 = new Employee("002", "KD","Thang",30,"20/11/2021",2,1,15);

        Employee n3 = new Employee("003", "CSKH","Ha",22,"20/11/2021",2,0,3);

        Manager m1 = new Manager("004","MKT","Tu",35,"25/11/2021",3,1,"Project Leader");

        Manager m2 = new Manager("005","KD","Xuong",35,"25/01/2021",3,1,"Business Leader");

        Department d1 = new Department("MKT", "Maketing",2);

        Department d2 = new Department("KD", "Kinh Doanh",2);

        Department d3 = new Department("CSKH", "Chăm Sóc Khách Hàng",1);

        eList.add(n1); eList.add(n2); eList.add(n3);
        mList.add(m1);mList.add(m2);
        dList.add(d1); dList.add(d2); dList.add(d3);
        tList.addAll(eList);
        tList.addAll(mList);
    }

    // Hiện thị Bảng Điều Khiển

    public static void luaChonChucNang (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Xin chào! Đây là những việc tôi có thê thực hiện:");

        while (yn.equals("") || yn.equals("1")){
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty.");
        System.out.println("2. Hiển thị các bộ phận trong công ty.");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
        System.out.println("4. Thêm nhân viên mới vào công ty.");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty.");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
        System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần.");
        System.out.println();
        System.out.print("Bạn cần tôi giúp gì nào (1-8)?: ");
        int choose = sc.nextInt();
        while (choose <1 || choose > 8){
            System.out.print("Chức năng bạn yêu cầu hiện không có, vui lòng nhập 1-8, xin cảm ơn: ");
            choose = sc.nextInt();
        }



            switch (choose){
                case 1: hienThiDsNhanSu (); break;
                case 2: hienThiDsBoPhan (); break;
                case 3: hienThiDsTheoBP (); break;
                case 4: themNVMoi (); break;
                case 5: timNVTheoTen (); break;
                case 6: displayLuongToanCty (); break;
                case 7: displayLuongToanCtyTangDan (); break;
                case 8: displayLuongToanCtyGiamDan (); break;
            }
            System.out.println();
            System.out.print("Bạn có muốn thực hiện chức năng khác (1: yes, other: no)? ");
            yn = sc.next();
            System.out.println();
        }
        if (!yn.equals("") || !yn.equals("1")) {System.out.println("Tạm biệt! Cảm ơn bạn! ^^ ");}

    }
    //   1. Hiển thị danh sách nhân viên hiện có trong công ty

    public static void hienThiDsNhanSu (){
        System.out.println();
        System.out.println("DANH SÁCH TOÀN BỘ NHÂN SỰ");
        System.out.println();
        for (int i = 0; i<tList.size(); i++){
            tList.get(i).displayInformation();
        }

    }

    //   2. Hiển thị các bộ phận trong công ty

    public static void hienThiDsBoPhan (){

        System.out.println();
        System.out.println("DANH SÁCH CÁC PHÒNG BAN: "  );
        System.out.println();

        for (int i = 0; i<dList.size(); i++){
            System.out.println(dList.get(i).toString());

        }
        System.out.println();
    }

    //   3. Hiển thị các nhân viên theo từng bộ phận

    public static void hienThiDsTheoBP (){

        Scanner sc = new Scanner(System.in);
        System.out.print("Hãy nhập bộ phận bạn muốn hiện thị DS Nhân Viên (MKT - KD - CSKH): ");
        String maBP = sc.next();

        System.out.println();
        System.out.println("DANH SÁCH CÁC BỘ PHẬN: " + maBP );
        System.out.println();

        for (int i = 0; i<tList.size(); i++){
            if(tList.get(i).getBoPhan().equals(maBP)){
                tList.get(i).displayInformation();
            }
        }


    }
    //   4. Thêm nhân viên mới vào công ty: bao gồm 2 loại

    public static void themNVMoi (){

        System.out.println();
        System.out.println("THÊM MỚI NHÂN VIÊN: " );
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("Bạn muốn nhật thông tin của vị trí nào (1: Manager - 2: Nhân viên): ");
        String me = sc.next();
        while (!me.equals("1") && !me.equals("2")){
            System.out.print("Bạn vui lòng nhập lại thông tin theo yêu cầu (1: Manager - 2: Nhân viên) ");
            me = sc.next();
        }

        //   - Thêm nhân viên là cấp quản lý (có thêm chức vụ)

        if( me.equals("1")){

            System.out.println();
            System.out.println("THÊM VỊ TRÍ QUẢN LÝ: ");
            System.out.println();

            Manager a = new Manager("000","","",0,"",0,0,"");
            System.out.print("Mã nhân viên mới (nhập theo mẫu: 00X)? ");
            a.setMaNV(sc.next());
            System.out.print("Nhân viên mới thuộc bộ phận nào (nhập: MKT - KD - CSKH)? ");
            String maBPN = sc.next();
            a.setBoPhan(maBPN);
            for (int i = 0; i<dList.size(); i++){
                if(dList.get(i).getMaBP().equals(maBPN)  ){
                    dList.get(i).setCrNumEm(dList.get(i).getCrNumEm()+1);
                }
            }
            System.out.print("Nhập tên NV: ");
            String ten1 = sc.next();
            a.setTen(ten1);
            System.out.print("Nhập tuổi NV: ");
            a.setTuoi(sc.nextInt());
            System.out.print("Nhập ngày vào làm (dd/mm/yyyy): ");
            a.setNgayVaoLam(sc.next());
            System.out.print("Nhập hệ số lương: ");
            a.setHeSoLuong(sc.nextInt());
            System.out.print("Nhập ngày nghỉ phép: ");
            a.setNgayNghiPhep(sc.nextInt());

            System.out.print("Nhập chức danh (Business-Leader/ Project-Leader/ Technical-Leader): ");
            String titleN = sc.next();
            while (!titleN.equals("Business-Leader") && !titleN.equals("Project-Leader")  && !titleN.equals("Technical-Leader")){
                System.out.print("Bạn vui lòng nhập lại thông tin theo yêu cầu (Business Leader/ Project Leader/ Technical Leader) ");
                titleN = sc.next();
            }
            a.setTitle(titleN);
            tList.add(a);
            System.out.print("Bạn đã thêm mới Nhân Viên: " + ten1);


        }
        //   - Thêm nhân viên thông thường

        else {
            System.out.println();
            System.out.println("THÊM VỊ TRÍ NHÂN VIÊN: ");
            System.out.println();

            Employee a = new Employee("000","","",0,"",0,0,0);
            System.out.print("Mã nhân viên mới (nhập theo mẫu: 00X)? ");
            a.setMaNV(sc.next());
            System.out.print("Nhân viên mới thuộc bộ phận nào (nhập: MKT - KD - CSKH)? ");
            String maBPN = sc.next();
            a.setBoPhan(maBPN);
            for (int i = 0; i<dList.size(); i++){
                if(dList.get(i).getMaBP().equals(maBPN)){
                    dList.get(i).setCrNumEm(dList.get(i).getCrNumEm()+1);
                }
            }
            System.out.print("Nhập tên NV: ");
            String ten = sc.next();
            a.setTen(ten);
            System.out.print("Nhập tuổi NV: ");
            a.setTuoi(sc.nextInt());
            System.out.print("Nhập ngày vào làm (dd/mm/yyyy): ");
            a.setNgayVaoLam(sc.next());
            System.out.print("Nhập hệ số lương: ");
            a.setHeSoLuong(sc.nextInt());
            System.out.print("Nhập ngày nghỉ phép: ");
            a.setNgayNghiPhep(sc.nextInt());
            tList.add(a);
            System.out.print("Bạn đã thêm mới Nhân Viên: " + ten);

        }
    }

    //   5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên

    public static void timNVTheoTen (){
        String tf = "";
        int total = tList.size();

        while (tf.equals("")||tf.equals("1")){
            int current = 0;
            System.out.println();
            System.out.print("TÌM THÔNG TIN NHÂN VIÊN THEO TÊN: ");
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            System.out.println();


            for (int i = 0; i<tList.size(); i++){
                if(tList.get(i).getTen().equals(name)) {
                    tList.get(i).displayInformation();
                } else {
                    current ++;
                }
            }


            if (current == total){
                System.out.println("Thông tin tên bạn cần tìm không tìm thấy trong danh sách nhân viên! ");
            }
            System.out.print("Bạn có muốn tiếp tục tìm thông tin Nhân Viên khác (có: 1 - không: 2)? ");
            tf = sc.next();
        }
    }


    //   6. Hiển thị bảng lương của nhân viên toàn công ty

    public static void displayLuongToanCty (){

        System.out.println();
        System.out.println("BẢNG LƯƠNG TỔNG TOÀN CÔNG TY: ");
        System.out.println();

        for (int i = 0; i<tList.size(); i++){
           System.out.println("Tên Nhân viên: " + tList.get(i).getTen() + " ,Lương tháng hiện tại: " + tList.get(i).calculateSalary()) ;
        }


    }

    //   7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần

    public static void displayLuongToanCtyTangDan (){

        System.out.println();
        System.out.println("BẢNG LƯƠNG TỔNG THEO THỨ TỰ TĂNG DẦN: ");
        System.out.println();

        for (int i = 0; i<tList.size(); i++){

            for (int j = i + 1 ; j < tList.size(); j++){
                double a = tList.get(i).calculateSalary();
                double b = tList.get(j).calculateSalary();
                if(a > b){
                    Staff temp = tList.get(j);
                    tList.remove(j);
                    tList.add(i,temp);
                }
            }

        }

        for (Staff staff :tList) {
            System.out.println("Tên Nhân viên: " + staff.getTen() + " ,Bộ Phận: " + staff.getBoPhan() + " Lương tháng hiện tại: " + staff.calculateSalary());
        }

    }

    //   8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần


    public static void displayLuongToanCtyGiamDan (){

        System.out.println();
        System.out.println("BẢNG LƯƠNG TỔNG THEO THỨ TỰ GIẢM DẦN: ");
        System.out.println();

        for (int i = 0; i<tList.size(); i++){

            for (int j = i + 1 ; j < tList.size(); j++){
                double a = tList.get(i).calculateSalary();
                double b = tList.get(j).calculateSalary();
                if(a < b){
                    Staff temp = tList.get(j);
                    tList.remove(j);
                    tList.add(i,temp);
                }
            }

        }

        for (Staff staff : tList) {
            System.out.println("Tên NV: " + staff.getTen() + " ,Bộ Phận: " + staff.getBoPhan() + " ,Lương tháng hiện tại: " + staff.calculateSalary());
        }

    }
}
