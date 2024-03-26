package lambdas;

@FunctionalInterface
public interface ILambda {
  boolean check(RecordAnimal a);
  private static String someStaticMethod() {
    return "Im useless";
  }
  public default void printSomething() {
    System.out.println(someStaticMethod());
  }
}
