package domain;

public class Player{

	private String playerId;
	private String name;
	private int backNumber;
	private String position;
	private String hittingHand;
	private String throwHand;
	
	private String teamId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBackNumber() {
		return backNumber;
	}

	public void setBackNumber(int backNumber) {
		this.backNumber = backNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHittingHand() {
		return hittingHand;
	}

	public void setHittingHand(String hittingHand) {
		this.hittingHand = hittingHand;
	}

	public String getThrowHand() {
		return throwHand;
	}

	public void setThrowHand(String throwHand) {
		this.throwHand = throwHand;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
}
