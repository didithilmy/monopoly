package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.listeners.*;
import id.or.k4x2.monopoly.model.GameManager;
import id.or.k4x2.monopoly.model.Tiles;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardWindow implements GameStateListener, PlayerMovedListener, PlayerAttributesListener {
    private JPanel panelMain;
    private JPanel tile0;
    private JPanel tile1;
    private JPanel tile2;
    private JPanel tile3;
    private JPanel tile4;
    private JPanel tile5;
    private JPanel tile6;
    private JPanel tile7;
    private JPanel tile8;
    private JPanel tile9;
    private JPanel tile10;
    private JPanel tile11;
    private JPanel tile12;
    private JPanel tile13;
    private JPanel tile14;
    private JPanel tile15;
    private JPanel tile16;
    private JPanel tile17;
    private JPanel tile18;
    private JPanel tile19;
    private JPanel tile20;
    private JPanel tile21;
    private JPanel tile22;
    private JPanel tile23;
    private JPanel tile24;
    private JPanel tile25;
    private JPanel tile26;
    private JPanel tile27;
    private JPanel tile28;
    private JPanel tile29;
    private JPanel tile30;
    private JPanel tile31;
    private JPanel tile32;
    private JPanel tile33;
    private JPanel tile34;
    private JPanel tile35;
    private JPanel tile36;
    private JPanel tile37;
    private JPanel tile38;
    private JPanel tile39;

    private JPanel[] tiles = {
            tile0, tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9,
            tile10, tile11, tile12, tile13, tile14, tile15, tile16, tile17, tile18, tile19,
            tile20, tile21, tile22, tile23, tile24, tile25, tile26, tile27, tile28, tile29,
            tile30, tile31, tile32, tile33, tile34, tile35, tile36, tile37, tile38, tile39
    };

    // Map for keeping track of player positions
    private Map<Player.Designation, Integer> positionsMap;

    public BoardWindow() {
        for(JPanel tile : tiles) {
            tile.setLayout(new BorderLayout());
        }

        positionsMap = new HashMap<>();

        initiateTiles();

        // Register listener
        Listeners.addGameStateListener(this);
        Listeners.addPlayerMoveListener(this);
        Listeners.addPlayerAttributesListener(this);
    }

    private void initiateTiles() {
        // StartTile
        tile0.add(new PlayerOverlay(new GenericTile(Tiles.getTile(0), "Mulai\nRp200")));

        // Community chest
        tile2.add(new PlayerOverlay(new GenericTile(Tiles.getTile(2), "Dana\nUmum")));
        tile17.add(new PlayerOverlay(new GenericTile(Tiles.getTile(17), "Dana\nUmum")));
        tile33.add(new PlayerOverlay(new GenericTile(Tiles.getTile(33), "Dana\nUmum")));

        // Chance
        tile7.add(new PlayerOverlay(new GenericTile(Tiles.getTile(7), "Kesempatan")));
        tile22.add(new PlayerOverlay(new GenericTile(Tiles.getTile(22), "Kesempatan")));
        tile36.add(new PlayerOverlay(new GenericTile(Tiles.getTile(36), "Kesempatan")));

        // Utilities
        tile12.add(new PlayerOverlay(new GenericTile(Tiles.getTile(12), "Perusahaan\nListrik")));
        tile28.add(new PlayerOverlay(new GenericTile(Tiles.getTile(28), "Perusahaan\nAir")));

        // Public services
        tile5.add(new PlayerOverlay(new GenericTile(Tiles.getTile(5), "Bandara\nKemayoran")));
        tile15.add(new PlayerOverlay(new GenericTile(Tiles.getTile(15), "Terminal\nBis\nSemarang")));
        tile25.add(new PlayerOverlay(new GenericTile(Tiles.getTile(25), "Stasiun\nPs. Turi")));
        tile35.add(new PlayerOverlay(new GenericTile(Tiles.getTile(35), "Pelabuhan\nBelawan")));

        // Taxes
        tile4.add(new PlayerOverlay(new GenericTile(Tiles.getTile(4), "Pajak\nJalan")));
        tile38.add(new PlayerOverlay(new GenericTile(Tiles.getTile(38), "Pajak\nIstimewa")));

        //Jail
        tile10.add(new PlayerOverlay(new GenericTile(Tiles.getTile(10), "Penjara")));
        tile30.add(new PlayerOverlay(new GenericTile(Tiles.getTile(30), "Pergi\nke\nPenjara")));

        // Free parking
        tile20.add(new PlayerOverlay(new GenericTile(Tiles.getTile(20), "Parkir\nBebas")));

        // Brown block
        tile1.add(new PlayerOverlay(new BottomsideLotPane(Tiles.getTile(1), "Monas", new Color(139, 69, 17))));
        tile3.add(new PlayerOverlay(new BottomsideLotPane(Tiles.getTile(3), "Taman\nMini", new Color(139, 69, 17))));

        // Light blue block
        tile6.add(new PlayerOverlay(new BottomsideLotPane(Tiles.getTile(6), "Ragunan", new Color(132, 207, 235))));
        tile8.add(new PlayerOverlay(new BottomsideLotPane(Tiles.getTile(8), "Binaria", new Color(132, 207, 235))));
        tile9.add(new PlayerOverlay(new BottomsideLotPane(Tiles.getTile(9), "Taman\nPluit", new Color(132, 207, 235))));

        // Purple block
        tile11.add(new PlayerOverlay(new LeftsideLotPane(Tiles.getTile(11), "Kebun\nRaya\nBogor", new Color(152, 49, 203))));
        tile13.add(new PlayerOverlay(new LeftsideLotPane(Tiles.getTile(13), "Pelabuhan\nRatu", new Color(152, 49, 203))));
        tile14.add(new PlayerOverlay(new LeftsideLotPane(Tiles.getTile(14), "Tangkuban\nPerahu", new Color(152, 49, 203))));

        // Orange block
        tile16.add(new PlayerOverlay(new LeftsideLotPane(Tiles.getTile(16), "Gedung\nBatu", new Color(246, 171, 0))));
        tile18.add(new PlayerOverlay(new LeftsideLotPane(Tiles.getTile(18), "Kopeng", new Color(246, 171, 0))));
        tile19.add(new PlayerOverlay(new LeftsideLotPane(Tiles.getTile(19), "Borobudur", new Color(246, 171, 0))));

        // Red block
        tile21.add(new PlayerOverlay(new TopsideLotPane(Tiles.getTile(21), "Prambanan", new Color(252, 4, 5))));
        tile23.add(new PlayerOverlay(new TopsideLotPane(Tiles.getTile(23), "Kraton\nYogya", new Color(252, 4, 5))));
        tile24.add(new PlayerOverlay(new TopsideLotPane(Tiles.getTile(24), "Bengawan\nSolo", new Color(252, 4, 5))));

        // Yellow block
        tile26.add(new PlayerOverlay(new TopsideLotPane(Tiles.getTile(26), "Sarangan", new Color(254, 254, 3))));
        tile27.add(new PlayerOverlay(new TopsideLotPane(Tiles.getTile(27), "Selecta", new Color(254, 254, 3))));
        tile29.add(new PlayerOverlay(new TopsideLotPane(Tiles.getTile(29), "Gn. Kawi", new Color(254, 254, 3))));

        // Green block
        tile31.add(new PlayerOverlay(new RightsideLotPane(Tiles.getTile(31), "Pantai\nSanur", new Color(0, 128, 0))));
        tile32.add(new PlayerOverlay(new RightsideLotPane(Tiles.getTile(32), "Tampak\nSiring", new Color(0, 128, 0))));
        tile34.add(new PlayerOverlay(new RightsideLotPane(Tiles.getTile(34), "Taman\nLaut\nBanda", new Color(0, 128, 0))));

        // Blue block
        tile37.add(new PlayerOverlay(new RightsideLotPane(Tiles.getTile(37), "Danau\nToba", new Color(0, 0, 192))));
        tile39.add(new PlayerOverlay(new RightsideLotPane(Tiles.getTile(39), "Brastagi", new Color(0, 0, 192))));
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JPanel createPanel() {
        // GBL is important for the next step..
        JPanel gui = new JPanel(new GridBagLayout());
        JPanel squareComponent = new JPanel(new BorderLayout()) {
            private static final long serialVersionUID = 1L;
            @Override
            public Dimension getPreferredSize() {
                // Relies on being the only component
                // in a layout that will center it without
                // expanding it to fill all the space.
                Dimension d = this.getParent().getSize();
                int newSize = d.width > d.height ? d.height : d.width;
                newSize = newSize == 0 ? 100 : newSize;
                return new Dimension(newSize, newSize);
            }
        };

        squareComponent.add(panelMain);
        squareComponent.setBackground(Color.CYAN);
        gui.add(squareComponent);
        return gui;
    }

    /**
     * Called when the game is starting
     */
    public void onGameStart() {
        List<Player> players = GameManager.getInstance().getPlayers();

        // Initiate players
        for(Player player : players) {
            positionsMap.put(player.getDesignation(), 0);   // Put everyone on Go
            onPlayerMoved(player, 0);
        }
    }

    /**
     * Called when the game is finished
     * Clean up game-related objects, including Players
     */
    public void onGameFinished() {
        // Clear positions map
        positionsMap.clear();

        // Detach all players from all tiles
        for(JPanel jPanel : tiles) {
            if(jPanel instanceof PlayerOverlay) {
                ((PlayerOverlay) jPanel).detachAllPlayers();
            }
        }
    }

    /**
     * On player moved
     * @param player Player entity
     * @param tileIndex the index of the destination tile
     */
    public void onPlayerMoved(Player player, int tileIndex) {
        System.out.println("BoardWindow: player moved to " + tileIndex);
        /*SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });*/

        // Detach player from old position
        int oldPosition = positionsMap.get(player.getDesignation());
        ((PlayerOverlay) tiles[oldPosition].getComponent(0)).detachPlayer(player.getDesignation());

        // Attach player to new position
        ((PlayerOverlay) tiles[tileIndex].getComponent(0)).attachPlayer(player.getDesignation());

        positionsMap.put(player.getDesignation(), tileIndex);
    }

    /**
     * On player bankrupted
     * @param player Player entity
     */
    public void onPlayerBankrupted(Player player) {
        // Detach player from old position
        int oldPosition = positionsMap.get(player.getDesignation());
        ((PlayerOverlay) tiles[oldPosition].getComponent(0)).detachPlayer(player.getDesignation());
    }

    /**
     * On money changed
     * @param player Player entity
     * @param oldNominal old nominal
     * @param newNominal new nominal
     */
    public void moneyUpdated(Player player, int oldNominal, int newNominal) {
        // Do nothing
    }
}
