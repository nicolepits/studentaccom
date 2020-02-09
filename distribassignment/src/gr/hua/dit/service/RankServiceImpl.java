package gr.hua.dit.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.hua.dit.dao.*;
import gr.hua.dit.entity.Rank;

@Service
public class RankServiceImpl implements RankService {

	@Autowired
	private RankDAO rankDAO;
	
	@Override
	@Transactional
	public List<Rank> getRanks() {
		return rankDAO.getRanks();
	}

	@Override
	@Transactional
	public void saveRank(Rank rank) {
		rankDAO.saveRank(rank);
	}

}
