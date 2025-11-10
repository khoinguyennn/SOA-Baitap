public class GiaiPhuongTrinh {
    
    /**
     * Giải phương trình bậc 2: ax² + bx + c = 0
     * @param a hệ số của x²
     * @param b hệ số của x
     * @param c hằng số
     * @return String chứa nghiệm của phương trình
     */
    public String giaiPT2(int a, int b, int c) {
        // Trường hợp a = 0, không phải phương trình bậc 2
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return "Phương trình có vô số nghiệm (0 = 0)";
                } else {
                    return "Phương trình vô nghiệm (" + c + " ≠ 0)";
                }
            } else {
                double x = -1.0 * c / b;
                return "Phương trình bậc nhất có nghiệm: x = " + Math.round(x * 100.0) / 100.0;
            }
        }
        
        // Tính biệt thức (delta = b² - 4ac)
        double delta = b * b - 4.0 * a * c;
        
        if (delta > 0) {
            // Hai nghiệm phân biệt
            double x1 = (-b + Math.sqrt(delta)) / (2.0 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2.0 * a);
            return "Phương trình có hai nghiệm: x1 = " + 
                   (Math.round(x1 * 100.0) / 100.0) + 
                   ", x2 = " + (Math.round(x2 * 100.0) / 100.0);
        } else if (delta == 0) {
            // Nghiệm kép
            double x = -1.0 * b / (2.0 * a);
            return "Phương trình có nghiệm kép: x = " + (Math.round(x * 100.0) / 100.0);
        } else {
            // Nghiệm phức
            double phanThuc = -1.0 * b / (2.0 * a);
            double phanAo = Math.sqrt(-delta) / (2.0 * a);
            return "Phương trình có nghiệm phức: x1 = " + 
                   (Math.round(phanThuc * 100.0) / 100.0) + 
                   " + " + (Math.round(phanAo * 100.0) / 100.0) + 
                   "i, x2 = " + (Math.round(phanThuc * 100.0) / 100.0) + 
                   " - " + (Math.round(phanAo * 100.0) / 100.0) + "i";
        }
    }
}