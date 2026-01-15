package stellarhaven.model.entity.genetics;

import stellarhaven.test.CountedData;
import stellarhaven.test.InfoResult;
import stellarhaven.test.Test;
import stellarhaven.util.Equatable;

import java.util.Random;

public enum BiologicalSex implements Equatable {
    MALE,
    FEMALE;

    public static Test getGenderTest() {
        return () -> {
            CountedData<BiologicalSex> data =  new CountedData<>();
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                data.add(random.nextBoolean() ?  MALE : FEMALE);
            }
            return new InfoResult("Display: \n", data);
        };
    }
}
