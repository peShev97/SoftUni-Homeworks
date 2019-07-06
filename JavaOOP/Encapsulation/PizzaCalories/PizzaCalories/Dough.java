
public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    private double flourTypeModifier;
    private double bakingTechniqueModifier;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private double getWeight() {
        return this.weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White":
                this.flourTypeModifier = 1.5;
                break;
            case "Wholegrain":
                this.flourTypeModifier = 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                this.bakingTechniqueModifier = 0.9;
                break;
            case "Chewy":
                this.bakingTechniqueModifier = 1.1;
                break;
            case "Homemade":
                this.bakingTechniqueModifier = 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        return (2 * this.getWeight()) * this.flourTypeModifier * this.bakingTechniqueModifier;
    }
}