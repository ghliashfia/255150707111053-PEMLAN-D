public class Main {
    public static void main(String[] args) {

        Kue[] kueArray = new Kue[20];

        // isi array
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                kueArray[i] = new KuePesanan("KuePesanan" + i, 10000, i + 1);
            } else {
                kueArray[i] = new KueJadi("KueJadi" + i, 8000, i + 2);
            }
        }

        double totalHarga = 0;
        double totalHargaPesanan = 0, totalBerat = 0;
        double totalHargaJadi = 0, totalJumlah = 0;

        Kue kueTermahal = kueArray[0];

        for (Kue k : kueArray) {
            System.out.println(k);
            double hargaAkhir = k.hitungHarga();
            System.out.println("Harga Akhir: " + hargaAkhir);

            totalHarga += hargaAkhir;

            if (k instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) k;
                totalHargaPesanan += hargaAkhir;
                totalBerat += kp.getBerat();
            } else if (k instanceof KueJadi) {
                KueJadi kj = (KueJadi) k;
                totalHargaJadi += hargaAkhir;
                totalJumlah += kj.getJumlah();
            }

            if (hargaAkhir > kueTermahal.hitungHarga()) {
                kueTermahal = k;
            }
        }

        System.out.println("\nTotal Harga Semua Kue: " + totalHarga);
        System.out.println("Total Harga KuePesanan: " + totalHargaPesanan);
        System.out.println("Total Berat KuePesanan: " + totalBerat);
        System.out.println("Total Harga KueJadi: " + totalHargaJadi);
        System.out.println("Total Jumlah KueJadi: " + totalJumlah);

        System.out.println("\nKue Termahal:");
        System.out.println(kueTermahal);
        System.out.println("Harga Akhir: " + kueTermahal.hitungHarga());
    }
}