package stellarhaven.model.entity.genetics;

public class Genetics {
    // their hair color
    AllelePair hairColor;

    // their eye color
    AllelePair eyeColor;

    // their strength
    AllelePair strength;

    // their color preference
    AllelePair colorPreference;

    // their health
    AllelePair health;

    // their intelligence
    AllelePair intelligence;

    // their happiness modifier
    AllelePair happiness;

    // their charisma
    AllelePair charisma;

    // their right brain left brain percentages, for whether their intelligence is related to creativity or logic
    AllelePair hemisphereUsage;

    // their gender (Gender type already created, as enum between Male and Female.)
    Gender gender = generateGender();

    public Genetics() {

    }

    public Genetics(AllelePair hairColor, AllelePair eyeColor, AllelePair strength, AllelePair colorPreference, AllelePair health) {

    }

    public Genetics(Genetics parent1, Genetics parent2) { // Assume parent1 is female and parent2 is male. Cause I ain't including weird stuff in my game cause progressive values are useless in a reproductive mission where the point is babies

    }

    private Gender generateGender() {
        return Math.random() < 0.5025 ? Gender.MALE : Gender.FEMALE;
    }

    public Gender getGender() {
        return gender;
    }
}
