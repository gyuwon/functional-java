using System;
using System.Collections.Generic;

foreach (var e in Take(25, SquaresOf(Integers())))
{
  Console.WriteLine(e);
}

public static IEnumerable<int> Take(int count, IEnumerable<int> source)
{
  foreach (int e in source)
  {
    if (count-- == 0) yield break;
    yield return e;
  }
}

public static IEnumerable<int> SquaresOf(IEnumerable<int> source)
{
  foreach (int e in source)
  {
    yield return e * e;
  }
}

public static IEnumerable<int> Integers()
{
  int current = 0;
  while (current < int.MaxValue)
  {
    yield return ++current;
  }
}

