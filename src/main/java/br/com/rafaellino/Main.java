package br.com.rafaellino;

class Teste {
  private int a;
  public Teste(int a) {
    this.a = a;
  }

  public int getA() {
    return a;
  }
}

class Teste2 {

}

public class Main {
  public final static void main(final String[] args) {
    // args[99];
    Teste t = new Teste(1);
    Teste2 t2 = new Teste2();
    System.out.println(t.getA());
    LocalClass localClass = new LocalClass();
    FirstMockExam.question11();
  }
}
