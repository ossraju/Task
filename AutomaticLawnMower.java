/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task;

/**
 *
 * @author shivasairajuomkar
 */


/******
 * Company is building an automatic lawn mower designed to mow rectangular surfaces.
 * (The mower can be programmed to mow the entire surface.)
 * The position of the mower can be represented by coordinates (x,y) and by a letter giving the
 * cardinal direction (N,E,W,S). The lawn is divided into a grid to simplify the navigation.
 * For example, a mower position can be « 0, 0, N », it means that this mower is located at the
 * lower-left corner of the lawn, and it is oriented North.
 * The mower is controlled by sending it a sequence of letters. Possible letters are « R », « L » and «
 * F ». « R » and « L » make the mower rotate of 90° respectively to the left or to the right, without
 * moving. « F » means that the mower is moving forward on the cell in front of it, without changing
 * its orientation.
 * If the position after the move is outside the lawn, then the mower do not move, it keeps its
 * orientation and process the next command.
 * The cell directly at North of the position (x, y) has for coordinates (x, y+1).
 * An input file following these rules is given to program the mower:
 * The first line is the coordinates of the upper-right corner of the lawn, coordinates of lower-left
 * corner are supposed to be (0,0)
 * Next lines of the file drive all mowers. There are two lines for each mower:
 * First line give the initial position and orientation of the mower. Position and orientation are given
 * by 2 numbers and a letter, separated by a space
 * Second line is a sequence of instruction driving the mower across the lawn. Instructions are a
 * sequence of letters without space.
 * Each mower moves sequentially, it means that the second mower moves only after the first one
 * execute all its instructions.
 * When the mower has executed all its instructions, it outputs its position and orientation.
 *
 * GOAL
 * Design and write a program implementing the above specifications and validating the following
 * test.
 * TEST
 * This file is given in input:
 * 5 5
 * 1 2 N
 * LFLFLFLFF
 * 3 3 E
 * FFRFFRFRRF
 *
 * This output is expected (final positions of mowers):
 * 1 3 N
 * 5 1 E
 *
 */


import java.util.Scanner;

public class AutomaticLawnMower {

    public static void main(String[] args) {
        System.out.println("Welcome!!!");
         
        Scanner sc = new Scanner(System.in);

        //Number of different locations from where the automatic lawn mower start mowing
        int N = sc.nextInt();

        // (X,Y) coordinates of the rectangular lawn

        int X = sc.nextInt();
        int Y = sc.nextInt();

        for (int i = 0; i < N; i++) {
            // (x,y) coordinates for the starting point of the lawn mower
             int x = sc.nextInt();
             int y = sc.nextInt();

            // Direction of the lawn mower
              String direction = sc.next();

            // This string taken input for movement by 'F and changing directions by 'L', 'R'
              String movement = sc.next();
            getFinalPosition(X,Y,x,y,direction,movement);
        }
    }

    //Method to get the final position of the mower
    private static void getFinalPosition(int X, int Y, int x, int y, String direction, String movement){
        int length = movement.length();

        for(int i=0;i<length;i++){
            if(movement.charAt(i) == 'F' && (direction.equals("N"))){
                 if(y<=Y){
                    y++;
                }
            }else if(movement.charAt(i) == 'F' && (direction.equals("S"))){
                if(y!=0){
                    y--;
                }
            }else if(movement.charAt(i) == 'F' && (direction.equals("E"))){
                if(x<=X){
                    x++;
                }
            }else if(movement.charAt(i) == 'F' && (direction.equals("W"))){
                if(x!=0){
                    x--;
                }
            }else{
                direction = getChangedDirection(direction,movement.charAt(i));
            }
        }

        System.out.println(x+" "+y+" "+direction);

    }

    //Method to change the direction of the
    private static String getChangedDirection(String direction, char movement){
        switch (direction){
            case "N":
                if(direction.equals("L")) return "W";
                return "E";

            case "S":
                if(direction.equals("L")) return "E";
                return "W";

            case "E":
                if(direction.equals("L")) return "N";
                return "S";

            case "W":
                if(direction.equals("L")) return "S";
                return "N";
        }
        return direction;
    }
}

