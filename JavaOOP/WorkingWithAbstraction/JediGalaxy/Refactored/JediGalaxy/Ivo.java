package WorkingWithAbstraction.JediGalaxy;

public class Ivo {
    private long stars;
    private int x;
    private int y;

    public Ivo() {
        this.stars = 0;
        this.x = 0;
        this.y = 0;
    }

    private int getX() { return this.x; }

    private void setX(int x) { this.x = x; }

    private int getY() { return this.y; }

    private void setY(int y) { this.y = y; }

    public long getStars() { return this.stars; }

    public void setStarterPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void collectStars(Galaxy galaxy) {
        while (this.getX() >= 0 && this.getY() < galaxy.getColLenght()) {
            if (isInRange(galaxy, this.getX(), this.getY())) {
                this.stars += galaxy.getStarValue(this.getX(), this.getY());
            }
            moveIvo();
        }
    }

    private void moveIvo() {
        this.x--;
        this.y++;
    }

    private static boolean isInRange(Galaxy galaxy, int x, int y) {
        return x >= 0 && x < galaxy.getRowLenght() && y >= 0 && y < galaxy.getColLenght();
    }
}