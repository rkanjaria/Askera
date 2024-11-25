package com.ai.askera.chat.domain

import com.ai.askera.core.domain.util.NetworkError
import com.ai.askera.core.domain.util.Result

interface ChatDataSource {

    suspend fun getRecentChats(): Result<Any, NetworkError>
}