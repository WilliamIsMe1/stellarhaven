package stellarhaven.model.structure;

import stellarhaven.model.Structure;
import stellarhaven.util.Constants;
import stellarhaven.view.resources.ResourcePool;
import stellarhaven.view.resources.assets.Model;

public class StructureBlock extends Structure {

    public StructureBlock() {
        this.texture = (Model) ResourcePool.getPool(Constants.MODEL_POOL).getItem("models/model1.json");
    }

    int counter;
    @Override
    public void update() {
        counter++;
        if (counter == 60) {
            System.out.println("Yippee! I exist!");
            counter = 0;
        }
    }
}
