package stepdefinitions.database_step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DbUtils;
import utilities.DbUtils;

import java.sql.SQLException;
public class Read_Step_Definitions {
    @Given("user connects to the database")
    public void user_connects_to_the_database() {
        DbUtils.createConnection();
    }
    @Given("user gets the {string} from {string} table")
    public void user_gets_the_from_table(String column, String table) {
//        Writing the query
        String myDynamicQuery = "Select "+column+" from "+table;
//        Executing the query. This takes us to the column from the table
        DbUtils.executeQuery(myDynamicQuery);
//      I am at Price column on the Hotel Room(column = Price, table = tHOTELROOM)
    }
    @Given("user reads all of the {string} column data")
    public void user_reads_all_of_the_column_data(String column) throws SQLException {
        DbUtils.getResultset().next();//I was on row 6 now I am on row 7
        Object columnData7 = DbUtils.getResultset().getObject(column);
        System.out.println(columnData7);//620.0000
        //        resultset.next(); takes to the next row
        DbUtils.getResultset().next();//I was on row 6 now I am on row 7
        Object columnData8 = DbUtils.getResultset().getObject(column);
        System.out.println(columnData8);//525.00
//        We can get teh data as String as well
        String columnDataAsString = DbUtils.getResultset().getString(column);
//        Assert.assertTrue(columnDataAsString.contains("00"));
        System.out.println(columnDataAsString);
//        How to get all of the price column data
        while (DbUtils.getResultset().next()){
            Object eachColumnData=DbUtils.getResultset().getObject(column);
            System.out.println(eachColumnData);
        }
    }
    @Then("close the connection")
    public void close_the_connection() {
        DbUtils.closeConnection();
    }
}

