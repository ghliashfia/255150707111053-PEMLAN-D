
import javax.swing.*;
import java.awt.event.*;

public class FormMahasiswa extends JFrame {

    JTextField txtNama, txtTTL, txtNo, txtTelp, txtEmail;
    JTextArea txtAlamat;
    JButton btnSubmit;

    public FormMahasiswa() {
        setTitle("Form Data Mahasiswa");
        setSize(400, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // LABEL + INPUT
        JLabel lbNama = new JLabel("Nama Lengkap");
        lbNama.setBounds(20, 20, 120, 20);
        add(lbNama);

        txtNama = new JTextField();
        txtNama.setBounds(150, 20, 200, 20);
        add(txtNama);

        JLabel lbTTL = new JLabel("Tanggal Lahir");
        lbTTL.setBounds(20, 50, 120, 20);
        add(lbTTL);

        txtTTL = new JTextField();
        txtTTL.setBounds(150, 50, 200, 20);
        add(txtTTL);

        JLabel lbNo = new JLabel("No. Pendaftaran");
        lbNo.setBounds(20, 80, 120, 20);
        add(lbNo);

        txtNo = new JTextField();
        txtNo.setBounds(150, 80, 200, 20);
        add(txtNo);

        JLabel lbTelp = new JLabel("No. Telp");
        lbTelp.setBounds(20, 110, 120, 20);
        add(lbTelp);

        txtTelp = new JTextField();
        txtTelp.setBounds(150, 110, 200, 20);
        add(txtTelp);

        JLabel lbAlamat = new JLabel("Alamat");
        lbAlamat.setBounds(20, 140, 120, 20);
        add(lbAlamat);

        txtAlamat = new JTextArea();
        txtAlamat.setBounds(150, 140, 200, 50);
        add(txtAlamat);

        JLabel lbEmail = new JLabel("E-mail");
        lbEmail.setBounds(20, 200, 120, 20);
        add(lbEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 200, 200, 20);
        add(txtEmail);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(150, 240, 100, 30);
        add(btnSubmit);

        // EVENT SUBMIT
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // VALIDASI
                if (txtNama.getText().isEmpty() ||
                    txtTTL.getText().isEmpty() ||
                    txtNo.getText().isEmpty() ||
                    txtTelp.getText().isEmpty() ||
                    txtAlamat.getText().isEmpty() ||
                    txtEmail.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!");
                } 
                else {
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Apakah data yang Anda isi sudah benar?",
                            "Konfirmasi",
                            JOptionPane.OK_CANCEL_OPTION
                    );

                    // kalau OK → tampilkan data
                    if (confirm == JOptionPane.OK_OPTION) {
                        tampilData();
                    }
                    // kalau cancel → balik ke form (otomatis)
                }
            }
        });

        setVisible(true);
    }

    // WINDOW HASIL
    void tampilData() {
        JFrame hasil = new JFrame("Data Mahasiswa");
        hasil.setSize(350, 300);
        hasil.setLayout(null);

        JTextArea area = new JTextArea();
        area.setBounds(20, 20, 300, 200);

        area.setText(
                "Nama : " + txtNama.getText() + "\n" +
                "Tanggal Lahir : " + txtTTL.getText() + "\n" +
                "No. Pendaftaran : " + txtNo.getText() + "\n" +
                "No. Telp : " + txtTelp.getText() + "\n" +
                "Alamat : " + txtAlamat.getText() + "\n" +
                "E-mail : " + txtEmail.getText()
        );

        hasil.add(area);
        hasil.setVisible(true);
    }

    public static void main(String[] args) {
        new FormMahasiswa();
    }
}
