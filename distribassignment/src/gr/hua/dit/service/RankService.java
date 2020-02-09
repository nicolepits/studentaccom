package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Rank;

public interface RankService {

	public List<Rank> getRanks();
	
	public void saveRank(Rank rank);
	
}
