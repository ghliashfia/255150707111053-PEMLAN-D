import java.io.File;

public class UkuranFile {
    public static void main(String[] args) {
        File file = new File("test.txt");

        long ukuran = file.length();
        double kb = ukuran / 1024.0;
        double mb = ukuran / (1024.0 * 1024.0);

        if (mb >= 1) {
            System.out.printf("Ukuran file: %.2f MB", mb);
        } else {
            System.out.printf("Ukuran file: %.2f KB", kb);
        }
    }
}
