import java.util.Scanner;

public class BankQueue {
    private static final int MAX_SIZE = 10;
    private static String[] queue1 = new String[MAX_SIZE];
    private static String[] queue2 = new String[MAX_SIZE];
    private static int front1 = -1, rear1 = -1;
    private static int front2 = -1, rear2 = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Tambah Data Antrian");
            System.out.println("2. Hapus Antrian Elemen Pertama");
            System.out.println("3. Hapus Antrian di Posisi Tertentu");
            System.out.println("4. Hapus Semua Elemen");
            System.out.println("5. Tampilkan Data");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    enqueue(scanner);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    delete(scanner);
                    break;
                case 4:
                    clear();
                    break;
                case 5:
                    display();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 0);
    }

    private static void enqueue(Scanner scanner) {
        System.out.print("Masukkan nama: ");
        String name = scanner.next();
        System.out.print("Masukkan nomor antrian (1/2): ");
        int queueNumber = scanner.nextInt();
        if (queueNumber == 1) {
            if (rear1 == MAX_SIZE - 1) {
                System.out.println("Antrian penuh!");
            } else {
                if (front1 == -1) {
                    front1 = 0;
                }
                rear1++;
                queue1[rear1] = name;
                System.out.println("Data berhasil ditambahkan ke antrian 1.");
            }
        } else if (queueNumber == 2) {
            if (rear2 == MAX_SIZE - 1) {
                System.out.println("Antrian penuh!");
            } else {
                if (front2 == -1) {
                    front2 = 0;
                }
                rear2++;
                queue2[rear2] = name;
                System.out.println("Data berhasil ditambahkan ke antrian 2.");
            }
        } else {
            System.out.println("Nomor antrian tidak valid!");
        }
    }

    private static void dequeue() {
        if (front1 == -1 && front2 == -1) {
            System.out.println("Antrian kosong!");
        } else {
            if (front1 != -1) {
                System.out.println("Data " + queue1[front1] + " dihapus dari antrian 1.");
                queue1[front1] = null;
                if (front1 == rear1) {
                    front1 = -1;
                    rear1 = -1;
                } else {
                    front1++;
                }
            } else {
                System.out.println("Data " + queue2[front2] + " dihapus dari antrian 2.");
                queue2[front2] = null;
                if (front2 == rear2) {
                    front2 = -1;
                    rear2 = -1;
                } else {
                    front2++;
                }
            }
        }
    }

    private static void delete(Scanner scanner) {
        System.out.print("Masukkan nomor antrian (1/2): ");
        int queueNumber = scanner.nextInt();
        System.out.print("Masukkan posisi data yang akan dihapus: ");
        int position = scanner.nextInt() - 1;
        if (queueNumber == 1) {
            if (position < front1 || position > rear1) {
                System.out.println("Posisi tidak valid!");
            } else {
                System.out.println("Data " + queue1[position] + " dihapus dari antrian 1.");
                for (int i = position; i < rear1; i++) {
                    queue1[i] = queue1[i + 1];
                }
                queue1[rear1] = null;
                rear1--;
                  if (front1 > rear1) {
                    front1 = -1;
                    rear1 = -1;
                }
            }
        } else if (queueNumber == 2) {
            if (position < front2 || position > rear2) {
                System.out.println("Posisi tidak valid!");
            } else {
                System.out.println("Data " + queue2[position] + " dihapus dari antrian 2.");
                for (int i = position; i < rear2; i++) {
                    queue2[i] = queue2[i + 1];
                }
                queue2[rear2] = null;
                rear2--;
                if (front2 > rear2) {
                    front2 = -1;
                    rear2 = -1;
                }
            }
        } else {
            System.out.println("Nomor antrian tidak valid!");
        }
    }

    private static void clear() {
        for (int i = 0; i < MAX_SIZE; i++) {
            queue1[i] = null;
            queue2[i] = null;
        }
        front1 = -1;
        rear1 = -1;
        front2 = -1;
        rear2 = -1;
        System.out.println("Semua data dihapus dari antrian.");
    }

    private static void display() {
        System.out.println("Antrian 1:");
        if (front1 == -1 && rear1 == -1) {
            System.out.println("Kosong");
        } else {
            for (int i = front1; i <= rear1; i++) {
                System.out.println((i + 1) + ". " + queue1[i]);
            }
        }
        System.out.println("Antrian 2:");
        if (front2 == -1 && rear2 == -1) {
            System.out.println("Kosong");
        } else {
            for (int i = front2; i <= rear2; i++) {
                System.out.println((i + 1) + ". " + queue2[i]);
            }
        }
    }
}