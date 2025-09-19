import java.util.*;

class Spreadsheet {
    private int[][] sheet;  

    public Spreadsheet(int rows) {
        sheet = new int[rows][26]; 
    }

    private int getRow(String cell) {
        int row = 0;
        for (int i = 1; i < cell.length(); i++) {
            row = row * 10 + (cell.charAt(i) - '0');
        }
        return row - 1; 
    }

    private int getCol(String cell) {
        return cell.charAt(0) - 'A';
    }

    public void setCell(String cell, int value) {
        int row = getRow(cell);
        int col = getCol(cell);
        sheet[row][col] = value;
    }

    public void resetCell(String cell) {
        int row = getRow(cell);
        int col = getCol(cell);
        sheet[row][col] = 0;
    }

    public int getValue(String formula) {
        if (formula.charAt(0) != '=') {
            return Integer.parseInt(formula);
        }

        String[] parts = formula.substring(1).split("\\+");
        int sum = 0;

        for (String part : parts) {
            part = part.trim();
            if (Character.isLetter(part.charAt(0))) {
                int row = getRow(part);
                int col = getCol(part);
                sum += sheet[row][col];
            } else {
                sum += Integer.parseInt(part);
            }
        }
        return sum;
    }
}

/**
 * Example usage:
 * Spreadsheet obj = new Spreadsheet(10);
 * obj.setCell("A1", 5);
 * obj.setCell("B2", 3);
 * System.out.println(obj.getValue("=A1+B2+7")); // prints 15
 */
