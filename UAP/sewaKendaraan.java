import java.util.Scanner;

public class sewaKendaraan {

    public static void proses(GoDriveRentalSystem sistem, Scanner scanner)
            throws KendaraanTidakTersediaException {

        System.out.print("Masukkan kode kendaraan yang ingin disewa: ");
        String kode = scanner.nextLine().trim().toUpperCase();

        System.out.print("Masukkan durasi sewa (dalam hari): ");
        int lamaSewa;
        try {
            lamaSewa = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Format durasi tidak valid!");
            return;
        }

        System.out.print("Apakah Anda Member VIP? (y/n): ");
        boolean isVIP = scanner.nextLine().trim().equalsIgnoreCase("y");

        // Cari kendaraan di daftar
        Kendaraan target = null;
        for (Kendaraan k : sistem.getDaftarKendaraan()) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                target = k;
                break;
            }
        }

        // Lempar exception jika tidak ditemukan atau tidak tersedia
        if (target == null || !target.isTersedia()) {
            throw new KendaraanTidakTersediaException(kode);
        }

        // ── Hitung biaya ─────────────────────────────────────────
        double biayaDasar    = lamaSewa * target.getHargaSewaPerHari();
        double totalBiaya    = target.hitungBiaya(lamaSewa);   // polymorphism
        double biayaTambahan = totalBiaya - biayaDasar;

        double diskonVIP  = isVIP         ? totalBiaya * 0.10 : 0;
        double diskonLama = lamaSewa > 7  ? totalBiaya * 0.05 : 0;
        double totalAkhir = totalBiaya - diskonVIP - diskonLama;

        // Ubah status kendaraan menjadi tidak tersedia
        target.setTersedia(false);

        // ── Tampilkan detail transaksi ────────────────────────────
        System.out.println("\n=== TRANSAKSI SEWA GODRIVE ===");
        System.out.println("Kendaraan Berhasil Disewa!");
        System.out.printf("Unit        : %s (%s)%n", target.getNamaKendaraan(), target.getKodeKendaraan());
        System.out.printf("Lama Sewa   : %d hari%n", lamaSewa);
        System.out.printf("Biaya Dasar Harian : Rp %,.0f%n", biayaDasar);

        if (biayaTambahan > 0) {
            if (target instanceof Mobil) {
                System.out.printf("Tambahan Kursi (>5) : Rp %,.0f%n", biayaTambahan);
            } else if (target instanceof Motor) {
                System.out.printf("Biaya Asuransi Matik: Rp %,.0f%n", biayaTambahan);
            }
        }

        if (isVIP)
            System.out.printf("Diskon Member VIP (10%%): -Rp %,.0f%n", diskonVIP);
        if (lamaSewa > 7)
            System.out.printf("Diskon Sewa >7 Hari (5%%): -Rp %,.0f%n", diskonLama);

        System.out.println("--------------------------------------");
        System.out.printf("TOTAL BIAYA AKHIR: Rp %,.0f%n", totalAkhir);
    }
}