
public class FoodRobot {
  private int x;
  private int y;
  private String name;

  public FoodRobot(int x, int y, String name) {
    this.x = x;
    this.y = y;
    this.name = name;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return this.name + "(" + this.x + "," + this.y + ")";
  }
}
