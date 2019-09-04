package co.com.advence.advance.v1.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.com.advence.advance.v1.entity.PageEntity;
import co.com.advence.advance.v1.model.Page;

public class PageMapper {

	public static Page getPage(PageEntity pageEntity) {
		Page page = new Page.Builder(pageEntity.getId())
				.name(pageEntity.getName())
				.url(pageEntity.getUrl())
				.father(pageEntity.getFather())
				.build();
		return page;
	}
	
	public static List<Page> getPage(List<PageEntity> pagesEntity) {
		List<Page> list = pagesEntity.stream().map(
				page ->
					getPage(page)
				).collect(Collectors.toList());
		return list;
	}
	
}
