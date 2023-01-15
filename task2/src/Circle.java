public class Circle {

    private final float cx;
    private final float cy;
    private final float r;

    public Circle(float cx, float cy, float r) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    public float getCx() {
        return cx;
    }

    public float getCy() {
        return cy;
    }

    public float getR() {
        return r;
    }

    @Override
    public String toString() {
        return "cx = " + cx + "\ncy = " + cy + "\nr = " + r;
    }
}
