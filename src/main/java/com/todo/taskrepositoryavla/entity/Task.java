package com.todo.taskrepositoryavla.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tasks")
public class Task {

    public enum TaskStatus {
        TODO,
        INPROGRESS,
        COMPLETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq_id")
    @SequenceGenerator(name="task_seq_id", sequenceName="task_seq_id",allocationSize=1)
    private int id;

    private String title;

    private String description;

    private int status;

    private boolean finished;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name="fK_task_user_id"))
    @JsonBackReference("user")
    private User user;

    private Date createDate;
    
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}