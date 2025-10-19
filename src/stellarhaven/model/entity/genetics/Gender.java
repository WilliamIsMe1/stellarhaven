package stellarhaven.model.entity.genetics;

import stellarhaven.test.Test;
import stellarhaven.util.Equatable;

public enum Gender implements Equatable {
    MALE,
    FEMALE;

    public static Test getGenderTest() {
        return () -> {

            return null;
        };
    }
}
