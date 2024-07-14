package ru.kochubey.geometry;

// функциональность класса реализована не полностью
public class Point3D implements Pointable<Point3D> {
    private int x;
    private int y;
    private int z;

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" + x + ';' + y + ':' + z + '}';
    }

    @Override
    public int lengthTo(Point3D p) {
        return (int) Math.sqrt(Math.pow(this.x - p.x, 2) +
                Math.pow(this.y - p.y, 2) + Math.pow(this.z - p.z, 2));
    }

    @Override
    public Point3D clone() {
        try {
            return (Point3D) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
