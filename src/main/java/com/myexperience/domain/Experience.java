package com.myexperience.domain;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by zilat on 31.05.2017.
 */
@Entity
@Table(name = "Experience")
public class Experience {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique = true, nullable = false, precision = 19)
    private long id;

    
    @Column(name = "title", length = 255, nullable = false)
    private String title;
    
    @Column(name = "body", columnDefinition="TEXT", nullable = false)
    private String body;
    

    @Column(name = "createdDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    
    @ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
    
    @OneToMany(mappedBy="experience", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    private List<Rating> ratings;
	
    public Experience() {
    }


	public long getId()
	{
		return id;
	}


	public void setId(long id)
	{
		this.id = id;
	}


	public String getTitle()
	{
		return title;
	}


	public void setTitle(String title)
	{
		this.title = title;
	}


	public String getBody()
	{
		return body;
	}


	public void setBody(String body)
	{
		this.body = body;
	}


	public Date getCreatedDate()
	{
		return createdDate;
	}


	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}


	public User getUser()
	{
		return user;
	}


	public void setUser(User user)
	{
		this.user = user;
	}


	public List<Rating> getRatings()
	{
		return ratings;
	}


	public void setRatings(List<Rating> ratings)
	{
		this.ratings = ratings;
	}
	    
}
