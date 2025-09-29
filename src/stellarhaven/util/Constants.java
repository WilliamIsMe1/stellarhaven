package stellarhaven.util;

import stellarhaven.view.GamePanel;

public interface Constants {
    int TILE_SIZE = 16;
    int GAME_SCALE = GamePanel.SCALE;
    int IMAGE_POOL = 0;
    int AUDIO_POOL = 1;
    int MODEL_POOl = 2;
    /**
     * This is the chance a gene calles {@link Allele#mutate()}
     */
    double MUTATION_CHANCE = 0.01;
}
