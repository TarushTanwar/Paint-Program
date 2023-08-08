import java.util.Scanner;

public class Paint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter canvas width: ");
        int width = scanner.nextInt();

        System.out.print("Enter canvas height: ");
        int height = scanner.nextInt();

        char[][] canvas = new char[height][width];

        initializeCanvas(canvas);

        boolean running = true;

        while (running) {
            System.out.print("Enter process (print/draw/clear/exit): ");
            String action = scanner.next();

            switch (action) {
                case "print":
                    printCanvas(canvas);
                    break;

                case "draw":
                    System.out.print("Enter shape (line/circle): ");
                    String shape = scanner.next();

                    switch (shape) {
                        case "line":
                            drawLine(canvas);
                            break;
                        case "circle":
                            drawCircle(canvas);
                            break;
                        default:
                            System.out.println("Invalid shape. Please enter 'line' or 'circle'.");
                    }
                    break;

                case "clear":
                    initializeCanvas(canvas);
                    break;

                case "exit":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid shape. Please enter 'line', 'circle', or 'exit'.");
            }
        }

        System.out.println("Paint program exited.");
    }

    private static void initializeCanvas(char[][] canvas) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    private static void printCanvas(char[][] canvas) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }

    private static void drawLine(char[][] canvas) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter starting point (x1 y1): ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.print("Enter ending point (x2 y2): ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (i >= 0 && i < canvas.length && j >= 0 && j < canvas[0].length) {
                    canvas[i][j] = 'x';
                }
            }
        }
    }

    private static void drawCircle(char[][] canvas) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter center (x y): ");
        int centerX = scanner.nextInt();
        int centerY = scanner.nextInt();

        System.out.print("Enter radius: ");
        int radius = scanner.nextInt();

        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                double distance = Math.sqrt(Math.pow(j - centerX, 2) + Math.pow(i - centerY, 2));
                if (distance <= radius) {
                    canvas[i][j] = 'o';
                }
            }
        }
    }
}

