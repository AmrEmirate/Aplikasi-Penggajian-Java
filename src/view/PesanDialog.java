package view;

import javax.swing.JOptionPane;

public class PesanDialog {
    public int tampilkanPilihan(String pesan, String judul, Object[] pilihan) {
        return JOptionPane.showOptionDialog(
            null,
            pesan,
            judul,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            pilihan,
            pilihan[0]
        );
    }
}
