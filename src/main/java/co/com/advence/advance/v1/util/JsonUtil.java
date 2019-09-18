package co.com.advence.advance.v1.util;

import com.monitorjbl.json.JsonResult;
import com.monitorjbl.json.JsonResult.ResultWrapper;
import com.monitorjbl.json.JsonView;
import com.monitorjbl.json.Match;

public class JsonUtil {
	
	private JsonUtil() {}

	private static JsonResult json = JsonResult.instance();
	
	public static ResultWrapper<Object> jsonExclude(Object object, @SuppressWarnings("rawtypes") Class clazz, String ...exclude) {
		return json.use(JsonView.with(object)
		        .onClass(clazz, Match.match()
			            .exclude(exclude)));
	}
	
}
