package com.todo.taskrepositoryavla.Request;

public class TaskRequest {
    private int id;

    private String title;

    private String description;
    
    private int status;

    private int userId;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStatus() {
		
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

    

}
