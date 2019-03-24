package id.or.k4x2.monopoly.model;

import id.or.k4x2.monopoly.entity.Cards.*;

/**
 * Cards collection hehe
 * @author Muhammad Yanza Hattari/18217043
 */
public class Cards {
    private static final Card[] cards = {
            new DeductMoneyCard("Biaya Listrik", "Anda terkena biaya listrik sebesar 10",10),
            new DeductMoneyCard("Biaya Pembangunan","Anda terkena biaya pembangunan kota sebesar 20",20),
            new DeductMoneyCard("Biaya Perbaikan Jalan","Kota Anda perlu perbaikan. Anda terkena biaya sebesar 15",15),
            new DeductMoneyCard("Pencuri","Pencuri mengambil uang Anda sebesar 10",10),
            new DeductMoneyCard("Iuran","Anda harus membayar uang iuran arisan bersama Arya sebesar 5",5),
            new DeductMoneyCard("Biaya Administrasi","Anda terkena biaya administrasi 5",5),
            new DeductMoneyCard("Biaya Rumah Sakit","Anda sakit karena terlalu banyak tubes! Anda terkena biaya 15",15),
            new AddMoneyCard("Sumbangan","Karena Anda sangat miskin, masyarakat kota mengumpulkan sumbangan sebesar 30",30),
            new AddMoneyCard("Hadiah Ulang Tahun","Selamat ulang tahun! Anda mendapat voucher Jordhy-Pay sebesar 20",20),
            new AddMoneyCard("Jackpot!","Anda menang undian! Anda mendapatkan uang sebesar 20",20),
            new AddMoneyCard("Bonus Day","Bos anda Didit memberi Anda bonus karena sudah bekerja keras sebesar 20",20),
            new AddMoneyCard("Angpao","Karena Audi merayakan Gong Xi Fa Cai, anda mendapat uang sebesar 5",5),
            new AddMoneyCard("Cashback","Anda mendapat cashback setelah mentraktir Hatta sebesar 10",10),
            new AddMoneyCard("Gaji","Anda mendapat gaji sebesar 10 setelah membantu Gambet menjadi MC",10),
            new AddMoneyCard("Gaji Bonus","Karena Anda tidak jadi di carry Didit, anda mendapat bonus sebesar 20",20),
            new MoveStaticCard("Tersandung","Anda tersandung beban hidup Audi, maju 3 tiles",3),
            new MoveStaticCard("Halu","Karena Anda sedang halu, Anda dimundurin 2 tiles",-2),
            new MoveStaticCard("Grebek","Karena Anda 'macem-macem', Anda kabur dan maju 4 tiles ;)",4),
            new MoveStaticCard("Atta Halilintar","Awas ada Bima! Mundur 3 tiles, ASHIAPP",-3),
            new MoveStaticCard("Daerah Terlarang","Karena Anda main bersama anak SD, ga boleh lewatin batas meja, mundur 1 tile",-1),
            new MoveStaticCard("Bendahara","Anda belum bayar iuran. Segera kabur dari Bendahara! Maju 1 tile",1),
            new MoveToCard("Loss","Sudah capek kuliah, Anda pulang ke daerah asal lewat Stasiun Pasar Turi",25),
            new MoveToCard("Rusa","Karena Anda kangen melihat Rusa, pergi ke Kebun Raya Bogor",11),
            new MoveToCard("Danusan","Karena Anda danusan di daerah ITB, Anda dikirim masuk ke penjara",30),
            new MoveToCard("Pacaran","Karena Anda pacaran di daerah Salman, Anda dikirim masuk ke penjara",30),
            new MoveToCard("Buku Cerita Rakyat","Karena Anda terinspirasi dengan buku cerita rakyat, Anda berkunjung ke Prambanan",21),
            new MoveToCard("Buku Cerita Rakyat","Karena Anda terinspirasi dengan buku cerita rakyat, Anda berkunjung ke Danau Toba",37),
            new MoveToCard("Pajak","Karena Anda ketahuan belum bayar pajak oleh Didit, Anda dipaksa bayar di Pajak Istimewa",38),
            new MoveToCard("Pajak","Ketahuan belum bayar pajak saat pacaran, Anda dipaksa bayar Pajak Jalan",4),
            new MoveToCard("Kunjungan","Anda ingin menjenguk Audi di penjara. Pindah ke penjara",10)
    };
    //0-6 7-14 15-20 21-29
    private static final Card[] chanceCards = {
            cards[0], cards[1], cards[2], cards[7], cards[8],
            cards[9], cards[10], cards[11], cards[12], cards[13],
            cards[14], cards[15], cards[16], cards[17], cards[18],
            cards[19], cards[20], cards[21], cards[22], cards[23],
            cards[24], cards[25], cards[26], cards[27], cards[28],
            cards[29], cards[7], cards[7], cards[7], cards[8],
            cards[8], cards[8], cards[9], cards[9], cards[9],
            cards[10], cards[10], cards[10], cards[11], cards[11],
            cards[12], cards[12], cards[12], cards[13], cards[13],
            cards[13], cards[14], cards[14], cards[14], cards[14],
            cards[15], cards[15], cards[16], cards[17], cards[17],
            cards[17], cards[18], cards[18], cards[19], cards[19],
            cards[20], cards[21], cards[21], cards[22], cards[22],
            cards[22], cards[23], cards[23], cards[23], cards[23],
            cards[24], cards[24], cards[25], cards[26], cards[27],
            cards[27], cards[27], cards[28], cards[28], cards[29],
            cards[0], cards[1], cards[2], cards[3], cards[3],
            cards[3], cards[4], cards[4], cards[4], cards[4],
            cards[5], cards[5], cards[5], cards[5], cards[5],
            cards[6], cards[6], cards[6], cards[6], cards[6]
    };

