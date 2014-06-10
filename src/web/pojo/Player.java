package web.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import web.type.Skill;
@Entity
public class Player {

	private int id;
	private int money;
	private String name;
	private List<Player> players = new ArrayList<Player>();
	private Skill skill;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public int getMoney() {
		return money;
	}
	public String getName() {
		return name;
	}
	@ManyToMany
	@JoinTable(
			name="players_relation",
			joinColumns={@JoinColumn(name="player_id")},
			inverseJoinColumns={@JoinColumn(name="friend_id")}
			)
	public List<Player> getPlayers() {
		return players;
	}
	@Enumerated(EnumType.STRING)
	public Skill getSkill() {
		return skill;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	

}
