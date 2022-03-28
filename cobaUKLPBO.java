import java.util.ArrayList;
import java.util.Scanner;

public class cobaUKLPBO {
    public static void main(String[] args) {
        Laporan toko = new Laporan();
        member baru = new member();
        barang item = new barang();
        toko.laporan(baru);
        toko.laporan(item);
        baru.setNama("Aldo");
        transaksi tokoAhmad = new transaksi();
        tokoAhmad.prosesTransaksi(baru, tokoAhmad,item);
        toko.laporan(tokoAhmad, item);
        toko.laporan(item);
        toko.laporan(baru);
    }
}

interface User {
    public void setNama(String nama);
    public void setAlamat(String alamat);
    public void setTelepon(String telepon) ;
    public abstract String getNama(int id);
    public abstract String getTelepon(int id);
    public abstract String getAlamat(int id);

}

class member implements User{
    private ArrayList<String> namaMember = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();
    private ArrayList<Integer> saldo = new ArrayList<Integer>();
    public member(){
        this.namaMember.add("Rafi");
        this.alamat.add("Sawojajar");
        this.telepon.add("085855008901");
        this.saldo.add(2000000000);
        this.namaMember.add("Budi");
        this.alamat.add("Bululawang");
        this.telepon.add("081222233344");
        this.saldo.add(200000);
        this.namaMember.add("Depi");
        this.alamat.add("Tulungagung");
        this.telepon.add("081222288392");
        this.saldo.add(200000000);
    }
    public void setSaldo(int saldo) {
        this.saldo.add(saldo);
    }
    public int getSaldo(int idMember) {
        return this.saldo.get(idMember);
    }
    public void editSaldo(int idMember, int saldo){
        this.saldo.set(idMember, saldo);
    }
    public int getJmlMember(){
        return this.saldo.size();
    }
    @Override
    public void setNama(String nama) {
        this.namaMember.add(nama);
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }

    @Override
    public void setTelepon(String telepon) {
        this.telepon.add(telepon);
    }

    @Override
    public String getNama(int id) {
        return this.namaMember.get(id);
    }
    @Override
    public String getTelepon(int id) {
        return this.telepon.get(id);
    }

    public String getAlamat(int id) {
        return this.alamat.get(id);
    }
}
class karyawan implements User{
    private ArrayList<String> namaKaryawan = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();
    private ArrayList<Integer> jabatan = new ArrayList<Integer>();

    public karyawan(){
        this.namaKaryawan.add("admin");
        this.alamat.add("kedung kandang");
        this.telepon.add("085768890121");
        this.jabatan.add(0);
    }

    public void setJabatan(int jabatan) {
        this.jabatan.add(jabatan);
    }

    public int getJabatan(int id) {
        return this.jabatan.get(id);
    }

    public int getJmlKaryawan() {
        return this.namaKaryawan.size();
    }

    @Override
    public void setNama(String nama) {
        this.namaKaryawan.add(nama);
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }

    @Override
    public void setTelepon(String telepon) {
        this.telepon.add("089891123654");
    }

    @Override
    public String getNama(int id) {
        return this.namaKaryawan.get(id);
    }

    @Override
    public String getTelepon(int id) {
        return this.telepon.get(id);
    }

    @Override
    public String getAlamat(int id) {
        return this.alamat.get(id);
    }

}
class barang {
    private ArrayList<String> namaBarang = new ArrayList<String>();
    private ArrayList<Integer> stok = new ArrayList<Integer>();
    private ArrayList<Integer> harga = new ArrayList<Integer>();
    public barang(){
        this.namaBarang.add("Cokelat Enak");
        this.stok.add(15);
        this.harga.add(10000);

        this.namaBarang.add("Sabun Beri");
        this.stok.add(30);
        this.harga.add(5000);

        this.namaBarang.add("Odol gummy");
        this.stok.add(20);
        this.harga.add(15000);
    }

    public int getJmlgBrg() {
        return this.namaBarang.size();
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang.add(namaBarang);
    }

    public String getNamaBarang(int idBarang) {
        return this.namaBarang.get(idBarang);
    }

    public void setStok(Integer stok) {
        this.stok.add(stok);
    }

    public int getStok(int idBarang) {
        return this.stok.get(idBarang);
    }

    public void editStok(int stok, int idBarang) {
        this.stok.set(idBarang,stok);
    }

    public void setHarga(int harga) {
        this.harga.add(harga);
    }