    private static final Card[] communityChestCards = {
            cards[0], cards[1], cards[2], cards[3], cards[3],
            cards[0], cards[1], cards[2], cards[3], cards[3],
            cards[0], cards[1], cards[2], cards[3], cards[3],
            cards[3], cards[4], cards[4], cards[4], cards[4],
            cards[3], cards[4], cards[4], cards[4], cards[4],
            cards[5], cards[5], cards[5], cards[5], cards[5],
            cards[5], cards[5], cards[5], cards[5], cards[5],
            cards[5], cards[5], cards[5], cards[5], cards[5],
            cards[6], cards[6], cards[6], cards[6], cards[6],
            cards[6], cards[6], cards[6], cards[6], cards[6],
            cards[6], cards[6], cards[6], cards[6], cards[6],
            cards[6], cards[6], cards[6], cards[6], cards[6],
            cards[7], cards[8], cards[7], cards[8], cards[7],
            cards[9], cards[10], cards[11], cards[12], cards[13],
            cards[14], cards[15], cards[16], cards[17], cards[18],
            cards[19], cards[20], cards[21], cards[22], cards[23],
            cards[24], cards[25], cards[26], cards[27], cards[28],
            cards[29], cards[7], cards[7], cards[7], cards[8],
            cards[8], cards[8], cards[9], cards[9], cards[9],
            cards[10], cards[10], cards[10], cards[11], cards[11],
            cards[12], cards[12], cards[12], cards[13], cards[13],
            cards[13], cards[14], cards[14], cards[14], cards[14],
            cards[15], cards[15], cards[16], cards[17], cards[17],
            cards[17], cards[18], cards[18], cards[19], cards[19],
            cards[20], cards[21], cards[21], cards[22], cards[22],
            cards[22], cards[23], cards[23], cards[23], cards[23],
            cards[24], cards[24], cards[25], cards[26], cards[27],
            cards[27], cards[27], cards[28], cards[28], cards[29]
    };


}
