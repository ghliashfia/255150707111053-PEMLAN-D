import java.io.File;

public class ListFile {
    public static void main(String[] args) {
        File folder = new File("C:/Data");

        String[] daftarFile = folder.list();

        if (daftarFile != null) {
            for (String nama : daftarFile) {
                System.out.println(nama);
            }
        } else {
            System.out.println("Direktori tidak ditemukan");
        }
    }
}