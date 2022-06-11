package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    public int id;
    private String name;
    private String announcement;
    private boolean isShowAnnouncement;
    @SerializedName(value = "suite_mode")
    private int typeOfProject;
    @SerializedName(value = "is_completed")
    private boolean isCompleted;
    private User user;

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return id;
    }

}
