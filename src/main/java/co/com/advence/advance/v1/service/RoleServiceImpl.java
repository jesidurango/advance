package co.com.advence.advance.v1.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.advence.advance.v1.dao.RoleDao;
import co.com.advence.advance.v1.entity.PageEntity;
import co.com.advence.advance.v1.entity.RoleEntity;
import co.com.advence.advance.v1.model.Menu;
import co.com.advence.advance.v1.model.MenuOption;
import co.com.advence.advance.v1.service.interfaces.RoleService;
import co.com.advence.advance.v1.service.mapper.PageMapper;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Menu getMenuByRole(Integer id) {
		Optional<RoleEntity> result = roleDao.findById(id);
		Menu menu = null;
		RoleEntity roleEntity = null;
		if (result.isPresent()) {
			roleEntity = result.get();
			menu = new Menu();
			//Put in a map all options grouped by the father attribute
			Map<Integer,List<PageEntity>> pagesGrouped = roleEntity.getPagesByRole().stream()
					.filter(page -> page.getFather() != null)
					.collect(
							Collectors.groupingBy(PageEntity::getFather)
					);
			List<MenuOption> menuOptions = roleEntity.getPagesByRole().stream()
				.filter(page -> page.getFather() == null)
				.map(page -> {
					List<PageEntity> pages = pagesGrouped.get(page.getId());
					MenuOption menuOption = new MenuOption();
					pages.add(page);
					pages.sort((page1, page2) -> page1.getOrder().compareTo(page2.getOrder()));
					menuOption.setPages(PageMapper.getPage(pages));
					return menuOption;
				}).collect(Collectors.toList());
			menu.setMenuOptions(menuOptions);
		}
		return menu;
	}

}
