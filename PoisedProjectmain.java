/**
 * @author nntshembho mhlongo
 * This is a class to create and manage projects for a structural engineering firm
 */

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.time.LocalDate;

//moduels used thoughout the project


public class PoisedProjectmain {
    static List<PoisedProjectClass> projectObjs = new ArrayList<PoisedProjectClass>();
    // ARRAY LIST TO CONTAIN PROJECT OBJECTS READ FROM THE UNFINALISED DATA FILE

    static int userProj;
    // CONTAINS PROJECT NUMBER THAT USER WANTS TO EDIT


    public static void main(String[] args) {


        PoisedProjectClass project = projectdetails();
        //CALLING THE PROJECTDETAILS FUNCTION TO GET DATA ON THE PROJECT

        ListFunc();
        //AFTER DATA HAS BEEN WRITTEN TO FILE THIS FUNC WILL READ THE DATA INTO THE ARRAYLIST


        Scanner menuInput = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("""
                        would you like to try to add another project(if you made an error while inputing a project)? type ap
                                                
                        !!! NOTE TO PICK THE FOLLOWING OPTION A PROJECT SHOULD HAVE BEEN CREATED FIRST!!!
                                                
                        would you like to change the due date of a project?,type pdd
                                                
                        would you like to change the amount paid to date? type apd
                                                
                        would you like to update people detals? type ud
                                                
                        would you like to view uncompleted projects? type VUC
                                                
                        would you like to view all overdue projects? type vod
                                                
                        would you like to finalize a project? type  FP
                                                
                        !! Note to pick the following option,you have to be satisified with all updates to the project!!
                                                
                        would you like to write the projects to the file? type WP
                                                
                                                
                        type exit to exit the programm

                        """);

                String projectMenu = menuInput.nextLine();
                if (projectMenu.equalsIgnoreCase("ap")) {
                    PoisedProjectClass reproject = projectdetails();


                }

                if (projectMenu.equalsIgnoreCase("exit")) {
                    break;

                }//break statement

                else if (projectMenu.equalsIgnoreCase("pdd")) {

                    try {
                        Scanner projectDueDate = new Scanner(System.in);

                        System.out.println("please enter the project number you want to edit from the projects displayed next?");
                        System.out.println(projectObjs);

                        int projNumb = Integer.parseInt(projectDueDate.nextLine());


                        System.out.println("please enter the new date");

                        String userEdit = projectDueDate.nextLine();

                        for (PoisedProjectClass num : projectObjs) {
                            projectObjs.get(projNumb - 1).setDate(userEdit);

                            System.out.println("the project with the new date: ");
//
                            System.out.println(projectObjs.get(projNumb - 1));

                        }


                    } catch (NumberFormatException e) {
                        System.out.println("something went wrong, maybe please input the right project number: ");
                    } catch (Exception e) {
                        System.out.println("you have selected a project that doesnt exist. Try again");
                    }


                } else if (projectMenu.equalsIgnoreCase("apd")) {
                    try {
                        Scanner amountPaidToDate = new Scanner(System.in);
                        System.out.println("please enter the project number you want to edit from the projects displayed next?");
                        System.out.println(projectObjs);


                        int projNumb = Integer.parseInt(amountPaidToDate.nextLine());
                        System.out.println("please enter the new amount paid to date");
                        double newmount = Double.parseDouble(amountPaidToDate.nextLine());


                        for (PoisedProjectClass num : projectObjs) {
                            projectObjs.get(projNumb - 1).setAmountpaidtodate(newmount);

                            System.out.println("the project with the new amount paid to date is");

                            System.out.println(projectObjs.get(projNumb - 1));

                        }


                    } catch (NumberFormatException e) {
                        System.out.println("something went wrong, maybe please input the right project number: ");
                    } catch (Exception e) {
                        System.out.println("you have selected a project that doesnt exist. Try again");
                    }


                } else if (projectMenu.equalsIgnoreCase("vuc")) {
                    uncompleteProjects();

                } else if (projectMenu.equalsIgnoreCase("vod")) {

                    getDateFromFile();


                } else if (projectMenu.equalsIgnoreCase("ud")) {
                    try {
                        Scanner ud = new Scanner(System.in);

                        while (true) {

                            System.out.println("""
                                    please enter which detail you would like to update,
                                    n = name 
                                    t = telephone
                                    e = email 
                                    a = address
                                    d = done """);

                            String userEdit = ud.nextLine();

                            if (userEdit.equalsIgnoreCase("d")) {
                                break;
                            }// break statement

                            else if (userEdit.equalsIgnoreCase("n")) {


                                System.out.println("""
                                            please enter which person you would like to update
                                            architect - A
                                            customer - C
                                            contractor - CT
                                            exit - E
                                        """);


                                String personChoice = ud.nextLine();

                                if (personChoice.equalsIgnoreCase("A")) {
                                    System.out.println("please enter the project number you want to edit from the projects below?");
                                    System.out.println(projectObjs);
                                    int projNumb = Integer.parseInt(ud.nextLine());


                                    System.out.println("please enter the new name of the architect f");

                                    String newArchitectName = ud.nextLine();

                                    for (PoisedProjectClass num : projectObjs) {

                                        projectObjs.get(projNumb - 1).getArchitect().setName(newArchitectName);

                                        System.out.println("the new architect of this project" + "\n");

                                        System.out.println(projectObjs.get(projNumb - 1));

                                    }


                                } else if (personChoice.equalsIgnoreCase("c")) {
                                    System.out.println("please enter the project number you want to edit from the projects below?");
                                    System.out.println(projectObjs);
                                    int projNumb = Integer.parseInt(ud.nextLine());


                                    System.out.println("please enter the new name of the customer");

                                    String newcustomerName = ud.nextLine();

                                    for (PoisedProjectClass num : projectObjs) {
                                        projectObjs.get(projNumb - 1).getCustomer().setName(newcustomerName);

                                        System.out.println("the new customer of this project" + "\n");

                                        System.out.println(projectObjs.get(projNumb - 1));


                                    }


                                } else if (personChoice.equalsIgnoreCase("ct")) {
                                    System.out.println("please enter the project number you want to edit from the projects below?");
                                    System.out.println(projectObjs);
                                    int projNumb = Integer.parseInt(ud.nextLine());


                                    System.out.println("please enter the new name of the contract name");

                                    String newcontractorName = ud.nextLine();
                                    for (PoisedProjectClass num : projectObjs) {

                                        projectObjs.get(projNumb - 1).getCustomer().setName(newcontractorName);

                                        System.out.println("the new contractor of this project" + "\n");

                                        System.out.println(projectObjs.get(projNumb - 1));

                                    }


                                } else if (personChoice.equalsIgnoreCase("e")) {
                                    break;

                                } else {
                                    System.out.println("thats not a valid person/option try again");
                                    break;
                                }


                            } else if (userEdit.equalsIgnoreCase("t")) {



                                System.out.println("""
                                            please enter which person you would like to update
                                            architect - A
                                            customer - C
                                            contractor - CT
                                            exit - E
                                        """);


                                String personChoice = ud.nextLine();

                                if (personChoice.equalsIgnoreCase("A")) {
                                    System.out.println("please enter the project number you want to edit from the projects below?");
                                    System.out.println(projectObjs);
                                    int projNumb = Integer.parseInt(ud.nextLine());

                                    System.out.println("please enter the new telephone of the architect");

                                    long newArchitecttele = Long.parseLong(ud.nextLine());

                                    for (PoisedProjectClass num : projectObjs) {

                                        projectObjs.get(projNumb - 1).getArchitect().setTelenum(newArchitecttele);

                                        System.out.println("the new architect telephone of this project" + "\n");

                                        System.out.println(projectObjs.get(projNumb - 1));

                                    }




                                } else if (personChoice.equalsIgnoreCase("c")) {
                                    System.out.println("please enter the project number you want to edit from the projects below?");
                                    System.out.println(projectObjs);
                                    int projNumb = Integer.parseInt(ud.nextLine());

                                    System.out.println("please enter the new telephone of the customer");

                                    long newcustTele = Long.parseLong(ud.nextLine());
                                    for (PoisedProjectClass num : projectObjs) {

                                        projectObjs.get(projNumb - 1).getCustomer().setTelenum(newcustTele);

                                        System.out.println("the new customer telephone of this project" + "\n");

                                        System.out.println(projectObjs.get(projNumb - 1));


                                    }

                                } else if (personChoice.equalsIgnoreCase("ct")) {
                                    System.out.println("please enter the project number you want to edit from the projects below?");
                                    System.out.println(projectObjs);
                                    int projNumb = Integer.parseInt(ud.nextLine());


                                    System.out.println("please enter the new telephone of the contract name");

                                    long newcontractorTele = Long.parseLong(ud.nextLine());

                                    for (PoisedProjectClass num : projectObjs) {
                                        projectObjs.get(projNumb - 1).getCustomer().setTelenum(newcontractorTele);

                                        System.out.println("the new contractor telephone of this project" + "\n");

                                        System.out.println(projectObjs.get(projNumb - 1));


                                    }



                                } else if (personChoice.equalsIgnoreCase("e")) {
                                    break;

                                } else {
                                    System.out.println("thats not a valid person/option try again");
                                    break;
                                }


                            }// set method for the contractors new telephone

                            else if (userEdit.equalsIgnoreCase("e")) {

                                System.out.println("""
                                            please enter which person you would like to update
                                            architect - A
                                            customer - C
                                            contractor - CT
                                            exit - E
                                        """);


                                String personChoice = ud.nextLine();

                                if (personChoice.equalsIgnoreCase("A")) {
                                    System.out.println("please enter the project number you want to edit from the projects below?");
                                    System.out.println(projectObjs);
                                    int projNumb = Integer.parseInt(ud.nextLine());

                                    System.out.println("please enter the new email of the architect");

                                    String newArchitectEmail = ud.nextLine();
                                    for (PoisedProjectClass num : projectObjs) {
                                        projectObjs.get(projNumb - 1).getArchitect().setEmail(newArchitectEmail);

                                        System.out.println("the new architect email of this project" + "\n");

                                        System.out.println(projectObjs.get(projNumb - 1));


                                    }


                                } else if (personChoice.equalsIgnoreCase("c")) {
                                    System.out.println("please enter the project number you want to edit from the projects below?");
                                    System.out.println(projectObjs);
                                    int projNumb = Integer.parseInt(ud.nextLine());


                                    System.out.println("please enter the new email of the customer");

                                    String newcustEmail = ud.nextLine();
                                    for (PoisedProjectClass num : projectObjs) {
                                        projectObjs.get(projNumb - 1).getCustomer().setEmail(newcustEmail);

                                        System.out.println("the new customer email of this project" + "\n");

                                        System.out.println(projectObjs.get(projNumb - 1));
                                    }





                                } else if (personChoice.equalsIgnoreCase("ct")) {
                                    System.out.println("please enter the project number you want to edit from the projects below?");
                                    System.out.println(projectObjs);
                                    int projNumb = Integer.parseInt(ud.nextLine());


                                    System.out.println("please enter the new email of the contract name");

                                    String newcontractorEmail = ud.nextLine();

                                    for (PoisedProjectClass num : projectObjs) {
                                        projectObjs.get(projNumb - 1).getCustomer().setEmail(newcontractorEmail);

                                        System.out.println("the new contractor email of this project" + "\n");

                                        System.out.println(projectObjs.get(projNumb - 1));

                                    }




                                } else if (personChoice.equalsIgnoreCase("e")) {
                                    break;

                                } else {
                                    System.out.println("thats not a valid person/option try again");
                                    break;
                                }


                            }// set method for the contractors new email

                            else if (userEdit.equalsIgnoreCase("a")) {

                                System.out.println("""
                                            please enter which person you would like to update
                                            architect - A
                                            customer - C
                                            contractor - CT
                                            exit - E
                                        """);


                                String personChoice = ud.nextLine();

                                if (personChoice.equalsIgnoreCase("A")) {
                                    System.out.println("please enter the project number you want to edit from the projects below?");
                                    System.out.println(projectObjs);
                                    int projNumb = Integer.parseInt(ud.nextLine());

                                    System.out.println("please enter the new address of the architect");

                                    String newArchitectAddy = ud.nextLine();

                                    for (PoisedProjectClass num : projectObjs) {

                                        projectObjs.get(projNumb - 1).getArchitect().setAddress(newArchitectAddy);

                                        System.out.println("the new architect address of this project" + "\n");

                                        System.out.println(projectObjs.get(projNumb - 1));
                                    }


                                } else if (personChoice.equalsIgnoreCase("c")) {
                                    System.out.println("please enter the project number you want to edit from the projects below?");
                                    System.out.println(projectObjs);
                                    int projNumb = Integer.parseInt(ud.nextLine());


                                    System.out.println("please enter the new email of the customer");

                                    String newcustaddy = ud.nextLine();
                                    for (PoisedProjectClass num : projectObjs) {
                                        projectObjs.get(projNumb - 1).getCustomer().setAddress(newcustaddy);

                                        System.out.println("the new customer address of this project" + "\n");

                                        System.out.println(projectObjs.get(projNumb - 1));

                                    }


                                } else if (personChoice.equalsIgnoreCase("ct")) {
                                    System.out.println("please enter the project number you want to edit from the projects below?");
                                    System.out.println(projectObjs);
                                    int projNumb = Integer.parseInt(ud.nextLine());


                                    System.out.println("please enter the new address of the contract name");

                                    String newcontractoraddy = ud.nextLine();

                                    for (PoisedProjectClass num : projectObjs) {

                                        projectObjs.get(projNumb - 1).getCustomer().setAddress(newcontractoraddy);

                                        System.out.println("the new contractor email of this project" + "\n");

                                        System.out.println(projectObjs.get(projNumb - 1));

                                    }



                                } else if (personChoice.equalsIgnoreCase("e")) {
                                    break;

                                } else {
                                    System.out.println("thats not a valid person/option try again");
                                    break;
                                }


                            }// set method for the contractors new address


                        }// while loop menu if the user chooses to edit contractor details

                    } catch (Exception e) {
                        System.out.println("you have selected a project that doesnt exist. Try again");
                    }


                } else if (projectMenu.equalsIgnoreCase("fp")) {
                    Scanner finalInput = new Scanner(System.in);
                    System.out.println("please enter the project number you want to finalize from the projects below");
                    System.out.println(projectObjs);


                    userProj = Integer.parseInt(finalInput.nextLine());
                    for (PoisedProjectClass num : projectObjs) {
                        finialiseProject(userProj);

                    }


                } else if (projectMenu.equalsIgnoreCase("wp")) {
                    System.out.println("please enter the project number you want to finalize");
                    Scanner finalInput = new Scanner(System.in);
                    userProj = Integer.parseInt(finalInput.nextLine());
                    WriteToFile(userProj);


                }

            }

        } catch (NumberFormatException e) {
            System.out.println("please dont enter the value encapsulated by quotation marks.");
        }catch (InputMismatchException e) {
            System.err.println("Not a valid input. Error :" + e.getMessage());
        }


    }// THE MAIN FUNCTION CONTAINS THE MENU TO ALLOW THE USER TO EDIT VARIOUS ASPECTS OF THE PROJECT

    public static PoisedProjectClass projectdetails() {
        /**
         * THIS FUNCTION GETS DATA TO CREATE A NEW PROJECT OBJECT
         * @RETURN A NEW PROJECT OBJECT
         */
        int projectnum = 0;
        String projectname = null;
        String buildingtype = null;
        int erfnumb = 0;
        double totalfee = 0.0;
        double amountpaid = 0.0;
        String projectdeadline = null;
        String physicaladd = null;
        String completedProject = "uncompleted";
        PoisedPersonClass architect = null;
        PoisedPersonClass contractor = null;
        PoisedPersonClass customer = null;

        Scanner userInput = new Scanner(System.in);


        //////////////////////////try block to open file///////////////////////////
        try {
            File myFile = new File("unfinalised Project details.txt");
            FileWriter ProjectWriter = new FileWriter(myFile, true);

        } catch (FileNotFoundException e) {
            System.out.println("file dont exist ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //////////////////////////try block to open file///////////////////////////


        while (true) {
            try {


                System.out.println("please select one of the options below:" +
                        "1- ADD NEW PROJECT - Type ANP" + "\n" +
                        "2 - ADDITIONAL PROJECT OPTIONS - Type APO" + "\n" +
                        "3 - EXIT[E]");

                String choice = userInput.nextLine();

                if (choice.equalsIgnoreCase("E")) {
                    break;

                } else if (choice.equalsIgnoreCase("ANP")) {


                    System.out.println("please enter the project number\n");

                    projectnum = Integer.parseInt(userInput.nextLine());



                    userInput = new Scanner(System.in);

                    System.out.println("please enter the project name\n");

                    projectname = userInput.nextLine();

                    userInput = new Scanner(System.in);

                    System.out.println("please enter what type of building it is");
                    buildingtype = userInput.nextLine();

                    userInput = new Scanner(System.in);
                    System.out.println("please enter the physical address");
                    physicaladd = userInput.nextLine();

                    userInput = new Scanner(System.in);
                    System.out.println("please enter the ERF number");
                    erfnumb = Integer.parseInt(userInput.nextLine());

                    userInput = new Scanner(System.in);
                    System.out.println("please enter the total fee being charged for the project");
                    totalfee = Double.parseDouble(userInput.nextLine());

                    userInput = new Scanner(System.in);
                    System.out.println("please enter the amount paid to date");
                    amountpaid = Double.parseDouble(userInput.nextLine());

                    userInput = new Scanner(System.in);
                    System.out.println(" please enter the project deadline. in this format YYYY-MM-DD.");
                    projectdeadline = userInput.nextLine();


                    Scanner State = new Scanner(System.in);
                    while (true) {
                        try {
                            System.out.println("Please choose one of the following persons to add new details for " + "\n" +
                                    "please exit the program fully to generate file,in order to use Additional project options"
                                    + "\n" +
                                    "1: - CUSTOMER: Type CD" + "\n" +
                                    "2: -ARCHITECH: TYPE AC" + "\n" +
                                    "3: -CONTRACTOR: TYPE CT" + "\n" +
                                    "4: -EXIT: TYPE E");

                            String choiceTwo = State.nextLine();

                            if (choiceTwo.equalsIgnoreCase("E")) {
                                break;

                            } else if (choiceTwo.equalsIgnoreCase("CD")) {

                                customer = peopledetails();

                            } else if (choiceTwo.equalsIgnoreCase("AC")) {
                                architect = peopledetails();

                            } else if (choiceTwo.equalsIgnoreCase("CT")) {
                                contractor = peopledetails();

                            } else {
                                System.out.println("that is a wrong input please try again with the options provided");
                                break;
                            }


                        } catch (NumberFormatException e) {
                            System.out.println("please dont enter the value encapsulated by quotation marks//the value you have entered is of the wrong type.");
                            break;
                        }catch (InputMismatchException e) {
                            System.err.println("Not a valid input. Error :" + e.getMessage());
                        }

                    }

                    FileFunction(projectnum, projectname, buildingtype, physicaladd, erfnumb, totalfee, amountpaid, projectdeadline, completedProject, architect, contractor, customer);

                } else if (choice.equalsIgnoreCase("APO")) {
                    break;

                } else {
                    System.out.println("thats not a valid option please try again with the options provided");
                    break;
                }


            } catch (NumberFormatException e) {
                System.out.println("please dont enter the value encapsulated by quotation marks//the value you have entered is of the wrong type.");
                break;
            } catch (InputMismatchException e) {
                System.err.println("Not a valid input. Error :" + e.getMessage());
                break;
            }


        }
        return new PoisedProjectClass(projectnum, projectname, buildingtype, physicaladd, erfnumb, totalfee, amountpaid, projectdeadline, completedProject, architect, contractor, customer);

    }// PROJECT FUNCTION CAPTUERS DATA AND CALLS PEOPLE DETAILS AND FILE FUNCTION


    public static PoisedPersonClass peopledetails() {
        /**
         * @return a new person object
         * @throws exception when wrong value entered
         */
        String name = null;
        long tele = 0;
        String mail = null;
        String addy = null;


        try {


            Scanner userInputOne = new Scanner(System.in);
            System.out.println("please enter your name");
            name = userInputOne.nextLine();

            userInputOne = new Scanner(System.in);
            System.out.println("please enter your telephone");
            tele = Long.parseLong(userInputOne.nextLine());

            userInputOne = new Scanner(System.in);
            System.out.println("please enter your email");
            mail = userInputOne.nextLine();

            userInputOne = new Scanner(System.in);
            System.out.println("please enter your address");
            addy = userInputOne.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("please dont enter the value encapsulated by quotation marks//the value you have entered is of the wrong type.");

        }catch (InputMismatchException e) {
            System.err.println("Not a valid input. Error :" + e.getMessage());
        }



        return new PoisedPersonClass(name, tele, mail, addy);
    }//PEOPLE DETAILS CONTAINS CODE TO GET DATA ON THE PEOPLE INVOLVED IN THE PROJECT


    public static void FileFunction(int projectnum, String projectname,String buildingtype,
                                    String physicaladd,
                                    int erfnumb,
                                    double totalfee,
                                    double amountpaid,
                                    String projectdeadline, String completedProject, PoisedPersonClass archiect, PoisedPersonClass contractor, PoisedPersonClass customer) {

        /**
         * @param project number for project
         * @param project name for project
         * @param Building type for the project
         * @param ErfNumber
         * @param total Fee charged for project
         * @param amount Paid at the moment for project
         * @param physical address for the project
         * @param Project Deadline for the project
         * @param completion status for the project
         * @param architect object
         * @param contractor object
         * @param customer object
         *@throws exception when file not found
         */
        try {
            File myFile = new File("unfinalised Project details.txt");
            FileWriter ProjectWriter = new FileWriter(myFile, true);

            String ProjectOutput = String.format("%s: %s: %s: %s: %s: %s: %s: %s: %s: %s: %s: %s", projectnum, projectname, buildingtype, physicaladd, erfnumb, totalfee, amountpaid, projectdeadline, completedProject, archiect, contractor, customer);
            ProjectWriter.write(ProjectOutput + "\n");
            ProjectWriter.close();


        } catch (FileNotFoundException e) {
            System.out.println("file dont exist ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }//FILE FUNCTION TO WRITE THE DATA GOT FROM PROJECT DETAILS

    public static void ListFunc() {
        /**
         * @throws exception
         */


        try {
            File projectFile = new File("unfinalised Project details.txt");
            Scanner myReader = new Scanner(projectFile);


            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitLIne = data.split(": ");


                // List functions first function, to create a Array list of project objects
                PoisedPersonClass architect = new PoisedPersonClass(splitLIne[9], Long.parseLong(splitLIne[10]),
                        splitLIne[11], splitLIne[12]);
                PoisedPersonClass contractor = new PoisedPersonClass(splitLIne[13],Long.parseLong(splitLIne[14]),
                        splitLIne[15], splitLIne[16]);
                PoisedPersonClass customer = new PoisedPersonClass(splitLIne[17],Long.parseLong(splitLIne[18]),
                        splitLIne[19], splitLIne[20]);

                PoisedProjectClass projectObject = new PoisedProjectClass(Integer.parseInt(splitLIne[0]), splitLIne[1], splitLIne[2],
                        splitLIne[3],Integer.parseInt(splitLIne[4]), Double.parseDouble(splitLIne[5]),Double.parseDouble(splitLIne[6]), splitLIne[7], splitLIne[8], architect, contractor, customer);
                projectObjs.add(projectObject);


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }// LIST FUNC TO READ THE DATA TO A ARRAYLIST OF OBJECTS


    public static void uncompleteProjects() {
        try {
            File projectFile = new File("unfinalised Project details.txt");
            Scanner myReader = new Scanner(projectFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }// SINCE ALL PROJECTS WRITTEN FROM PROJECT DETAILS FUNCTION BY DEFAULT ARE NOT COMPLETE THIS FUNCTION WILL
    //SHOW THE USER ALL THE "UNCOMPLETED PROJECTS"

    public static void getDateFromFile() {

        for (int counter = 0; counter < projectObjs.size(); counter++) {
            String dateOne = projectObjs.get(counter).getDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate FileDate = LocalDate.parse(dateOne, formatter);
            LocalDate CurrentDate = LocalDate.now();

            if (FileDate.compareTo(CurrentDate) > 0) {

                System.out.println(projectObjs);

            }


        }


    }//THIS FUNCTION WILL CHECK THE DATA INPUTTED FROM THE FILE AND COMPARE TO THE CURRENT DATE TO CHECK OVERDUE STATUS
    //IF OVERDUE THE PROJECT IN QUESTION WILL BE DISPLAYED TO THE USER

    public static void finialiseProject(int projectNumb) {
        /**
         * @param project number
         */

        try {
            int newProjnum = projectNumb;
            double amountCharged = projectObjs.get(newProjnum - 1).getProjecttotalfee();
            double amountPaid = projectObjs.get(newProjnum - 1).getAmountpaidtodate();

            if (amountCharged > amountPaid) {
                System.out.println("This project cannot be finalised due to the remaining outstanding balance");
            } else {
                projectObjs.get(newProjnum - 1).setCompletedProject("completed");
                System.out.println(projectObjs);
                System.out.println("project has been finalized");
            }

        } catch (Exception e) {
            System.out.println("the project you have entered isn't available");
        }


    }// THIS FUNCTION WILL BE USED TO FINALISE A PROJECT
    //IT CHECKS IF THE AMOUNT PAID IS ENOUGH TO FULFILL THE AMOUNT DUE IF YES THEN THE PROJECT COMPLETION STATUS WILL BE
    //COMPLETED AND PROJECT FINIALISED


    public static void WriteToFile(int projectnumb) {
        /**
         * @param project number
         *
         */
        try {
            finialiseProject(projectnumb);

            String compOrNot = projectObjs.get(projectnumb - 1).getCompletedProject();
            System.out.println(compOrNot);

            if (compOrNot.equalsIgnoreCase("completed")) {

                try {
                    File myFile = new File("Finalised Project details.txt");
                    FileWriter ProjectWriter = new FileWriter(myFile, true);


                    ProjectWriter.write(projectObjs.toString() + "\n");
                    ProjectWriter.close();


                } catch (FileNotFoundException e) {
                    System.out.println("file dont exist ");
                }

            } else {
                System.out.println("project couldn't be written to file, please check any outstanding balances");
            }


        } catch (Exception e) {
            System.out.println("the project you have entered isnt available");
        }
    }//THIS FUNCTION WILL WRITE ALL FINIALISED PROJECTS TO THE FINIALISED PROJECT

}













