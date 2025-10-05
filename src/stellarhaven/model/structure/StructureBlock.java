package stellarhaven.model.structure;

import stellarhaven.model.Structure;
import stellarhaven.util.Constants;
import stellarhaven.view.resources.ResourcePool;
import stellarhaven.view.resources.assets.Model;

public class StructureBlock extends Structure {

    public StructureBlock() {
        this.texture = (Model) ResourcePool.getPool(Constants.MODEL_POOL).getItem("models/model1.json");
    }

    @Override
    public void update() {

    }
}
