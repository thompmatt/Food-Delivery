
public class Delivery implements Comparable<Delivery> {
  private int studentId;
  private String robotName;
  private int distance;

  public Delivery(Student student, FoodRobot robot) {
    this.studentId = student.getID();
    this.robotName = robot.getName();
    this.distance =
        Math.abs(student.getX() - robot.getX()) + Math.abs(student.getY() - robot.getY());
  }

  @Override
  public int compareTo(Delivery delivery) {
    // If delivery distances are the same:
    if (this.distance == delivery.distance) {
      // If studentId's are the same
      if (this.studentId == delivery.studentId) {
        // If this.robotName is lexicographically earlier than delivery.robotName
        if (this.robotName.compareTo(delivery.robotName) <= 0) {
          return -1;
        } else { // delivery.robotName is lexicographically earlier than this.robotName
          return 1;
        }
      } else if (this.studentId < delivery.studentId) { // If this.studentId is less than
                                                        // delivery.studentId
        return -1;
      } else { // delivery.studentId is less than this.studentId
        return 1;
      }
    } else if (this.distance < delivery.distance) { // If this.distance is less than
                                                    // delivery.distance
      return -1;
    } else {// delivery.distance is less than this.distance
      return 1;
    }
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Delivery) { // Checks if it is a Delivery object
      Delivery delivery = (Delivery) object;

      if (this.studentId == delivery.studentId) { // If this.studentId is equal to the object's
                                                  // studentId
        return true;
      } else if (this.robotName.equals(delivery.robotName)) { // If this.robotName is equal to the
                                                              // object's robotName
        return true;
      } else {
        return false;
      }
    } else if (object instanceof Student) { // Checks if it is a Student object
      Student student = (Student) object;

      if (this.studentId == student.getID()) { // Checks if this.studentId matches the object's ID
        return true;
      } else {
        return false;
      }
    } else if (object instanceof FoodRobot) {
      FoodRobot robot = (FoodRobot) object;

      if (this.robotName.equals(robot.getName())) {
        return true;
      } else {
        return false;
      }
    } else { // Object is none of the above
      return false;
    }
  }

  @Override
  public String toString() {
    return "The distance between " + studentId + " and " + robotName + " is " + distance;
  }
}
