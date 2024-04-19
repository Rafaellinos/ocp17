import java.util.*;

public class Person implements Comparable<Person> {  
  public Person(String name, Integer age) {
    this.name = name;
    this.age = age;
  }
  
  private String name;
  private Integer age;

  public String getName() {return this.name;};
  public void setName(String name) {this.name = name;}
  public Integer getAge() {return this.age;}
  public void setAge(Integer age) {this.age = age;}

  @Override
  public int compareTo(Person otherPerson) {
    return age.compareTo(otherPerson.getAge());
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("{")  
      .append("name=")
      .append(this.name)
      .append(",age=")
      .append(this.age.toString())
      .append("}")
      .toString();
  }

  public static void main(String[] args) {
    List<Person> persons = new ArrayList<>();
    persons.add(new Person("Rafael", 33));
    persons.add(new Person("Yasmin", 25));
    System.out.println(persons); // [Rafael, Yasmin]
    Collections.sort(persons);
    System.out.println(persons); // [Yasmin, Rafael]
  }
}