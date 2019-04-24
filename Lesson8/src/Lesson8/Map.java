package Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private Graphics g;
    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    final int cross = -1;
    final int zero = +1;
    int[][] field;
    int fieldSizeX;
    int fieldSizeY;
    int mode;
    int winLen;

    int cellHeight;
    int cellWidth;

    boolean isInitialized = false;
    boolean isCross;
    int countMoves;
    Random rnd = new Random();
    int moveX, moveY;

    Map() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {

                update(e);


            }
        });
    }

    void update(MouseEvent e) {


        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
//      System.out.println("x: " + cellX + " y: " + cellY);
        // repaint();
        g = getGraphics();

        if (MODE_H_V_A == mode) {
            if (!isCross) {
                if (field[cellY][cellX] == 0) {
                    g.drawLine(cellWidth * cellX + 5, cellHeight * cellY + 5, cellWidth * (cellX + 1) - 10, cellHeight * (cellY + 1) - 10);
                    g.drawLine(cellWidth * cellX + 5, cellHeight * (cellY + 1) - 10, cellWidth * (cellX + 1) - 10, cellHeight * cellY + 5);
                    field[cellY][cellX] = cross;
                    isCross = !isCross;

                    if (checkWin(cross)) {
                        JOptionPane.showMessageDialog(null, "Человек выиграл!");
                        hide();
                        return;
                    }
                    disable();
                    AiMove();
                    g.drawOval(cellWidth * moveX + 5, cellHeight * moveY + 5, cellWidth - 10, cellHeight - 10);
                    field[moveY][moveX] = zero;
                    isCross = !isCross;
                    enable();

                    if (checkWin(zero)) {
                        JOptionPane.showMessageDialog(null, "Компьютер выиграл!");
                        hide();
                        return;
                    }
                }

            }
        } else {
            if (isCross) {
                if (field[cellY][cellX] == 0) {
                    g.drawLine(cellWidth * cellX + 5, cellHeight * cellY + 5, cellWidth * (cellX + 1) - 10, cellHeight * (cellY + 1) - 10);
                    g.drawLine(cellWidth * cellX + 5, cellHeight * (cellY + 1) - 10, cellWidth * (cellX + 1) - 10, cellHeight * cellY + 5);
                    field[cellY][cellX] = cross;
                    isCross = !isCross;

                    if (checkWin(cross)) {
                        JOptionPane.showMessageDialog(null, "Крестик выиграл!");
                        hide();
                        return;
                    }
                }
            } else {
                if (field[cellY][cellX] == 0) {
                    g.drawOval(cellWidth * cellX + 5, cellHeight * cellY + 5, cellWidth - 10, cellHeight - 10);
                    field[cellY][cellX] = zero;
                    isCross = !isCross;

                    if (checkWin(zero)) {
                        JOptionPane.showMessageDialog(null, "Нолик выиграл!");
                        hide();
                        return;
                    }
                }
            }
        }

        countMoves++;
        if (countMoves == fieldSizeX * fieldSizeY) {
            JOptionPane.showMessageDialog(null, "Ничья");
        }
    }

    void AiMove() {
        //блокировка ходов человека
        for (int v = 0; v < fieldSizeY; v++) {
            for (int h = 0; h < fieldSizeX; h++) {
                //анализ наличие поля для проверки
                if (h + winLen <= fieldSizeX) {                           //по горизонтале
                    if (checkLineHorisont(v, h, cross) == winLen - 1) {
                        if (MoveAiLineHorisont(v, h, zero)) return;
                    }

                    if (v - winLen > -2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, cross) == winLen - 1) {
                            if (MoveAiDiaUp(v, h, zero)) return;
                        }
                    }
                    if (v + winLen <= fieldSizeY) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, cross) == winLen - 1) {
                            if (MoveAiDiaDown(v, h, zero)) return;
                        }
                    }
                }
                if (v + winLen <= fieldSizeY) {                       //по вертикале
                    if (checkLineVertical(v, h, cross) == winLen - 1) {
                        if (MoveAiLineVertical(v, h, zero)) return;
                    }
                }
            }
        }

        for (int v = 0; v < fieldSizeY; v++) {
            for (int h = 0; h < fieldSizeX; h++) {
                //анализ наличие поля для проверки
                if (h + winLen <= fieldSizeX) {                           //по горизонтале
                    if (checkLineHorisont(v, h, zero) == winLen - 1) {
                        if (MoveAiLineHorisont(v, h, zero)) return;
                    }

                    if (v - winLen > -2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, zero) == winLen - 1) {
                            if (MoveAiDiaUp(v, h, zero)) return;
                        }
                    }
                    if (v + winLen <= fieldSizeY) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, zero) == winLen - 1) {
                            if (MoveAiDiaDown(v, h, zero)) return;
                        }
                    }

                }
                if (v + winLen <= fieldSizeY) {                       //по вертикале
                    if (checkLineVertical(v, h, zero) == winLen - 1) {
                        if (MoveAiLineVertical(v, h, zero)) return;
                    }
                }
            }
        }
        int x, y;
        //случайный ход
        do {
            y = rnd.nextInt(fieldSizeY);
            x = rnd.nextInt(fieldSizeX);
        } while (!checkMove(y, x));
        moveX = x;
        moveY = y;
        field[y][x] = zero;
    }

    //проверка заполнения выбранного для хода игроком
    private boolean checkMove(int y, int x) {
        if (x < 0 || x >= fieldSizeX || y < 0 || y >= fieldSizeY) return false;
        else if (!(field[y][x] == 0)) return false;

        return true;
    }

    //ход компьютера по горизонтале
    private boolean MoveAiLineHorisont(int v, int h, int zero) {
        for (int j = h; j < winLen; j++) {
            if ((field[v][j] == 0)) {
                field[v][j] = zero;
                moveX = j;
                moveY = v;
                return true;
            }
        }
        return false;
    }

    //ход компьютера по вертикале
    private boolean MoveAiLineVertical(int v, int h, int zero) {
        for (int i = v; i < winLen; i++) {
            if ((field[i][h] == 0)) {
                field[i][h] = zero;
                moveX = h;
                moveY = i;
                return true;
            }
        }
        return false;
    }
    //проверка заполнения всей линии по диагонале вверх

    private boolean MoveAiDiaUp(int v, int h, int zero) {
        for (int i = 0, j = 0; j < winLen; i--, j++) {
            if ((field[v + i][h + j] == 0)) {
                field[v + i][h + j] = zero;
                moveX = h + j;
                moveY = v + i;
                return true;
            }
        }
        return false;
    }
    //проверка заполнения всей линии по диагонале вниз

    private boolean MoveAiDiaDown(int v, int h, int zero) {

        for (int i = 0; i < winLen; i++) {
            if ((field[i + v][i + h] == 0)) {
                field[i + v][i + h] = zero;
                moveX = i + h;
                moveY = i + v;
                return true;
            }
        }
        return false;
    }

    //проверка победы
    private boolean checkWin(int dot) {
        for (int v = 0; v < fieldSizeY; v++) {
            for (int h = 0; h < fieldSizeX; h++) {
                //анализ наличие поля для проверки
                if (h + winLen <= fieldSizeX) {                           //по горизонтале
                    if (checkLineHorisont(v, h, dot) >= winLen) return true;

                    if (v - winLen > -2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, dot) >= winLen) return true;
                    }
                    if (v + winLen <= fieldSizeY) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, dot) >= winLen) return true;
                    }
                }
                if (v + winLen <= fieldSizeY) {                       //по вертикале
                    if (checkLineVertical(v, h, dot) >= winLen) return true;
                }
            }
        }
        return false;
    }

    //проверка заполнения всей линии по диагонале вверх
    private int checkDiaUp(int v, int h, int zero) {
        int count = 0;
        for (int i = 0, j = 0; j < winLen; i--, j++) {
            if ((field[v + i][h + j] == zero)) count++;
        }
        return count;
    }
    //проверка заполнения всей линии по диагонале вниз

    private int checkDiaDown(int v, int h, int zero) {
        int count = 0;
        for (int i = 0; i < winLen; i++) {
            if ((field[i + v][i + h] == zero)) count++;
        }
        return count;
    }

    private int checkLineHorisont(int v, int h, int zero) {
        int count = 0;
        for (int j = h; j < winLen + h; j++) {
            if ((field[v][j] == zero)) count++;
        }
        return count;
    }

    //проверка заполнения всей линии по вертикале
    private int checkLineVertical(int v, int h, int zero) {
        int count = 0;
        for (int i = v; i < winLen + v; i++) {
            if ((field[i][h] == zero)) count++;
        }
        return count;
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.mode = mode;
        this.winLen = winLen;
        field = new int[fieldSizeY][fieldSizeX];
        isInitialized = true;
        countMoves = 0;
        isCross = false;
        show();
        repaint();


    }


    @Override
    protected void paintComponent(Graphics g) {
        this.g = g;
        super.paintComponent(g);
        render(g);


    }

    void circle(Graphics g) {

    }

    void render(Graphics g) {
        if (!isInitialized) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeX;
        cellWidth = panelWidth / fieldSizeY;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

    }

}
