
public class Student {
  private int x;
  private int y;
  private int id;

  public Student(int x, int y, int id) {
    this.x = x;
    this.y = y;
    this.id = id;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getID() {
    return this.id;
  }

  @Override
  public String toString() {
    return this.id + "(" + this.x + "," + this.y + ")";
  }
}
