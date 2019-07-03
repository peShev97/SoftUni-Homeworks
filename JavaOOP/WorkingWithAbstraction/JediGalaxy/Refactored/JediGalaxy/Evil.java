package WorkingWithAbstraction.JediGalaxy;

public class Evil {
    private int x;
    private int y;

    public Evil() {
        this.x = 0;
        this.y = 0;
    }

    private int getX() { return this.x; }

    private void setX(int x) { this.x = x; }

    private int getY() { return this.y; }

    private void setY(int y) { this.y = y; }

    public void setStarterPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void destroyStars(Galaxy galaxy) {
        while (this.getX() >= 0 && this.getY() >= 0) {
            if (isInRange(galaxy, this.getX(), this.getY())) {
                galaxy.setStarValue(this.getX(), this.getY());
            }
            moveEvil();
        }
    }

    private void moveEvil() {
        this.x--;
        this.y--;
    }

    private static boolean isInRange(Galaxy galaxy, int x, int y) {
        return x >= 0 && x < galaxy.getRowLenght() && y >= 0 && y < galaxy.getColLenght();
    }
}