package packageexamplea;

public class ClassA {
 public ClassA() {
    System.out.println("construct classAAAA");
 }   
 public void ClassA() {
   String someString = """
   I'm a method! \
   YES!""";
   // the "\" in the text block indicates to not break a line.
   System.out.println(someString);
 }
}