public abstract class Kendaraan {
    private String kodeKendaraan;
    private String namaKendaraan;
    private double hargaSewaPerHari;
    private boolean tersedia;

    public Kendaraan(String kodeKendaraan, String namaKendaraan, double hargaSewaPerHari) {
        this.kodeKendaraan    = kodeKendaraan;
        this.namaKendaraan    = namaKendaraan;
        this.hargaSewaPerHari = hargaSewaPerHari;
        this.tersedia         = true;
    }

    // ── Getters ──────────────────────────────────────────────────
    public String  getKodeKendaraan()    { return kodeKendaraan; }
    public String  getNamaKendaraan()    { return namaKendaraan; }
    public double  getHargaSewaPerHari() { return hargaSewaPerHari; }
    public boolean isTersedia()           { return tersedia; }

    // ── Setter ───────────────────────────────────────────────────
    public void setTersedia(boolean tersedia) { this.tersedia = tersedia; }

    // ── Abstract Methods (wajib di-override subclass) ────────────
    public abstract double hitungBiaya(int lamaSewa);
    public abstract String getInfoTambahan();

    @Override
    public String toString() {
        return String.format(
            "Kode: %s | Nama: %-20s | %s | Tarif: Rp%,.0f/hari | Status: %s",
            kodeKendaraan,
            namaKendaraan,
            getInfoTambahan(),
            hargaSewaPerHari,
            tersedia ? "Tersedia" : "Tidak Tersedia"
        );
    }
}