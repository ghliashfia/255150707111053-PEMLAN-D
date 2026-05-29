import java.util.ArrayList;
import java.util.Scanner;

public class GoDriveRentalSystem {
    private ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();

    // ── Data awal (preloaded) ────────────────────────────────────
    public void inisialisasiData() {
        daftarKendaraan.add(new Mobil("MBL01", "Toyota Avanza",   350000, 7));
        daftarKendaraan.add(new Mobil("MBL02", "Daihatsu Sigra",  300000, 7));
        daftarKendaraan.add(new Mobil("MBL03", "Honda Brio",      280000, 5));
        daftarKendaraan.add(new Motor("MTR01", "Honda Vario",      80000, "Matik"));
        daftarKendaraan.add(new Motor("MTR02", "Yamaha NMAX",     100000, "Matik"));
        daftarKendaraan.add(new Motor("MTR03", "Kawasaki KLX",     90000, "Manual"));
    }

    // ── Getter daftar (dipakai tambahKendaraan & sewaKendaraan) ──
    public ArrayList<Kendaraan> getDaftarKendaraan() {
        return daftarKendaraan;
    }

    // ── Tampilkan menu ───────────────────────────────────────────
    public void tampilkanMenu() {
        System.out.println("\n====== MENU GO DRIVE RENTAL SYSTEM ======");
        System.out.println("1. Tambah Kendaraan");
        System.out.println("2. Tampilkan Daftar Armada");
        System.out.println("3. Sewa Kendaraan");
        System.out.println("4. Kembalikan Kendaraan");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
    }

    // ── Tampilkan daftar ─────────────────────────────────────────
    public void tampilkanDaftar() {
        System.out.println("\n=== DAFTAR ARMADA GODRIVE ===");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("[INFO] Belum ada kendaraan terdaftar.");
            return;
        }
        int no = 1;
        for (Kendaraan k : daftarKendaraan) {
            System.out.println(no++ + ". " + k.toString());
        }
    }

    // ── Kembalikan kendaraan ──────────────────────────────────────
    public void kembalikanKendaraan(Scanner scanner) {
        System.out.print("Masukkan kode kendaraan yang ingin dikembalikan: ");
        String kode = scanner.nextLine().trim().toUpperCase();

        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                if (k.isTersedia()) {
                    System.out.println("[INFO] Kendaraan " + k.getNamaKendaraan()
                        + " (" + kode + ") tidak sedang disewa.");
                } else {
                    k.setTersedia(true);
                    System.out.println("[INFO] Kendaraan " + k.getNamaKendaraan()
                        + " (" + kode + ") berhasil dikembalikan. Status: Tersedia.");
                }
                return;
            }
        }
        System.out.println("[ERROR] Kendaraan dengan kode " + kode + " tidak ditemukan.");
    }
}