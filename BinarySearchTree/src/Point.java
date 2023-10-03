public class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** copy constructor */
    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    /** I changed the implementation of the Pointer class to make it work with my BinarySearchTree class.
     * I also implemented the other functions, but they won't be used in this assignment. */
    @Override
    public int compareTo(Point obj) {
        int xComparison = Integer.compare(this.x, obj.x);
        if (xComparison != 0) {
            return xComparison;
        }
        return Integer.compare(this.y, obj.y);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    /** check if the current point is less than the given point */
    public boolean isLessThan(Point obj) {
        if (this.x < obj.x) return true;
        else if (this.x == obj.x) return this.y < obj.y;
        else return false;
    }

    /** check if the current point is more than the given point */
    public boolean isGreaterThan(Point obj) {
        if (this.x > obj.x) return true;
        else if (this.x == obj.x) return this.y > obj.y;
        else return false;
    }

    /** check if the current point is equal to the given point */
    public boolean equals(Point obj) {
        return this.x == obj.x && this.y == obj.y;
    }

    /** check if the current point is NOT equal to the given point */
    public boolean notEquals(Point obj) {
        return !this.equals(obj);
    }
}
