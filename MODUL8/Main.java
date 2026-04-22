public class Main {
    public static void main(String[] args) {

        Invoice i1 = new Invoice("Buku", 2, 5000);
        Invoice i2 = new Invoice("Pulpen", 3, 2000);

        Invoice[] invoices = {i1, i2};

        Employee emp = new Employee(101, "Ghalia", 5000000, invoices);

        emp.display();
    }
}
