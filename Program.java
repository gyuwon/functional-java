import java.util.Iterator;

public final class Program {
  public static void main(String... args) {
    for (Integer e : take(25, squaresOf(integer()))) {
      System.out.println(e);
    }
  }

  public static Iterable<Integer> take(int count, Iterable<Integer> source) {
    return new Iterable<Integer>() {
      public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
          Iterator<Integer> iterator = source.iterator();
          int cursor = 0;
          public boolean hasNext() {
            return cursor < count && this.iterator.hasNext();
          }
          public Integer next() {
            ++this.cursor;
            return this.iterator.next();
          }
        };
      }
    };
  }

  public static Iterable<Integer> squaresOf(Iterable<Integer> source) {
    return new Iterable<Integer>() {
      public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
          Iterator<Integer> iterator = source.iterator();
          public boolean hasNext() {
            return this.iterator.hasNext();
          }
          public Integer next() {
            Integer e = this.iterator.next();
            int n = e.intValue();
            return n * n;
          }
        };
      }
    };
  }

  public static Iterable<Integer> integer() {
    return new Iterable<Integer>() {
      public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
          int current = 0;
          public boolean hasNext() {
            return this.current < Integer.MAX_VALUE;
          }
          public Integer next() {
            return new Integer(++current);
          }
        };
      }
    };
  }
}
