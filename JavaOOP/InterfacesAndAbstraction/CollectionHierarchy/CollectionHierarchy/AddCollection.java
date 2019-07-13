package InterfacesAndAbstraction.CollectionHierarchy;

public class AddCollection extends Collection implements Addable{

    @Override
    public int add(String item) {
        this.getItems().add(item);
        return this.getItems().indexOf(item);
    }
}