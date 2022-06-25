package tests.dbTest;

import dbEntities.MilestonesTable;
import helpers.ProjectHelper;
import models.Project;
import models.ProjectType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;
import tests.api.BaseApiTest;

import java.util.HashMap;
import java.util.Map;

public class BaseDBMilestonesTest extends BaseApiTest {

    Logger logger = LoggerFactory.getLogger(BaseDBMilestonesTest.class);
    MilestonesTable milestonesTable;

    public DataBaseService dataBaseService;
    public Project project;
    public ProjectHelper projectHelper = new ProjectHelper();

    @BeforeTest
    public void setupConnection() {
        dataBaseService = new DataBaseService();
    }

    @BeforeMethod
    public void addTestProject() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", "Project_Test");
        jsonAsMap.put("suite_mode", ProjectType.SINGLE_SUITE_MODE);
        project = projectHelper.addProject(jsonAsMap);
        logger.info("Проект создан!!!");

        milestonesTable = new MilestonesTable(dataBaseService);
        milestonesTable.dropMilestonesTable();
        logger.info("Таблица milestone удалена!!!");
        milestonesTable.createMilestonesTable();
        logger.info("Таблица milestone создана!!!");

        milestonesTable.addMilestones(project.projectId, "Milestone_1", "Test Milestone_1", false, null, null, 0);
        milestonesTable.addMilestones(project.projectId, "Milestone_2", "Test Milestone_2", true, null, null, 0);
        logger.info("Таблица milestone заполнена!!!");
    }

    @AfterMethod
    public void deleteTestProject() {
        projectHelper.deleteProject(project.projectId);
        logger.info("Проект удален!!!");
    }

    @AfterTest
    public void closeConnection() {
        dataBaseService.closeConnection();
    }
}
