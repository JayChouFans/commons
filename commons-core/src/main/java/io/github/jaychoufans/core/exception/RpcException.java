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

/**
 * Remote call failure
 *
 * @author liuyang
 * @since 0.0.1 2023/05/01
 */
public class RpcException extends SystemException {

	public RpcException(String code, String message) {
		super(code, message);
	}

	public RpcException(String code, String message, Throwable cause) {
		super(code, message, cause);
	}

	public RpcException(ErrorCode errorCode) {
		super(errorCode);
	}

	public RpcException(ErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}

}
