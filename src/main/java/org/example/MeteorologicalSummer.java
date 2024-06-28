package org.example;

import java.util.Scanner;

public class MeteorologicalSummer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean tryAgainMonth = true;

        while (tryAgainMonth) {
            System.out.println("Please enter the month:");

            if (input.hasNextInt()) {
                int month = input.nextInt();
                if (month == 6 || month == 7 || month == 8) {
                    boolean tryAgainDay = true;

                    while (tryAgainDay) {
                        System.out.println("Please enter the day:");

                        if (input.hasNextInt()) {
                            int day = input.nextInt();
                            input.nextLine(); // Consume newline left-over
                            System.out.println("You entered " + month + "/" + day + ".");

                            if ((month == 6 && (day > 30 || day < 1)) || (month == 7 && (day > 31 || day < 1)) || (month == 8 && (day > 31 || day < 1))) {
                                System.out.println("The day is invalid.");
                                System.out.println("Do you want to try again? (Y/N)");
                                if (input.hasNext()) {
                                    String dayDecision = input.nextLine();
                                    if ("Y".equalsIgnoreCase(dayDecision)) {
                                        // Continue the loop to try again
                                    } else {
                                        tryAgainDay = false;
                                        tryAgainMonth = false;
                                        System.out.println("Unfortunately, we are not able to get your important summer date!");
                                    }
                                }
                            } else {
                                tryAgainDay = false;
                                tryAgainMonth = false;
                                System.out.println("Congrats! We know " + month + "/" + day + " is important for you!");
                            }
                        } else {
                            System.out.println("The day is invalid.");
                            System.out.println("Do you want to try again? (Y/N)");
                            if (input.hasNext()) {
                                String dayDecision = input.nextLine();
                                if ("Y".equalsIgnoreCase(dayDecision)) {
                                    // go back to please enter the day
                                } else {
                                    tryAgainDay = false;
                                    tryAgainMonth = false;
                                    System.out.println("Unfortunately, we are not able to get your important summer date!");
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("The month is invalid. Do you want to try again? (Y/N)");
                    input.nextLine(); // Consume the leftover newline
                    if (input.hasNext()) {
                        String decision = input.nextLine();
                        if ("Y".equalsIgnoreCase(decision)) {
                            // Continue the loop to try again
                        } else {
                            tryAgainMonth = false;
                            System.out.println("Unfortunately, we are not able to get your important summer date!");
                        }
                    }
                }
            } else {
                System.out.println("Invalid input. Please enter a valid month.");
                System.out.println("Do you want to try again? (Y/N)");
                if (input.hasNext()) {
                    String monthDecision = input.nextLine();
                    if ("Y".equalsIgnoreCase(monthDecision)) {
                        // go back to please enter the month
                    } else {
                        tryAgainMonth = false;
                        System.out.println("Unfortunately, we are not able to get your important summer date!");
                    }
                }
            }
        }
        input.close();
    }
}
