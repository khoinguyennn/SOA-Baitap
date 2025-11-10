import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Tạo server socket
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server đang lắng nghe trên cổng 5000...");
            
            // Chờ kết nối từ client
            Socket socket = serverSocket.accept();
            System.out.println("Client đã kết nối!");
            
            // Tạo luồng input/output
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            
            // Xử lý phép cộng
            String phepToan1 = input.readUTF();
            if ("CONG".equals(phepToan1)) {
                int so1 = input.readInt();
                int so2 = input.readInt();
                int tong = so1 + so2;
                
                System.out.println("Nhận được hai số: " + so1 + " và " + so2);
                System.out.println("Tính tổng: " + tong);
                
                output.writeUTF("Tổng của " + so1 + " và " + so2 + " là: " + tong);
            }
            
            // Xử lý phương trình bậc 2
            String phepToan2 = input.readUTF();
            if ("PHUONGTRINH".equals(phepToan2)) {
                int a = input.readInt();
                int b = input.readInt();
                int c = input.readInt();
                
                System.out.println("Nhận được hệ số: a=" + a + ", b=" + b + ", c=" + c);
                
                // Tạo đối tượng GiaiPhuongTrinh và giải
                GiaiPhuongTrinh giaiPT = new GiaiPhuongTrinh();
                String ketQua = giaiPT.giaiPT2(a, b, c);
                
                System.out.println("Kết quả phương trình: " + ketQua);
                output.writeUTF(ketQua);
            }
            
            // Đóng kết nối
            socket.close();
            serverSocket.close();
            System.out.println("Server đã đóng.");
            
        } catch (IOException e) {
            System.out.println("Lỗi Server: " + e.getMessage());
        }
    }
}