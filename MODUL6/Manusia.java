public class Manusia {
    private String nama;
    private boolean jenisKelamin;
    private String nik;
    private boolean menikah;

    public Manusia() {}

    public Manusia(String nama, boolean jenisKelamin, String nik, boolean menikah){
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.nik = nik;
        this.menikah = menikah;
    }

    public double getTunjangan() {
        if (menikah) {
            if (jenisKelamin) return 25;
            else return 20;
        } else {
            return 15;
        }
    }

    public double getPendapatan() {
        return getTunjangan();
    }

    public String getNik() {
        return nik;
    }

    @Override
    public String toString() {
        return "nama : " + nama + "\nnik : " + nik + "\njenisKelamin : " + (jenisKelamin ? "Laki-laki" : "Perempuan") + "\npendapatan : " + getPendapatan();
    }
}
