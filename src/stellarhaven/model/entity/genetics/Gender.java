package stellarhaven.model.entity.genetics;

import stellarhaven.test.CountedData;
import stellarhaven.test.InfoResult;
import stellarhaven.test.Test;
import stellarhaven.util.Equatable;
import stellarhaven.util.Utils;

import java.util.Random;

public enum Gender implements Equatable {
    MALE,
    FEMALE;

    public static Test getGenderTest() {
        return () -> {
            CountedData<Gender> data =  new CountedData<>();
            Random random = new Random();
            for (int i : Utils.range(25)) {
                data.add(random.nextBoolean() ?  MALE : FEMALE);
            }
            return new InfoResult("Display: \n", data);
        };
    }
}
