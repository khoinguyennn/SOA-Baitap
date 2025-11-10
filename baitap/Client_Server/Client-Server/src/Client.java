import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Thiết lập kết nối với server
            Socket socket = new Socket("127.0.0.1", 5000);
            
            // Tạo luồng input/output
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            
            // Nhiệm vụ 1: Gửi hai số để tính tổng
            System.out.println("=== Máy tính cộng hai số ===");
            System.out.print("Nhập số thứ nhất: ");
            int so1 = scanner.nextInt();
            System.out.print("Nhập số thứ hai: ");
            int so2 = scanner.nextInt();
            
            // Gửi loại phép tính và các số
            output.writeUTF("CONG");
            output.writeInt(so1);
            output.writeInt(so2);
            
            // Nhận và hiển thị kết quả
            String ketQuaCong = input.readUTF();
            System.out.println("Kết quả từ server: " + ketQuaCong);
            
            // Nhiệm vụ 2: Gửi hệ số cho phương trình bậc 2
            System.out.println("\n=== Giải phương trình bậc 2 ===");
            System.out.print("Nhập hệ số a: ");
            int a = scanner.nextInt();
            System.out.print("Nhập hệ số b: ");
            int b = scanner.nextInt();
            System.out.print("Nhập hệ số c: ");
            int c = scanner.nextInt();
            
            // Gửi loại phép tính và hệ số
            output.writeUTF("PHUONGTRINH");
            output.writeInt(a);
            output.writeInt(b);
            output.writeInt(c);
            
            // Nhận và hiển thị kết quả
            String ketQuaPT = input.readUTF();
            System.out.println("Kết quả phương trình từ server: " + ketQuaPT);
            
            // Đóng kết nối
            scanner.close();
            socket.close();
            
        } catch (IOException e) {
            System.out.println("Lỗi Client: " + e.getMessage());
        }
    }
}