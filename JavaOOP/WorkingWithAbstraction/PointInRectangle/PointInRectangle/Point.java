package WorkingWithAbstraction.PointInRectangle;

public class Point {
    private int coordinatesX;
    private int coordinatesY;

    public Point(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
    }

    public int getCoordinatesX() { return this.coordinatesX; }

    public int getCoordinatesY() { return this.coordinatesY; }
}