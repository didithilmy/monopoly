package id.or.k4x2.monopoly.model;

import id.or.k4x2.monopoly.entity.Properties.Lot;
import id.or.k4x2.monopoly.entity.Properties.Railroad;
import id.or.k4x2.monopoly.entity.Properties.Utility;
import id.or.k4x2.monopoly.entity.Spaces.*;
import id.or.k4x2.monopoly.entity.Tile;

public class Tiles {
    private static Tile[] tiles;

    public static void init() {
        tiles = new Tile[40];
        // StartTile
        tiles[0] = new StartTile();

        // Community chest
        tiles[2] = new CommunityChest();
        tiles[17] = new CommunityChest();
        tiles[33] = new CommunityChest();

        // Chance
        tiles[7] = new Chance();
        tiles[22] = new Chance();
        tiles[36] = new Chance();

        // Utilities
        tiles[12] = new Utility("Perusahaan Listrik", 50);  // Perusahaan Listrik
        tiles[28] = new Utility("Perusahaan Air", 50);  // Perusahaan Air

        // Public services
        tiles[5] = new Railroad("Bandara Kemayoran", 80);  // Bandara Kemayoran
        tiles[15] = new Railroad("Terminal Bis Semarang", 80);  // Terminal bis semarang
        tiles[25] = new Railroad("Stasiun Pasar Turi", 80);  // Stasiun Ps. Turi
        tiles[35] = new Railroad("Pelabuhan Belawan", 80);  // Pelabuhan Belawan

        // Taxes
        tiles[4] = new Taxation("Pajak Jalan");  // Pajak Jalan
        tiles[38] = new Taxation("Pajak Istimewa"); // Pajak Istimewa

        //Jail
        tiles[10] = new FreeParking("Penjara");  // Penjara
        tiles[30] = new GoToJail(); // Pergi ke Penjara

        // Free parking
        tiles[20] = new FreeParking("Parkir Bebas");

        // Brown block
        tiles[1] = new Lot("Monas", 50, Lot.Group.BROWN);
        tiles[3] = new Lot("Taman Mini", 50, Lot.Group.BROWN);

        // Light blue block
        tiles[6] = new Lot("Ragunan", 60, Lot.Group.LIGHT_BLUE);
        tiles[8] = new Lot("Binaria", 60, Lot.Group.LIGHT_BLUE);
        tiles[9] = new Lot("Taman Pluit", 65, Lot.Group.LIGHT_BLUE);

        // Purple block
        tiles[11] = new Lot("Kebun Raya Bogor", 80, Lot.Group.PURPLE);
        tiles[13] = new Lot("Pelabuhan Ratu", 80, Lot.Group.PURPLE);
        tiles[14] = new Lot("Tangkuban Perahu", 85, Lot.Group.PURPLE);

        // Orange block
        tiles[16] = new Lot("Gedung Batu", 100, Lot.Group.ORANGE);
        tiles[18] = new Lot("Kopeng", 100, Lot.Group.ORANGE);
        tiles[19] = new Lot("Borobudur", 105, Lot.Group.ORANGE);

        // Red block
        tiles[21] = new Lot("Prambanan", 120, Lot.Group.RED);
        tiles[23] = new Lot("Kraton Yogya", 120, Lot.Group.RED);
        tiles[24] = new Lot("Bengawan Solo", 125, Lot.Group.RED);

        // Yellow block
        tiles[26] = new Lot("Sarangan", 140, Lot.Group.YELLOW);
        tiles[27] = new Lot("Selecta", 140, Lot.Group.YELLOW);
        tiles[29] = new Lot("Gunung Kawi", 145, Lot.Group.YELLOW);

        // Green block
        tiles[31] = new Lot("Pantai Sanur", 160, Lot.Group.GREEN);
        tiles[32] = new Lot("Tampak Siring", 160, Lot.Group.GREEN);
        tiles[34] = new Lot("Taman Laut Banda", 165, Lot.Group.GREEN);

        // Blue block
        tiles[37] = new Lot("Danau Toba", 180, Lot.Group.BLUE);
        tiles[39] = new Lot("Brastagi", 180, Lot.Group.BLUE);
    }

    /**
     * Get Tile by index
     * @param index index
     * @return Tile entity
     */
    public static Tile getTile(int index) {
        if(index < tiles.length)
            return tiles[index];
        else
            return null;
    }

    public static Tile[] getTiles() {
        return tiles;
    }
}
