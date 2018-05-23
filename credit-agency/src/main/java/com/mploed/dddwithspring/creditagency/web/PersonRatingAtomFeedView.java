package com.mploed.dddwithspring.creditagency.web;

import com.mploed.dddwithspring.creditagency.model.PersonRating;
import com.mploed.dddwithspring.creditagency.repository.PersonRatingRepository;
import com.rometools.rome.feed.atom.*;
import com.rometools.rome.feed.synd.SyndPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonRatingAtomFeedView extends AbstractAtomFeedView {
	private PersonRatingRepository personRatingRepository;

	public PersonRatingAtomFeedView(PersonRatingRepository personRatingRepository) {
		this.personRatingRepository = personRatingRepository;
	}

	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Feed feed, HttpServletRequest request) {
		feed.setId("https://github.com/mploed/ddd-with-spring/credit-agency");
		feed.setTitle("Credit Agency Ratings");
		List<Link> alternateLinks = new ArrayList<>();
		Link link = new Link();
		link.setRel("self");
		link.setHref(baseUrl(request) + "feed");
		alternateLinks.add(link);
		List<SyndPerson> authors = new ArrayList<SyndPerson>();
		Person person = new Person();
		person.setName("Big Pug Bank");
		authors.add(person);
		feed.setAuthors(authors);

		feed.setAlternateLinks(alternateLinks);
		feed.setUpdated(personRatingRepository.lastUpdate());
		Content subtitle = new Content();
		subtitle.setValue("List of all valid person ratings");
		feed.setSubtitle(subtitle);
	}

	private String baseUrl(HttpServletRequest request) {
		return String.format("%s://%s:%d%s/", request.getScheme(), request.getServerName(), request.getServerPort(),
				request.getContextPath());
	}

	@Override
	protected List<Entry> buildFeedEntries(Map<String, Object> model, HttpServletRequest request,
	                                       HttpServletResponse response) throws Exception {

		List<Entry> entries = new ArrayList<Entry>();

		for (PersonRating o : personRatingRepository.findAll(new Sort(Sort.Direction.DESC, "lastUpdated"))) {
			Entry entry = new Entry();
			entry.setId("https://github.com/mploed/ddd-with-spring/person-rating/" + o.getId());
			entry.setUpdated(o.getLastUpdated());
			entry.setTitle("Person Rating " + o.getId());
			List<Content> contents = new ArrayList<Content>();
			Content content = new Content();
			content.setSrc(baseUrl(request) + "rating/rest/" + o.getId());
			content.setType("application/json");
			contents.add(content);
			entry.setContents(contents);
			Content summary = new Content();
			summary.setValue(""+o.getPoints());
			entry.setSummary(summary);
			entries.add(entry);
		}

		return entries;
	}
}
