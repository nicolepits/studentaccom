package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.*;

public interface RankDAO {
	
	public List<Rank> getRanks();
	public void saveRank(Rank rank);
}
