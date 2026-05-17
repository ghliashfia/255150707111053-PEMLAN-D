abstract class Notifikasi {
    abstract void kirim();
}

class SMS extends Notifikasi {
    @Override
    void kirim() {
        System.out.println("Pesan dikirim dari SMS");
    }
}