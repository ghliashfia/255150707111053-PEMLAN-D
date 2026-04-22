package TugasPraktikum;

class Employee implements Payable {
    private int registrationNumber;
    private String name;
    private int salaryPerMonth;
    private Invoice[] invoices;

    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    @Override
    public double getPayableAmount() {
        double totalBelanja = 0;

        for (Invoice inv : invoices) {
            totalBelanja += inv.getPayableAmount();
        }

        return salaryPerMonth - totalBelanja;
    }

    public void display() {
        System.out.println("No Reg: " + registrationNumber);
        System.out.println("Nama: " + name);
        System.out.println("Gaji: " + salaryPerMonth);

        System.out.println("\n--- Detail Belanja ---");
        for (Invoice inv : invoices) {
            inv.display();
        }

        System.out.println("Gaji setelah potongan: " + getPayableAmount());
    }
}