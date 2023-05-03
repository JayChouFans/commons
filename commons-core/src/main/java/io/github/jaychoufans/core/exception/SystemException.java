package io.github.jaychoufans.core.exception;

/*-
 * #%L
 * commons-core
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

import lombok.Getter;

/**
 * The type of system is abnormal. The type of abnormal types that need to be solved by
 * system developers
 *
 * @author liuyang
 * @since 0.0.1 2023/05/01
 */
public class SystemException extends RuntimeException {

	@Getter
	private final String code;

	public SystemException(String code, String message) {
		super(message);
		this.code = code;
	}

	public SystemException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public SystemException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.code = errorCode.getCode();
	}

	public SystemException(ErrorCode errorCode, Throwable cause) {
		super(errorCode.getMessage(), cause);
		this.code = errorCode.getCode();
	}

}
