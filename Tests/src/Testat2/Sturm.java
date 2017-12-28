package Testat2;

public class Sturm {
  private String name;
  private String date;
  private double damage;
  private double speedkm;
  private double speedSmph;
  private double beaufort;
  private Windstaerke strength;

  public Sturm(String name, String date, double damage, double speedkm) {
    this.name = name;
    this.date = date;
    this.damage = damage;
    this.speedkm = speedkm;
  }

  @Override
  public String toString() {
    return "Sturm" +
        "name='" + name + '\'' +
        ", date='" + date + '\'' +
        ", damage=" + damage +
        ", speedkm=" + speedkm +
        ", speedSmph=" + speedSmph +
        ", beaufort=" + beaufort +
        ", strength=" + strength
        + "\n";
  }

  /**
   * Exercise 3: Method to transform to speed
   * @param speedkm the speed in kilometers per hour
   * @return the speed in seemiles per hour
   */
  public static double seemeilen(double speedkm) {
    return speedkm / 1.852;
  }

  /**
   * Exercise 4: Getting the beaufortvalue
   * @param speedkm the speed in kilometers per hour
   * @return the beaufortvalue
   */
  public static int beaufortwert(double speedkm) {
    return (int) Math.round(Math.pow(speedkm / 3.01, 2 / 3));
  }

  /**
   * Exercise 5: Getting the windstaerke.
   * @param speedkm speed in kilometers per hour
   * @return windstaerke
   */
  public static Windstaerke staerke(double speedkm) {
    if (speedkm < 140) {
      return Windstaerke.STURM;
    } else if (speedkm > 150) {
      return Windstaerke.ORKAN;
    } else {
      return Windstaerke.ORKANARTIG;
    }
  }

  /**
   * speedkm getter
   * @return speed in kilometers per hour
   */
  public double getSpeedkm() {
    return speedkm;
  }

  public void setSpeedSmph(double speedSmph) {
    this.speedSmph = speedSmph;
  }

  public void setBeaufort(double beaufort) {
    this.beaufort = beaufort;
  }

  public void setStrength(Windstaerke strength) {
    this.strength = strength;
  }
}
