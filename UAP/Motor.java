public class Motor extends Kendaraan {
    private String jenisTransmisi; // "Matik" atau "Manual"

    public Motor(String kodeKendaraan, String namaKendaraan,
                 double hargaSewaPerHari, String jenisTransmisi) {
        super(kodeKendaraan, namaKendaraan, hargaSewaPerHari);
        this.jenisTransmisi = jenisTransmisi;
    }

    public String getJenisTransmisi() { return jenisTransmisi; }

    @Override
    public double hitungBiaya(int lamaSewa) {
        double biayaDasar    = lamaSewa * getHargaSewaPerHari();
        double biayaAsuransi = jenisTransmisi.equalsIgnoreCase("Matik")
                               ? 10000 * lamaSewa
                               : 0;
        return biayaDasar + biayaAsuransi;
    }

    @Override
    public String getInfoTambahan() {
        return String.format("Transmisi: %s", jenisTransmisi);
    }

    @Override
    public String toString() {
        return "[MOTOR] " + super.toString();
    }
}