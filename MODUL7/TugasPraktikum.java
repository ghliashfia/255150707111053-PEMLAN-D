package TugasPraktikum;

import java.util.ArrayList;
import java.util.Collections;

public class TugasPraktikum {

    public static void main(String[] args) {

        // Data Tim A
        ArrayList<Integer> tinggiA = new ArrayList<Integer>();
        Collections.addAll(tinggiA, 168, 170, 165, 168, 172,
                170, 169, 165, 171, 166);

        ArrayList<Integer> beratA = new ArrayList<Integer>();
        Collections.addAll(beratA, 50, 60, 56, 55, 60,
                70, 66, 56, 72, 56);

        // Data Tim B
        ArrayList<Integer> tinggiB = new ArrayList<Integer>();
        Collections.addAll(tinggiB, 170, 167, 165, 166, 168,
                175, 172, 171, 168, 169);

        ArrayList<Integer> beratB = new ArrayList<Integer>();
        Collections.addAll(beratB, 66, 60, 59, 58, 58,
                71, 68, 68, 65, 60);

        // Sorting Ascending
        Collections.sort(tinggiA);
        Collections.sort(beratA);
        Collections.sort(tinggiB);
        Collections.sort(beratB);

        System.out.println("=== ASCENDING ===");
        System.out.println("Tinggi Tim A : " + tinggiA);
        System.out.println("Berat Tim A  : " + beratA);
        System.out.println("Tinggi Tim B : " + tinggiB);
        System.out.println("Berat Tim B  : " + beratB);

        // Sorting Descending
        Collections.sort(tinggiA, Collections.reverseOrder());
        Collections.sort(beratA, Collections.reverseOrder());
        Collections.sort(tinggiB, Collections.reverseOrder());
        Collections.sort(beratB, Collections.reverseOrder());

        System.out.println("\n=== DESCENDING ===");
        System.out.println("Tinggi Tim A : " + tinggiA);
        System.out.println("Berat Tim A  : " + beratA);
        System.out.println("Tinggi Tim B : " + tinggiB);
        System.out.println("Berat Tim B  : " + beratB);

        // Nilai maksimum dan minimum
        System.out.println("\n=== MAX DAN MIN ===");

        System.out.println("Tinggi maksimum Tim A : "
                + Collections.max(tinggiA));
        System.out.println("Tinggi minimum Tim A  : "
                + Collections.min(tinggiA));

        System.out.println("Berat maksimum Tim A  : "
                + Collections.max(beratA));
        System.out.println("Berat minimum Tim A   : "
                + Collections.min(beratA));

        System.out.println("Tinggi maksimum Tim B : "
                + Collections.max(tinggiB));
        System.out.println("Tinggi minimum Tim B  : "
                + Collections.min(tinggiB));

        System.out.println("Berat maksimum Tim B  : "
                + Collections.max(beratB));
        System.out.println("Berat minimum Tim B   : "
                + Collections.min(beratB));

        // Copy Tim B ke Tim C
        ArrayList<Integer> timC = new ArrayList<Integer>();
        timC.addAll(tinggiB);

        System.out.println("\n=== DATA TIM C ===");
        System.out.println("Data Tim C : " + timC);

        // Binary Search dan Frequency
        Collections.sort(tinggiB);

        int tinggi168 = Collections.frequency(tinggiB, 168);
        int tinggi160 = Collections.frequency(tinggiB, 160);

        System.out.println("\n=== SEARCHING TIM B ===");
        System.out.println("Jumlah pemain tinggi 168 : "
                + tinggi168);
        System.out.println("Jumlah pemain tinggi 160 : "
                + tinggi160);

        Collections.sort(beratA);

        int berat56 = Collections.frequency(beratA, 56);
        int berat53 = Collections.frequency(beratA, 53);

        System.out.println("\n=== SEARCHING TIM A ===");
        System.out.println("Jumlah pemain berat 56 : "
                + berat56);
        System.out.println("Jumlah pemain berat 53 : "
                + berat53);

        // Mengecek data yang sama
        boolean cekTinggi =
                !Collections.disjoint(tinggiA, tinggiB);

        boolean cekBerat =
                !Collections.disjoint(beratA, beratB);

        System.out.println("\n=== PENGECEKAN DATA ===");
        System.out.println("Ada tinggi badan yang sama : "
                + cekTinggi);

        System.out.println("Ada berat badan yang sama  : "
                + cekBerat);
    }
}
