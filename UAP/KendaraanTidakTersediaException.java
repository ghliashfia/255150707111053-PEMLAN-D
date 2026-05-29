public class KendaraanTidakTersediaException extends Exception {
    public KendaraanTidakTersediaException(String kodeKendaraan) {
        super("Kendaraan dengan kode " + kodeKendaraan +
              " gagal disewa. Alasan: Kendaraan sedang disewa atau tidak ditemukan!");
    }
}