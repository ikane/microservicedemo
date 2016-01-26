package org.ikane;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;

	@RequestMapping(value="/teams", method=RequestMethod.GET)
	public Iterable<Team> getTeams() {

		return this.teamRepository.findAll();
	}
	
	
	@RequestMapping(value="/teams/{id}", method=RequestMethod.GET)
	public Team getTeam(@PathVariable Long id) {
		return this.teamRepository.findOne(id);
	}
	
}
