// Homework 1: Sales Register Program
// Course: CIS357
// Due date: 7/5/2022
// Name: Chistopher Rucker
// GitHub: carucker313
// Instructor: Il-Hyung Cho
// Program description: This program prompts the user to enter in some items from by a while loop, and gets the total of the sales items


import java.util.Scanner;

public class CashRegister {
    /**the computePrice method calculates the price of the item List. It accepts the price of each Item object and the sales 6 percent sales tax*/
    public static double computePrice(double price, double tax){
        double salesTax = price*tax;
        double total = salesTax+price;
        return total;



    }
        public static void main(String[] args) {
            /**intializing the array that will hold the Array of Item Objects*/

            Item[] itemArr = new Item[11];
            itemArr[1] = new Item(1, "bottled water", 1.50);
            itemArr[2] = new Item(2, "candy", 1.00);
            itemArr[3] = new Item(3, "chocolate", 2.50);
            itemArr[4] = new Item(4, "gum", 1.00);
            itemArr[5] = new Item(5, "soda", 2.50);
            itemArr[6] = new Item(6, "juice", 3.00);
            itemArr[7] = new Item(7, "popcorn", 2.50);
            itemArr[8] = new Item(8, "donut", 1.50);
            itemArr[9] = new Item(9, "pretzel", 2.00);
            itemArr[10] = new Item(10, "caramel", 1.50);
            int size = 0;
            int capacity = 5;
            String arr[] = new String[capacity];

            /** Initializing all of the variables im going to use */
            Scanner input = new Scanner(System.in);
            String answer = "";
            int productCode = 0;
            int quantity = 0;
            double amountPaid = 0;
            double subTotal = 0;
            double totalSale = 0;
            final double salesTax = 0.06;





            /** This is a while loop that constantly prompts the user for input checking if they want to begin a sale */

            while (true) {
                System.out.println("Beginning new sale(Y/N)");
                System.out.println("----------------");

                /** this portion resets some data, so a new sale can occur */
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = "";
                    subTotal = 0;

                }
                answer = input.next();
                /** this checks if the user entered N, and doesnt want to begin another sale */

                if (answer.equalsIgnoreCase("N")){
                    System.out.println("The total sale for total is " + Math.round(totalSale*100.0)/100.0);
                    System.out.println("Thank you for using POST system goodbye");
                    totalSale = 0;
                    /** breaks the loop and ends the program */

                    break;


                }else{
                    /** prompts the user to enter the product codes so they can purchase items that they want */
                    while (true) {
                        System.out.print("Enter product code:");
                        productCode = input.nextInt();

                        /**if the use doesnt want to purchase any more then print out all the items they selected*/

                        if (productCode == -1) {
                            System.out.println("---------------------");
                            for (int i = 0; i < arr.length ; i++) {
                                if (arr[i]!=null){
                                    System.out.println(arr[i]);

                                }

                            }

                            System.out.println("Subtotal: $" +subTotal);
                            double totalAmountWithTax = computePrice(subTotal,salesTax);
                            System.out.println("Total with tax $" + totalAmountWithTax);


                            System.out.print("tendered amount: $");
                            amountPaid = input.nextDouble();
                            double change = amountPaid-totalAmountWithTax ;
                            System.out.println("Change: $" +Math.round(change*100.0)/100.0);
                            totalSale = totalSale+totalAmountWithTax;
                            break;


                        } else {

                            /**if the user does enter a valid product code then it will be printed back to them*/

                            for (int i = 1; i < itemArr.length; i++) {
                                if (productCode == i) {


                                    System.out.println("Item name:" + itemArr[productCode].itemName);


                                }
                            }
                            /**prompts the user to enter how many they want*/

                            System.out.print("Enter Quantity");
                            quantity = input.nextInt();
                            System.out.println("Item total $" +itemArr[productCode].unitPrice*quantity);



                            //creating the list of items in the receipt'[
                            /**this checks to see if the array is at max capacity, if the array is full
                             then increase capacity, create a new array, copy all of the old data from the original array,
                             onto the new one, and then allow the original array to reference the contents of the new array
                             that has the data.*/

                            if (size == capacity){
                                capacity = capacity * 2;
                                String tempArr[] = new String[capacity];
                                for (int i = 0; i < size; i++){
                                    tempArr[i] = arr[i];

                                }
                                arr = tempArr;

                            }

                            arr[size] = quantity + " " + itemArr[productCode].itemName + " $" + itemArr[productCode].unitPrice * quantity + " ";
                            /**size keeps track of the last element in the array*/
                            size++;
                            subTotal=itemArr[productCode].unitPrice*quantity+subTotal;


                        }


                    }
                }

            }

        }

    }


