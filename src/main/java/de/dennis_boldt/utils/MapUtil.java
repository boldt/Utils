package de.dennis_boldt.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapUtil {

	public static <T> List<T> toList(Map<?, T> map) {
		return new ArrayList<T>(map.values());
	}

}
