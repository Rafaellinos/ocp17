
class Generico<T> {
  public <T> T test(T t) {
    return t;
  }
}

record RecordGeneric<T> (
  T genericField,
  String stringField
) {
}


public class GenericsExamples {
  public static void main(String... args) {
    Generico<Integer> g = new Generico<>();
    var a = g.test("Hahaha");
    System.out.println(a instanceof String); // true
    var gr = new RecordGeneric<Integer>(33, "Rafael");
    System.out.println(gr);
    
  }
}
