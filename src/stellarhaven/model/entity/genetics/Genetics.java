package stellarhaven.model.entity.genetics;

public class Genetics {
    // their hair color
    AllelePair<HairColorAllele.Color> hairColor;

    // their eye color
    AllelePair<EyeColorAllele.Color> eyeColor;

    // their strength
    AllelePair<Integer> strength;

    // their color preference
    AllelePair<ColorPreferenceAllele.Color> colorPreference;

    // their health
    AllelePair<Integer> health;

    // their intelligence
    AllelePair<Integer> intelligence;

    // their happiness modifier
    AllelePair<Integer> optimism;

    // their charisma
    AllelePair<Integer> charisma;

    // their right brain left brain percentages, for whether their intelligence is related to creativity or logic
    AllelePair<Double> hemisphereUsage;

    // their gender (Gender type already created, as enum between Male and Female.)
    Gender gender = generateGender();

    /**
     * Random genetics profile
     * 
     * @author William
     */
    public Genetics() {
        colorPreference = new AllelePair<>(ColorPreferenceAllele.getSupplier());
        strength = new AllelePair<>(StrengthAllele.getSupplier());
        hairColor = new AllelePair<>(HairColorAllele.getSupplier());
        eyeColor = new AllelePair<>(EyeColorAllele.getSupplier());
        health = new AllelePair<>(HealthAllele.getSupplier());
        intelligence = new AllelePair<>(IntelligenceAllele.getSupplier());

    }

    public Genetics(AllelePair<HairColorAllele.Color> hairColor, AllelePair<EyeColorAllele.Color> eyeColor, AllelePair<Integer> strength, AllelePair<ColorPreferenceAllele.Color> colorPreference, AllelePair<Integer> health, AllelePair<Integer> intelligence, AllelePair<Integer> optimism, AllelePair<Integer> charisma, AllelePair<Double> hemisphereUsage) {
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.strength = strength;
        this.colorPreference = colorPreference;
        this.health = health;
        this.intelligence = intelligence;
        this.optimism = optimism;
        this.charisma = charisma;
        this.hemisphereUsage = hemisphereUsage;
    }

    public Genetics(Genetics parent1, Genetics parent2) { // Assume parent1 is female and parent2 is male. Cause I ain't including weird stuff in my game cause progressive values are useless in a reproductive mission where the point is babies
        if (parent1.getGender() == parent2.getGender()) {
            throw new IllegalArgumentException("I'm sorry, but biology does not allow this to happen.");
        }
    }

    private Gender generateGender() {
        return Math.random() < 0.5025 ? Gender.MALE : Gender.FEMALE;
    }

    public Gender getGender() {
        return gender;
    }

    public HairColorAllele.Color getHairColor() {
        return hairColor.getDominantAllele().getValue();
    }

    public EyeColorAllele.Color getEyeColor() {
        return eyeColor.getDominantAllele().getValue();
    }
    
    public Integer getStrength() {
        return strength.getDominantAllele().getValue();
    }

    public ColorPreferenceAllele.Color getColorPreference() {
        return colorPreference.getDominantAllele().getValue();
    }

    public Integer getHealth() {
        return health.getDominantAllele().getValue();
    }

    public Integer getIntelligence() {
        return health.getDominantAllele().getValue();
    }

}
