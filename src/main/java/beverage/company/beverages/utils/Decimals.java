package beverage.company.beverages.utils;

public class Decimals {


  public static Double round(double var) {
    return (double) Math.round(((var) * 100d) / 100d);

  }


  public static Double floor(double var) {
    return Math.floor(var * 100) / 100;

  }
}
