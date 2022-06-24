package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class Milestone {
    public int id;
    private String name;
    private String description;
    @SerializedName(value = "due_on")
    private String dueOn;
    @SerializedName(value = "parent_id")
    private int parentId;
    private String refs;
    @SerializedName(value = "start_on")
    private String startOn;
    @SerializedName(value = "is_completed")
    private boolean isCompleted;
    @SerializedName(value = "is_started")
    private boolean isStarted;
}
