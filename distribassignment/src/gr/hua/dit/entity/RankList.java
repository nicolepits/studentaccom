package gr.hua.dit.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="RankList")
@Component
public class RankList {
	
	List<Rank> rankList;

	public List<Rank> getRankList() {
		return rankList;
	}

	public void setRankList(List<Rank> rankList) {
		this.rankList = rankList;
	}
	
	public int getIndexOfRank(int id) {
		  for(Rank rank : this.rankList)  {
		     if(rank.getId() == id)
		         return this.rankList.indexOf(rank);
		   }
		 return -1; 
		 }
	
}