    public int getHarga(int idBarang) {
        return this.harga.get(idBarang);
    }
}
class transaksi {
    private ArrayList<Integer> idBarang = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();
    private ArrayList<Integer> idMember = new ArrayList<Integer>();

    transaksi() {
        this.idMember.add(0);
        this.idBarang.add(0);
        this.banyak.add(2);

        this.idMember.add(0);
        this.idBarang.add(1);
        this.banyak.add(3);

        this.idMember.add(1);
        this.idBarang.add(0);
        this.banyak.add(1);

        this.idMember.add(1);
        this.idBarang.add(2);
        this.banyak.add(2);
    }

    public void prosesTransaksi(member member, transaksi transaksi, barang barang) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Silahkan Belanja");
        System.out.print("Masukkan Id member: ");
        int idMember = myObj.nextInt();
        System.out.println("Selamat datang " + member.getNama(idMember));
        ArrayList<Integer> idbarang = new ArrayList<Integer>();
        ArrayList<Integer> banyak = new ArrayList<Integer>();
        int i = 0;
        int temp;
        try {
            do {
                System.out.print("Masukkan kode Barang: ");
                temp = myObj.nextInt();
                if (temp != 99) {
                    idbarang.add(temp);
                    System.out.println(barang.getNamaBarang(idbarang.get(i)) + " sebanyak: ");
                    banyak.add(myObj.nextInt());
                    i++;
                }
            } while (temp != 99);
            System.out.println("Transaksi belanja " + member.getNama(idMember) + " sebagai berikut: ");
            System.out.println("Nama barang \tQty \tHarga \tJumlah \t");
            int total = 0;
            int x = idbarang.size();
            for (int j = 0; j < x; j++) {
                int jumlah = banyak.get(j) * barang.getHarga(idbarang.get(j));
                total += jumlah;
                System.out.println(barang.getNamaBarang(idbarang.get(j)) + "\t" + idbarang.get(j) + "\t" + barang.getHarga(idbarang.get(j)) + "\t" + jumlah);
                transaksi.setTransaksi(barang, idMember, idbarang.get(j), banyak.get(j));
            }
            System.out.println("total belanja: " + total);
            member.editSaldo(idMember, member.getSaldo(idMember) - total);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void setTransaksi(barang barang, int idbarang, int idMember, int banyaknya) {
        this.idMember.add(idMember);
        this.idBarang.add(idbarang);
        this.banyak.add(banyaknya);
        barang.editStok( barang.getStok(idbarang) - banyaknya, idbarang);
    }

    public int getIdBarang(int id) {
        return this.idBarang.get(id);
    }

    public int getBanyak(int id) {
        return this.banyak.get(id);
    }

    public int getIdMember(int id) {
        return this.idMember.get(id);
    }

    public int getJmlTransaksi(){
        return this.idMember.size();
    }
}
class Laporan {
    public void laporan(barang barang) {
        int x = barang.getJmlgBrg();
        System.out.println();
        System.out.println("Tabel barang");
        System.out.println();
        System.out.println("Nama barang \tStok \tHarga");
        for (int i = 0; i < x; i++) {
            System.out.println(barang.getNamaBarang(i) + "\t" + barang.getStok(i) + "\t" + barang.getHarga(i));
        }
    }

    public void laporan(member member) {
        int x = member.getJmlMember();
        System.out.println();
        System.out.println("Tabel member");
        System.out.println();
        System.out.println("Nama \tAlamat \t\tTelepon \tSaldo");
        for (int i = 0; i < x; i++) {
            System.out.println(member.getNama(i) + "\t" + member.getAlamat(i) + "\t" + member.getTelepon(i) + "\t" + member.getSaldo(i));
        }
    }

    public void laporan(transaksi transaksi, barang barang) {
        int x = transaksi.getJmlTransaksi();
        System.out.println();
        System.out.println("Laporan transaksi");
        System.out.println();
        System.out.println("Nama barang \tQty \tHarga \tJumlah");
        int total = 0;
        for (int i = 0; i < x; i++) {
            int jumlah = transaksi.getBanyak(i) * barang.getHarga(transaksi.getIdBarang(i));
            total += jumlah;
            System.out.println(barang.getNamaBarang(transaksi.getIdBarang(i)) + "\t" + transaksi.getBanyak(i)+"\t"+barang.getHarga(transaksi.getIdBarang(i))+"\t"+jumlah);
        }
        System.out.println("Total Omset ="+total);
    }
}
