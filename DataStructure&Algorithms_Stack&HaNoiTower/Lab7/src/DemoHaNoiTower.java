public class DemoHaNoiTower {

    public static void main(String[] args) {

        int n = 3;

        haNoiTowwer(n,"A","C","B");

    }

    public static void haNoiTowwer (int n, String A, String C, String B) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + A + " to " + C);
            return;
        }
        haNoiTowwer(n-1,A,B,C);
        System.out.println("Move disk " + n + " from " + A + " to " + C);
        haNoiTowwer(n-1,B,C,A);

    }
}

