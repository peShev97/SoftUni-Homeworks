package Generics.Tuple;

public class Tuple<T1, T2, T3> {
    private T1 itemOne;
    private T2 itemTwo;
    private T3 itemThree;

    public Tuple() {
    }

    public void setItemOne(T1 itemOne) { this.itemOne = itemOne; }

    public void setItemTwo(T2 itemTwo) { this.itemTwo = itemTwo; }

    public void setItemThree(T3 itemThree) { this.itemThree = itemThree; }

    @Override
    public String toString() {
        return itemOne + " -> " + itemTwo + " -> " + itemThree;
    }
}
