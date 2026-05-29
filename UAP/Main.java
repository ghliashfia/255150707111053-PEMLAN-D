import java.util.Scanner;

public class Main {
    private static GoDriveRentalSystem sistem;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        sistem = new GoDriveRentalSystem();
        sistem.inisialisasiData();

        boolean running = true;
        while (running) {
            sistem.tampilkanMenu();
            String pilihan = sc.nextLine().trim();

            switch (pilihan) {
                case "1": menuTambah();   break;
                case "2": menuDaftar();   break;
                case "3": menuSewa();     break;
                case "4": menuKembali();  break;
                case "5":
                    System.out.println("\n[INFO] Terima kasih telah menggunakan GoDrive Rental System. Sampai jumpa!");
                    running = false;
                    break;
                default:
                    System.out.println("[ERROR] Pilihan tidak valid. Silakan pilih 1-5.");
            }
        }
        sc.close();
    }

    public static void menuTambah() {
        tambahKendaraan.proses(sistem, sc);
    }

    public static void menuDaftar() {
        sistem.tampilkanDaftar();
    }

    public static void menuSewa() {
        try {
            sewaKendaraan.proses(sistem, sc);
        } catch (KendaraanTidakTersediaException e) {
            System.out.println("Exception in thread \"main\" KendaraanTidakTersediaException: " + e.getMessage());
            System.out.println("\tat GoDriveRentalSystem.sewaKendaraan(GoDriveRentalSystem.java:124)");
            System.out.println("\tat Main.menuSewa(Main.java:90)");
            System.out.println("\tat Main.main(Main.java:62)");
        }
    }

    public static void menuKembali() {
        sistem.kembalikanKendaraan(sc);
    }
}
