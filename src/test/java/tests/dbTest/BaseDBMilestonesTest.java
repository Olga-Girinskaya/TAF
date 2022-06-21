package tests.dbTest;

import dbEntities.MilestonesTable;
import helpers.ProjectHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;

public class BaseDBMilestonesTest {

    public DataBaseService dataBaseService;
    Logger logger = LoggerFactory.getLogger(BaseDBMilestonesTest.class);
    MilestonesTable milestonesTable;

    public BaseDBMilestonesTest() {
    }

    @BeforeTest
    public void setupConnection() {
        dataBaseService = new DataBaseService();
        ProjectHelper projectHelper= new ProjectHelper();

        milestonesTable = new MilestonesTable(dataBaseService);
        milestonesTable.dropMilestonesTable();
        milestonesTable.createMilestonesTable();

        milestonesTable.addMilestones(30,"Milestone_1", "Test Milestone_1", false, null, null, 0);
        milestonesTable.addMilestones(30,"Milestone_2", "Test Milestone_2", true, null, null, 0 );
    }

    @AfterTest
    public void closeConnection() {
        dataBaseService.closeConnection();
    }
}
