package classDesign;

public class BaseballPlayer {

	private String name;
	private Integer jersey_number;
	private Integer total_runs;
	private Integer total_hits;
	private Integer total_rbis;
	private Integer total_games;
	
	public BaseballPlayer(String name, Integer jersey_number, Integer total_runs, Integer total_hits, Integer total_rbis, Integer total_games) {
		this.name = name;
		this.jersey_number = jersey_number;
		this.total_runs = total_runs;
		this.total_hits = total_hits;
		this.total_rbis = total_rbis;
		this.total_games = total_games;
	}
	
	private void addRuns(Integer runs) {
		this.total_runs += runs;
	}
	
	private void addHits(Integer hits) {
		this.total_hits += hits;
	}
	
	private void addRBIs(Integer rbis) {
		this.total_rbis += rbis;
	}
	
	public void addGame(Integer runs, Integer hits, Integer rbis) {
		this.total_games += 1;
		this.addRuns(runs);
		this.addHits(hits);
		this.addRBIs(rbis);
	}
	
	@Override
	public String toString() {
		return "BaseballPlayer [name=" + name + ", jersey_number=" + jersey_number + ", total_runs=" + total_runs
				+ ", total_hits=" + total_hits + ", total_rbis=" + total_rbis + ", total_games=" + total_games + "]";
	}

	public static void main(String[] args) {
		BaseballPlayer b1 = new BaseballPlayer("Kevin", 23, 0, 0, 0, 0);
		System.out.println(b1);
		b1.addGame(2, 5, 3);
		System.out.println(b1);
		b1.addGame(5, 8, 3);
		System.out.println(b1);
	}

}
