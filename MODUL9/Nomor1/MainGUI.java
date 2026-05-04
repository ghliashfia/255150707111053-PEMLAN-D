import java.awt.*;
import java.awt.event.*;

public class MainGUI extends Frame {

    Label lbJudul, lbTugas, lbKuis, lbUTS, lbUAS, lbHasil;
    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtHasil;
    Button btnHitung, btnTampil;
    TextArea area;

    CheckboxGroup cbg;
    Checkbox cbPemlan, cbASD, cbMatkomlan, cbProbstat;

    double hasilPemlan=0, hasilASD=0, hasilMatkomlan=0, hasilProbstat=0;

    public MainGUI(){
        setLayout(null);

        // biar bisa ditutup
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Judul
        lbJudul = new Label("Hitung Nilai Akhir");
        add(lbJudul);
        lbJudul.setBounds(130, 30, 200, 20);

        // Radio Button
        cbg = new CheckboxGroup();
        cbPemlan = new Checkbox("Pemlan", cbg, true);
        cbASD = new Checkbox("ASD", cbg, false);
        cbMatkomlan = new Checkbox("Matkomlan", cbg, false);
        cbProbstat = new Checkbox("Probstat", cbg, false);

        add(cbPemlan); cbPemlan.setBounds(40, 60, 80, 20);
        add(cbASD); cbASD.setBounds(120, 60, 60, 20);
        add(cbMatkomlan); cbMatkomlan.setBounds(180, 60, 100, 20);
        add(cbProbstat); cbProbstat.setBounds(290, 60, 80, 20);

        // reset field kalau ganti matkul
        ItemListener clear = e -> {
            txtTugas.setText("");
            txtKuis.setText("");
            txtUTS.setText("");
            txtUAS.setText("");
            txtHasil.setText("");
        };

        cbPemlan.addItemListener(clear);
        cbASD.addItemListener(clear);
        cbMatkomlan.addItemListener(clear);
        cbProbstat.addItemListener(clear);

        // Label
        lbTugas = new Label("Tugas"); add(lbTugas); lbTugas.setBounds(100,100,80,20);
        lbKuis = new Label("Kuis"); add(lbKuis); lbKuis.setBounds(100,130,80,20);
        lbUTS = new Label("UTS"); add(lbUTS); lbUTS.setBounds(100,160,80,20);
        lbUAS = new Label("UAS"); add(lbUAS); lbUAS.setBounds(100,190,80,20);
        lbHasil = new Label("Hasil"); add(lbHasil); lbHasil.setBounds(100,220,80,20);

        // TextField
        txtTugas = new TextField(); add(txtTugas); txtTugas.setBounds(200,100,80,20);
        txtKuis = new TextField(); add(txtKuis); txtKuis.setBounds(200,130,80,20);
        txtUTS = new TextField(); add(txtUTS); txtUTS.setBounds(200,160,80,20);
        txtUAS = new TextField(); add(txtUAS); txtUAS.setBounds(200,190,80,20);
        txtHasil = new TextField(); add(txtHasil); txtHasil.setBounds(200,220,80,20);

        // Button
        btnHitung = new Button("Hitung");
        add(btnHitung); btnHitung.setBounds(150, 260, 100, 25);

        btnTampil = new Button("Tampilkan semua");
        add(btnTampil); btnTampil.setBounds(130, 420, 150, 25);

        // TextArea
        area = new TextArea();
        add(area);
        area.setBounds(80, 300, 250, 100);

        // EVENT HITUNG
        btnHitung.addActionListener(e -> {
            double t = Double.parseDouble(txtTugas.getText());
            double k = Double.parseDouble(txtKuis.getText());
            double uts = Double.parseDouble(txtUTS.getText());
            double uas = Double.parseDouble(txtUAS.getText());

            double hasil = 0;

            if (cbPemlan.getState()) {
                hasil = new Pemlan().hitung(t,k,uts,uas);
                hasilPemlan = hasil;
            } 
            else if (cbASD.getState()) {
                hasil = new ASD().hitung(t,k,uts,uas);
                hasilASD = hasil;
            } 
            else if (cbMatkomlan.getState()) {
                hasil = new Matkomlan().hitung(t,k,uts,uas);
                hasilMatkomlan = hasil;
            } 
            else if (cbProbstat.getState()) {
                hasil = new Probstat().hitung(t,k,uts,uas);
                hasilProbstat = hasil;
            }

            txtHasil.setText(String.valueOf(hasil));
        });

        // EVENT TAMPIL SEMUA
        btnTampil.addActionListener(e -> {
            area.setText("HASIL NILAI SEMUA MATA KULIAH\n\n");
            area.append("Pemlan : " + hasilPemlan + "\n");
            area.append("ASD : " + hasilASD + "\n");
            area.append("Matkomlan : " + hasilMatkomlan + "\n");
            area.append("Probstat : " + hasilProbstat + "\n");
        });
    }

    public static void main(String[] args) {
        MainGUI f = new MainGUI();
        f.setSize(420, 500);
        f.setVisible(true);
    }
}