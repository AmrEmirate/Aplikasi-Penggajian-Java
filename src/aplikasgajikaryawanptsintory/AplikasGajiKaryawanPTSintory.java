package aplikasgajikaryawanptsintory;

// 1. Kita ganti import-nya menjadi FormLogin
import view.FormLogin; 

public class AplikasGajiKaryawanPTSintory {
    
    public static void main(String[] args) {
        // 1. Tampilkan FormUtama terlebih dahulu
        view.FormUtama formUtama = new view.FormUtama();
        formUtama.setVisible(true);
        
        // 2. Tampilkan FormLogin sebagai modal dialog di atas FormUtama
        view.FormLogin formLogin = new view.FormLogin(formUtama, true);
        formLogin.setVisible(true);
    }
    
}