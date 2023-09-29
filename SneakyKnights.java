// Justin Lugo
// COP 3403, Fall 2021

import java.io.*;
import java.util.*;
import java.awt.*;

public class SneakyKnights
{
  public static boolean allTheKnightsAreSafe(ArrayList<String> coordinateStrings, int boardSize)
  {
    // The purpose of this function is to take in an ArrayList of coordinates and determine
    // if the Knights pieces that they represent on a grid are out of each others' line of sights.
    // To start this off, we declare / set-up the variables that we will be using.
    int i, k, currCol, currRow;
    Point currKnight, leftOneUpTwo, leftOneDownTwo, leftTwoUpOne, leftTwoDownOne, rightOneUpTwo,
      rightOneDownTwo, rightTwoUpOne, rightTwoDownOne;

    // We are going to use a HashSet (which is good in this case for not allowing duplicates)
    // that holds the points we want.
    HashSet<Point> points = new HashSet<>();

    // Adapted from my SneakyQueens assignment to accomodate HashSets and Points, we iterate through
    // the ArrayList to start the "Are the Knights Safe?" procedure.
    for (String coordStr: coordinateStrings)
    {
      // Our letters correlate to our columns, so we'll do those first. Should we come across a
      // number, we know that's the end of our letter part of the string, so we break there and
      // apply ASCII arithmetic to determine our rows.
      currCol = 0;
      for (i = 0; i < coordStr.length(); i++)
      {
        if (Character.isDigit(coordStr.charAt(i)))
        {
          break;
        }
        currCol = (currCol * 26) + (coordStr.charAt(i) - 96);
      }

      // Next we have to the rows. The integers associated to this come after the letters, so we
      // loop through said letters to skip over them and start the parsing once we get to the
      // integer values within the string, breaking the if-statement once we reach the end.
      currRow = 0;
      for (k = 0; k < coordStr.length(); k++)
      {
        if (Character.isLetter(coordStr.charAt(k)))
        {
          continue;
        }
        if (Character.isDigit(coordStr.charAt(k)))
        {
          currRow = Integer.parseInt(coordStr.substring(k));
          break;
        }
      }

      // We place our knight at its respective row and column.
      currKnight = new Point(currRow, currCol);
      points.add(currKnight);

      // We place points to see if there are any other knights at the respective coordinates that
      // the knight chess piece can move.
      leftOneUpTwo = new Point(currRow - 1, currCol + 2);
      leftOneDownTwo = new Point(currRow - 1, currCol - 2);
      leftTwoUpOne = new Point(currRow - 2, currCol + 1);
      leftTwoDownOne = new Point(currRow - 2, currCol - 1);
      rightOneUpTwo = new Point(currRow + 1, currCol + 2);
      rightOneDownTwo = new Point(currRow + 1, currCol - 2);
      rightTwoUpOne = new Point(currRow + 2, currCol + 1);
      rightTwoDownOne = new Point(currRow + 2, currCol - 1);

      // If ANY of the other points has a Knight, immediately return false because the knights are
      // not safe.
      if (points.contains(leftOneUpTwo) || points.contains(leftOneDownTwo) ||
        points.contains(leftTwoUpOne) || points.contains(leftTwoDownOne) ||
        points.contains(rightOneUpTwo) || points.contains(rightOneDownTwo) ||
        points.contains(rightTwoUpOne) || points.contains(rightTwoDownOne))
      {
          return false;
      }
    }
    // If we've gotten this far, our knights are all safe.
    return true;
  }

  public static double difficultyRating()
  {
    // This function returns an value representative of my feelings regarding the difficulty of the
    // assignment.
    return 3.0;
  }

  public static double hoursSpent()
  {
    // This function returns an approximate value of how long this assignment took me.
    return 3.0;
  }
}
