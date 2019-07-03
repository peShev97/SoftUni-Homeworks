package WorkingWithAbstraction.JediGalaxy;

public class Galaxy {
    private int[][] galaxy;

    public Galaxy(int rows, int cols) {
        this.galaxy = new int[rows][cols];
        fillTheGalaxy();
    }

    public int getColLenght() {
        return this.galaxy[1].length;
    }

    public int getRowLenght() {
        return this.galaxy.length;
    }

    public int getStarValue(int x, int y) {
        return this.galaxy[x][y];
    }

    public void setStarValue(int x, int y) {
        this.galaxy[x][y] = 0;
    }

    private void fillTheGalaxy() {
        int value = 0;
        for (int i = 0; i < this.galaxy.length; i++) {
            for (int j = 0; j < this.galaxy[i].length; j++) {
                this.galaxy[i][j] = value++;
            }
        }
    }
}