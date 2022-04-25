import java.util.ArrayList;

public class Resource {

    private String name;
    private String resourceType;
    private ArrayList<String> requiredLands;
    private Technology requiredTechnology;
    private Improvement requiredImprovement;


    public Resource(String name, String resourceType, ArrayList<String> requiredLands,
                    Technology requiredTechnology, Improvement requiredImprovement) {
        this.name = name;
        this.resourceType = resourceType;
        this.requiredLands = requiredLands;
        this.requiredTechnology = requiredTechnology;
        this.requiredImprovement = requiredImprovement;
    }

    public String getName() {
        return name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public ArrayList<String> getRequiredLands() {
        return requiredLands;
    }

    public Technology getRequiredTechnology() {
        return requiredTechnology;
    }

    public Improvement getRequiredImprovement() {
        return requiredImprovement;
    }

}
