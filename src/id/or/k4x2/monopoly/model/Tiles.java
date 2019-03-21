package id.or.k4x2.monopoly.model;

import id.or.k4x2.monopoly.entity.Spaces.StartTile;
import id.or.k4x2.monopoly.entity.Tile;

public class Tiles {
    private static Tile[] tiles;

    public static void init() {
        tiles = new Tile[40];
        // StartTile
        tiles[0] = new StartTile();

        // Community chest
        tiles[2].add(new GenericTile("Dana\nUmum").getPanel());
        tiles[17].add(new GenericTile("Dana\nUmum").getPanel());
        tiles[33].add(new GenericTile("Dana\nUmum").getPanel());

        // Chance
        tiles[7].add(new GenericTile("Kesempatan").getPanel());
        tiles[22].add(new GenericTile("Kesempatan").getPanel());
        tiles[36].add(new GenericTile("Kesempatan").getPanel());

        // Brown block
        tiles[1].add(new BottomsideLotPane("Monas", new Color(139, 69, 17)).getPanel());
        tiles[3].add(new BottomsideLotPane("Taman\nMini", new Color(139, 69, 17)).getPanel());

        // Light blue block
        tiles[6].add(new BottomsideLotPane("Ragunan", new Color(132, 207, 235)).getPanel());
        tiles[8].add(new BottomsideLotPane("Binaria", new Color(132, 207, 235)).getPanel());
        tiles[9].add(new BottomsideLotPane("Taman\nPluit", new Color(132, 207, 235)).getPanel());

        // Purple block
        tiles[11].add(new LeftsideLotPane("Kebun\nRaya\nBogor", new Color(152, 49, 203)).getPanel());
        tiles[13].add(new LeftsideLotPane("Pelabuhan\nRatu", new Color(152, 49, 203)).getPanel());
        tiles[14].add(new LeftsideLotPane("Tangkuban\nPerahu", new Color(152, 49, 203)).getPanel());

        // Orange block
        tiles[16].add(new LeftsideLotPane("Gedung\nBatu", new Color(246, 171, 0)).getPanel());
        tiles[18].add(new LeftsideLotPane("Kopeng", new Color(246, 171, 0)).getPanel());
        tiles[19].add(new LeftsideLotPane("Borobudur", new Color(246, 171, 0)).getPanel());

        // Red block
        tiles[21].add(new TopsideLotPane("Prambanan", new Color(252, 4, 5)).getPanel());
        tiles[23].add(new TopsideLotPane("Kraton\nYogya", new Color(252, 4, 5)).getPanel());
        tiles[24].add(new TopsideLotPane("Bengawan\nSolo", new Color(252, 4, 5)).getPanel());

        // Yellow block
        tiles[26].add(new TopsideLotPane("Sarangan", new Color(254, 254, 3)).getPanel());
        tiles[27].add(new TopsideLotPane("Selecta", new Color(254, 254, 3)).getPanel());
        tiles[29].add(new TopsideLotPane("Gn. Kawi", new Color(254, 254, 3)).getPanel());

        // Green block
        tiles[31].add(new RightsideLotPane("Pantai\nSanur", new Color(0, 128, 0)).getPanel());
        tiles[32].add(new RightsideLotPane("Tampak\nSiring", new Color(0, 128, 0)).getPanel());
        tiles[34].add(new RightsideLotPane("Taman\nLaut\nBanda", new Color(0, 128, 0)).getPanel());

        // Blue block
        tiles[37].add(new RightsideLotPane("Danau\nToba", new Color(0, 0, 192)).getPanel());
        tiles[39].add(new RightsideLotPane("Brastagi", new Color(0, 0, 192)).getPanel());
    }
}
