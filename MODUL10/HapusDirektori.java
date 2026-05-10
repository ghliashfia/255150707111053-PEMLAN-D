import java.io.File;

public class HapusDirektori {
    public static void main(String[] args) {
        File folder = new File("C:/Data/Test");

        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }

        if (folder.delete()) {
            System.out.println("Direktori berhasil dihapus");
        } else {
            System.out.println("Direktori gagal dihapus");
        }
    }
}