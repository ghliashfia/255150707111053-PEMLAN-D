import java.util.Scanner;

public class tambahKendaraan {

    public static void proses(GoDriveRentalSystem sistem, Scanner scanner) {
        System.out.print("Masukkan jenis kendaraan (mobil/motor): ");
        String jenis = scanner.nextLine().trim().toLowerCase();

        System.out.print("Masukkan kode kendaraan: ");
        String kode = scanner.nextLine().trim().toUpperCase();

        // Cek duplikat kode
        for (Kendaraan k : sistem.getDaftarKendaraan()) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                System.out.println("[ERROR] Kode kendaraan " + kode + " sudah ada!");
                return;
            }
        }

        System.out.print("Masukkan nama kendaraan: ");
        String nama = scanner.nextLine().trim();

        System.out.print("Masukkan harga sewa per hari: ");
        double harga;
        try {
            harga = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Format harga tidak valid!");
            return;
        }

        if (jenis.equals("mobil")) {
            System.out.print("Masukkan kapasitas kursi: ");
            try {
                int kursi = Integer.parseInt(scanner.nextLine().trim());
                sistem.getDaftarKendaraan().add(new Mobil(kode, nama, harga, kursi));
                System.out.println("[INFO] Kendaraan berhasil ditambahkan: " + nama + " (" + kode + ")");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Format jumlah kursi tidak valid!");
            }

        } else if (jenis.equals("motor")) {
            System.out.print("Masukkan jenis transmisi (Matik/Manual): ");
            String transmisi = scanner.nextLine().trim();
            sistem.getDaftarKendaraan().add(new Motor(kode, nama, harga, transmisi));
            System.out.println("[INFO] Kendaraan berhasil ditambahkan: " + nama + " (" + kode + ")");

        } else {
            System.out.println("[ERROR] Jenis tidak dikenali. Gunakan 'mobil' atau 'motor'.");
        }
    }
}