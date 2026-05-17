import java.time.LocalDate;
import java.time.Period;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(double gaji, int tahun, int bulan, int hari, int jumlahAnak,
                   String nama, boolean jenisKelamin, String nik, boolean menikah) {
        super(nama, jenisKelamin, nik, menikah);
        this.gaji = gaji;
        this.tahunMasuk = LocalDate.of(tahun, bulan, hari);
        this.jumlahAnak = jumlahAnak;
    }

    public double getBonus() {
        int lamaKerja = 2020 - tahunMasuk.getYear();

        if (lamaKerja <= 5) return 0.05 * gaji;
        else if (lamaKerja <= 10) return 0.10 * gaji;
        else return 0.15 * gaji;
    }

    public double getGaji() {
        return gaji;
    }
    
    @Override
    public double getPendapatan() {
        return gaji + getBonus() + super.getTunjangan() + (jumlahAnak * 20);
    }

    @Override
    public String toString() {
        return super.toString() +
               "\ntahun masuk : " + tahunMasuk.getDayOfMonth() + " " +
               tahunMasuk.getMonthValue() + " " +
               tahunMasuk.getYear() +
               "\njumlah anak : " + jumlahAnak +
               "\ngaji : " + gaji;
        }
}
