package io.github.jaychoufans.web.servlet.security;

/*-
 * #%L
 * commons-web
 * %%
 * Copyright (C) 2023 JayChouFans
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.HtmlUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理表单参数xss攻击
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		return htmlEscape(super.getParameter(name));
	}

	@Override
	public String[] getParameterValues(String name) {
		return htmlEscape(super.getParameterValues(name));
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> parameterMap = super.getParameterMap();
		if (CollectionUtils.isEmpty(parameterMap)) {
			return parameterMap;
		}

		Map<String, String[]> parameterEscapeMap = new HashMap<>(parameterMap.size());
		parameterMap.forEach((key, value) -> parameterEscapeMap.put(key, htmlEscape(value)));
		return parameterEscapeMap;
	}

	private String htmlEscape(String input) {
		return input == null ? null : HtmlUtils.htmlEscape(input);
	}

	private String[] htmlEscape(String[] input) {
		return input == null ? null : Arrays.stream(input).map(this::htmlEscape).toArray(String[]::new);
	}

}
