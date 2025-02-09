import javax.swing.JOptionPane;
public class KodeBuku{
    public static void main(String[] args) {
        //variabel array
        String kode_buku[]={"181818A","191919B","202020C","171717D","161616E","101010F","090909G"};
        String judul_buku[]={"Dhirga","Summer sky","Noversation","Si Anak Badai","Komet Minor","Me and my broken heart","Dilan"};
        String nama_pengarang[]={"natalia tan","Stephanie zen","Valerie patkar","tereliye","tereliye","wulanfadi","pidi baiq"};
        double harga_buku[]={68000,124000,115000,75000,71500,69000,59000};
        
        //variabel lainnya
        String tampilKode;
        String tampilJudul;
        String tampilPengarang;
        double tampilHarga;
        int salah;
        int jumlahBuku;
        int angka;
        double totalHarga;
        double diskon=0;
        String hasil;
        
        //memulai proses
        String kata="ya";
        while (kata.equalsIgnoreCase("ya")) {            
            int pilihan=Integer.parseInt(JOptionPane.showInputDialog("MENU\n1. lihat\n2. beli"));
            switch (pilihan) {
                //lihat
                case 1:
                    //variabel tambahan
                    tampilKode="";
                    tampilJudul="";
                    tampilPengarang="";
                    tampilHarga=0;
                    //menampilkan data pada kode buku
                    String kode_diminta=JOptionPane.showInputDialog("masukkan kode buku");
                    salah=0;
                    //proses mencari buku yang diminta
                    for (int i = 0; i < kode_buku.length; i++) {
                        if (kode_diminta.equalsIgnoreCase(kode_buku[i])) {
                            tampilKode=kode_buku[i];
                            tampilJudul=judul_buku[i];
                            tampilPengarang=nama_pengarang[i];
                            tampilHarga=harga_buku[i];
                        } else {
                            salah++;
                        }
                        if (salah>=kode_buku.length){
                            JOptionPane.showMessageDialog(null, "kode buku tidak tersedia");
                            return;
                        }
                    }
                    //output data buku yang diminta
                    JOptionPane.showMessageDialog(null,"INFORMASI BUKU\n"
                            + "\nKode buku: "+tampilKode+
                            "\nJudul Buku: "+tampilJudul+
                            "\nNama Pengarang: "+tampilPengarang+
                            "\nHarga Buku: "+tampilHarga);
                    salah=0;
                    kata=JOptionPane.showInputDialog("lanjut? (ya/tidak)");
                    break;
                //beli
                    
                case 2:
                    //variabel tambahan
                    String keranjang[]=new String[10];
                    for (int i = 0; i < keranjang.length; i++) {
                        keranjang[i] = "";
                    }
                    hasil="";
                    tampilKode="";
                    tampilJudul="";
                    tampilPengarang="";
                    tampilHarga=0;
                    jumlahBuku=1;
                    angka=1;
                    totalHarga=0;
                    //proses
                    int jumlahBeli=Integer.parseInt(JOptionPane.showInputDialog("Masukkan jumlah buku yang ingin dibeli"));
                    //input kode buku
                    for (int i = 0; i < jumlahBeli; i++) {
                        kode_diminta=JOptionPane.showInputDialog("masukkan kode buku ke-"+(i+1));
                        salah=0;
                        //proses mencari buku yang diminta
                        for (int j = 0; j < kode_buku.length; j++) {
                            if (kode_diminta.equalsIgnoreCase(kode_buku[j])) {
                                tampilKode=kode_buku[j];
                                tampilJudul=judul_buku[j];
                                keranjang[j]=judul_buku[j];
                                tampilPengarang=nama_pengarang[j];
                                tampilHarga=harga_buku[j];
                                totalHarga+=harga_buku[j];
                            } else {
                                salah++;
                            }
                            if (salah>=kode_buku.length){
                                JOptionPane.showMessageDialog(null, "kode buku tidak tersedia");
                            return;
                            }
                        }
                        //output data buku yang ditambah
                        
                        JOptionPane.showMessageDialog(null,"INFORMASI BUKU\n"
                            + "\nKode buku: "+tampilKode+
                            "\nJudul Buku: "+tampilJudul+
                            "\nNama Pengarang: "+tampilPengarang+
                            "\nHarga Buku: "+tampilHarga+
                            "\n\nTotal buku disimpan:"+jumlahBuku+
                            "\nTotal Harga sekarang:"+totalHarga);
                        jumlahBuku++;
                    }
                    if (totalHarga>150000) {
                        diskon=totalHarga*0.1;
                    }
                    int x=0;
                    String bukuDibeli[]=new String[jumlahBeli];
                    for (int i = 0; i < keranjang.length; i++) {
                        String nama= keranjang[i];
                        if (!nama.isEmpty()) {
                            bukuDibeli[x]=nama;
                            x++;
                        }
                    }
                    for (int i = 0; i < bukuDibeli.length; i++) {
                        hasil += (angka++) +")"+ bukuDibeli[i] + "   ||   ";
                    }
                    JOptionPane.showMessageDialog(null, "DATA BUKU YANG DIBELI\n"+
                            hasil+
                            "\n\nTotal harga buku:"+totalHarga+
                            "\nDiskon didapat (10%) :"+diskon+
                            "\nTotal harga:"+(totalHarga-diskon));
                    kata=JOptionPane.showInputDialog("lanjut? (ya/tidak)");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"menu tidak tersedia");
                    return;
            }
        }
    }
}
