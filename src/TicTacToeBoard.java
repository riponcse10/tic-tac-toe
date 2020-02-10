/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Font;

import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Ripon
 */
public class TicTacToeBoard extends JFrame{
    
    int MAX=1;
    int MIN=2;
    int turn;
    JButton[][] buttons;
    JButton start;
    JButton reset;
    TextArea details;
    JPanel buttonPanel;
    JPanel commentryPanel;
    JPanel gamePanel;
    JScrollPane scroll;
    BorderLayout layout;
    ArrayList<State> availableTiles = new ArrayList<>();
    int depth=0;
    int noOfAvailableTile;
    Font font;
    int[] goalArr;
    public TicTacToeBoard()
    {
        super("Tic Tac Toe");
        layout = new BorderLayout(5,5);
        setLayout(layout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        buttons = new JButton[3][3];
        start = new JButton("START NEW GAME");
        reset = new JButton("RESET");
        details = new TextArea(50,20);
        buttonPanel = new JPanel();
        commentryPanel = new JPanel();
        gamePanel = new JPanel(new GridLayout(3,3));
        buttonPanel.add(start);
        buttonPanel.add(reset);
        commentryPanel.add(details);
        goalArr = new int [8];
        
        //scroll = new JScrollPane(details);
        for (int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                buttons[i][j] = new JButton();
                gamePanel.add(buttons[i][j]);
                buttons[i][j].setEnabled(false);
            }
        }
        add(buttonPanel,BorderLayout.NORTH);
        add(gamePanel,BorderLayout.CENTER);
        add(commentryPanel,BorderLayout.EAST);
        turn = MAX;
        
        
        noOfAvailableTile =9;
        font = new Font("Dialog", Font.PLAIN, 24);
        buttons[0][0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[0][0].setText("O");
                changeGoalArr(0,0,MIN);
                turn = MAX;
                buttons[0][0].setEnabled(false);
                details.append("button 0 0 clicked\n");
                buttons[0][0].setFont(font);
                
                if (IsLeaf()==0) generateComputerMove();
                else if (IsLeaf()==2) details.append("Human wins\n.");
            }
        });
        
        buttons[0][1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[0][1].setText("O");
                changeGoalArr(0,1,MIN);
                turn = MAX;
                buttons[0][1].setEnabled(false);
                details.append("button 0 1 clicked\n");
                buttons[0][1].setFont(font);
                if (IsLeaf()==0) generateComputerMove();
                else if (IsLeaf()==2) details.append("Human wins\n.");
            }
        });
        buttons[0][2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[0][2].setText("O");
                changeGoalArr(0,2,MIN);
                turn = MAX;
                buttons[0][2].setEnabled(false);
                details.append("button 0 2 clicked\n");
                buttons[0][2].setFont(font);
                if (IsLeaf()==0) generateComputerMove();
                else if (IsLeaf()==2) details.append("Human wins\n.");
            }
        });
        buttons[1][0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[1][0].setText("O");
                changeGoalArr(1,0,MIN);
                turn = MAX;
                buttons[1][0].setEnabled(false);
                details.append("button 1 0 clicked\n");
                buttons[1][0].setFont(font);
                if (IsLeaf()==0) generateComputerMove();
                else if (IsLeaf()==2) details.append("Human wins\n.");
            }
        });
        buttons[1][1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[1][1].setText("O");
                changeGoalArr(1,1,MIN);
                turn = MAX;
                buttons[1][1].setEnabled(false);
                details.append("button 1 1 clicked\n");
                buttons[1][1].setFont(font);
                if (IsLeaf()==1) details.append("Computer wins\n");
                else if (IsLeaf()==2) details.append("Human wins\n.");
                else generateComputerMove();
            }
        });
        buttons[1][2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[1][2].setText("O");
                changeGoalArr(1,2,MIN);
                turn = MAX;
                buttons[1][2].setEnabled(false);
                details.append("button 1 2 clicked\n");
                buttons[1][2].setFont(font);
                if (IsLeaf()==0) generateComputerMove();
                else if (IsLeaf()==2) details.append("Human wins\n.");
            }
        });
        buttons[2][0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[2][0].setText("O");
                changeGoalArr(2,0,MIN);
                turn = MAX;
                buttons[2][0].setEnabled(false);
                details.append("button 2 0 clicked\n");
                buttons[2][0].setFont(font);
                if (IsLeaf()==0) generateComputerMove();
                else if (IsLeaf()==2) details.append("Human wins\n.");
            }
        });
        buttons[2][1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[2][1].setText("O");
                changeGoalArr(2,1,MIN);
                turn = MAX;
                buttons[2][1].setEnabled(false);
                details.append("button 2 1 clicked\n");
                buttons[2][1].setFont(font);
                if (IsLeaf()==0) generateComputerMove();
                else if (IsLeaf()==2) details.append("Human wins\n.");
            }
        });
        buttons[2][2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[2][2].setText("O");
                changeGoalArr(2,2,MIN);
                turn = MAX;
                buttons[2][2].setEnabled(false);
                details.append("button 2 2 clicked\n");
                buttons[2][2].setFont(font);
                if (IsLeaf()==0) generateComputerMove();
                else if (IsLeaf()==2) details.append("Human wins\n.");
            }
        });
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                details.append("\nNew Game Started!!!\n");
                for (int i=0;i<8;i++)
                {
                    goalArr[i]=0;
                }
                for (int i=0;i<3;i++)
                    for (int j=0;j<3;j++)
                    {
                        
                        buttons[i][j].setEnabled(true);
                    }
                firstMove();
                noOfAvailableTile--;
                start.setEnabled(false);
            }
        });
        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                details.append("\nReset Button Pressed!!!\n");
                noOfAvailableTile = 9;
                for (int i=0;i<3;i++)
                    for (int j=0;j<3;j++)
                    {
                        buttons[i][j].setText("");
                        buttons[i][j].setEnabled(false);
                    }
                start.setEnabled(true);
            }
        });
    }
    
    public void reverseGoalArray(int i,int j,int turn)
    {
        if (turn == MIN)
        {
            goalArr[i]+=1;
            goalArr[j+3]+=1;
            if (i==j) goalArr[6]+=1;
            if (i+j==2) goalArr[7]+=1;
        }
        else
        {
            goalArr[i]-=1;
            goalArr[j+3]-=1;
            if (i==j) goalArr[6]-=1;
            if (i+j==2) goalArr[7]-=1;
        }
    }
    
    public void changeGoalArr(int i,int j,int turn)
    {
        if (turn == MAX)
        {
            goalArr[i]+=1;
            goalArr[j+3]+=1;
            if (i==j) goalArr[6]+=1;
            if (i+j==2) goalArr[7]+=1;
        }
        else
        {
            goalArr[i]-=1;
            goalArr[j+3]-=1;
            if (i==j) goalArr[6]-=1;
            if (i+j==2) goalArr[7]-=1;
        }
        
    }
    
    
    public int IsLeaf()
    {
        for (int i=0;i<8;i++)
        {
            if (goalArr[i]==3) {System.out.println(goalArr[i]);return 1;}
            else if (goalArr[i]==-3) {System.out.println(goalArr[i]);return 2;}
        }
        
        
        return 0;
    }
    private class Tile
    {
        int row,column;
        public Tile(int x,int y)
        {
            row=x;
            column=y;
        }
    }
    
    private class State
    {
        int currentScore;
        
        int row;
        int column;
        public State(int x,int r,int c)
        {
            currentScore=x;
            row = r;
            column = c;
        }
    }
    
    private ArrayList<Tile> generateMoves()
    {
        ArrayList<Tile> nextMoves = new ArrayList<>();
        if (IsLeaf()==1 || IsLeaf()==2)
            return nextMoves;
        for (int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                if (buttons[i][j].getText().equals(""))
                {
                    nextMoves.add(new Tile(i,j));
                    
                }
            }
        }
        return nextMoves;
    }
    
    private int calculateUtilityValue()
    {
        int value=0;
        int X;
        int O;
        for (int i=0;i<3;i++)
        {
            X=0;
            O=0;
            for(int j=0;j<3;j++)
            {
                if(buttons[i][j].getText().equals("X")) X++;
                else if (buttons[i][j].getText().equals("O")) O++;
            }
            
            value += calculateChange(X,O);
        }
        for (int j=0;j<3;j++)
        {
            X=0;
            O=0;
            for(int i=0;i<3;i++)
            {
                if(buttons[i][j].getText().equals("X")) X++;
                else if (buttons[i][j].getText().equals("O")) O++;
            }
            
            value += calculateChange(X,O);
        }
        X=0;
        O=0;
        for(int p=0;p<3;p++)
        {
            if(buttons[p][p].getText().equals("X")) X++;
            else if (buttons[p][p].getText().equals("O")) O++;
        }
        
        value += calculateChange(X,O);
        X=0;
        O=0;
        for (int i=0,j=2;i<3;i++,j--)
        {
            if(buttons[i][j].getText().equals("X")) X++;
            else if (buttons[i][j].getText().equals("O")) O++;
        }
        
        value += calculateChange(X,O);
        return value;
    }
    private int calculateChange(int X,int O)
    {
        int change=0;
        if (X == 3) {
            change = 100;
        } else if (X !=0 ) {
            change = 1;
        }
        if (O == 3) {
            change = -100;
        } else if (O !=0) {
            change = -1;
        } 
        if (X==0 && O==0) {
            change = 0;
        } 
        return change;
    }
    
    private int calculateUtilityValueBook()
    {
        if (IsLeaf()==1) return 1;
        else if (IsLeaf()==2) return -1;
        else return 0;
    }
    
    private Tile move()
    {
        State state = alphabeta();
        return new Tile (state.row,state.column);
    }
    private int MAXVal(int alpha,int beta)
    {
        ArrayList<Tile> nextMoves = generateMoves();
        if (IsLeaf()!=0 || nextMoves.isEmpty())
        {
            int score = calculateUtilityValue();
            return score;
        }
        int utilvalue = Integer.MIN_VALUE;
        
        for (Tile move : nextMoves)
        {
            buttons[move.row][move.column].setText("X");
            changeGoalArr(move.row, move.column, MAX);
            depth++;
            utilvalue = Math.max(utilvalue, MINVal(alpha, beta));
            depth--;
            reverseGoalArray(move.row, move.column, MAX);
            if (depth==0)
            {
                State t = new State(utilvalue,move.row,move.column);
                availableTiles.add(t);
            }
                
            buttons[move.row][move.column].setText("");
            if (utilvalue >= beta) return utilvalue;
            alpha = Math.max(alpha, utilvalue);
        }
        return utilvalue;
    }
    private int MINVal(int alpha,int beta)
    {
        ArrayList<Tile> nextMoves = generateMoves();
        if (IsLeaf()!=0 || nextMoves.isEmpty())
        {
            int score = calculateUtilityValue();
            return score;
        }
        int utilvalue = Integer.MAX_VALUE;
        for (Tile move : nextMoves)
        {
            buttons[move.row][move.column].setText("O");
            changeGoalArr(move.row, move.column, MIN);
            utilvalue = Math.min(utilvalue, MAXVal(alpha, beta));
            buttons[move.row][move.column].setText("");
            reverseGoalArray(move.row, move.column, MIN);
            if (utilvalue <= alpha) return utilvalue;
            beta = Math.min(beta, utilvalue);
        }
        return utilvalue;
    }
    private State alphabeta()
    {
        int value = MAXVal(Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.println("Value: "+value);
        for (int i=0;i<availableTiles.size();i++){
        State state = availableTiles.get(i);
            if (state.currentScore == value) {
                availableTiles.clear();
                return state;
            }
        }
        return null;
    
    }
    private void generateComputerMove()
    {
        Tile selectedTile = move();
        changeGoalArr(selectedTile.row,selectedTile.column,MAX);
        turn = MIN;
        noOfAvailableTile = noOfAvailableTile -2;
        
        
        buttons[selectedTile.row][selectedTile.column].setText("X");
        buttons[selectedTile.row][selectedTile.column].setFont(font);
        
        buttons[selectedTile.row][selectedTile.column].setEnabled(false);
        
        if (IsLeaf()==1)
        {
            details.append("Computer wins!!!\n");
            for (int i=0;i<3;i++)
                for (int j=0;j<3;j++)
                {
                    if (buttons[i][j].getText().equals(""))
                        buttons[i][j].setEnabled(false);
                }
        }
        else if (noOfAvailableTile==0)
        {
            details.append("Game drawn!!!\n");
        }
        
    }
    private void firstMove()
    {
        Random rand = new Random();
        int i = rand.nextInt(3);
        int j = rand.nextInt(3);
        buttons[i][j].setText("X");
        changeGoalArr(i,j,MAX);
        buttons[i][j].setEnabled(false);
        buttons[i][j].setFont(font);
        turn = MIN;
    }
}
