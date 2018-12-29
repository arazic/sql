import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import javafx.util.Pair;
import java.util.ArrayList;



public class Assignment4 {


    private Assignment4() {
    }

    public static void executeFunc(Assignment4 ass, String[] args) {
        String funcName = args[0];
        switch (funcName) {
            case "loadNeighborhoodsFromCsv":
                ass.loadNeighborhoodsFromCsv(args[1]);
                break;
            case "dropDB":
                ass.dropDB();
                break;
            case "initDB":
                ass.initDB(args[1]);
                break;
            case "updateEmployeeSalaries":
                ass.updateEmployeeSalaries(Double.parseDouble(args[1]));
                break;
            case "getEmployeeTotalSalary":
                System.out.println(ass.getEmployeeTotalSalary());
                break;
            case "updateAllProjectsBudget":
                ass.updateAllProjectsBudget(Double.parseDouble(args[1]));
                break;
            case "getTotalProjectBudget":
                System.out.println(ass.getTotalProjectBudget());
                break;
            case "calculateIncomeFromParking":
                System.out.println(ass.calculateIncomeFromParking(Integer.parseInt(args[1])));
                break;
            case "getMostProfitableParkingAreas":
                System.out.println(ass.getMostProfitableParkingAreas());
                break;
            case "getNumberOfParkingByArea":
                System.out.println(ass.getNumberOfParkingByArea());
                break;
            case "getNumberOfDistinctCarsByArea":
                System.out.println(ass.getNumberOfDistinctCarsByArea());
                break;
            case "AddEmployee":
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                ass.AddEmployee(Integer.parseInt(args[1]), args[2], args[3], java.sql.Date.valueOf(args[4]), args[5], Integer.parseInt(args[6]), Integer.parseInt(args[7]), args[8]);
                break;
            default:
                break;
        }
    }



    public static void main(String[] args) {

        File file = new File(".");
        String csvFile = args[0];/*"neighborhoods.csv";*/
        String line = "";
        String cvsSplitBy = ",";
        Assignment4 ass = new Assignment4();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] row = line.split(cvsSplitBy);

                executeFunc(ass, row);

            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }



    private void loadNeighborhoodsFromCsv(String csvPath) {
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] row = line.split(cvsSplitBy);



            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void updateEmployeeSalaries(double percentage) {

    }


    public void updateAllProjectsBudget(double percentage) {

    }


    private double getEmployeeTotalSalary() {
    return 0;
    }


    private int getTotalProjectBudget() {
        return 0;
    }

    private void dropDB() {

    }

    private void initDB(String csvPath) {

        String databaseName = "DB2019_Ass2";
        dataBase dataBase = new dataBase(databaseName);
        dataBase.startConnection();
        ResultSet resultSet = dataBase.executeQuerySelect(sqlInitDB(csvPath));
        resultPrint.printResultSet(resultSet);
        dataBase.closeConnection();

    }

    private String sqlInitDB(String csvPath){
        String sqlInitDB= "";
        String cvsSplitBy = ",";
        String line="";
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                sb.append(line);

            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        String[] inst = sb.toString().split(";");
        for(int i = 0; i<inst.length; i++)
        {
            // we ensure that there is no spaces before or after the request string
            // in order to not execute empty statements
            if(!inst[i].trim().equals(""))
            {
                sqlInitDB=sqlInitDB+inst[i];
            }
        }
        return sqlInitDB;
    }



    private int calculateIncomeFromParking(int year) {
        return 0;
    }

    private ArrayList<Pair<Integer, Integer>> getMostProfitableParkingAreas() {
        ArrayList<Pair<Integer, Integer>> a=null;
        return  a;

    }

    private ArrayList<Pair<Integer, Integer>> getNumberOfParkingByArea() {
        ArrayList<Pair<Integer, Integer>> a=null;
        return  a;
    }


    private ArrayList<Pair<Integer, Integer>> getNumberOfDistinctCarsByArea() {
        ArrayList<Pair<Integer, Integer>> a=null;
        return  a;
    }


    private void AddEmployee(int EID, String LastName, String FirstName, Date BirthDate, String StreetName, int Number, int door, String City) {

    }
}
