package dbEntities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.Timestamp;

public class MilestonesTable {

    Logger logger = LoggerFactory.getLogger(DataBaseService.class);

    DataBaseService dataBaseService;

    public MilestonesTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void dropMilestonesTable() {
        logger.info("Удаляем milestones таблицу");
        String dropTableMilestonesSQL = "DROP TABLE Milestones;";

        dataBaseService.executeSQL(dropTableMilestonesSQL);
    }

    public void createMilestonesTable() {
        logger.info("Создаем milestones таблицу");

        String createTableMilestonesSQL = "CREATE TABLE Milestones (" +
                "ID SERIAL PRIMARY KEY, " +
                "ProjectId INTEGER, " +
                "Name CHARACTER VARYING(50), " +
                "Description CHARACTER VARYING(150), " +
                "Completed BOOLEAN, " +
                "StartDate  TIMESTAMP, " +
                "EndDate  TIMESTAMP, " +
                "ParentId  INTEGER " +
                ");";

        dataBaseService.executeSQL(createTableMilestonesSQL);
    }

    public void addMilestones(Integer projectId, String name, String description, Boolean completed, Timestamp startDate, Timestamp endDate, int parentId) {
        logger.info("Добавляем запись в таблицу");

        String insertTableMilestonesSQL = "INSERT INTO public.Milestones(" +
                "projectId ,name, description, completed, startDate, endDate, parentId)" +
                "VALUES ("+ projectId +",'" + name + "', '" + description + "', " + completed + ", " + startDate + "," + endDate + "," + parentId + ");";

        dataBaseService.executeSQL(insertTableMilestonesSQL);
    }

    public ResultSet getMilestones() {
        String selectSQL = "SELECT * FROM public.Milestones ORDER BY id ASC;";

        return dataBaseService.executeQuery(selectSQL);
    }

    public ResultSet getMilestoneById(int id) {
        String selectSQL = "SELECT * FROM public.Milestones WHERE id =" + id;

        return dataBaseService.executeQuery(selectSQL);
    }

}
