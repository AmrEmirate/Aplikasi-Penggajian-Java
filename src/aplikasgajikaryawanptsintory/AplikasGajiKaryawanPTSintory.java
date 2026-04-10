package aplikasgajikaryawanptsintory;

// 1. Kita ganti import-nya menjadi FormLogin
import view.FormLogin; 

public class AplikasGajiKaryawanPTSintory {
    
    // 2. Kita buat variabel formLogin
    private final static FormLogin formLogin = new FormLogin();

    public static void main(String[] args) {
        // 3. Kita tampilkan formLogin saat F6 ditekan
        formLogin.setVisible(true);
    }
    
}