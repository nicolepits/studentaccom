package gr.hua.dit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rank")
public class Rank implements Comparable<Rank>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id; //app id
	
	@Column(name="points")
	int points;

	public Rank() {
		
	}
	
	public Rank(int id, int points) {
		super();
		this.id = id;
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int compareTo(Rank rank) {
		return(this.points-rank.points);
	}

	
	
	
}
