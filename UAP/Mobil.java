public class Mobil extends Kendaraan {
    private int jumlahKursi;

    public Mobil(String kodeKendaraan, String namaKendaraan,
                 double hargaSewaPerHari, int jumlahKursi) {
        super(kodeKendaraan, namaKendaraan, hargaSewaPerHari);
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() { return jumlahKursi; }

    @Override
    public double hitungBiaya(int lamaSewa) {
        double biayaDasar    = lamaSewa * getHargaSewaPerHari();
        double biayaTambahan = (jumlahKursi > 5) ? 50000 : 0;
        return biayaDasar + biayaTambahan;
    }

    @Override
    public String getInfoTambahan() {
        return String.format("Kursi: %d", jumlahKursi);
    }

    @Override
    public String toString() {
        return "[MOBIL] " + super.toString();
    }
}