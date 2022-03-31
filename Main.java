package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);

        System.out.println("\n>>>>> Welcome To Phone Book System! <<<<<");

        String [] Names = new String [1000];
        String [] PhoneNumbers = new String [1000];
        String [] Adresses = new String [1000];

        int NumberOfContacts = 0;

        Menu(Names , PhoneNumbers , Adresses , NumberOfContacts);
    }

    public static void Menu(String [] Names , String [] PhoneNumbers , String [] Adresses , int NumberOfContacts) {
        Scanner console = new Scanner (System.in);

        System.out.println("\n-------------------------------------------");

        System.out.println("\n•Please choose an option:\n1. Add a Contact\n2. Search a Contact\n3. Show all Saved Contacts\n4. Edit a Contact\n5. Delete a Contact\n6. Exit");
        int x = console.nextInt();


        if(x==1) {
            Add_Contact(Names , PhoneNumbers , Adresses , NumberOfContacts);
            NumberOfContacts++;

        }else if(x==2) {
            Search_Contact(Names , PhoneNumbers , Adresses , NumberOfContacts);


        }else if(x==3) {
            Print_SortAssending_Contacts(Names , PhoneNumbers , Adresses , NumberOfContacts);


        }else if (x==4) {

            Update_Contact(Names , PhoneNumbers , Adresses , NumberOfContacts);


        }else if (x==5) {
            Delete_Contact(Names , PhoneNumbers , Adresses , NumberOfContacts);


        }else if (x==6) {
            System.out.println("\n-------------------------------------------");
            System.out.println("\nThank you for using!");
            System.exit(0);

        }else {
            System.out.println("\nPlease Enter a Valid Number! \n");

        }

        Menu(Names , PhoneNumbers , Adresses , NumberOfContacts);
    }



    //1- Add a Contact Function.
    public static void Add_Contact (String [] Names , String [] PhoneNumbers , String [] Adresses , int NumberOfContacts) {

        Scanner console = new Scanner (System.in);

        System.out.println("\n-------------------------------------------");

        System.out.print("\nPlease Enter The Contact's Name: ");
        Names[NumberOfContacts]= console.nextLine();

        System.out.print("Please Enter The Contact's Phone Number: ");
        PhoneNumbers[NumberOfContacts]= console.nextLine();

        if(PhoneNumbers[NumberOfContacts].length()==11) {
            System.out.print("Please Enter The Contact's Adress: ");
            Adresses[NumberOfContacts]= console.nextLine();

            System.out.println("\nContact Added Sucssesfully!");
        }else {
            System.out.println("\nPlease Enter a Valid Phone Number!");

            System.out.print("\nPlease Enter The Contact's Phone Number Again: ");
            PhoneNumbers[NumberOfContacts]= console.nextLine();

            System.out.print("Please Enter The Contact's Adress: ");
            Adresses[NumberOfContacts]= console.nextLine();

            System.out.println("\nContact Added Sucssesfully!");
        } }



    //2- Search a Contact Function.
    public static void Search_Contact(String [] Names , String [] PhoneNumbers , String [] Adresses , int NumberOfContacts) {

        Scanner console = new Scanner (System.in);

        System.out.println("\n-------------------------------------------");

        System.out.println("\nPlease Enter Name Of Contact You Want To Look Up: ");
        String target = console.nextLine();

        for (int i= 0; i<Names.length; i++) {
            if (target.equalsIgnoreCase(Names[i])) {
                {
                    System.out.println("\nName: "+ Names[i]);
                    System.out.println("Phone Number: " + PhoneNumbers[i]);
                    System.out.println("City: " + Adresses[i]);


                }
            }else{ System.out.println("\nContact Is Not Avilable!\n\n-------------------------------------------\n\n-Press 2 To Try Again\n-Press 0 To go Back to main menu\n-Press 6 To Exit");
                int tryAgain = console.nextInt();

                if (tryAgain==2) {
                    Search_Contact(Names , PhoneNumbers , Adresses , NumberOfContacts);
                } else if (tryAgain==6) {
                    System.out.println("\n-------------------------------------------\n\nThank you for using!");
                    System.exit(0);

                }

            }break;
        }
    }




    //3- Show All Saved Contacts Function.
    public static void Print_SortAssending_Contacts(String [] Names , String [] PhoneNumbers , String [] Adresses , int NumberOfContacts)	{

        Scanner console = new Scanner (System.in);

        if(NumberOfContacts!=0) {
            System.out.println("\n-------------------------------------------");
            System.out.println("\n•All Saved Contacts (Sorted Alphabetically):-");
            System.out.println("_______________");
            for (int i= 0; i<NumberOfContacts-1; i++) {
                for (int j = i; j<NumberOfContacts; j++) {
                    if(Names[i].toLowerCase().charAt(0)>Names[j].toLowerCase().charAt(0)) {
                        String temp = Names[i];
                        Names[i]=Names[j];
                        Names [j]= temp;
                    }

                }
            }for (int k = 0; k<NumberOfContacts; k++) {
                System.out.println("\nName: "+ Names[k]);
                System.out.println("Phone Number: " + PhoneNumbers[k]);
                System.out.println("Adress: " + Adresses[k]);
                System.out.println("_______________");

            }}else{ System.out.println("\n-------------------------------------------");
            System.out.println("\nThere Is No Saved Contacts!\n\n-------------------------------------------\n\n-Press 2 To Add a Contact\n-Press 0 To go Back to main menu\n-Press 6 To Exit");
            int tryAgain = console.nextInt();

            if (tryAgain==2) {
                Add_Contact(Names , PhoneNumbers , Adresses , NumberOfContacts);
                NumberOfContacts++;
            } else if (tryAgain==6) {
                System.out.println("\n-------------------------------------------\n\nThank you for using!");
                System.exit(0);

            }

        }
    }





    //4- Edit Function.
    public static void Update_Contact (String [] Names , String [] PhoneNumbers , String [] Adresses , int NumberOfContacts) {

        Scanner console = new Scanner (System.in);

        System.out.println("\n-------------------------------------------");
        System.out.println("\nEnter Name of Contact You Want To Edit:");
        String target = console.nextLine();

        for (int i= 0; i<Names.length; i++) {
            if (target.equalsIgnoreCase(Names[i])) {
                {
                    System.out.println("\nEnter The New Contact's Name:");
                    String NewNames= console.nextLine();
                    Names[i] = NewNames;

                    System.out.println("Enter The New Contact's Phone Number:");
                    String NewPhoneNumber= console.nextLine();
                    PhoneNumbers[i] = NewPhoneNumber;

                    System.out.println("Enter The New Contact's Adress:");
                    String NewAdress= console.nextLine();
                    Adresses[i] = NewAdress;

                    System.out.println("\nContact Updated Sucessfully!");
                }
            }else{ System.out.println("\nContact Is Not Avilable!\n\n-------------------------------------------\n\n-Press 2 To Try Again\n-Press 0 To go Back to main menu\n-Press 6 To Exit");
                int tryAgain = console.nextInt();

                if (tryAgain==2) {
                    Update_Contact(Names , PhoneNumbers , Adresses , NumberOfContacts);
                } else if (tryAgain==6) {
                    System.out.println("\n-------------------------------------------\nThank you for using!");
                    System.exit(0);

                }

            }break;
        }
    }



    //5- Delete Function.
    public static void Delete_Contact (String [] Names ,String [] PhoneNumbers , String [] Adresses , int NumberOfContacts) {

        Scanner console = new Scanner (System.in);

        System.out.println("\nPlease Enter Name Of Contact You Want To Delete: ");
        String target = console.nextLine();

        for (int i= 0; i<Names.length; i++) {
            if (target.equalsIgnoreCase(Names[i])) {
                System.out.println("\nAre you sure you want to delete this data? (Y or N?)");
                char Answer = console.next().charAt(0);
                if (Answer=='Y' || Answer=='y') {
                    Names[NumberOfContacts-1]="";
                    PhoneNumbers[NumberOfContacts-1]="";
                    Adresses[NumberOfContacts-1]="";
                    System.out.println("\nContact Deleted Sucessfully!");
                }else if (Answer=='N' || Answer=='n') {
                    System.out.println("\nDeleting Contact has been Canceled!");
                    Menu(Names , PhoneNumbers , Adresses , NumberOfContacts);
                }

            }else{ System.out.println("\nContact Is Not Avilable!\n\n-------------------------------------------\n\n-Press 5 To Try Again\n-Press 0 To go Back to main menu\n-Press 6 To Exit");
                int tryAgain = console.nextInt();

                if (tryAgain==5) {
                    Delete_Contact(Names , PhoneNumbers , Adresses , NumberOfContacts);
                } else if (tryAgain==6) {
                    System.out.println("\n-------------------------------------------\n\nThank you for using!");
                    System.exit(0);

                }

            }break;
        }
    }


}