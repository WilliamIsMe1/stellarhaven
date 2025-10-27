package stellarhaven.test;

import stellarhaven.model.entity.genetics.Gender;

public class AllTestsSuite extends TestSuite {
    @Override
    public void initializeSuite() {
        tests.add(Gender.getGenderTest());
    }
}
