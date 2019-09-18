package co.com.advence.advance.v1.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.advence.advance.v1.entity.PageEntity;
import co.com.advence.advance.v1.model.Page;

public class PageMapper {

	private PageMapper() {}
	
	public static Page getPage(PageEntity pageEntity) {
		return new Page.Builder(pageEntity.getId())
				.name(pageEntity.getName())
				.url(pageEntity.getUrl())
				.father(pageEntity.getFather())
				.order(pageEntity.getOrder())
				.build();
	}
	
	public static List<Page> getPage(List<PageEntity> pagesEntity) {
		return pagesEntity.stream().map(
				PageMapper::getPage
				).collect(Collectors.toList());
	}
	
}
