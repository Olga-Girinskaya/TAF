package tests.dbTest;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class dbMilestoneTest extends BaseDBMilestonesTest {

    @Test
    public void firstTest() {
        logger.info("Test is started...");

        ResultSet rs = milestonesTable.getMilestones();

        try {
            while (rs.next()) {
                String id = rs.getString("ID");
                int projectId = rs.getInt("projectId");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String completed = rs.getString("completed");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");
                int parentId = rs.getInt("parentId");

                logger.info("id: " + id);
                logger.info("projectId: " + projectId);
                logger.info("name: " + name);
                logger.info("description: " + description);
                logger.info("completed: " + completed);
                logger.info("startDate: " + startDate);
                logger.info("endDate: " + endDate);
                logger.info("parentId: " + parentId);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }

        logger.info("Test is completed...");
    }
}
