package stellarhaven.test;

import stellarhaven.model.entity.genetics.BiologicalSex;

public class AllTestsSuite extends TestSuite {
    @Override
    public void initializeSuite() {
        tests.add(BiologicalSex.getGenderTest());
    }
}
